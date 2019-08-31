package Services;
import java.sql.SQLException;
import java.util.Scanner;
import Dao.TestUserDao;
import Dao.UserDao;
import Model.UserDetails;

public class Login {
static Scanner scan =new Scanner(System.in);

	 static void login(String name, String setPassword) throws SQLException {
		 UserDetails details = new UserDetails();
		 TestUserDao userdao=new UserDao();
			details=userdao.findByName(name,setPassword);
		 try {
				
			 String Name=details.getName();
			 String SetPassword=details.getSetPassword();
				
				if(name==Name && setPassword==SetPassword) {
					
					System.out.println("Login Succesfully!!! ");
					System.out.println("\n Your Name: "+details.getName());
					System.out.println("Your  Mobile Number: "+details.getMob_no());
					
					
				}
				
			} catch (RuntimeException e) {
				throw new RuntimeException("Invalid Credentials!!!... Enter valid details...");
			}	
		
	}
}
