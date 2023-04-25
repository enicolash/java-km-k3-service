package com.km.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.km.connection.Conn;
import com.km.constand.ConstandSql;
import com.km.dao.AktivitasPekerjaanDao;
import com.km.helper.Helper;

@Repository
public class AktivitasPekerjaanDaoImpl implements AktivitasPekerjaanDao {
	
	@Autowired
	Helper helper;

	@Override
	public List<Map<String, Object>> aktivitasPekejaanData(Conn connection) throws Exception {
		List<Map<String, Object>> response = new ArrayList<>();
		try {
			connection.ps = connection.conn.prepareStatement(ConstandSql.data_aktivitas_pekerjaan);
			connection.rs = connection.ps.executeQuery();
			response = helper.converResultSetToList(connection.rs);
		 } catch (Exception e) {
	          e.printStackTrace();
	          throw new Exception(e.getMessage());
	     }
		return response;
	}
}
