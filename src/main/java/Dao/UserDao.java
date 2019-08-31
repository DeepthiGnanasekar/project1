package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.UserDetails;
import jdbc.ConnectionUtil;

public class UserDao implements TestUserDao{
	public UserDetails findByName(String name, String setPassword) throws SQLException{
		Connection con = ConnectionUtil.getConnection();
		String sql = "select Name, MobileNumber,SetPassword from waterPlant_db where Name = ? and SetPassword = ?";
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

	private UserDetails toRow(ResultSet rs) throws SQLException {

		String name = rs.getString("Name");
		Long mob_no = rs.getLong("MobNo");
		String setPassword = rs.getString("SetPassword");
		UserDetails user = new UserDetails();
		user.setName(name);
		user.setMob_no(mob_no);
		user.setSetPassword(setPassword);
		return user;
	}

	
}
