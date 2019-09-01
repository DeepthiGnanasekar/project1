package Services;
import java.sql.SQLException;
import java.util.Scanner;
import Dao.TestUserDao;
import Dao.UserDao;
import Model.UserDetails;

public class Login {
static Scanner scan =new Scanner(System.in);

	 public static void login(String name, String setPassword) throws SQLException {
		 UserDetails details = new UserDetails();
		 TestUserDao userdao=new UserDao();
			details=userdao.findByName(name,setPassword);
		 try {
			 String Name=details.getName();
			 String SetPassword=details.getSetPassword();
				if(name.equals(Name) && setPassword.equals(SetPassword)) {
					System.out.println("Logged_IN Succesfully!!! ");
					System.out.println("\n Welcome : "+details.getName());	
				}
				
			} catch (RuntimeException e) {
				throw new RuntimeException("Invalid Credentials!!!... Enter valid details...");
			}	
	}
	 void admin() {
		 System.out.println("Enter Admin Name :");
		 String a_name=scan.next();
		 System.out.println("Enter Admin Password :");
		 String a_password = scan.next();
		 System.out.println("Set the Availability List of WaterCans :");
		 int list=scan.nextInt();
	 }
}
