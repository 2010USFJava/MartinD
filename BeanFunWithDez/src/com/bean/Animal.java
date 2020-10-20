package com.bean;

public class Animal {
	
	public Type type;
	String color;
	int legs;
	boolean tail;
	
	public Animal(Type type, String color, int legs, boolean tail) {
		this.type = type;
		this.color = color;
		this.legs = legs;
		this.tail = tail;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public boolean isTail() {
		return tail;
	}

	public void setTail(boolean tail) {
		this.tail = tail;
	}

	@Override
	public String toString() {
		return "Animal [type=" + type + ", color=" + color + ", legs=" + legs + ", tail=" + tail + "]";
	}
	
	
	

}
