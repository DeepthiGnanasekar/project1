package com.revature.waterplant.dao;

import java.sql.SQLException;

import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.Details;

public interface WaterDaoImp {
	void admin(Details water)throws  SQLException, DBException;

	void admin1(Details water)throws  SQLException, DBException;

	void quantity(Details water)throws  SQLException, DBException;

	void status(Details water)throws  SQLException, DBException;

	void reserve(Details water)throws  SQLException, DBException;

	void reserve1(Details water)throws  SQLException, DBException;

	void reserveu(Details water)throws  SQLException, DBException;

}