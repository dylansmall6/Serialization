package com.dylanscode.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeOwner {
	public static final String[] DOG_TRICKS = {"Lay","Sit","Reach","Shake","Hunt","Jump"};
	public static void main(String[] args) {
		ArrayList<Cat> cats = new ArrayList<Cat>();
		ArrayList<Dog> dogs = new ArrayList<Dog>();

		cats.add(new Cat(12, "Ruffles", 'F',0731,10.3));
		cats.add(new Cat(4, "Jingles", 'M',0101,7.37));
		cats.add(new Cat(3, "Pepper", 'M',0014,15.25));
		dogs.add(new Dog(15,"Black Lab","Jumpy",'F',25,1001,makeTricks(0,2,5)));
		dogs.add(new Dog(5,"Yellow Lab","Baxter",'M',9,1072,makeTricks(3,2,4)));
		dogs.add(new Dog(2,"Morkie","Zoey",'F',5,1821,makeTricks(0,1,4)));
		
		Owner dylan = new Owner(cats, dogs, "Dylan", "123 Floral Pl", 12312123);
		/*
		 * Starting serialization part
		 */
		try {
			//FileOutputStream is basic file IO. It just allows data to be written into a file
			FileOutputStream fOut = new FileOutputStream(new File("Owner.ser"));
			//The ObjectOutputStream allows objects to be serialized into data on a .ser file type. This takes in a FileOutputStream in order to write to the files
			ObjectOutputStream out = new ObjectOutputStream(fOut);
			//writeObject simply writes the Owner data directly to the file name
			out.writeObject(dylan);
			//always remember to close out
			fOut.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * simply returns a String[] that contains the three tricks from DOG_TRICKS at the index of the three parameters
	 * @param trick1
	 * @param trick2
	 * @param trick3
	 * @return
	 */
	public static String[] makeTricks(int trick1, int trick2, int trick3) {
		String[] tricks = new String[3];
		tricks[0] = DOG_TRICKS[trick1];
		tricks[1] = DOG_TRICKS[trick2];
		tricks[2] = DOG_TRICKS[trick3];
		return tricks;
	}
}
