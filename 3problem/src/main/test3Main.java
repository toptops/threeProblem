package main;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import promble_3.sort;


public class test3Main {
	public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		int input5[] = new int[100000000];

		int input8[] = new int[100000000];
		int buf[] = new int[10];
		Random random = new Random();

		for(int i=0;i<input5.length;i++) {
			input5[i]=random.nextInt(100000000-1)+1;

			input8[i]=input5[i];
		}
		
		sort sort = new sort();
		long startTime, endTime, lTime;
		
//		//퀵정렬
//		startTime = System.currentTimeMillis();
//		sort.quickSort(input5, 0, input5.length-1);
//		endTime = System.currentTimeMillis();
//		lTime = endTime - startTime;
//		System.out.println("Qsort TIME : " + lTime + "(ms)");
		
//		for(int i=10000;i<10010;i++) {
//			System.out.println(input5[i]);
//		}
//		input5 = null;
//		
		int data[][];
////		//분할 후 퀵정렬
//		startTime = System.currentTimeMillis();
//		data = sort.divideQuickSort(input5,100);
//		endTime = System.currentTimeMillis();
//		lTime = endTime - startTime;
//		System.out.println("Dividesort TIME : " + lTime + "(ms)");
////		
////		for(int i=0;i<100;i++) {
////			for(int j=0;j<data[i].length;j++) {
////				System.out.println(data[i][j]);
////			}
////		}
//		input5 = null;
//		
//		//더블 피벗 퀵정렬
//		startTime = System.currentTimeMillis();
//		int k=0;
//		DualPivotQuicksort.sort(input7, 0, input7.length - 1, buf, k, buf.length);
//		endTime = System.currentTimeMillis();
//		lTime = endTime - startTime;
//		System.out.println("DualPivotQuicksort TIME : " + lTime + "(ms)");
//		
//		for(int i=10000;i<10010;i++) {
//			System.out.println(input7[i]);
//		}
//		input7 = null;
		
//		//분할 후 더블 피벗 퀵정렬
		startTime = System.currentTimeMillis();
		data = sort.divideDualPivotQuickSort(input8,100);
		endTime = System.currentTimeMillis();
		lTime = endTime - startTime;
		System.out.println("Dividesort TIME : " + lTime + "(ms)");
		
//		for(int i=0;i<100;i++) {
//			for(int j=0;j<data[i].length;j++) {
//				System.out.println(data[i][j]);
//			}
//		}
		input8 = null;
		
//		번외
		
//		ArrayList 40000000개  Collection.sort 걸린 시간 21초 
//		LinkedList 40000000개   Collection.sort 걸린 시간 41초
//		HashSet 순서가 없기 때문에 list 객체로 변환후 정렬해야함. 그러면 list종류에 따라 시간이 달라짐.
	}
	
	
}
