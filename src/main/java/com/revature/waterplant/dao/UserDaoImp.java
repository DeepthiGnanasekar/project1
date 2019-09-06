package com.revature.waterplant.dao;

import java.sql.SQLException;

import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.UserDetails;

public interface UserDaoImp {
	UserDetails findByName(String name, String setPassword) throws SQLException, DBException;

	UserDetails findByID(int id) throws SQLException, DBException;

	void register(UserDetails details) throws SQLException, DBException;

}
