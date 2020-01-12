package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.utilities.BaseClass;

public class TasksPage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement taskPageLink;

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement taskHeaderText;

	@FindBy(linkText = "New")
	WebElement newButton;

	@FindBy(name = "title")
	WebElement titleField;

	@FindBy(xpath = "//div[@class='ui fluid selection dropdown']")
	WebElement assignField;

	@FindBy(css = ".visible.transition .text")
	WebElement assignFieldValue;

	@FindBy(xpath = "//div[3]//div[1]//div[1]//div[1]//div[1]//input[1]")
	WebElement dueDateField;

	@FindBy(xpath = "//div[@name='deal']//input[@class='search']")
	WebElement dealField;

	@FindBy(xpath = "//div[5]//div[1]//div[1]//div[1]//div[1]//input[1]")
	WebElement closeDateField;

	@FindBy(name = "description")
	WebElement descriptionField;

	@FindBy(name = "completion")
	WebElement completionField;

	@FindBy(xpath = "//div[@name='status']")
	WebElement statusDropDown;

	@FindBy(xpath = "//div[@class='visible menu transition']//div[2]")
	WebElement statusOption;

	@FindBy(xpath = " //div[@name='type']")
	WebElement typeDropDown;

	@FindBy(xpath = "//span[contains(text(),'Technical Support')]")
	WebElement typeOption;

	@FindBy(xpath = "//div[@name='contact']//input[@class='search']")
	WebElement contactField;

	@FindBy(xpath = "//div[@name='case']//input[@class='search']")
	WebElement caseField;

	@FindBy(xpath = "//div[@name='priority']")
	WebElement priorityDropDown;

	@FindBy(xpath = "//div[@class='visible menu transition']//div[2]")
	WebElement priorityOption;

	@FindBy(css = "input[name='identifier']")
	WebElement identifierField;

	@FindBy(css = ".save.icon")
	WebElement saveButton;

	@FindBy(xpath = "//tr[1]//td[1]")
	WebElement checkBoxRowOne;

	@FindBy(xpath = "//tr[1]//td[7]//div[1]//button[1]")
	WebElement deleteButtonRowOne;

	@FindBy(xpath = "//button[@class='ui button']")
	WebElement deletePopUp;

	@FindBy(xpath = "//p[contains(text(),'The field Title is required')]")
	WebElement titleError;

	@FindBy(xpath = "//*[@id=\"ui\"]//p")
	WebElement titleHeader;

	public TasksPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickNew() {
		click(newButton);
	}

	public void enterTitle(String value) {
		enter(titleField, value);
	}

	public void assignTo() {
		click(assignField);
		click(assignFieldValue);
	}

	public void enterDeal(String value) {

		enterWithKey(dealField, value);
	}

	public void enterDiscription(String value) {
		enter(descriptionField, value);
	}

	public void enterCompletion(String value) {
		enter(completionField, value);
	}

	public void enterContact(String value) {

		enterWithKey(contactField, value);
	}

	public void enterCase(String value) {

		enterWithKey(caseField, value);
	}

	public void enterIdentifier(String value) {
		enter(identifierField, value);
	}

	public void enterDueDate(String date) {
		enterWithKey(dueDateField, date);
	}

	public void enterCloseDate(String date) {
		enterWithKey(closeDateField, date);
	}

	public void selectType() {
		click(typeDropDown);
		click(typeOption);
	}

	public void selectStatus() {
		click(statusDropDown);
		click(statusOption);
	}

	public void selectPriority() {
		click(priorityDropDown);
		click(priorityOption);
	}

	public void clickSave() {
		click(saveButton);
	}

	public String getTaskHeaderText() {
		String actualText = getTextValue(taskHeaderText);
		return actualText;
	}

	public void clickTaskLink() {
		click(taskPageLink);
	}

	public void clickCheckBox() {
		selectCheckBox(checkBoxRowOne);
	}

	public void deleteRowOne() {
		click(deleteButtonRowOne);
		click(deletePopUp);
	}

	public String getTitleError() {
		return getTextValue(titleError);
	}

	public String getTitleHeaderText() {
		return getTextValue(titleHeader);
	}
}
