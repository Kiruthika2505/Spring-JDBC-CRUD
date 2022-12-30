package com.crud.controller;

import org.json.simple.JSONArray;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.dao.Cruddao;
import com.crud.model.Crudmodel;

@Controller

@RequestMapping("/controller")
public class Crudcontroller {

	Cruddao obj = new Cruddao();

	@PostMapping("/post")
//	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<String> postMethod(@RequestBody Crudmodel value) {
		return ResponseEntity.ok(obj.postMethod(value));
	}  
	
	@DeleteMapping("/delete")
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteMethod(@RequestParam int id) {
		return ResponseEntity.ok(obj.deleteMethod(id));
	}
	@PutMapping("/put")
//	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	public ResponseEntity<String> putMethod(@RequestParam int id) {
		return ResponseEntity.ok(obj.putMethod(id)); 
	}
	@GetMapping("/get")
	public ResponseEntity<JSONArray> getMethod(@RequestParam int id) {
		return ResponseEntity.ok(obj.getMethod(id));
	}    
	@GetMapping("/getall")
	public ResponseEntity<JSONArray> getallMethod() {
		return ResponseEntity.ok(obj.getallMethod());
	}  
}
