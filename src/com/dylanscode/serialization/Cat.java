package com.dylanscode.serialization;

import java.io.Serializable;

public class Cat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int age;
	private String name;
	private char gender;
	// The cat's ID is private information, so we set this to transient, stated before as meaning that this data can not be serialized
	private transient int ID;
	private double weight;
	public Cat(int age, String name, char gender, int ID, double weight) {
		this.age = age;
		this.setName(name);
		this.setGender(gender);
		this.setID(ID);
		this.setWeight(weight);
	}
	/**
	 * adds a double to the cat's weight
	 * @param amount
	 */
	public void feed(double amount) {
		setWeight(getWeight() + amount);
	}
	/**
	 * returns true if the cat is over 19 years old
	 * @return
	 */
	public boolean isDead() {
		return age > 19 ? true : false;
	}
	/**
	 * Cats are never happy, it's just a fact
	 * @return
	 */
	public boolean isHappy() {
		return false;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Name: " + name + " Age: " + age + " Gender: " + gender + " Weight: " + weight + " ID: " + ID + " Happy: " + isHappy() + " State of life: " + (isDead() == true ? "Dead" : "Alive");
	}
}
