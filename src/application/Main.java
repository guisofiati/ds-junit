package application;

import java.util.Locale;

import entities.Financing;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		try {
			Financing f1 = new Financing(100000.0, 2000.0, 20);
			System.out.println("Financing data 1:");
			System.out.printf("Entrance: %.2f\n", f1.entry());
			System.out.printf("Quotes: %.2f\n", f1.quota());
		}
		catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println();
		
		try {
			Financing f2 = new Financing(100000.0, 2000.0, 80);
			System.out.println("Financing data 2:");
			System.out.printf("Entrance: %.2f\n", f2.entry());
			System.out.printf("Quotes: %.2f\n", f2.quota());
		}
		catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
