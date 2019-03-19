package module1;

import java.awt.List;
import java.util.ArrayList;

public class ArraysLab {
	/*
	 * public static void main(String[] args) { int[][] a = new int[4][5]; int count
	 * = 1; for (int i = 0; i < a.length; i++) { for (int j = 0; j < a[i].length;
	 * j++) { a[i][j] = count; count++; } }
	 * 
	 * for (int i = 0; i < a.length; i++) { for (int j = 0; j < a[i].length; j++) {
	 * System.out.print(a[i][j]); } }
	 * 
	 * }
	 */
	public static void main(String[] args) {

		int[][] myArray = {{44, 45, 16, 50},{16, 12, 66, 9}, {52, 83, 3, 37}, {56, 61, 69, 61}};

		twoDimensions(myArray);
		for (int i = 0; i < myArray.length; i++) {
			for (int j = 0; j < myArray[i].length; j++) {
				System.out.print(myArray[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
	}

	public static void twoDimensions(int[][] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers[i].length - 1; j++) {
				if (numbers[i][j] < numbers[i][j + 1]) {
					numbers[i][j] = numbers[i][j] + numbers[i + 1][j];
					numbers[i + 1][j] = numbers[i + 1][j] / 2;
				}
			}
		}
	}

	public static void change(int[] arr) {
		int k = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (k < arr[i]) {
				arr[0] = arr[i];
				arr[i] = k;
				k = arr[0];
			}
		}
	}

	public static void mystery2(ArrayList<Integer> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			if (i % 2 == 0) {
				list.add(list.get(i));
			} else {
				list.add(0, list.get(i));
			}
		}
		System.out.println(list);
	}

}
