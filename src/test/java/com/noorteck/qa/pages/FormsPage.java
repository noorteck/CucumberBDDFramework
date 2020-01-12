package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.noorteck.qa.utilities.BaseClass;
import com.noorteck.qa.utilities.Common;

public class FormsPage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'Forms')]")
	WebElement formsLink;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement newButton;

	@FindBy(name = "name")
	WebElement nameField;

	@FindBy(name = "intro")
	WebElement introTextField;

	@FindBy(name = "outro")
	WebElement completionTextField;

	@FindBy(xpath = "//label[contains(text(),'Active')]")
	WebElement activeCheckBox;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveButton;

	@FindBy(xpath = "//tr[1]//td[1]")
	WebElement checkboxRowOne;

	@FindBy(xpath = "//tr[1]//td[6]//div[1]//button[1]")
	WebElement deleteButtonRowOne;

	@FindBy(xpath = "//button[@class='ui button']")
	WebElement deletePopUp;

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement formsHeaderText;

	@FindBy(xpath = "//tr[1]//td[6]//a[2]//button[1]")
	WebElement editButton;

	public FormsPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickFormsLink() {
		click(formsLink);
	}

	public void clickNewButton() {
		click(newButton);
	}

	public void enterName(String value) {
		enter(nameField, value);
	}

	public void enterIntroText(String value) {
		enter(introTextField, value);
	}

	public void enterCompletionText(String value) {
		enter(completionTextField, value);
	}

	public void clickActiveCheckBox() {
		click(activeCheckBox);
	}

	public void clickSave() {
		click(saveButton);
	}

	public void clickCheckBox() {
		selectCheckBox(checkboxRowOne);
	}

	public void deleteRowOne() {

		click(deleteButtonRowOne);
		click(deletePopUp);

	}

	public String getFormHeaderText() {
		String actualText = getTextValue(formsHeaderText);
		return actualText;
	}

	public String getFormsPageTitle() {
		return getTitle();
	}
}
