package com.dylanscode.serialization;

import java.io.Serializable;

public class Dog implements Serializable {

	private static final long serialVersionUID = 1L;
	private int age;
	private String type;
	private String name;
	private char gender;
	private int weight;
	/*
	 * We set the ID and tricks of the dog to transient, because it is information that is either private or is not needed to be transfered
	 */
	private transient int ID;
	private transient String[] tricks;

	public Dog(int age, String type, String name, char gender,int weight, int ID, String[] tricks) {
		this.age = age;
		this.setType(type);
		this.setName(name);
		this.setGender(gender);
		this.setWeight(weight);
		this.setID(ID);
		this.tricks = tricks;
	}
	/**
	 * returns true if dog knows more then two tricks
	 * @return
	 */
	public boolean isSmart() {
		if(tricks != null) {
			return tricks.length > 2 ? true : false;

		}
		else {
			return false;
		}
	}
	/**
	 * returns true if the age is under 8 and weight is even (using bit operators)
	 * @return
	 */
	public boolean isHappy() {
		return (age < 8) && ((weight & 1) == 0);
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "Name: " + name + " Age: " + age + " Type: " + type + " Gender: " + gender + " Weight: " + weight + " ID: " + ID + " Tricks: " + tricksToString() + " Happy: " + (isHappy() == true ? "Yes" : "No") + " Smart: " + (isSmart() == true ? "Yes" : "No");
	}
	public String tricksToString() {
		if(tricks != null)
			return "Trick 1: " + tricks[0] + " Trick 2: " + tricks[1] + " Trick 3: " + tricks[2];
		else
			return "Could not load tricks";
		
	}
}
