package com.revature.waterplant.dao;

import java.sql.SQLException;

import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.ListDetails;

public interface ListDaoImp {
	void admin(ListDetails list)throws  SQLException, DBException;

	void admin1(ListDetails list)throws  SQLException, DBException;

	void quantity(ListDetails list)throws  SQLException, DBException;

	void status(ListDetails list)throws  SQLException, DBException;

	void reserve(ListDetails list)throws  SQLException, DBException;

	void reserve1(ListDetails list)throws  SQLException, DBException;

	void reserveu(ListDetails list)throws  SQLException, DBException;

}