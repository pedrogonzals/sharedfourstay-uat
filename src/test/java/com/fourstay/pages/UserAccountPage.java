package com.fourstay.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class UserAccountPage {
	public UserAccountPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = ".user-name")
	public WebElement accountHolder;

	@FindBy(id = "hLocName")
	public WebElement schoolName;

	@FindBy(id = "rentoutfrom3")
	public WebElement startDate;

	@FindBy(id = "rentoutto3")
	public WebElement endDate;

	@FindBy(xpath = "//span[@class='ng-binding']")
	public List<WebElement> allPriceTags;

	@FindBy(xpath = "//html/body/div[3]/div/section/div/div/div[2]/div/div/div[1]/form/div[1]/div[1]/input")
	public WebElement firstnameBtn;

	@FindBy(css = "li.nav-gravicon .dropdown-toggle")
	public WebElement picture;

	@FindBy(linkText = "Edit Profile")
	public WebElement editProfile;

}
