package com.km.model.response;

import java.util.List;

public class ResponseDaoMatriksAktivitasToResiko {
	private String aktivitas_pekerjaan_code;
	private String bahaya_code;
	private String bahaya_desc;
	private String tipe_bahaya_desc;
	private String resiko_code;
	private String resiko_desc;
	private String pengendalian_code;
	private String pengendalian_desc;
	private String sasaran_code;
	private String sasaran_desc;
	private List<String> penyebab_desc;
	public String getBahaya_code() {
		return bahaya_code;
	}
	public void setBahaya_code(String bahaya_code) {
		this.bahaya_code = bahaya_code;
	}
	public String getBahaya_desc() {
		return bahaya_desc;
	}
	public void setBahaya_desc(String bahaya_desc) {
		this.bahaya_desc = bahaya_desc;
	}
	public String getResiko_code() {
		return resiko_code;
	}
	public void setResiko_code(String resiko_code) {
		this.resiko_code = resiko_code;
	}
	public String getResiko_desc() {
		return resiko_desc;
	}
	public void setResiko_desc(String resiko_desc) {
		this.resiko_desc = resiko_desc;
	}
	public List<String> getPenyebab_desc() {
		return penyebab_desc;
	}
	public void setPenyebab_desc(List<String> penyebab_desc) {
		this.penyebab_desc = penyebab_desc;
	}
	public String getAktivitas_pekerjaan_code() {
		return aktivitas_pekerjaan_code;
	}
	public void setAktivitas_pekerjaan_code(String aktivitas_pekerjaan_code) {
		this.aktivitas_pekerjaan_code = aktivitas_pekerjaan_code;
	}
	public String getPengendalian_code() {
		return pengendalian_code;
	}
	public void setPengendalian_code(String pengendalian_code) {
		this.pengendalian_code = pengendalian_code;
	}
	public String getPengendalian_desc() {
		return pengendalian_desc;
	}
	public void setPengendalian_desc(String pengendalian_desc) {
		this.pengendalian_desc = pengendalian_desc;
	}
	public String getSasaran_code() {
		return sasaran_code;
	}
	public void setSasaran_code(String sasaran_code) {
		this.sasaran_code = sasaran_code;
	}
	public String getSasaran_desc() {
		return sasaran_desc;
	}
	public void setSasaran_desc(String sasaran_desc) {
		this.sasaran_desc = sasaran_desc;
	}
	public String getTipe_bahaya_desc() {
		return tipe_bahaya_desc;
	}
	public void setTipe_bahaya_desc(String tipe_bahaya_desc) {
		this.tipe_bahaya_desc = tipe_bahaya_desc;
	}
	
}




