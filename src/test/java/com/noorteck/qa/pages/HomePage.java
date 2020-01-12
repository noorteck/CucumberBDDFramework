package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.utilities.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'fahim noor')]")
	WebElement userNameText;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String getUserNameText() {
		return getTextValue(userNameText);
	}

	public String getHomePageTitle() {
		return getTitle();
	}

}
