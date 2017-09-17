package com.dylanscode.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadSerializedOwner {
	public static void main(String[] args) {
		Owner owner = null;
		try {
			//Same as serializing an object, but now we are de-serializing it. Instead of FileOutputStream, we need a FileInputStream to use INPUT, not OUTPUT
			FileInputStream fIn = new FileInputStream("Owner.ser");
			//Same with ObjectInputStream. This reads the first line of "Owner.ser" and de-serializes the object, casting it to our Owner class
			ObjectInputStream in = new ObjectInputStream(fIn);
			owner = (Owner) in.readObject();
			fIn.close();
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			/*
			 * We can now read our owner. As you will see, the transient variables will appear as the default value for its type.
			 * For example: The Owner's SSN and Address are 0, because its transiency didn't allow the object to be serialized. Since the 
			 * default value of the int type is 0, it simple prints out 0.
			 */
			if(owner != null) {
				System.out.println("Owner's Cats: ");
				owner.printList(owner.getCats());
				System.out.println("Owner's Dogs: ");
				owner.printList(owner.getDogs());
				System.out.println("Owner Name: " + owner.getName());
				System.out.println("Owner Address: " + owner.getAddress());
				System.out.println("Owner SSN: " + owner.getSSN());
			}
			/*
			 *One might wonder why serialize stuff when we are on our own computers? It isn't such a good idea on the computers, but serialization comes in
			 *handy when dealing with networking. Since java uses a binary serializer, it writes the object to a ton of bytes (8 bits) that can be send accross 
			 *networks. A bit is either a 1 or a 0, which is easy to de-serialize (for the computer, not human). However, this type of serialization is not good
			 *when somebody is trying to read the data in say, C#. This is why JSON comes handy when serializing, and we will certainly use this later, but
			 *since JSON is a universally understood structure, all different types of languages can read it, so Java can post data online, and somebody in C# 
			 *can de-serialize it!
			 */
		}
	}
}
