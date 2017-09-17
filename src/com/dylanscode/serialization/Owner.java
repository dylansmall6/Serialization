package com.dylanscode.serialization;

import java.io.Serializable;
import java.util.ArrayList;

public class Owner implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Cat> cats;
	private ArrayList<Dog> dogs;
	private String name;
	/*
	 * "transient" is a key word in java. Its meaning is that the following data type is not serializable, meaning it can not be transfered in data.
	 */
	private transient String address;
	private transient int SSN;
	public Owner(ArrayList<Cat> cats, ArrayList<Dog> dogs, String name, String address, int SSN) {
		this.setCats(cats);
		this.setDogs(dogs);
		this.setName(name);
		this.setAddress(address);
		this.setSSN(SSN);
	}
	public ArrayList<Cat> getCats() {
		return cats;
	}
	public void setCats(ArrayList<Cat> cats) {
		this.cats = cats;
	}
	public ArrayList<Dog> getDogs() {
		return dogs;
	}
	public void setDogs(ArrayList<Dog> dogs) {
		this.dogs = dogs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int SSN) {
		this.SSN = SSN;
	}
	/**
	 * Generic class to print dog or cat class
	 * @param list
	 */
	public < E > void printList(ArrayList<E> list) {
		for(E element : list) {
			System.out.println(element);
		}
	}
}
