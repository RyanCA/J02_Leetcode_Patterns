package com.pland.interviews.algorithm;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QuickSortTest {

	@Test
	public void testSort() {
//		fail("Not yet implemented");
		
//		//2. Extreme case
//		Integer[] beforeSort1 = null;
//		Integer[] expecteds1 = {};
//		ExpectedException thrown = ExpectedException.none();
////		thrown.expect(IllegalArgumentException.class);
//		thrown.expect(NullPointerException.class);
//		Integer[] actuals1 = QuickSort.sort(beforeSort1);


		
//		//3. Extreme case
//		Integer[] beforeSort2 = {,};
//		Integer[] expecteds2 = {,};
//		Integer[] actuals2 = QuickSort.sort(beforeSort2);
//		Assert.assertArrayEquals(expecteds2, actuals2);
//		
//		//1. Normal case
//		Integer[] beforeSort = {3,4,1,2,6};
//		Integer[] expecteds = {1, 2, 3, 4, 6};
//		Integer[] actuals = QuickSort.sort(beforeSort);
//		Assert.assertArrayEquals(expecteds, actuals);
//		
//		//4. Extreme case
//		Integer[] beforeSort3 = {2,};
//		Integer[] expecteds3 = {2,};
//		Integer[] actuals3 = QuickSort.sort(beforeSort3);
//		Assert.assertArrayEquals(expecteds3, actuals3);
//		
//		//5. Extreme case
//		Integer[] beforeSort4 = {2};
//		Integer[] expecteds4 = {2};
//		Integer[] actuals4 = QuickSort.sort(beforeSort4);
//		Assert.assertArrayEquals(expecteds4, actuals4);
//		
		//6. Extreme case
		Integer[] beforeSort5 = {2, 1};
		Integer[] expecteds5 = {1, 2};
		Integer[] actuals5 = QuickSort.sort(beforeSort5);
		Assert.assertArrayEquals(expecteds5, actuals5);
		
		//7. Extreme case
		Integer[] beforeSort6 = {1, 2};
		Integer[] expecteds6 = {1, 2};
		Integer[] actuals6 = QuickSort.sort(beforeSort6);
		Assert.assertArrayEquals(expecteds6, actuals6);
		
		//8. Extreme case
		Integer[] beforeSort7 = {1, 2, 3, 4, 5, 6};
		Integer[] expecteds7 =  {1, 2, 3, 4, 5, 6};
		Integer[] actuals7 = QuickSort.sort(beforeSort7);
		Assert.assertArrayEquals(expecteds7, actuals7);
		
		//9. Extreme case
		Integer[] beforeSort8 = {6, 5, 4, 3, 2, 1};
		Integer[] expecteds8 =  {1, 2, 3, 4, 5, 6};
		Integer[] actuals8 = QuickSort.sort(beforeSort8);
		Assert.assertArrayEquals(expecteds8, actuals8);
		
	}

}
