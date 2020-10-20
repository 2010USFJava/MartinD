package com.bean.driver;

import com.bean.Animal;
import com.bean.Type;


public class Driver {

	public static void main(String[] args) {
	
		Animal cow = new Animal(new Type(), "black and white", 4, true);
		System.out.println(cow);
		
		Type r = new Type("Reptile");
		Animal snake = new Animal(r, "black", 0, false);
		System.out.println(snake);
	
		

		
	}

}
