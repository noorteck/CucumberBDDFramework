package com.noorteck.qa.steps;

import org.testng.Assert;

import com.noorteck.qa.utilities.BaseClass;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TasksStepDefinition extends BaseClass {

	@When("^User navigates to tasks page$")
	public void navToTask() {
		taskObj.clickTaskLink();
	}

	@When("^User clicks New$")
	public void clickNew() {
		taskObj.clickNew();
	}

	@When("^User saves the task$")
	public void saveTask() {
		taskObj.clickSave();
	}

	@Then("^it should display error \"([^\"]*)\"$")
	public void expectedError(String expectedError) {
		String actualError = taskObj.getTitleError();
		Assert.assertEquals(expectedError, actualError);
	}

	@When("^User enters task title \"([^\"]*)\"$")
	public void taskData(String titleValue) throws Throwable {
		taskObj.enterTitle(titleValue);
	}

	@Then("^the title of task should be displayed \"([^\"]*)\"$")
	public void expectedTitle(String exptectedTitleHeader) {
		String actualTitleHeader = taskObj.getTitleHeaderText();
		Assert.assertEquals(exptectedTitleHeader, actualTitleHeader);

	}

}
