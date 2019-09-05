package com.revature.waterplant.dao;

import java.sql.SQLException;

import com.revature.waterplant.model.UserDetails;

public interface UserDaoImp {
	UserDetails findByName(String name, String setPassword) throws SQLException;

	UserDetails findByID(int id) throws SQLException;

	void register(UserDetails details);

}
