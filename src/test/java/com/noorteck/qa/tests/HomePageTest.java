package com.noorteck.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.noorteck.qa.utilities.BaseClass;
import com.noorteck.qa.utilities.Common;

public class HomePageTest extends BaseClass {

	@Test
	public void homePageTitleTest() {
		String expectedTitle = "Cogmento CRM";
		String actualTitle = homeObj.getHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void homePageUserNameTest() {
		String expectedUserName = "fahim noor";
		String actualUserName = homeObj.getUserNameText();
		boolean isEqual = Common.compareTwoValue(actualUserName, expectedUserName);
		Assert.assertTrue(isEqual);
	}

}
