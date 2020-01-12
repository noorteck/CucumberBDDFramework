package com.noorteck.qa.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonUI extends GlobalVariables {

	/**
	 * This method opens the browser
	 */
	public static void openBrowser() {
		String browser = prop.getProperty("browserType").toLowerCase();

		try {
			if (browser.equals("chrome")) {
				System.setProperty(prop.getProperty("chromeName"), prop.getProperty("chromePath"));
				driver = new ChromeDriver();

			} else if (browser.equals("ff")) {
				System.setProperty(prop.getProperty("FFName"), prop.getProperty("FFPath"));
				driver = new FirefoxDriver();

			} else if (browser.equals("ie")) {
				System.setProperty(prop.getProperty("IEName"), prop.getProperty("IEPath"));
				driver = new InternetExplorerDriver();

			} else {
				Assert.fail("Unable to find browser, Check EnvrionrmentData.properties file");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to find browser, Check EnvrionrmentData.properties file");
		}
	}

	/**
	 * THis method takes URL and navigates
	 * 
	 * @param url
	 */
	public static void navigate(String url) {
		driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);

	}

	/**
	 * Close all the Browser
	 */
	public static void quitBrowser() {
		try {
			// Thread.sleep(3000);
			driver.quit();
		} catch (Exception e) {
			System.out.println("Driver instance does not exist " + e);
			e.printStackTrace();
		}
	}

	/**
	 * This method checks if element is displayed returns boolean value
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isDisplayed(WebElement element) {
		boolean isElDisplayed = false;
		try {

			if (element.isDisplayed()) {
				isElDisplayed = true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Assert.assertTrue(false, "WebElement not found " + e);
		}

		return isElDisplayed;
	}

	/**
	 * This takes element and performs click actions
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		if (isDisplayed(element)) {
			element.click();
		} else {
			Assert.assertTrue(false, "WebElement not clickable " + element);
		}
	}

	/**
	 * This method takes two parameters and enters value in text field
	 * 
	 * @param element
	 * @param value
	 */
	public static void enter(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("WebElement not found " + e);
			controlFlag = false;
			e.printStackTrace();
		}
	}

	/**
	 * This method takes one parameter and clears the value in text field
	 * 
	 * @param element
	 */
	public static void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			System.out.println("WebElement not found " + e);
			e.printStackTrace();
		}
	}

	/**
	 * This method takes two parameters and then performs clear and enter actions in
	 * page
	 * 
	 * @param element
	 * @param value
	 */
	public static void clearAndEnter(WebElement element, String value) {
		clear(element);
		enter(element, value);
	}

	/**
	 * THis methods ENters the values then hit "ENTER" key
	 * 
	 * @param element
	 * @param value
	 */

	public static void enterWithKey(WebElement element, String value) {
		try {
			element.sendKeys(value + Keys.ENTER);
		} catch (Exception e) {
			System.out.println("WebElement not found " + e);
			e.printStackTrace();
		}
	}

	/**
	 * This method takes element parameter and returns the textValue
	 * 
	 * @param element
	 * @return
	 */

	public static String getTextValue(WebElement element) {
		String textValue = null;
		try {
			textValue = element.getText();
		} catch (Exception e) {
			System.out.println("WebElement not found " + e);
			e.printStackTrace();
		}
		return textValue;
	}

	/**
	 * This method takes element and return the title of the page
	 * 
	 * @return
	 */

	public static String getTitle() {
		String titleStr = null;
		try {
			titleStr = driver.getTitle();
		} catch (Exception e) {
			System.out.println("Unable to open the WebSite: " + e);
			e.printStackTrace();
		}
		return titleStr;
	}

	/**
	 * This method takes two parameters and selects value from drop-down based on
	 * index number
	 * 
	 * @param element
	 * @param index
	 * 
	 * 
	 */
	public static void dropDownByIndex(WebElement element, int index) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByIndex(index);
		} catch (Exception e) {
			System.out.println("WebElement not found : " + e);
			e.printStackTrace();
		}
	}

	/**
	 * This method takes two parameters and selects value from drop-down based on
	 * value
	 * 
	 * @param element
	 * @param value
	 */
	public static void dropDownByValue(WebElement element, String value) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByValue(value);
		} catch (Exception e) {
			System.out.println("WebElement not found : " + e);
			e.printStackTrace();
		}
	}

	/**
	 * This method takes two parameters and selects value from drop-down based
	 * Visible Text
	 * 
	 * @param element
	 * @param visibleText
	 */
	public static void dropDownByVisText(WebElement element, String visibleText) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(visibleText);
		} catch (Exception e) {
			System.out.println("WebElement not found : " + e);
			e.printStackTrace();
		}
	}

	public static boolean isAlertPresent() {
		boolean isAlert = false;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
				isAlert = true;
			}
		} catch (UnhandledAlertException e) {
			System.out.println("Alert is not handled " + e);
			e.printStackTrace();
		}
		return isAlert;
	}

	public static void alertAccept() {
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public static void alertDecline() {
		if (isAlertPresent()) {
			driver.switchTo().alert().dismiss();
			driver.switchTo().defaultContent();
		}
	}

	public static void selectCheckBox(WebElement element) {
		try {
			if (!element.isSelected()) {
				element.click();
			} else {
				System.out.println("Element already Selectected ");
			}
		} catch (Exception e) {
			System.out.println("WebElement not found " + e);
			e.printStackTrace();
		}
	}

}
