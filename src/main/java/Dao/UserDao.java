package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.UserDetails;
import jdbc.ConnectionUtil;

public class UserDao implements TestUserDao{
	Connection con = ConnectionUtil.getConnection();
	public UserDetails findByName(String name, String setPassword) throws SQLException{
		
		String sql = "select ID, Name, MobileNumber,SetPassword from userInfo where Name = ? and SetPassword = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, setPassword);
		ResultSet rs = pst.executeQuery();
		UserDetails details = null;
		if (rs.next()) {
			details = toRow(rs);
		}
		return details;
	}
	public UserDetails findByID(int id) throws SQLException{
		String sql = "select ID, Name, MobileNumber,SetPassword from userInfo where ID = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs1 = pst.executeQuery();
		UserDetails did = null;
		if (rs1.next()) {
			did = toRow1(rs1);
		}
		return did;
	}
	private UserDetails toRow(ResultSet rs) throws SQLException {
        int id = rs.getInt("ID");
		String name = rs.getString("Name");
		long mob_no = rs.getLong("MobileNumber");
		String setPassword = rs.getString("SetPassword");
		UserDetails user = new UserDetails();
		user.setID(id);
		user.setName(name);
		user.setMobilenumber(mob_no);
		user.setSetPassword(setPassword);
		return user;
	}
	private UserDetails toRow1(ResultSet rs1) throws SQLException {
        int id = rs1.getInt("ID");
		String name = rs1.getString("Name");
		long mob_no = rs1.getLong("MobileNumber");
		String setPassword = rs1.getString("SetPassword");
		UserDetails user = new UserDetails();
		user.setID(id);
		user.setName(name);
		user.setMobilenumber(mob_no);
		user.setSetPassword(setPassword);
		return user;
	}
}