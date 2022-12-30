package com.crud.dao;

import java.sql.Statement;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.crud.model.Crudmodel;
import com.crud.service.Crudinterface;

public class Cruddao implements Crudinterface {

	@Override
	public String postMethod(Crudmodel value) {
		String insertQuery = "insert into cruddetails(username,email,phoneno,password)" + "values('"
				+ value.getUsername() + "','" + value.getEmail() + "','" + value.getPhoneno() + "','"
				+ value.getPassword() + "')";
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root",
				"Kiruthi@2505"); Statement statement = connection.createStatement();) {
		 	statement.executeUpdate(insertQuery);
			System.out.println(insertQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Success";
	}

	public String deleteMethod(int id) {
		String deleteQuery = "delete from cruddetails where id=" + id + "";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root",
				"Kiruthi@2505"); Statement statement = connection.createStatement();) {
			statement.executeUpdate(deleteQuery);
			System.out.println(deleteQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Success";
	}

	public String putMethod(int id) {
		String updateQuery = "update cruddetails set username='kirithi' where id=" +id+ "";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root",
				"Kiruthi@2505"); Statement statement = connection.createStatement();) {
			statement.executeUpdate(updateQuery);
			System.out.println(updateQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Success";
	}

	@SuppressWarnings("unchecked")
	public JSONArray getMethod(int id) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		String selectQuery = "select * from cruddetails where id=" + id + "";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root",
				"Kiruthi@2505"); Statement statement = connection.createStatement();) {
			// statement.executeQuery(selectQuery);
			ResultSet rs = statement.executeQuery(selectQuery);
			while (rs.next()) {
				jsonObject.put("Name:", rs.getObject("username"));
				jsonObject.put("Email:", rs.getObject("email"));
				jsonObject.put("Phoneno:", rs.getObject("phoneno"));
				jsonObject.put("Password:", rs.getObject("password"));
				jsonArray.add(jsonObject);
			}
			System.out.println(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}

	@SuppressWarnings("unchecked")
	public JSONArray getallMethod() {
		String selectQuery = "select * from cruddetails";
		
		JSONArray jsonArray = new JSONArray();	
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root",
				"Kiruthi@2505"); 
		   Statement statement = connection.createStatement();) {
			
			// statement.executeQuery(selectQuery);
			ResultSet rs = statement.executeQuery(selectQuery);
			while(rs.next()) {
				JSONObject Object = new JSONObject(); 
				Object.put("Name:", rs.getObject("username"));
				Object.put("Email:", rs.getObject("email"));
				Object.put("Phoneno:", rs.getObject("phoneno"));
				Object.put("Password:", rs.getObject("password"));
//				System.out.println(jsonObject);
				jsonArray.add(Object); 
			}
			System.out.println(jsonArray);
	      
	    }

		catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
}
