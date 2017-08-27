package com.fourstay.utilities;

public class checkEmail {

	public static void checkingEmailMatch(String EmailName, String firstName, String lastName, String email) {
		if (email.equals(EmailName.toUpperCase())) {

			String MatchEmail = "email match";
			System.out.println(firstName + " " + lastName + " " + email + " " + MatchEmail);
		} else {
			String MatchEmail = " no email match";
			System.out.println(firstName + " " + lastName + " " + email + " " + MatchEmail);

		}
	}

}
