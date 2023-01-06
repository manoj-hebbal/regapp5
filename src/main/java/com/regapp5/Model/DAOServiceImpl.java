package com.regapp5.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
	Connection con;
	Statement stmnt;
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/regapp","root","manoj2756");
			stmnt= con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean VerifyCredentials(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void SaveReg(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet ListReg() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void DeleteReg(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email='"+email+"' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void UpdateReg(String email, String mobile) {
		try {
			stmnt.executeUpdate("Update registration set mobile='"+mobile+"' where email='"+email+"' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
