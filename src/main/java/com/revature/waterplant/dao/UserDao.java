package com.revature.waterplant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.waterplant.model.UserDetails;
import com.revature.waterplant.jdbc.ConnectionUtil;

public class UserDao implements UserDaoImp {
	Connection con = ConnectionUtil.getConnection();

	public void register(UserDetails user) {
		try {
			String sql = "insert into user_Info(Name,Mobile_Number,Set_Password) values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setLong(2, user.getMobile_number());
			pst.setString(3, user.getSet_Password());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);

		} catch (SQLException e) {
			throw new RuntimeException("This account is already existing!!!...Please enter a valid details...");
		}
	}

	public UserDetails findByName(String name, String setPassword) {
		UserDetails details = null;
		try {
			String sql = "select ID, Name, Mobile_Number,Set_Password from user_Info where Name = ? and Set_Password = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, setPassword);
			ResultSet rs = pst.executeQuery();
			details = new UserDetails();
			if (rs.next()) {
				details = toRow(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}

	public UserDetails findByID(int id) throws SQLException {
		UserDetails did = null;
		try {
			String sql = "select ID, Name, Mobile_Number,Set_Password from user_Info where ID = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs1 = pst.executeQuery();

			if (rs1.next()) {
				did = toRow1(rs1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return did;
	}

	private UserDetails toRow(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID");
		String name = rs.getString("Name");
		long mob_no = rs.getLong("Mobile_Number");
		String setPassword = rs.getString("Set_Password");
		UserDetails user = new UserDetails();
		user.setID(id);
		user.setName(name);
		user.setMobile_number(mob_no);
		user.setSet_Password(setPassword);
		return user;
	}

	private UserDetails toRow1(ResultSet rs1) throws SQLException {
		int id = rs1.getInt("ID");
		String name = rs1.getString("Name");
		long mob_no = rs1.getLong("Mobile_Number");
		String setPassword = rs1.getString("Set_Password");
		UserDetails user = new UserDetails();
		user.setID(id);
		user.setName(name);
		user.setMobile_number(mob_no);
		user.setSet_Password(setPassword);
		return user;
	}

}