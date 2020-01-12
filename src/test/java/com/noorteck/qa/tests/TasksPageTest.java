package com.noorteck.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.noorteck.qa.utilities.BaseClass;
import com.noorteck.qa.utilities.Common;

public class TasksPageTest extends BaseClass {

	public void tasksPageHeaderTest() {
		String expectedText = "Tasks";
		taskObj.clickTaskLink();
		String actualText = taskObj.getTaskHeaderText();
		// Assertions
		boolean isEqual = Common.compareTwoValue(actualText, expectedText);
		Assert.assertTrue(isEqual);
	}

	@Test
	public void tasksPageCreateNewTask() {
		taskObj.clickTaskLink();
		taskObj.clickNew();
		taskObj.enterTitle("Java SDET");
		taskObj.assignTo();
		taskObj.enterDueDate("21/12/2019 00:00");
		taskObj.enterDeal("Studying");
		taskObj.enterCloseDate("21/12/2020 00:00");
		taskObj.enterDiscription("Java Programming");
		taskObj.enterCompletion("123");
		taskObj.selectStatus();
		taskObj.selectType();
		taskObj.enterContact("Contract with Company");
		taskObj.enterCase("Case 1235");
		taskObj.selectPriority();
		taskObj.enterIdentifier("Main COurse");
		taskObj.clickSave();
	}

	public void tasksPageRemoveTask() {
		taskObj.clickTaskLink();
		taskObj.clickCheckBox();
		taskObj.deleteRowOne();
	}
}
