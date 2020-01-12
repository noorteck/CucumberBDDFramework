package com.noorteck.qa.utilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.noorteck.qa.pages.CampaignsPage;
import com.noorteck.qa.pages.FormsPageTemp;
import com.noorteck.qa.pages.HomePage;
import com.noorteck.qa.pages.LoginPage;
import com.noorteck.qa.pages.TasksPage;

public class BaseClass extends CommonUI {

	@BeforeMethod
	public void setUp() {
		prop = ReadProperties.getProperties(environmentDataFilePath);
		openBrowser();
		navigate(prop.getProperty("url"));
		initializeClassObj();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

	public void initializeClassObj() {
		loginObj = new LoginPage();
		campaingObj = new CampaignsPage();
		homeObj = new HomePage();
		taskObj = new TasksPage();
		formsTempObj = new FormsPageTemp();
	}
}
