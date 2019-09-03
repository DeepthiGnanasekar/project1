package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Model.UserDetails;
import jdbc.ConnectionUtil;

public class List {
static	Connection con = ConnectionUtil.getConnection();
	static Scanner scan = new Scanner(System.in);
	static int iD = 3110;
	static double Set_List;
	static double quantyList;
static void admin() {
	System.out.println("Enter Admin Name : ");
	String aname = scan.next();
	System.out.println("Enter Admin Password : ");
	String apin = scan.next();
	try
	{
		if((aname.equals("Admin")) &&(apin.equals("a@123"))) {
			System.out.println("Welcome Admin!!!");
			System.out.println("\nSet the Availability Quantity of Cans : ");
			Set_List = scan .nextDouble();
				System.out.println("Set the Availability Quantity of Cans : "+Set_List+" "+"Units");
				try {
					String sql = "insert into availabilityList(Set_List) values (?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setDouble(1, Set_List);
					int rows=pst.executeUpdate();
					System.out.println("no of rows inserted:"+rows);
				} catch (SQLException e) {
					throw new RuntimeException("This account is already existing!!!...Please enter a valid details..." );
				}
				
		}
	}catch (Exception e) {
		throw new RuntimeException("Invalid Crendentials!!!...Please enter a valid admin details..." );	}
}
 static void order(UserDetails det)   
{System.out.println("******************************************************************************");
	System.out.println("\nAvailablity List of Quantity of WaterCans : "+Set_List+" "+"Units");
 System.out.println("\n******************************************************************************");
	System.out.println("Set the order quantity  List of Cans : ");
	quantyList = scan.nextLong();
	if((0 < quantyList)&&(quantyList <= 100)) {
	System.out.println("Are you sure you want to order only this much quantity of Water Cans : "+quantyList+" "+"Units"+" "+" then select Yes(1) / No(2)");
	int Yes = scan.nextInt();
	if(Yes==1) {	
			try {
				String sql = "insert into quantityList(QuantityList) values(?)";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setDouble(1, quantyList);
				int rows=pst.executeUpdate();
				System.out.println("no of rows inserted:"+rows);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		System.out.println("Your Order has been Confirmed... Thankyou for Ordering with us!!!");
		System.out.println(" your WaterCan unique code is : "+iD);
		System.out.println("And your reference id is : "+det.getID());

		Set_List = Set_List-quantyList;
		System.out.println("Availablity List of Quantity of WaterCans : "+(Set_List)+"Units");
		String sql1 = "update availabilityList set Set_List=?";
		PreparedStatement pst1;
		try {
			pst1 = con.prepareStatement(sql1);
			pst1.setDouble(1, Set_List);
			pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		WaterPlant.welcomePage();
		
	}	if(Yes==2){ WaterPlant.welcomePage();
		}}
	
	if(quantyList > 100) {System.out.println("Please set the order between 0 to 100...!!!");
	WaterPlant.welcomePage();
	}
	}
}

