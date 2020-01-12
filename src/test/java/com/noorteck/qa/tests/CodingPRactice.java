package com.noorteck.qa.tests;

public class CodingPRactice {

	public static void main(String[] args) {
		String country[] = { "USA", "Canada", null, null, "Mexico", null, "England" };

		try {
			for (int i = 0; i < country.length; i++) {
				if (country[i] != null && country[i].equalsIgnoreCase("England")) {
					System.out.println("Egland equals");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Null value");
		}
	}
}
