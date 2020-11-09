package com.revature.driver;

import com.revature.menus.Menu;
import com.revature.services.FileStuff;

public class Driver {

	public static void main(String[] args) {
		
		{FileStuff.readAccountsFile();}
		{FileStuff.readCustomerAccountsFile();}
		 
		Menu.startMenu();

	}

}
