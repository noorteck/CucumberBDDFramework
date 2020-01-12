package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.noorteck.qa.utilities.BaseClass;
import com.noorteck.qa.utilities.Common;

public class CampaignsPage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'Campaigns')]")
	WebElement campaingsLink;

	@FindBy(xpath = "//button[contains(text(),'Templates')]")
	WebElement templateButton;

	@FindBy(xpath = "//button[@class='ui button']")
	WebElement newContentTemplateButton;

	@FindBy(xpath = "//div[@name='type']")
	WebElement templateType;

	@FindBy(xpath = "//div[@class='visible menu transition']//div[@class='item']")
	WebElement smsTemplateType;

	@FindBy(xpath = "//input[@name='name']")
	WebElement nameField;

	@FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
	WebElement smsBodyField;

	@FindBy(xpath = "//input[@name='subject']")
	WebElement subjectField;

	@FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
	WebElement emailBodyField;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement campaingsHeaderText;

	@FindBy(xpath = "//div[@name='type']")
	WebElement emailContentTemplate;

	@FindBy(xpath = "//div[@class='visible menu transition']//div[@class='item']")
	WebElement smsContentTemplate;

	@FindBy(xpath = "//tr[1]/td[4]/button")
	WebElement deleteIcond;

	@FindBy(xpath = "//button[text()='Delete']")
	WebElement deletePopUpButton;

	@FindBy(xpath = "//div[contains(text(),'Error')]")
	WebElement deleteErrorText;

	@FindBy(xpath = "//button[@class='ui red button']")
	WebElement errorOkButton;

	@FindBy(xpath = "//button[@class='ui black button']")
	WebElement cancelButton;

	public CampaignsPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickCampaingsLink() {
		click(campaingsLink);
	}

	public void clickTemplateButton() {
		click(templateButton);
	}

	public void clickNewContentTemplate() {
		click(newContentTemplateButton);
	}

	public void selectSmsTemplateType() {
		click(templateType);
		click(smsTemplateType);
	}

	public void enterName(String value) {
		enter(nameField, value);
	}

	public void enterSmsBody(String value) {
		enter(smsBodyField, value);
	}

	public void enterSubject(String value) {
		enter(subjectField, value);
	}

	public void enterEmailBody(String value) {
		enter(emailBodyField, value);
	}

	public void clickSave() {
		click(saveButton);
	}

	public void selectSmsContent() {

		click(emailContentTemplate);
		click(smsContentTemplate);
	}

	public String getCampaingHeaderText() {
		String actualText = getTextValue(campaingsHeaderText);
		return actualText;
	}

	public void clickDeleteEmail() {
		click(deleteIcond);
		click(deletePopUpButton);
		click(deletePopUpButton);
	}

	public void clickDeleteSms() {
		click(emailContentTemplate);
		click(smsContentTemplate);
		click(deleteIcond);
		click(deletePopUpButton);
		click(deletePopUpButton);
	}

	public void validateErrorMessage() {
		String expectedError = "Error";
		String actualError = getTextValue(deleteErrorText);
		boolean isEqual = Common.compareTwoValue(actualError, expectedError);
		Assert.assertTrue(isEqual);
		click(errorOkButton);
		click(cancelButton);

	}
}