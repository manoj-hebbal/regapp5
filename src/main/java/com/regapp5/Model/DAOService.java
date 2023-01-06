package com.regapp5.Model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean VerifyCredentials(String email,String password);
	public void SaveReg(String name,String city,String email,String mobile);
	public ResultSet ListReg();
	public void DeleteReg(String email);
	public void UpdateReg(String email,String mobile);
}
