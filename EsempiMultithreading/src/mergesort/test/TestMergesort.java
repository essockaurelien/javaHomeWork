package mergesort.test;

import mergesort.MTMergeSort;

import org.junit.jupiter.api.Test;

public class TestMergesort {

	@Test
	void test() {
		int[] a={0,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		MTMergeSort.mergeMT(a,4);
	}
}
