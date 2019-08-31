package Dao;

import java.sql.SQLException;

import Model.UserDetails;

public interface TestUserDao {
	UserDetails findByName(String name, String setPassword) throws SQLException;

	
}
