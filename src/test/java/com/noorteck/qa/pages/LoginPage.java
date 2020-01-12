package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.noorteck.qa.utilities.BaseClass;

public class LoginPage extends BaseClass {
	// Using @FindBy for locating elements
	@FindBy(name = "email")
	WebElement emailField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(css = ".blue.button.fluid")
	WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String email) {
		enter(emailField, email);
	}

	public void enterPassword(String password) {
		enter(passwordField, password);

	}

	public void clickLogin() {
		click(loginButton);
	}
}
