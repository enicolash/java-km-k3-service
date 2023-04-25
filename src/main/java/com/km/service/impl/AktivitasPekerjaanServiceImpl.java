package com.km.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.connection.Conn;
import com.km.connection.DbConnectionPostgre;
import com.km.dao.AktivitasPekerjaanDao;
import com.km.dao.impl.AktivitasPekerjaanDaoImpl;
import com.km.service.AktivitasPekerjaanService;

@Service
public class AktivitasPekerjaanServiceImpl extends DbConnectionPostgre implements AktivitasPekerjaanService {
	@Autowired
	AktivitasPekerjaanDao dao;

	@Override
	public List<?> aktivitasPekerjaanData() throws Exception {
		List<?> response = new ArrayList<>();
		Conn connection = new Conn();
		try {
			connection.conn = this.getConnection();
			response = dao.aktivitasPekejaanData(connection);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			 connection.closeConnection();
		}
		return response;
	}
}
