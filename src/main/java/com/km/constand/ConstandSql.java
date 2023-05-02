package com.km.constand;

public class ConstandSql {
	public static final String data_aktivitas_pekerjaan = "SELECT id,aktivitas_pekerjaan_code,aktivitas_pekerjaan_desc FROM alvia_km_k3.mst_aktivitas_pekerjaan  WHERE deleted = 'FALSE' ORDER BY id ASC";
	
	public static final String matriks_aktivitas_to_resiko = "SELECT MAUR.id,MAUR.aktivitas_pekerjaan_code,MAUR.bahaya_code,(SELECT B.bahaya_desc \r\n"
			+ "			 			 FROM  alvia_km_k3.mst_bahaya B\r\n"
			+ "			 			 WHERE B.bahaya_code = MAUR.bahaya_code) AS bahaya_desc,\r\n"
			+ "			 			 (SELECT B.tipe_bahaya_desc \r\n"
			+ "			 			 FROM  alvia_km_k3.mst_bahaya B\r\n"
			+ "			 			 WHERE B.bahaya_code = MAUR.bahaya_code) AS tipe_bahaya_desc,\r\n"
			+ "			 			 MAUR.resiko_code,(SELECT R.resiko_desc \r\n"
			+ "			 			 FROM  alvia_km_k3.mst_resiko R\r\n"
			+ "			 			 WHERE R.resiko_code = MAUR.resiko_code) AS resiko_desc,\r\n"
			+ "			 			 MAUR.pengendalian_code,(SELECT PR.pengendalian_desc FROM alvia_km_k3.mst_pengendalian_resiko PR \r\n"
			+ "			 			 WHERE PR.pengendalian_code = MAUR.pengendalian_code) AS pengendalian_desc,\r\n"
			+ "			 			 MAUR.sasaran_code,(SELECT S.sasaran_desc FROM alvia_km_k3.mst_sasaran S\r\n"
			+ "			 			 WHERE S.sasaran_code = MAUR.sasaran_code) AS sasaran_desc\r\n"
			+ "			 			 FROM alvia_km_k3.mst_map_aktivitas_until_resiko MAUR  \r\n"
			+ "			 			 WHERE MAUR.aktivitas_pekerjaan_code = ?\r\n"
			+ "						 AND MAUR.bahaya_code = ?";
	
	public static final String matriks_resiko_to_penyebab = "SELECT MARP.penyebab_code,(SELECT P.penyebab_desc \r\n"
			+ "FROM  alvia_km_k3.mst_penyebab P\r\n"
			+ "WHERE P.penyebab_code = MARP.penyebab_code) AS penyebab_desc\r\n"
			+ "FROM alvia_km_k3.mst_map_resiko_to_penyebab MARP  \r\n"
			+ "WHERE MARP.aktivitas_pekerjaan_code = ? \r\n"
			+ "AND MARP.resiko_code = ?";
	
	public static final String matriks_map_program = "SELECT id,sasaran_code,sasaran_desc,sumber_daya_desc,jangka_waktu_desc,indikator_pencapaian_desc,monitoring_desc,penanggung_jawab_desc \r\n"
			+ "FROM alvia_km_k3.mst_map_program \r\n"
			+ "WHERE sasaran_code = ?";
	
	public static final String map_wbs_to_bahaya = "SELECT MWB.id,MWB.level_2_desc,MWB.level_3_desc,MWB.level_4_desc,MWB.alternatif_design_desc,MWB.aktivitas_pekerjaan_code,\r\n"
			+ "			 (SELECT AP.aktivitas_pekerjaan_desc \r\n"
			+ "			 FROM alvia_km_k3.mst_aktivitas_pekerjaan AP WHERE AP.aktivitas_pekerjaan_code = MWB.aktivitas_pekerjaan_code) AS aktivitas_pekerjaan_desc,AB.bahaya_code,\r\n"
			+ "			 (SELECT B.bahaya_desc\r\n"
			+ "			 FROM alvia_km_k3.mst_bahaya B WHERE B.bahaya_code = AB.bahaya_code),\r\n"
			+ "			 AB.id as id_map_aktivitas_to_bahaya\r\n"
			+ "			 FROM alvia_km_k3.mst_map_wbs_to_bahaya MWB\r\n"
			+ "			 RIGHT JOIN alvia_km_k3.mst_aktivitas_bahaya AB\r\n"
			+ "			 ON MWB.aktivitas_pekerjaan_code = AB.aktivitas_pekerjaan_code\r\n"
			+ "			 ORDER BY AB.id";
	
}
