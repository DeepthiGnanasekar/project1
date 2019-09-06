package com.revature.waterplant.services;
import java.sql.SQLException;
import java.util.Scanner;
import com.revature.waterplant.dao.UserDaoImp;
import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.dao.UserDao;
import com.revature.waterplant.model.UserDetails;

public class Login {
	static Scanner scan = new Scanner(System.in);

	public static void login(String name, String setPassword) throws SQLException, DBException {
		UserDetails details = new UserDetails();
		UserDaoImp userdao = new UserDao();
		details = userdao.findByName(name, setPassword);
		String Name = details.getName();
		String SetPassword = details.getSet_Password();
		if (name.equals(Name) && setPassword.equals(SetPassword)) {
			System.out.println("Logged_IN Succesfully!!! ");
			System.out.println("\n Welcome : " + details.getName());
			UserDetails obj = new UserDetails();
			obj.setID(details.getID());
			List o = new List();
			o.order(obj);
		}
	}

}
