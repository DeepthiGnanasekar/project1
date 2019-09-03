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
	static double reservedOrderList;
	static String status;
	static int order;
	static int ref_id;
	static int iD = 3110;
	static double Set_List;
	static double reservedList;
	static double quantyList;
	static double quanty;
	static int choice;
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
					String sql = "insert into availability_List(Set_List) values (?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setDouble(1, Set_List);
					int rows=pst.executeUpdate();
					System.out.println("no of rows inserted:"+rows);
				} catch (SQLException e) {
					throw new RuntimeException("This account is already existing!!!...Please enter a valid details..." );}}
	}catch (Exception e) {
		throw new RuntimeException("Invalid Crendentials!!!...Please enter a valid admin details..." );	}
}
 static void order(UserDetails det)   
{
 System.out.println("Select Order(1)/Reservation(2)/Reserved_Order(3) : ");
  order = scan.nextInt();
if(order == 1) {
	System.out.println("******************************************************************************");
	System.out.println("\nAvailablity List of Quantity of WaterCans : "+Set_List+" "+"Units");
 System.out.println("\n******************************************************************************");
	System.out.println("Set the order quantity of Cans : ");
	quantyList = scan.nextDouble();
	if((quantyList > 0)&&(quantyList <= 100)) {
	System.out.println("Are you sure you want to order only this much quantity of Water Cans : "+quantyList+" "+"Units"+" "+" then select Yes(1) / No(2)");
	int Yes = scan.nextInt();
	if(Yes==1) {	
			try {
				String sql = "insert quantity_List(Quantity_List) values(?)";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setDouble(1, quantyList);
				int rows=pst.executeUpdate();
				System.out.println("no of rows inserted:"+rows);
			} catch (SQLException e) {
				e.printStackTrace();}	
		System.out.println("Your Order has been Confirmed... Thankyou for Ordering with us!!!");
		System.out.println(" your WaterCan unique code is : "+iD);
		System.out.println("And your reference id is : "+det.getID());
		status = "Ordered";
		try {
			String sql = "update quantity_List set STATUS=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, status);
			int rows=pst.executeUpdate();
			System.out.println("no of rows inserted:"+rows);
		} catch (SQLException e) {
			e.printStackTrace();}
		Set_List = Set_List-quantyList;
		System.out.println("Availablity List of Quantity of WaterCans : "+(Set_List)+"Units");
		String sql1 = "update availability_List set Set_List=?";
		PreparedStatement pst2;
		try {
			pst2 = con.prepareStatement(sql1);
			pst2.setDouble(1, Set_List);
			pst2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();}	
		WaterPlant.welcomePage();}
	if(Yes==2){ WaterPlant.welcomePage();}}
	if((quantyList <= 0) && (quantyList > 100)) {System.out.println("Please set the order between 0 to 100...!!!");
	WaterPlant.welcomePage();
	}}
if(order==2) {
	System.out.println("******************************************************************************");
	System.out.println("\nAvailablity List of Quantity of WaterCans : "+Set_List+" "+"Units");
 System.out.println("\n******************************************************************************");
 System.out.println("Set the resevered quantity of Cans : ");
	reservedList = scan.nextDouble();
	if((reservedList > 0)&&(reservedList <= 100)) {
	System.out.println("Are you sure you want to order only this much quantity of Water Cans : "+reservedList+" "+"Units"+" "+" then select Yes(1) / No(2)");
	int Yes = scan.nextInt();
	if(Yes==1) {	
			try {
				String sql = "insert quantity_List(Reserved_List) values (?)";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setDouble(1, reservedList);
				int rows=pst.executeUpdate();
				System.out.println("no of rows inserted:"+rows);
			} catch (SQLException e) {
				e.printStackTrace();}
		System.out.println("Your reservation has been Confirmed...!!!");
		System.out.println(" your WaterCan unique code is : "+iD);
		System.out.println("And your reference id is : "+det.getID());
		status = "Reserved...Order pending";
		try {
			String sql = "update quantity_List set STATUS=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, status);
			int rows=pst.executeUpdate();
			System.out.println("no of rows inserted:"+rows);
		} catch (SQLException e) {
			e.printStackTrace();}
		Set_List = Set_List-reservedList;
		System.out.println("Availablity List of Quantity of WaterCans : "+(Set_List)+"Units");
		String sql1 = "update availability_List set Set_List=?";
		PreparedStatement pst2;
		try {
			pst2 = con.prepareStatement(sql1);
			pst2.setDouble(1, Set_List);
			pst2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();}
		WaterPlant.welcomePage();}
	if(Yes==2){ WaterPlant.welcomePage();}}
	if(reservedList > 100) {System.out.println("Please set the reserve the quantities between 0 to 100...!!!");}
	WaterPlant.welcomePage();}
if(order == 3) {System.out.println("Enter your reference ID : ");
ref_id = scan.nextInt();
	System.out.println("******************************************************************************");
	System.out.println("\nAvailablity List of Quantity of WaterCans : "+Set_List+" "+"Units");
 System.out.println("\n******************************************************************************");
 System.out.println("Your Reference ID is : "+ref_id);
 System.out.println("Your reserved quantity of water cans is : "+reservedList);
 System.out.println("Do you want to order your reserved quantity of water cans??? : if Yes press (1)/if No press (2)/ do you want to modify the order press (3) ");
 choice = scan.nextInt();
 if(choice == 1) {
	 reservedOrderList = reservedList;
	 try {
			String sql = "update quantity_List set Reserved_Order=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, reservedOrderList);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 reservedList = 0;
	 String sql1 = "update quantity_List set Reserved_List=?";
		PreparedStatement pst2;
		try {
			pst2 = con.prepareStatement(sql1);
			pst2.setDouble(1, reservedList);
			pst2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();}
		System.out.println("Your Order has been Confirmed... Thankyou for Ordering with us!!!");
		System.out.println(" your WaterCan unique code is : "+iD);
		System.out.println("And your reference_order id is : "+det.getID());
		System.out.println("Availablity List of Quantity of WaterCans : "+(Set_List)+"Units");

		status = "ordered";
		 String sql2 = "update quantity_List set STATUS=?";
			PreparedStatement pst3;
			try {
				pst3 = con.prepareStatement(sql2);
				pst3.setString(1, status);
				pst3.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();}
			WaterPlant.welcomePage();}
 if(choice == 2) {WaterPlant.welcomePage();}
if(choice == 3) {System.out.println("Set the order quantity of Cans : ");
quanty = scan.nextDouble();
if((quanty >= 50)&&(quanty <= 100)) {
	System.out.println("Are you sure you want to modify your order for only this much quantity of Water Cans : "+quanty+" "+"Units"+" "+" then select Yes(1) / No(2)");
	int Yes = scan.nextInt();
	if(Yes==1) {	
			try {
				String sql = "update quantity_List set Reserved_Order=?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setDouble(1, quanty);
				int rows=pst.executeUpdate();
				System.out.println("no of rows inserted:"+rows);
			} catch (SQLException e) {
				e.printStackTrace();}
		System.out.println("Your reservedOrder has been Confirmed...!!!");
		System.out.println(" your WaterCan unique code is : "+iD);
		System.out.println("And your reference id is : "+det.getID());
		 reservedList = 0;
		 String sql1 = "update quantity_List set Reserved_List=?";
			PreparedStatement pst2;
			try {
				pst2 = con.prepareStatement(sql1);
				pst2.setDouble(1, reservedList);
				pst2.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();}
		status = "ordered";
		 String sql2 = "update quantity_List set STATUS=?";
			PreparedStatement pst3;
			try {
				pst3 = con.prepareStatement(sql2);
				pst3.setString(1, status);
				pst3.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();}
			quanty=reservedList-quanty;
		Set_List = Set_List+quanty;
		System.out.println("Availablity List of Quantity of WaterCans : "+(Set_List)+"Units");
		String sql3 = "update availability_List set Set_List=?";
		PreparedStatement pst4;
		try {
			pst4 = con.prepareStatement(sql3);
			pst4.setDouble(1, Set_List);
			pst4.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();}
		WaterPlant.welcomePage();}
	if(Yes == 2) {WaterPlant.welcomePage();}}
	if((quanty < 50)&&(quanty > 100)) {
		System.out.println("Please order the quantity of cans between 50 to 100 " );
		WaterPlant.welcomePage();
	}}}}}
 
 



