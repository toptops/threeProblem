package main;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import promble_3.DualPivotQuicksort;
import promble_3.sort;


public class test3Main {
	public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		int ramdomNumbers[] = new int[100000000];
		int ramdomNumbersLength = ramdomNumbers.length;
		int basePivetSite = 0;
		int sortOutpuData[][];
		int division = 100;
		
		Random random = new Random();

		for(int i=0;i<ramdomNumbers.length;i++) {
			ramdomNumbers[i]=random.nextInt(100000000-1)+1;
		}
		
		sort sort = new sort();
		long startTime, endTime, lTime;
		startTime = System.currentTimeMillis();
		
		/**
		 * 	sort.quickSort(ramdomNumbers, 0, ramdomNumbersLength - 1);                                  // 퀵정렬   
		 * 	sortOutpuData = sort.divideQuickSort(ramdomNumbers);									 // 분할 퀵정렬 
		 * 	DualPivotQuicksort.sort(ramdomNumbers, 0, ramdomNumbersLength - 1, buf, basePivetSite, buf.length);   // 더블 피벗 정렬
		 * 	sortOutpuData = sort.divideDualPivotQuickSort(ramdomNumbers);							 // 분할 더블 피벗 정렬 
		 * 
		 */
		
		DualPivotQuicksort.sort(ramdomNumbers, 0, ramdomNumbersLength - 1, new int[2], basePivetSite, 2); 
		endTime = System.currentTimeMillis();
		lTime = endTime - startTime;
		System.out.println("Sort TIME : " + lTime + "(ms)");
	}
	
	
}
