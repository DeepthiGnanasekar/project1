/*WaterPlant Project*/
/*This Application is used for both admin_of_the_waterplant Services and user(customer)*/
/* Admin_of_the_waterplant Services can set the availability number of watercans_in_the_WaterPlant which can be viewed by the user anytime_before_ordering the can*/
/*User can able to order/reserve/can able to modify the order based on the availability*/
package com.revature.waterplant.services;
import java.sql.SQLException;
import java.util.Scanner;
import com.revature.waterplant.dao.UserDaoImp;
import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.dao.UserDao;
import com.revature.waterplant.model.UserDetails;


public class WaterPlant {
	static String name;
	static long mobileNumber;
	static String setPassword;
	static Scanner scan = new Scanner(System.in);
	
	
		public static void main(String[] args) throws DBException, SQLException {
			Water a = new Water();
			a.admin();
			WaterPlant.welcomePage();
			}
	
	
	public static int checkNumber() {
		boolean result = false;
		int choice = 0;
		while(result!=true) {
			try {
				String s =scan.next();
				choice= Integer.parseInt(s);
				result = true;
				break;
			}catch(Exception e) {
				System.out.println("Enter your choice :");
			}
			
		}
		return choice;
	}
	
	
/*This method is used for the user registration or user login purpose*/
	
	 public static void welcomePage() throws DBException {
		System.out.println("\nWelcome to Revature Water Plant Services  ");
		System.out.println("\n");
		System.out.println("***********************************************************");
		System.out.println("   |   Register(1)  |  |   Login(2)  |  |   Exit(3)  |");
		System.out.println("***********************************************************");
		System.out.println("\n Enter Your Choice :");
		int choice = checkNumber();

		switch (choice) {
		case 1:
			try {
				System.out.println("Create your account...");
				System.out.println("Enter your name :");
				name = scan.next();
				System.out.println("Enter your Mobile Number:");
				mobileNumber = scan.nextLong();
				System.out.println("Set Password :");
				setPassword = scan.next();
				System.out.println("Click Submit/Cancel");
				String Submit = scan.next();
				if (Submit.equals("Submit")) {
				  
					UserDetails details = new UserDetails();
					UserDaoImp userdao = new UserDao();
					details.setName(name);
					details.setMobileNumber(mobileNumber);
					details.setSet_Password(setPassword);
					userdao.register(details);
					System.out.println("\n Registered Successfully!!! ");
					 WaterPlant.welcomePage();
				}
				else if (Submit.equals("Cancel")) {
					welcomePage();
				}
				else {System.out.println("Invalid selection...please try again...");
				 WaterPlant.welcomePage();
}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case 2:
			System.out.println("Enter your Login Name :");
			name = scan.next();
			System.out.println("Enter your Password :");
			setPassword = scan.next();
			try {
				Login.login(name, setPassword);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("\nThank you for using our services!!!...");
			break;
			
			default : {System.out.println("Invalid Choice...Please try again...");
			 WaterPlant.welcomePage();}
		}

	}
}
