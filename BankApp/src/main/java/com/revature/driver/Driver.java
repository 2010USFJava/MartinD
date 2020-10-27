package com.revature.driver;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		 Scanner myPrompt = new Scanner(System.in);  // Create a Scanner object
		 
		 	System.out.println("Welcome to DSM Bank. If you are a customer please press 1. If you are a employee please press 2.");
		 	int who = Integer.parseInt(myPrompt.nextLine());
		 	if(who == 1) {
		 		System.out.println("Register or Login");
		 		
		 	} else {
		 		//call login function
		 	}
		 	
		    System.out.println("Register or Login");
		    String answer = myPrompt.nextLine();
		
		 
		 	System.out.println("Enter username");

		    String userName = myPrompt.nextLine();  // Read user input
		    System.out.println("Username is: " + userName);  // Output user input

	}

}
