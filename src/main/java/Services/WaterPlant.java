package Services;
import java.sql.Connection;
import java.util.Scanner;

import jdbc.ConnectionUtil;

public class WaterPlant {
	
	static String name;
	static long mobno;
	static String setPassword;
	static Scanner scan =new Scanner(System.in);
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		Connection con = ConnectionUtil.getConnection();
		WaterPlant.welcomePage();
	}
	
	public static void welcomePage() throws Exception {
		System.out.println("   Welcome to Revature Water Plant Services  ");
		System.out.println("\n");
		System.out.println("***********************************************************");
		System.out.println("   |   Register(1)  |  |   Login(2)  |  |   Exit(3)  |");
		System.out.println("***********************************************************");
		System.out.println("\n Enter Your Choice :");
		int choice=scan.nextInt();
		
			switch (choice) {
			case 1:
				try { 
					System.out.println("Create your account...");
				System.out.println("Enter your name :");
		        name = scan.next();
		        System.out.println("Enter your MobileNumber:");
				long mob_no = scan.nextLong();
				System.out.println("Set Password :");
				String setPassword = scan.next();
				System.out.println("Enter Submit/Cancel");
				String Submit = scan.next();
				if(Submit.equals("Submit")) {
				Register.register(name,mob_no,setPassword);}
				if(Submit.equals("Cancel")) {
					welcomePage();}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter your Login Name :");
				String Name=scan.next();
				System.out.println("Enter your Password :");
				String setPassword=scan.next();
					Login.login(Name,setPassword);
					break;
			case 3:
				System.out.println("\nThank you for using our services!!!...");
				break;
			}
		
				
			}}

