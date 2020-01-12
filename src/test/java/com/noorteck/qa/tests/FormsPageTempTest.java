package com.noorteck.qa.tests;

import org.testng.annotations.Test;

import com.noorteck.qa.utilities.BaseClass;

public class FormsPageTempTest extends BaseClass {

	@Test
	public void createNewForm() {
		formsTempObj.clickFormsLink();
		formsTempObj.clickNewButton();
		formsTempObj.enterName("Denmark");
		formsTempObj.enterIntroText("Travel");
		formsTempObj.enterCompletionText("Summer");
		formsTempObj.clickActiveCheckBox();
		formsTempObj.clickSaveButton();

	}

	@Test
	public void createNewFormWithoutActiveCheckBox() {

		formsTempObj.clickFormsLink();
		formsTempObj.clickNewButton();
		formsTempObj.enterName("Netherland");
		formsTempObj.enterIntroText("Orange");
		formsTempObj.enterCompletionText("Winter");
		formsTempObj.clickSaveButton();

	}
}
