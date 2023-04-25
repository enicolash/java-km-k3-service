package com.km.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.connection.Conn;
import com.km.connection.DbConnectionPostgre;
import com.km.dao.DataAktivitasToSasaranDao;
import com.km.service.DataAktivitasToSasaranService;

@Service
public class DataAktivitasToSasaranServiceImpl extends DbConnectionPostgre implements DataAktivitasToSasaranService {
	@Autowired
	DataAktivitasToSasaranDao dao;
	
	@Override
	public List<?> dataAktivitasToSasaran(Map<String, Object> parameter) throws Exception {
		List<?> response = new ArrayList<>();
		Conn connection = new Conn();
		try {
			connection.conn = this.getConnection();
			response = dao.dataAktivitasToResiko(connection,parameter);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			 connection.closeConnection();
		}
		return response;
	}

}
