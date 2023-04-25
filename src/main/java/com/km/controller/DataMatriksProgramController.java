package com.km.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.km.service.DataMartriksProgramService;

@RestController
public class DataMatriksProgramController {
	@Autowired
	DataMartriksProgramService service;
	
	public static final Logger Logger = LoggerFactory.getLogger(CheckConnectionController.class);
	
	
	@RequestMapping(value = "/matriksProgram", method = RequestMethod.POST)
	    public ResponseEntity<Map<String, Object>> aktivitasPekerjaanData(@RequestBody Map<String, Object> parameter) {
		 Map<String, Object> response = new HashMap();
		 Map<String, Object> result = new HashMap<String, Object>();
		 try {
			  response = service.dataMatriksProgram(parameter);
			  result = checkService(response);
	          return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
		} catch (Exception e) {
			 	String errorMessage = e.getMessage();
				Logger.error(errorMessage);
			 	result = checkService(errorMessage);
	            e.printStackTrace();
	            return new ResponseEntity<Map<String, Object>>(result, HttpStatus.BAD_REQUEST);
		}
	 
	 }
		
		public Map<String, Object> checkService (Map<String, Object> resultService){
			return resultServiceTrue(resultService);
		}
		
		public Map<String, Object> checkService (String errorMessage){
			return resultServiceFalse(errorMessage);
		}
		
		public Map<String, Object> resultServiceTrue(Map<String, Object>  resultService){
			 Map<String, Object> result = new HashMap<String, Object>();
			 result.put("data", resultService);
			 result.put("status", true);
			 return result;
		}
		
		public Map<String, Object> resultServiceFalse(String messageError){
			 Map<String, Object> result = new HashMap<String, Object>();
			 result.put("data", messageError);
			 result.put("status", false);
			 return result;
		}
}
