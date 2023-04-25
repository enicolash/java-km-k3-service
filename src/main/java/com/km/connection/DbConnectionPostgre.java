package com.km.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class DbConnectionPostgre {
	@Autowired
	@Qualifier("datasourcepostgre")
	private DataSource dataSource;

	private static final Logger logger = LoggerFactory.getLogger(DbConnectionPostgre.class);

	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	protected CallableStatement cl = null;
	protected Connection conn = null;
	protected boolean isNoError = false;
	protected String status = "";

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		return connection;
	}
}
