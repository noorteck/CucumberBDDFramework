package com.noorteck.qa.steps;

import java.util.List;
import java.util.Map;

import com.noorteck.qa.utilities.BaseClass;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormsStepDefinition extends BaseClass {

	@When("^User navigates to Forms page$")
	public void navigateToForm() {
		formsTempObj.clickFormsLink();
	}

	@When("^User clicks new$")
	public void clickNewButton() {
		formsTempObj.clickNewButton();
	}

	@When("^User enters form data$")
	public void enterFormData(DataTable dataTable) throws InterruptedException {
		// Convert Data Tale to List Map
		List<Map<String, String>> ListMap = dataTable.asMaps(String.class, String.class);

		// Convert List Map to a Map
		for (Map<String, String> map : ListMap) {
			// use get() method to retrieve the value by passing the key
			formsTempObj.enterName(map.get("name"));
			formsTempObj.enterIntroText(map.get("introductionText"));
			formsTempObj.enterCompletionText(map.get("completionText"));
			Thread.sleep(1000);
		}

	}

	@Then("^User saves the form$")
	public void saveForm() {
		formsTempObj.clickSaveButton();
	}

	@When("^User navigates to forms page$")
	public void navtoPage() {
		formsTempObj.clickFormsLink();

	}

	@When("^User click delete icon$")
	public void clickDelIcon() {

		formsTempObj.clickDelIcon();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^User clicks delete button$")
	public void clicDelButton() {
		formsTempObj.clickDelButton();
	}

	@Then("^User should be directed to Forms page$")
	public void isFormPage() {
		System.out.println("In Form Page");
	}

	@When("^User enters name \"([^\"]*)\"$")
	public void enterName(String name) {
		formsTempObj.enterName(name);
	}

	@When("^User enters introduction text \"([^\"]*)\"$")
	public void enterIntro(String introText) {
		formsTempObj.enterIntroText(introText);
	}

	@When("^User enters completion text \"([^\"]*)\"$")
	public void enterCompletion(String value) {
		formsTempObj.enterCompletionText(value);
	}

	@When("^User clicks save$")
	public void clickSave() {
		formsTempObj.clickSaveButton();
	}

	@Then("^User should be directed to Active page$")
	public void toActivePage() {
		System.out.println("In active Page");
	}

	@When("^User enters  form data$")
	public void enterData(DataTable dataTable) {
		// Convert Data Tale to List Map
		List<Map<String, String>> ListMap = dataTable.asMaps(String.class, String.class);

		// Convert List Map to a Map
		for (Map<String, String> map : ListMap) {
			// use get() method to retrieve the value by passing the key
			formsTempObj.enterName(map.get("name"));
			formsTempObj.enterIntroText(map.get("introductionText"));
			formsTempObj.enterCompletionText(map.get("completionText"));
		}
	}

	@When("^User enters form field data \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void enterFormFieldData(String name, String intro, String comp) {
		formsTempObj.enterName(name);
		formsTempObj.enterIntroText(intro);
		formsTempObj.enterCompletionText(comp);
	}

}
