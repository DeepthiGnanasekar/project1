package com.revature.waterplant.validator;
import com.revature.waterplant.exception.ValidatorException;
import com.revature.waterplant.model.UserDetails;

public class UserValidator {

public static void registerValidator(UserDetails details) throws ValidatorException
{
	String name = details.getName();
	String password = details.getSet_Password();
	
	/** name validation **/
	if(name == null || "".equals(name.trim()))
	{
		throw new ValidatorException("Invalid Name!");
	}
	
	/** Password validation **/
	if(password == null || "".equals(password.trim()))
	{
		throw new ValidatorException("Invalid SetPassword!");
	}
}

/**  Login validation **/
public static void loginValidator(UserDetails details) throws ValidatorException
{
	String name = details.getName();
	String password = details.getSet_Password();
	
	/** name validation **/
	if(name == null || "".equals(name.trim()))
	{
		throw new ValidatorException("Invalid Name!");
	}
	
	/** Password validation **/
	if(password == null || "".equals(password.trim()))
	{
		throw new ValidatorException("Invalid SetPassword!");
	}
}
}