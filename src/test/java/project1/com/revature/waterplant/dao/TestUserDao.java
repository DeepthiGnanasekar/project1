package project1.com.revature.waterplant.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.dao.UserDao;
import com.revature.waterplant.dao.UserDaoImp;
import com.revature.waterplant.model.UserDetails;

public class TestUserDao {
	@Test
	public void testfindByNullName() throws DBException {
		UserDaoImp obj=new UserDao();
		String name=null;
		String setPassword = null;
		UserDetails details;
		try {
			details = obj.findByName(name,setPassword);
			assertNull(details);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testfindByInvalidName() throws DBException {
		UserDaoImp obj=new UserDao();
		String name="";
		String setPassword = "";
		UserDetails details;
		try {
			details = obj.findByName(name,setPassword);
			assertNull(details);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		@Test
		public void testfindByValidName() throws DBException {
			UserDaoImp obj=new UserDao();
			String name="Deeps";
			String setPassword = "d@123";
			UserDetails details;
			try {
				details = obj.findByName(name,setPassword);
				assertNotNull(details);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			    
	}

}
