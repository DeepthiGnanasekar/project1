package com.revature.waterplant.services;

import java.sql.SQLException;
import java.util.Scanner;
import com.revature.waterplant.dao.UserDaoImp;
import com.revature.waterplant.dao.UserDao;
import com.revature.waterplant.model.UserDetails;

public class WaterPlant {
	static String name;
	static long mob_no;
	static String setPassword;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		List.admin();
		WaterPlant.welcomePage();
	}

	static void welcomePage() {
		System.out.println("\nWelcome to Revature Water Plant Services  ");
		System.out.println("\n");
		System.out.println("***********************************************************");
		System.out.println("   |   Register(1)  |  |   Login(2)  |  |   Exit(3)  |");
		System.out.println("***********************************************************");
		System.out.println("\n Enter Your Choice :");
		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			try {
				System.out.println("Create your account...");
				System.out.println("Enter your name :");
				name = scan.next();
				System.out.println("Enter your MobileNumber:");
				mob_no = scan.nextLong();
				System.out.println("Set Password :");
				setPassword = scan.next();
				System.out.println("Enter Submit/Cancel");
				String Submit = scan.next();
				if (Submit.equals("Submit")) {
					UserDetails details = new UserDetails();
					UserDaoImp userdao = new UserDao();
					details.setName(name);
					details.setMobile_number(mob_no);
					details.setSet_Password(setPassword);
					userdao.register(details);
					System.out.println("\n Registered Successfully!!! ");
					WaterPlant.welcomePage();
				}
				if (Submit.equals("Cancel")) {
					welcomePage();
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
		}

	}
}
