package com.revature.driver;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;

import com.revature.beans.Person;
import com.revature.log.LogIt;

public class Driver {
	
	
	private static final String peopleFile="people.txt";
	
	public static Scanner sc= new Scanner(System.in);
	
	static {readPeopleFile();}


	public static void main(String[] args) {
		String personName;
		String personAge;
		String personRace;
		String personHeight;
		
		System.out.println("Welcome, would you like to: ");
		System.out.println("\t[c]reate a Person");
		System.out.println("\t[l]ook for someone by name");
		String choice = sc.nextLine();
		
		switch(choice.toLowerCase()) {
		case "c":
			System.out.println("Please enter a name for the Person: ");
			personName = sc.nextLine();
			System.out.println("Name: " + personName);
			System.out.println("Please enter an age for the Person: ");
			personAge = sc.nextLine();
			System.out.println("Age: " + personAge);
			System.out.println("Please enter a height for the Person: ");
			personHeight = sc.nextLine();
			System.out.println("Height: " + personHeight);
			System.out.println("Please enter an race for the Person: ");
			personRace = sc.nextLine();
			System.out.println("Race: " + personRace);
			Person thisPerson = new Person(Integer.parseInt(personAge), personRace, Double.parseDouble(personHeight), personName);
			//Person.people.add(thisPerson);
			LogIt.LogThis("info", thisPerson.getName() + " was created!");
			//writePeopleFile(Person.people);
			System.out.println(Person.people);
			break;
		case "l":
			System.out.println("Enter the name of the Person your looking for");
			String p= sc.nextLine();
			Person who= Person.findPersonByName(p.toLowerCase());
			System.out.println(who.toString());
			//LogIt.LogThis("info", who.getName()+" just came up in a search");
			break;
		default:
			System.out.println("Try again NERD");
			//startMenu();
			break;			
	}
		
		
		
		
		
		 /* if (choice.toLowerCase() == "c\n") {
			
		} else if  (choice.toLowerCase() == "l\n") {
			
		}
		*/	

	}
	
	
	//write ArrayList to file
	public static void writePeopleFile(List<Person> pList ) {
		try {
			ObjectOutputStream objectOut =new ObjectOutputStream(new FileOutputStream(peopleFile));
			objectOut.writeObject(pList);
			objectOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
//Read info into an ArrayList
	@SuppressWarnings("unchecked")
	public static void readPeopleFile() {
		try {
			ObjectInputStream objectIn= new ObjectInputStream(new FileInputStream(peopleFile));
			Person.people=(ArrayList<Person>)objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
