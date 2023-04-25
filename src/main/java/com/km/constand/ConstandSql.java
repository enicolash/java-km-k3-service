package com.km.constand;

public class ConstandSql {
	public static final String data_aktivitas_pekerjaan = "SELECT id,aktivitas_pekerjaan_code,aktivitas_pekerjaan_desc FROM alvia_km_k3.mst_aktivitas_pekerjaan  WHERE deleted = 'FALSE' ORDER BY id ASC";
	
	public static final String matriks_aktivitas_to_resiko = "SELECT MAUR.aktivitas_pekerjaan_code,MAUR.bahaya_code,(SELECT B.bahaya_desc \r\n"
			+ "			 FROM  alvia_km_k3.mst_bahaya B\r\n"
			+ "			 WHERE B.bahaya_code = MAUR.bahaya_code) AS bahaya_desc,\r\n"
			+ "			 (SELECT B.tipe_bahaya_desc \r\n"
			+ "			 FROM  alvia_km_k3.mst_bahaya B\r\n"
			+ "			 WHERE B.bahaya_code = MAUR.bahaya_code) AS tipe_bahaya_desc,\r\n"
			+ "			 MAUR.resiko_code,(SELECT R.resiko_desc \r\n"
			+ "			 FROM  alvia_km_k3.mst_resiko R\r\n"
			+ "			 WHERE R.resiko_code = MAUR.resiko_code) AS resiko_desc,\r\n"
			+ "			 MAUR.pengendalian_code,(SELECT PR.pengendalian_desc FROM alvia_km_k3.mst_pengendalian_resiko PR \r\n"
			+ "			 WHERE PR.pengendalian_code = MAUR.pengendalian_code) AS pengendalian_desc,\r\n"
			+ "			 MAUR.sasaran_code,(SELECT S.sasaran_desc FROM alvia_km_k3.mst_sasaran S\r\n"
			+ "			 WHERE S.sasaran_code = MAUR.sasaran_code) AS sasaran_desc\r\n"
			+ "			 FROM alvia_km_k3.mst_map_aktivitas_until_resiko MAUR  \r\n"
			+ "			 WHERE MAUR.aktivitas_pekerjaan_code = ?";
	
	public static final String matriks_resiko_to_penyebab = "SELECT MARP.penyebab_code,(SELECT P.penyebab_desc \r\n"
			+ "FROM  alvia_km_k3.mst_penyebab P\r\n"
			+ "WHERE P.penyebab_code = MARP.penyebab_code) AS penyebab_desc\r\n"
			+ "FROM alvia_km_k3.mst_map_resiko_to_penyebab MARP  \r\n"
			+ "WHERE MARP.aktivitas_pekerjaan_code = ? \r\n"
			+ "AND MARP.resiko_code = ?";
	
	public static final String matriks_map_program = "SELECT id,sasaran_code,sasaran_desc,sumber_daya_desc,jangka_waktu_desc,indikator_pencapaian_desc,monitoring_desc,penanggung_jawab_desc \r\n"
			+ "FROM alvia_km_k3.mst_map_program \r\n"
			+ "WHERE sasaran_code = ?";
	
}
