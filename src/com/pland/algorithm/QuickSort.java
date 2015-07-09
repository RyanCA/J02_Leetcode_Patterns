package com.pland.algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * http://en.wikipedia.org/wiki/Quicksort
 * 
 * It's two or three times faster than merge sort and heapsort
 * It's not a stable sort, it can operate in-place on an array
 * on average, the algorithm takes O(n log n) comparisons to sort n items. 
 * In the worst case, it makes O(n2) comparisons, though this behavior is rare.
 * 
 * Algorithm: 
 * Key
 * Value less than pivot, put on the left of pivot and 
 * value greater than pivot put on the right of pivot
 * 
 *
 */

public class QuickSort {
	
	private static void sort(Integer [] input, int startPos, int endPos){
		
		if(input == null){
			throw new NullPointerException();
		}
		
		if(startPos<0 || endPos<0 || startPos>endPos || endPos>= input.length){
			throw new IllegalArgumentException();
		}
		
		if(input.length == 0 || input.length == 1){
			return ;
		}
		

		//Pick up the pivot
		int pivotPosition = startPos;
		//Take 3,4,1,2,5 as an example
		for(int i=startPos; i <= endPos; i++){
			
			//move the values one by one
			if(input[i] < input[pivotPosition]){

				int temp = input[i];
				
				for(int j=i; j>pivotPosition; j--){
					input[j] = input[j-1];
				}
				input[pivotPosition] = temp;
				pivotPosition++;



				
			}
		}
		
		if(pivotPosition-1 > startPos){
			sort(input, startPos, pivotPosition-1);
		}
		if(pivotPosition+1 < endPos){
			sort(input, pivotPosition+1, endPos);
		}
		
		
	}
	
	public static Integer[] sort(Integer[] input){
		sort(input, 0, input.length-1);
		Integer[] output = input;
		return output;
		
	}
	
	public static void main(String args[]){
		

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse("2015-05-13");
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_YEAR, 46);
			Date date2 = cal.getTime();
			System.out.println(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
