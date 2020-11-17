package com.revature.driver;

import java.io.IOException;

import com.revature.menus.Menu;

public class Driver {

	public static void main(String[] args) {
		try {
			Menu.startMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
