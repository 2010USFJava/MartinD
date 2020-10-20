package com.bean.driver;

import com.bean.Animal;
import com.bean.Type;


public class Driver {

	public static void main(String[] args) {
	
		Animal cow = new Animal(new Type(), "black and white", 4, true);
		String one = cow.type.classification;
		System.out.println(one);
		System.out.println(cow);
		
		Type r = new Type("Reptile");
		Animal snake = new Animal(r, "black", 0, false);
		String two = snake.type.classification;
		System.out.println(snake);
		System.out.println(two);
		
	
		

		
	}

}
