package com.revature.waterplant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.waterplant.model.Details;
import com.revature.waterplant.util.ConnectionUtil;

public class WaterDao implements WaterDaoImp {
	Connection con = ConnectionUtil.getConnection();

	public void admin(Details water) {
		try {
			String sql = "insert into availability_List(Availability_List) values (?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, water.getAvailability_List());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void admin1(Details water) {
		try {
			String sql = "update availability_List set Availability_List=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, water.getAvailability_List());
		  pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void quantity(Details water) {
		try {
			String sql = "insert into quantity_List(Quantity_List) values(?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, water.getQuantyList());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reserve(Details water) {
		try {
			String sql = "insert quantity_List(Reserved_List) values (?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, water.getReservedList());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reserveu(Details water) {
		try {
			String sql = "update quantity_List set Reserved_List=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, water.getReservedList());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reserve1(Details water) {
		try {
			String sql = "update quantity_List set Reserved_Order=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, water.getReservedOrder());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void status(Details water) {
		try {
			String sql = "update quantity_List set STATUS=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, water.getStatus());
			int rows = pst.executeUpdate();
			System.out.println("no of rows inserted:" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}