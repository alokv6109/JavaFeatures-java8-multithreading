package interviewserializable;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DeSerial {
	
	public static void main(String[] args) {
		try {
			//input stream ka reference
			InputStream inputStream  =new FileInputStream("ob.txt");
			
			//for putting the data stream to the Object we use the Object Input stream,  
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			
			Student student  =(Student)objectInputStream.readObject();
			
			student.display();
			System.out.println(student.hashCode());
			
			System.out.println("student details : " +  student.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
