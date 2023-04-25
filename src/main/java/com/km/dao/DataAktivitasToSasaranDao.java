package com.km.dao;

import java.util.List;
import java.util.Map;

import com.km.connection.Conn;
import com.km.model.response.ResponseDaoMatriksAktivitasToResiko;

public interface DataAktivitasToSasaranDao {
	List<ResponseDaoMatriksAktivitasToResiko> dataAktivitasToResiko(Conn connection, Map<String, Object> parameter) throws Exception;
}
