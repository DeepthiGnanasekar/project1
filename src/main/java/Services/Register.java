package Services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.ConnectionUtil;

public  class Register {
	
	static Scanner sc =new Scanner(System.in);
	
	public static  void register(String name,long mob_no,String setPassword) throws Exception {
		 Connection con = ConnectionUtil.getConnection();
		try {
			String sql = "insert into userInfo(Name,Mobile_Number,Set_Password) values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setLong(2, mob_no);
			pst.setString(3, setPassword);
			int rows=pst.executeUpdate();
			System.out.println("no of rows inserted:"+rows);
			System.out.println("\n Registered Successfully!!! ");
			WaterPlant.welcomePage();
		} catch (SQLException e) {
			throw new RuntimeException("This account is already existing!!!...Please enter a valid details..." );
		}
		
	}
}
