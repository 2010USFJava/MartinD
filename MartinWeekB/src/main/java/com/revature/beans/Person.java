package com.revature.beans;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import com.revature.driver.Driver;
import com.revature.log.LogIt;


public class Person implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6653098350082781233L;
	
	
	int age;
	String race;
	double height;
	String name;
	public static List<Person> people = new ArrayList<Person>();
	
	
	public Person() {
		//super();
		people.add(this);
		Driver.writePeopleFile(people);
	}
	
	
	
	public Person(int age, String race, double height, String name) {
		//super();
		this.age = age;
		this.race = race;
		this.height = height;
		this.name = name;
		
		people.add(this);
		Driver.writePeopleFile(people);
		LogIt.LogThis("info", "A new person, "+ this.name + ", has entered the system!");
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getRace() {
		return race;
	}


	public void setRace(String race) {
		this.race = race;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "Person [age=" + age + ", race=" + race + ", height=" + height  + ", name=" + name + "]";
	}
	
	
	
		
	public static Person findPersonByName(String inputName) {
		for (int i = 0; i < people.size(); i++) {
			String name= people.get(i).getName();
			if(inputName.equals(name)) {
				return people.get(i);
			}
		}
		
		System.out.println("Warrior not found");
		
		return null;
	}
	
	

}
