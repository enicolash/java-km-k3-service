package com.km.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckConnectionController {
	
	public static final Logger Logger = LoggerFactory.getLogger(CheckConnectionController.class);
	 @GetMapping("/")
	    public String index() throws Exception {
	        String result = "";
	        try {
	            result = "KNOWLEDGE MANAGEMENT SERVICE JAVA V.1";
	        } catch (Exception e) {
	            result = "Koneksi Gagal<br/>" + e.getMessage();
	        }
	        return result;
	    }
	 
}
