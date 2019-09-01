package Services;

import java.util.Scanner;

public class List {
	Scanner scan = new Scanner(System.in);
void admin() {
	System.out.println("Enter Admin Name : ");
	String aname = scan.next();
	System.out.println("Enter Admin Password : ");
	String apin = scan.next();
	try
	{
		if((aname.equals("Admin")) &&(apin.equals("a@123"))) {
			System.out.println("Welcome Admin!!!");
			System.out.println("Set the Availability List of Cans : ");
			
		}
	}catch (Exception e) {
		throw new RuntimeException("Invalid Crendentials!!!...Please enter a valid admin details..." );	}
}
}
