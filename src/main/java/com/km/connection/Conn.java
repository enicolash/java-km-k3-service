package com.km.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conn {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public PreparedStatement ps2 = null;
	public ResultSet rs = null;
	public ResultSet rs2 = null;
	public ResultSet rs3 = null;
	public CallableStatement cl = null;

	public void closeConnection() throws Exception {
		try {
			if (conn != null) {
				conn.close();
			}

			if (ps != null) {
				ps.close();
			}

			if (ps2 != null) {
				ps2.close();
			}

			if (rs != null) {
				rs.close();
			}

			if (rs2 != null) {
				rs2.close();
			}

			if (rs3 != null) {
				rs3.close();
			}

			if (cl != null) {
				cl.close();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void closeStatement() throws Exception {
		try {

			if (ps != null) {
				ps.close();
			}

			if (ps2 != null) {
				ps2.close();
			}

			if (rs != null) {
				rs.close();
			}

			if (rs2 != null) {
				rs2.close();
			}

			if (rs3 != null) {
				rs3.close();
			}

			if (cl != null) {
				cl.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
