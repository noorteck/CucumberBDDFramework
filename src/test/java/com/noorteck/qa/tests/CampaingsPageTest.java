package com.noorteck.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.noorteck.qa.utilities.BaseClass;
import com.noorteck.qa.utilities.Common;

public class CampaingsPageTest extends BaseClass {

	@Test(priority = 1)
	public void campaingsPageHeaderTest() {
		String expectedText = "Campaigns";
		campaingObj.clickCampaingsLink();
		String actualText = campaingObj.getCampaingHeaderText();

		// Assertions
		boolean isEqual = Common.compareTwoValue(actualText, expectedText);
		Assert.assertTrue(isEqual);

	}

	@Test(priority = 3)
	public void campaingsPageCreateSmSMessage() {
		campaingObj.clickCampaingsLink();
		campaingObj.clickTemplateButton();
		campaingObj.clickNewContentTemplate();
		campaingObj.selectSmsTemplateType();
		campaingObj.enterName("Rajesh");
		campaingObj.enterSmsBody("SDET");
		campaingObj.clickSave();
		// Assert.assertTrue(controlFlag, "Successfully Created New SMS Message");
	}

	@Test(priority = 2)
	public void campaingsPageCreateEmailMessage() {

		campaingObj.clickCampaingsLink();
		campaingObj.clickTemplateButton();
		campaingObj.clickNewContentTemplate();
		campaingObj.enterName("Rajesh ");
		campaingObj.enterSubject("Code REview");
		campaingObj.enterEmailBody("Skype Meeting");
		campaingObj.clickSave();
		// Assert.assertTrue(controlFlag, "Successfully Created New Email Message");

	}

	@Test(priority = 5)
	public void campaingsPageRemoveSmSMessage() {
		campaingObj.clickCampaingsLink();
		campaingObj.clickTemplateButton();
		campaingObj.selectSmsContent();
		campaingObj.clickDeleteSms();
		campaingObj.validateErrorMessage();
		// Assert.assertTrue(true, "Successfully Removed SMS Message");

	}

	@Test(priority = 4)
	public void campaingsPageRemoveEmailMessage() {
		campaingObj.clickCampaingsLink();
		campaingObj.clickTemplateButton();
		campaingObj.clickDeleteEmail();
		campaingObj.validateErrorMessage();
		// Assert.assertTrue(true, "Successfully Removed Email Message");

	}

}
