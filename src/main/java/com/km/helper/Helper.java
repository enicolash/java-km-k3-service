package com.km.helper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class Helper {
	public static List<Map<String, Object>> converResultSetToList(ResultSet rs) throws Exception {
		List<Map<String, Object>> response = new ArrayList<>();
		ResultSetMetaData metadata = rs.getMetaData();
		try {
			while (rs.next()) {
				Map<String, Object> result = new HashMap<String, Object>();
				for (int i = 1; i <= metadata.getColumnCount(); i++) {
					result.put(metadata.getColumnName(i).toLowerCase(), rs.getString(i) == null ? "" : rs.getString(i));
				}
				response.add(result);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return response;
	}
	
	@SuppressWarnings("unused")
	public static Map<String, Object> converResultSetToMap(ResultSet rs) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		ResultSetMetaData metadata = rs.getMetaData();
		try {
			while (rs.next()) {
				for (int i = 1; i <= metadata.getColumnCount(); i++) {
					result.put(metadata.getColumnName(i).toLowerCase(), rs.getString(i) == null ? "" : rs.getString(i));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return result;
	}
	
	public static <T> T getNestedValue(Map map, String... keys) {
        Object value = map;

        for (String key : keys) {
            value = ((Map) value).get(key);
        }

        return (T) value;
    }
}
