package insertionSort;

import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		Random r = new Random();
		int[] array =new int[10];
		System.out.println("random integers: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(50);
		}
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
		System.out.println("insertionSortByRecursion: ");
		insertionSortByRecursion(array,0);
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
		System.out.println("random integers: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(50);
		}
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
		System.out.println("insertionSortByIteration: ");
		insertionSortByIteration(array);
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
		
		

	}
	
	public static void insertionSortByIteration (int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if(array[j] >= array[j-1]) {
					break;
				}
				if(array[j] < array[j-1]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}//end if
			}//end for
		}//end for
	}//end  insertionSortByIteration
	
	public static void insertionSortByRecursion (int[] array, int firstUnsorted) {
		
		movingElement(array, firstUnsorted);	
		if(firstUnsorted < array.length-1) {
			insertionSortByRecursion(array, firstUnsorted + 1);
		}
		
	}//end insertionSortByRecursion
	
	public static void movingElement (int[] array, int indexOfChekingElement) {
		
		if((indexOfChekingElement <= 0) 
				|| (array[indexOfChekingElement] >= array[indexOfChekingElement - 1]))
			;
		else {
			int temp = array[indexOfChekingElement];
			array[indexOfChekingElement] = array[indexOfChekingElement - 1];
			array[indexOfChekingElement - 1] = temp;
			movingElement(array, indexOfChekingElement - 1);
		}//end else
		
		
	}//end comparingElements
	

}
