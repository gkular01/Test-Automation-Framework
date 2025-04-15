package com.ui.pages;
// follow page object design pattern.

import org.apache.logging.log4j.Logger;

//rules to create a page class:
// variables created inside the class and are static are called class variables
//variables created inside the class and are non static are instance variable.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR = By.className("login");

	public HomePage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless);// To call the parent class constructor from the child constructor
		goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());

	}

	public HomePage(WebDriver driver) {
		super(driver);// To call the parent class constructor from the child constructor
		goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());

	}

	public LoginPage goToLoginPage() {// page functions, can't return void in page functions.
		logger.info("Trying to perform click on the login page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;// always return the object reference.
	}

	

	
}
