package com.dylanscode.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadSerializedOwner {
	public static void main(String[] args) {
		Owner owner = null;
		try {
			FileInputStream fIn = new FileInputStream("Owner.ser");
			ObjectInputStream in = new ObjectInputStream(fIn);
			owner = (Owner) in.readObject();
			fIn.close();
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(owner != null) {
				System.out.println("Owner's Cats: ");
				owner.printList(owner.getCats());
				System.out.println("Owner's Dogs: ");
				owner.printList(owner.getDogs());
				System.out.println("Owner Name: " + owner.getName());
				System.out.println("Owner Address: " + owner.getAddress());
				System.out.println("Owner SSN: " + owner.getSSN());
			}
		}
	}
}
