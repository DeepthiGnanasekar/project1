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
		 String Name=details.getName();
		 String SetPassword=details.getSet_Password();
			if(name.equals(Name) && setPassword.equals(SetPassword)) {
				System.out.println("Logged_IN Succesfully!!! ");
				System.out.println("\n Welcome : "+details.getName());
				UserDetails obj = new UserDetails();
				obj.setID(details.getID());
				List.order(obj);
			}	
	}
	
}
