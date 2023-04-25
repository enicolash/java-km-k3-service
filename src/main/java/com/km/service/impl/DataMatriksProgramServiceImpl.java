package com.km.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.connection.Conn;
import com.km.connection.DbConnectionPostgre;
import com.km.dao.AktivitasPekerjaanDao;
import com.km.dao.DataMatriksProgramDao;
import com.km.service.DataMartriksProgramService;

@Service
public class DataMatriksProgramServiceImpl extends DbConnectionPostgre implements DataMartriksProgramService {
	@Autowired
	DataMatriksProgramDao dao;
	
	@Override
	public Map<String, Object>  dataMatriksProgram(Map<String, Object> parameter) throws Exception {
		Map<String, Object>  response = new HashMap();
		Conn connection = new Conn();
		try {
			connection.conn = this.getConnection();
			response = dao.dataMatriksProgram(connection,parameter);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			 connection.closeConnection();
		}
		return response;
	}

}
