package interviewLogicalQues;

import java.util.Scanner;

public class CountWhiteSpacesAndUppercase {

	//WAP to input string and count no of white spaces and uppercases and lowercases
	
	public static void main(String[] args) {
		
		System.out.println("Enter the String : ");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		System.out.println("the input is : "+ str);
		
		//s here we are counting the storage buckets which will contain the logic to add the spaces, upper and lower cases respectively 
		
		int spaceCount= 0;
		int lowerCount =0;
		int upperCount = 0;
		
//		for(int i=0;i<str.length();i++) {
//			char c = str.charAt(i);
//			
//			if(c>='a' && c<='z') { //could have been the numbers also ie the ascii value of these chars tat would have also worked 97 and 122
//				lowerCount += 1;
//			}else if(c>='A' && c<='Z') { //54 and 90
//				upperCount += 1;
//			}else if(c==' ') { //32
//				spaceCount += 1;
//			}
//		}
		
		//for doing and letting the other person know rhat you know JAVA
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			
			if(Character.isLowerCase(c)) { //could have been the numbers also ie the ascii value of these chars tat would have also worked 97 and 122
				lowerCount += 1;
			}else if(Character.isUpperCase(c)) { //54 and 90
				upperCount += 1;
			}else if(Character.isWhitespace(c)) { //32
				spaceCount += 1;
			}
		}
		
		System.out.println("space count : "+ spaceCount + " lower count "+ lowerCount + " upper count " + upperCount);
	}
}
