package com.gordon.doc_repo.utils;

public class EmailUtils {
	
	public static String getEmailMessage(String name, String host, String token) {
		
		return "Hello "+name + ",\n\n Your new account has been created. Please click on the link below to verify your account \n\n" +
		getverificationUrl(host, token) + "\n\nThe Support team";
	}
	
	public static String getResetPasswordMessage(String name, String host, String token) {
		return "Hello "+name + ",\n\n Your new account reset password token ha been set. Please click on the link below to reset your account \n\n" +
				getResetPasswordUrl(host, token) + "\n\nThe Support team";
	}

	public static String getverificationUrl(String host, String token) {
		return "verify/account?token="+token;
	}
   
	public static String getResetPasswordUrl(String host, String token) {
		return "verify/password?token="+token;
	}

}
