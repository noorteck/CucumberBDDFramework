package com.noorteck.qa.utilities;

public class Common {

	/**
	 * This compares two string values and return boolean value
	 * 
	 * @param actualVal
	 * @param expectedVal
	 * @return
	 */
	public static boolean compareTwoValue(String actualVal, String expectedVal) {
		boolean result = false;
		try {
			if (actualVal.equalsIgnoreCase(expectedVal)) {
				result = true;
				System.out
						.println("Expected value:[" + expectedVal + "] and Actual Value:[" + actualVal + "] is Equal");
			} else {
				System.out.println(
						"Expected value:[" + expectedVal + "] and Actual Value:[" + actualVal + "] is not Equal");
			}
		} catch (Exception e) {
			System.out.println("Unable to cmpare two values " + e);
			e.printStackTrace();
		}
		return result;
	}

}
