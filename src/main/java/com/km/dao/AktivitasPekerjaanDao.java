package com.km.dao;

import java.util.List;
import java.util.Map;


import com.km.connection.Conn;

public interface AktivitasPekerjaanDao {
	List<Map<String, Object>> aktivitasPekejaanData(Conn connection) throws Exception;
	List<Map<String, Object>> mapWbsBahayaData(Conn connection) throws Exception;

}
