package interviewserializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Serial {
	
	public static void main(String[] args) {
		try {
		//create an object of the student 
		Student student = new Student("alok verma", "alokv@gmail.com", 26, "Mohali, kharar");
		
		//write data to file - ob.txt
		OutputStream fileOutputStream= new FileOutputStream("ob.txt");
			
		//basically read this object for the  bytestream, takes the object of OutputStream as FileOutputStream extends Outputstream and hence an object of Outputstream is there 
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		//how to serialize
		objectOutputStream.writeObject(student);
		
		objectOutputStream.close();
		fileOutputStream.close();
		
		System.out.println("Object sttae is transferred successfully to fle ob");
		
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
