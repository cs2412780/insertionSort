package insertionSort;

import java.util.Random;

import lab1.ArrayBag;

public class InsertionSort {

	public static void main(String[] args) {
		ArrayBag<Integer> a1 = new ArrayBag<>(1000);
		ArrayBag<Integer> a2 = new ArrayBag<>(1000);

		Random r = new Random();
		int[] array =new int[1000];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(1000);
			a1.add(array[i]);
			//System.out.println(array[i]);
		}
		System.out.println("insertionSortByIteration: ");
		insertionSortByIteration(array);
		for(int i = 0; i < array.length; i++) {
			a2.add(array[i]);
			//System.out.println(array[i]);
		}
		boolean pass = true;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				System.out.println("*****Failed");
				pass = false;
				break;
			}
		}
		
		if(a1.equals(a2) && pass) {
			System.out.println("Sorted.");
		}
		System.out.println();
		
		
		
		a1.clear();
		a2.clear();

		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(500);
			a1.add(array[i]);
			//System.out.println(array[i]);
		}
		System.out.println("insertionSortByRecursion: ");
		insertionSortByRecursion(array,0);
		for(int i = 0; i < array.length; i++) {
			a2.add(array[i]);
			//System.out.println(array[i]);
		}
		pass = true;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				System.out.println("*****Failed");
				pass = false;
				break;
			}
		}
		if(a1.equals(a2) && pass) {
			System.out.println("Sorted.");
		}

	}
	
	/**
	 * a function that uses iterative insertion sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public static void insertionSortByIteration (int[] array) {
		for (int i = 0; i < array.length; i++) {
			int j = i;
			while((j > 0) && (array[j] < array[j-1])) {
				int temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
				j--;
			}//end while
		}//end for
	}//end  insertionSortByIteration
	
	
	/**
	 * a function that uses recursive insertion sort to sort an array.
	 * @param array The array that to be sorted
	 * @param firstUnsorted The index of the first entry in an unsorted part of the array
	 */
	public static void insertionSortByRecursion (int[] array, int firstUnsorted) {
		
		movingElement(array, firstUnsorted);	
		if(firstUnsorted < array.length-1) {
			insertionSortByRecursion(array, firstUnsorted + 1);
		}
		
	}//end insertionSortByRecursion
	
	
	/**
	 * compare and swap entries when necessary.
	 * @param array The target array
	 * @param indexOfChekingElement Index of the entry that is being checked
	 */
	private static void movingElement (int[] array, int indexOfChekingElement) {
		
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
