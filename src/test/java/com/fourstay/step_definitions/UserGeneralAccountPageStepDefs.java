package com.fourstay.step_definitions;

import java.util.List;

import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.DBUtility;
import com.fourstay.utilities.DBUtility.DBType;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.checkEmail;

import cucumber.api.java.en.Then;

public class UserGeneralAccountPageStepDefs {

	UserAccountPage userAccPage = new UserAccountPage();

	@Then("^I am on the General Account Setting page$")
	public void i_am_on_the_General_Account_Setting_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Driver.getInstance().get(ConfigurationReader.getProperty("userAccountpage"));

	}

	@Then("^I verify credentials with database$")
	public void i_verify_credentials_with_database() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		String actualEmail = "sking@testmail.com";
		String[] EmailString = actualEmail.split("@");
		String EmailName = EmailString[0];

		String sqlstatement = "SELECT * from employees";

		DBUtility.establishConnection(DBType.MYSQL);

		List<String[]> queryResultsList = DBUtility.runSQLQuery(sqlstatement);

		DBUtility.closeConnections();

		for (int rowNum = 0; rowNum < queryResultsList.size(); rowNum++) {

			String[] rowData = queryResultsList.get(rowNum);

			String employeeID = rowData[0];
			String firstName = rowData[1];
			String lastName = rowData[2];
			String email = rowData[3];

			String phone = rowData[4];
			String startDate = rowData[6];
			String salary = rowData[7];

			checkEmail.checkingEmailMatch(EmailName, firstName, lastName, email);

		}

	}

}
