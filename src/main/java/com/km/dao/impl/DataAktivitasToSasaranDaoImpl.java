package com.km.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.km.connection.Conn;
import com.km.constand.ConstandSql;
import com.km.dao.DataAktivitasToSasaranDao;
import com.km.model.response.ResponseDaoMatriksAktivitasToResiko;

@Repository
public class DataAktivitasToSasaranDaoImpl implements DataAktivitasToSasaranDao {	

	@Override
	public List<ResponseDaoMatriksAktivitasToResiko> dataAktivitasToResiko(Conn connection,Map<String, Object> parameter) throws Exception {
		List<ResponseDaoMatriksAktivitasToResiko> response = new ArrayList<>();
		try {
			connection.ps = connection.conn.prepareStatement(ConstandSql.matriks_aktivitas_to_resiko);
			String aktivitas_code = parameter.get("aktivitas_pekerjaan_code") == null ? "" : parameter.get("aktivitas_pekerjaan_code").toString();
			connection.ps.setString(1, aktivitas_code);
			connection.rs = connection.ps.executeQuery();
			response = convertToModelMatriksAktivitasToResiko(connection.rs,connection);
		 } catch (Exception e) {
	          e.printStackTrace();
	          throw new Exception(e.getMessage());
	     }
		return response;
	}
	
	public static List<ResponseDaoMatriksAktivitasToResiko> convertToModelMatriksAktivitasToResiko(ResultSet rs,Conn connection) throws Exception {
		List<ResponseDaoMatriksAktivitasToResiko> response = new ArrayList<>();
		try {
			while (rs.next()) {
				ResponseDaoMatriksAktivitasToResiko dataAktivitasToResiko = new ResponseDaoMatriksAktivitasToResiko();
				dataAktivitasToResiko = queryDataToModelMatriks(rs,connection);
				response.add(dataAktivitasToResiko);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return response;
	}
	
	public static ResponseDaoMatriksAktivitasToResiko queryDataToModelMatriks (ResultSet rs,Conn connection) throws Exception{
		ResponseDaoMatriksAktivitasToResiko dataMatriks = new ResponseDaoMatriksAktivitasToResiko();
		Integer idFromQuery = rs.getInt("id");
		String aktivitasPekerjaanCodeFromQuery = rs.getString("aktivitas_pekerjaan_code") == null ? "" :  rs.getString("aktivitas_pekerjaan_code") .toString();
		String bahayaCodeFromQuery = rs.getString("bahaya_code") == null ? "" :  rs.getString("bahaya_code") .toString();
		String bahayaDescFromQuery = rs.getString("bahaya_desc") == null ? "" :  rs.getString("bahaya_desc") .toString();
		String tipeBahayaDescFromQuery = rs.getString("tipe_bahaya_desc") == null ? "" :  rs.getString("tipe_bahaya_desc") .toString();
		String resikoCodeFromQuery = rs.getString("resiko_code") == null ? "" :  rs.getString("resiko_code") .toString();
		String resikoDescFromQuery = rs.getString("resiko_desc") == null ? "" :  rs.getString("resiko_desc") .toString();
		String pengendalianCodeFromQuery = rs.getString("pengendalian_code") == null ? "" :  rs.getString("pengendalian_code") .toString();
		String pengendalianDescFromQuery = rs.getString("pengendalian_desc") == null ? "" :  rs.getString("pengendalian_desc") .toString();
		String sasaranCodeFromQuery = rs.getString("sasaran_code") == null ? "" :  rs.getString("sasaran_code") .toString();
		String sasaranDescFromQuery = rs.getString("sasaran_desc") == null ? "" :  rs.getString("sasaran_desc") .toString();
		dataMatriks.setId_map_aktivitas_untill_resiko(idFromQuery);
		dataMatriks.setAktivitas_pekerjaan_code(aktivitasPekerjaanCodeFromQuery);
		dataMatriks.setBahaya_code(bahayaCodeFromQuery);
		dataMatriks.setBahaya_desc(bahayaDescFromQuery);
		dataMatriks.setTipe_bahaya_desc(tipeBahayaDescFromQuery);
		dataMatriks.setResiko_code(resikoCodeFromQuery);
		dataMatriks.setResiko_desc(resikoDescFromQuery);
		dataMatriks.setPengendalian_code(pengendalianCodeFromQuery);
		dataMatriks.setPengendalian_desc(pengendalianDescFromQuery);
		dataMatriks.setSasaran_code(sasaranCodeFromQuery);
		dataMatriks.setSasaran_desc(sasaranDescFromQuery);
		dataMatriks.setPenyebab_desc(dataResikoToPenyebab(dataMatriks,connection));
		return dataMatriks;
	}
	
	public static List<String> dataResikoToPenyebab(ResponseDaoMatriksAktivitasToResiko parameter,Conn connection)throws Exception{
		List<String> response = new ArrayList<>();
		String id_map_aktivitas_untill_resiko = parameter.getId_map_aktivitas_untill_resiko() == null ? "" : parameter.getId_map_aktivitas_untill_resiko().toString();
		if(id_map_aktivitas_untill_resiko.equals("14")) {
			System.out.println(id_map_aktivitas_untill_resiko);
		}
		String aktivitas_pekerjaan_code =  parameter.getAktivitas_pekerjaan_code() == null ? "" : parameter.getAktivitas_pekerjaan_code();
		try {
			connection.ps = connection.conn.prepareStatement(ConstandSql.matriks_resiko_to_penyebab);
			connection.ps.setString(1, aktivitas_pekerjaan_code);
			connection.ps.setString(2, id_map_aktivitas_untill_resiko);
			connection.rs = connection.ps.executeQuery();
			response = convertQueryDataToListPenyebab(connection.rs);
		 } catch (Exception e) {
	          e.printStackTrace();
	          throw new Exception(e.getMessage());
	     }
		return response;
	}
	
	public static List<String> convertQueryDataToListPenyebab(ResultSet rs) throws Exception {
		List<String> response = new ArrayList<>();
		try {
			while (rs.next()) {
				String penyebab_desc = rs.getString("penyebab_desc") == null ? "" :  rs.getString("penyebab_desc").toString();
				response.add(penyebab_desc);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return response;
	}
	
	

}
