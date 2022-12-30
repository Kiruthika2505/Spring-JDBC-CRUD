package com.crud.service;

import org.json.simple.JSONArray;

import org.springframework.stereotype.Component;

import com.crud.model.Crudmodel;

@Component
public interface Crudinterface {
	public String postMethod(Crudmodel value); 
	public String deleteMethod(int id);
	public String putMethod(int id);
	public JSONArray getMethod(int id);
	public JSONArray getallMethod();
}
 