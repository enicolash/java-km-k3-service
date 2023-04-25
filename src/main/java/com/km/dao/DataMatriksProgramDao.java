package com.km.dao;

import java.util.List;
import java.util.Map;

import com.km.connection.Conn;

public interface DataMatriksProgramDao {
	Map<String, Object> dataMatriksProgram(Conn connection, Map<String, Object> parameter) throws Exception;
}
