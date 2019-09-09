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

public void validCheck(String name, String password) throws Exception
{
        if (password.length() > 7 || password.length() < 8)
        {
                throw new Exception("Password should be less than 8 characters");
        }
        if (password.indexOf(name) > -1)
        {
                throw new Exception("Password Should not be same as user name");
        }
        String upperCaseChars = "(.[A-Z].)";
        if (!password.matches(upperCaseChars ))
        {
                throw new Exception("Password should contain atleast one upper case alphabet");
        }
        String lowerCaseChars = "(.[a-z].)";
        if (!password.matches(lowerCaseChars ))
        {
                throw new Exception("Password should contain atleast one lower case alphabet");
        }
        String numbers = "(.[0-9].)";
        if (!password.matches(numbers ))
        {
                throw new Exception("Password should contain atleast one number.");
        }
        String specialChars = "(.[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if (!password.matches(specialChars ))
        {
                throw new Exception("Password should contain atleast one special character");
        }

}
}
