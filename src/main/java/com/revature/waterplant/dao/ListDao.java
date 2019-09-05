package com.revature.waterplant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.waterplant.model.ListDetails;
import com.revature.waterplant.jdbc.ConnectionUtil;

public class ListDao implements TestListDao {
	Connection con = ConnectionUtil.getConnection();
	public void admin(ListDetails list)
	{
		try {
			String sql = "insert into availability_List(Set_List) values (?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, list.getSet_List());
			int rows=pst.executeUpdate();
			System.out.println("no of rows inserted:"+rows);
		} catch (SQLException e) {
			throw new RuntimeException("This account is already existing!!!...Please enter a valid details..." );}
	}
	public void admin1(ListDetails list)
	{
		try {
			String sql = "update availability_List set Set_List=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, list.getSet_List());
			int rows=pst.executeUpdate();
			System.out.println("no of rows inserted:"+rows);
		} catch (SQLException e) {
			throw new RuntimeException("This account is already existing!!!...Please enter a valid details..." );}
	}
	
	public void quantity(ListDetails list) {
	try {
		String sql = "insert into quantity_List(Quantity_List) values(?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setDouble(1, list.getQuantyList());
		int rows=pst.executeUpdate();
		System.out.println("no of rows inserted:"+rows);
	} catch (SQLException e) {
		e.printStackTrace();}	}
	
	public void reserve(ListDetails list) {
	try {
		String sql = "insert quantity_List(Reserved_List) values (?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setDouble(1, list.getReservedList());
		int rows=pst.executeUpdate();
		System.out.println("no of rows inserted:"+rows);
	} catch (SQLException e) {
		e.printStackTrace();}}

	public void reserveu(ListDetails list) {
	try {
		String sql = "update quantity_List set Reserved_List=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setDouble(1, list.getReservedList());
		int rows=pst.executeUpdate();
		System.out.println("no of rows inserted:"+rows);
	} catch (SQLException e) {
		e.printStackTrace();}}
	
	public void reserve1(ListDetails list) {
	 try {
			String sql = "update quantity_List set Reserved_Order=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, list.getReservedOrder());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();}
		}
	
	public void status(ListDetails list) {
	try {
		String sql = "update quantity_List set STATUS=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, list.getStatus());
		int rows=pst.executeUpdate();
		System.out.println("no of rows inserted:"+rows);
	} catch (SQLException e) {
		e.printStackTrace();}}
}
