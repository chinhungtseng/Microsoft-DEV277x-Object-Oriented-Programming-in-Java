/*
 * Write a method maxLength that takes an ArrayList of Strings as a parameter and that returns the length of the longest string in the 
 * 
 * list. If your method is passed an empty list, it should return 0.
 *  
 */
package module1;

import java.util.ArrayList;

public class MaxLength {
	public static void main(String[] args) {
		
	}

	public  int maxLength(ArrayList<String> list) {

		int numberOfList = (int) list.size();
		int maxNumber = 0;
		for (int i = 0; i < numberOfList; i++) {
			if ((list.get(i)).length() > maxNumber) {
				maxNumber = (list.get(i)).length();
			}
		}
		return maxNumber;
	}

}
