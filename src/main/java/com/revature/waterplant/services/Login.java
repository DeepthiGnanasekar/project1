package com.revature.waterplant.services;
import java.sql.SQLException;
import java.util.Scanner;
import com.revature.waterplant.dao.UserDaoImp;
import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.dao.UserDao;
import com.revature.waterplant.model.UserDetails;

public class Login {
	static Scanner scan = new Scanner(System.in);
/** This method is to check the user details which is in database  
 * @throws DBException 
 * @throws SQLException **/
	public static void login(String name, String setPassword) throws DBException, SQLException {
		UserDetails details = new UserDetails();
		UserDaoImp userdao = new UserDao();
		try {
			details = userdao.findByName(name, setPassword);
			if (details == null) {
				System.out.println("Invalid Crendentials...!!! Please try again...!!!");
				WaterPlant.welcomePage();
			}
			String newName = details.getName();
			String password = details.getSet_Password();
			if (name.equals(newName) && setPassword.equals(password)) {
				System.out.println("Logged_IN Succesfully!!! ");
				System.out.println("\n Welcome : " + details.getName());
				UserDetails userd = new UserDetails();
				userd.setID(details.getID());
				Water o = new Water();
				o.order(userd);
				}
			else {
				System.out.println("Invalid Crendentials...!!!");
				WaterPlant.welcomePage();
			}

	} catch (DBException e) {
		throw new DBException("Invalid crendentials...",e);	
		}
		
		}
		
	}


