package com.km.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.km.connection.Conn;
import com.km.constand.ConstandSql;
import com.km.dao.DataMatriksProgramDao;
import com.km.helper.Helper;

@Repository
public class DataMatriksProgramDaoImpl implements DataMatriksProgramDao {
	@Autowired
	Helper helper;

	@Override
	public Map<String, Object>dataMatriksProgram(Conn connection, Map<String, Object> parameter) throws Exception {
		Map<String, Object> response = new HashMap<>();
		String sasaran_code = parameter.get("sasaran_code") == null ? "" : parameter.get("sasaran_code").toString();
		try {
			connection.ps = connection.conn.prepareStatement(ConstandSql.matriks_map_program);
			connection.ps.setString(1, sasaran_code);
			connection.rs = connection.ps.executeQuery();
			response = helper.converResultSetToMap(connection.rs);
		 } catch (Exception e) {
	          e.printStackTrace();
	          throw new Exception(e.getMessage());
	     }
		return response;
	}

}
