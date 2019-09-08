package com.revature.waterplant.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.dao.WaterDao;
import com.revature.waterplant.dao.WaterDaoImp;
import com.revature.waterplant.model.Details;
import com.revature.waterplant.model.UserDetails;
import com.revature.waterplant.util.ConnectionUtil;

public class Water {
	static Details ref = new Details();
	static WaterDaoImp waterdao = new WaterDao();
	static Connection con = ConnectionUtil.getConnection();
	static Scanner scan = new Scanner(System.in);
	static int stock = 0;
	static int reservedOrderList;
	static String status;
	static int order = 0;
	static int referenceid;
	static int id = 3110;
	static int availability_List;
	static int reservedList;
	static int quantyList;
	static int quanty;
	static int choice=0;
	static int yes = 0;

	public static int checkInput() {
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
	
	/* This method is for admin_login and set the availability of water can purpose*/
	
	void admin() throws SQLException, DBException {
		System.out.println("Enter Admin Name : ");
		String aname = scan.next();
		System.out.println("Enter Admin Password : ");
		String apin = scan.next();

		if ((aname.equals("Admin")) && (apin.equals("a@123"))) {
			System.out.println("Welcome Admin!!!");
			System.out.println("Select View_Stock(1)/cancel(2)");
			System.out.println("Enter your choice :");
			stock = checkInput();
			if (stock == 1) {
				int stock = 500;
				System.out.println("Avalibility stocks : " + stock + " " + "Units");
				System.out.println("\nSet the Availability Quantity of Cans : ");
				availability_List = scan.nextInt();
				System.out.println("Set the Availability Quantity of Cans : " + availability_List + " " + "Units");
				ref.setAvailability_List(availability_List);
				waterdao.admin(ref);
				System.out.println("Availabilty Set is done!!!");
			} else if (stock == 2) {
				Water a = new Water();
				a.admin();
			} else {
				System.out.println("Please enter correct choice..");
				Water a = new Water();
				a.admin();
			}
		} else {
			System.out.println("Please enter valid details...");
			Water a = new Water();
			a.admin();
		}
	}

	/* This method is for user, the user can able to order/reserve/reserve_order the cans*/
	void order(UserDetails det) throws SQLException, DBException {
		System.out.println("Select Order(1)/Reservation(2)/Reserved_Order(3) : ");
		System.out.println("Enter your choice :");
		order = checkInput();
		if (order == 1) {
			System.out.println("**************************************************************************************");
			System.out.println("  Availablity List of Quantity of WaterCans : " + availability_List + " " + "Units");
			System.out.println("**************************************************************************************");
			System.out.println("Set the order quantity of Cans : ");
			quantyList = scan.nextInt();
			if ((quantyList > 0) && (quantyList <= 100)) {
				System.out.println("Are you sure you want to order only this much quantity of Water Cans : "
						+ quantyList + " " + "Units" + " " + " then select Yes(1) / No(2)");
				System.out.println("Enter your choice :");
				yes = checkInput();
				if (yes == 1) {
					ref.setQuantyList(quantyList);
					waterdao.quantity(ref);
					System.out.println("Your Order has been Confirmed... Thankyou for Ordering with us!!!");
					System.out.println(" your WaterCan unique code is : " + id);
					System.out.println("And your reference id is : " + det.getID());
					status = "Ordered";
					ref.setStatus(status);
					waterdao.status(ref);
					availability_List = availability_List - quantyList;
					System.out.println("**************************************************************************************");
							System.out.println("  Availablity List of Quantity of WaterCans : " + availability_List + " " + "Units");
							System.out.println("**************************************************************************************");
					ref.setAvailability_List(availability_List);
					waterdao.admin1(ref);
					WaterPlant.welcomePage();
				} else if (yes == 2) {
					WaterPlant.welcomePage();
				} else {
					System.out.println("Please enter correct choice...");
					 WaterPlant.welcomePage();
				}
			}
			if ((quantyList <= 0) && (quantyList > 100)) {
				System.out.println("Please set the order between 0 to 100...!!!");
				 WaterPlant.welcomePage();
			}
		} else if (order == 2) {
			
			System.out.println("**************************************************************************************");
			System.out.println("  Availablity List of Quantity of WaterCans : " + availability_List + " " + "Units");
			System.out.println("**************************************************************************************");
			System.out.println("Set the resevered quantity of Cans : ");
			System.out.println("Enter your choice :");
			reservedList = scan.nextInt();
			if ((reservedList > 0) && (reservedList <= 100)) {
				System.out.println("Are you sure you want to order only this much quantity of Water Cans : "+ reservedList + " " + "Units" + " " + " then select Yes(1) / No(2)");
				System.out.println("Enter your choice :");
				int Yes = checkInput();
				if (Yes == 1) {
					ref.setReservedList(reservedList);
					waterdao.reserve(ref);
					System.out.println("Your reservation has been Confirmed...!!!");
					System.out.println(" your WaterCan unique code is : " + id);
					System.out.println("And your reference id is : " + det.getID());
					status = "Reserved...Order pending";
					ref.setStatus(status);
					waterdao.status(ref);
					availability_List = availability_List - reservedList;
							System.out.println("**************************************************************************************");
							System.out.println("  Availablity List of Quantity of WaterCans : " + availability_List + " " + "Units");
							System.out.println("**************************************************************************************");
					ref.setAvailability_List(availability_List);
					waterdao.admin1(ref);
					WaterPlant.welcomePage();
				}
				else if (Yes == 2) {
					WaterPlant.welcomePage();
				}
				else {
					System.out.println("Please enter correct choice...");
					 WaterPlant.welcomePage();
				}
			}
			if (reservedList > 100) {
				System.out.println("Please set the reserve the quantities between 0 to 100...!!!");
				WaterPlant.welcomePage();
			}
			
		} else if (order == 3) {
			System.out.println("Enter your reference ID : ");
			referenceid = scan.nextInt();
			System.out.println("**************************************************************************************");
			System.out.println("  Availablity List of Quantity of WaterCans : " + availability_List + " " + "Units");
			System.out.println("**************************************************************************************");
			System.out.println("Your Reference ID is : " + referenceid);
			System.out.println("Your reserved quantity of water cans is : " + reservedList);
			System.out.println("Do you want to order your reserved quantity of water cans??? : if Yes press (1)/if No press (2)/ do you want to modify the order press (3) ");
			System.out.println("Enter your choice :");
			choice = checkInput();
			if (choice == 1) {
				reservedOrderList = reservedList;
				ref.setReservedOrder(reservedOrderList);
				waterdao.reserve1(ref);
				reservedList = 0;
				ref.setReservedList(reservedList);
				waterdao.reserveu(ref);
				System.out.println("Your Order has been Confirmed... Thankyou for Ordering with us!!!");
				System.out.println(" your WaterCan unique code is : " + id);
				System.out.println("And your reference_order id is : " + det.getID());
				System.out.println("**************************************************************************************");
				System.out.println("  Availablity List of Quantity of WaterCans : " + availability_List + " " + "Units");
				System.out.println("**************************************************************************************");
				status = "ordered";
				ref.setStatus(status);
				waterdao.status(ref);
				WaterPlant.welcomePage();
			}
			else if (choice == 2) {
				WaterPlant.welcomePage();
			}
			else if (choice == 3) {
				System.out.println("Set the order quantity of Cans : ");
				quanty = scan.nextInt();
				if ((quanty >= 50) && (quanty <= 100)) {
					System.out.println("Are you sure you want to modify your order for only this much quantity of Water Cans : "+ quanty + " " + "Units" + " " + " then select Yes(1) / No(2)");
					System.out.println("Enter your choice :"); 
					yes = checkInput();
					if (yes == 1) {
						ref.setReservedOrder(quanty);
						waterdao.reserve1(ref);
						System.out.println("Your reservedOrder has been Confirmed...!!!");
						System.out.println(" your WaterCan unique code is : " + id);
						System.out.println("And your reference id is : " + det.getID());
						reservedList = 0;
						ref.setReservedList(reservedList);
						waterdao.reserveu(ref);
						status = "ordered";
						ref.setStatus(status);
						waterdao.status(ref);
						quanty = reservedList - quanty;
						availability_List = availability_List + quanty;
						System.out.println("**************************************************************************************");
					    System.out.println(	"  Availablity List of Quantity of WaterCans : " + availability_List + " " + "Units");
						System.out.println(	"**************************************************************************************");
						ref.setAvailability_List(availability_List);
						waterdao.admin1(ref);
						WaterPlant.welcomePage();}
						else if (yes == 2) {
							WaterPlant.welcomePage();
						}

						else {
							System.out.println("Please enter valid choice...");
							WaterPlant.welcomePage();
						}}
				if ((quanty < 50) && (quanty > 100)) {
					System.out.println("Please order the quantity of cans between 50 to 100 ");
					WaterPlant.welcomePage();
				}
			}
		}
		else {
			System.out.println("Invalid choice... Please try again...");
			Water w = new Water();
			w.order(det);
		}
	}
}
	
	

