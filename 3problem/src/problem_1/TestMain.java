package problem_1;

import java.util.ArrayList;
import java.util.Random;


public class TestMain {
	public static void main(String args[]) {
		ArrayList<hashVo> input1 = new ArrayList<>();
		ArrayList<hashVo> input2 = new ArrayList<>();
		
		input1.add(new hashVo(101,2));
		input1.add(new hashVo(101,1));
		input1.add(new hashVo(102,6));
		input1.add(new hashVo(102,5));
		input1.add(new hashVo(103,3));
		input1.add(new hashVo(103,2));
		
		input2.add(new hashVo(101,'e'));
		input2.add(new hashVo(101,'a'));
		input2.add(new hashVo(102,'b'));
		input2.add(new hashVo(102,'c'));
		input2.add(new hashVo(103,'a'));
		input2.add(new hashVo(103,'d'));
		
		Join join = new Join();
		join.setData(input1,input2);
		join.printData();
		
		System.out.println("----------------------------------------------------");

		ArrayList<hashVo> input3 = new ArrayList<>();
		input3.add(new hashVo(101,1));
		input3.add(new hashVo(101,2));
		input3.add(new hashVo(101,3));
		input3.add(new hashVo(102,5));
		input3.add(new hashVo(102,6));
		input3.add(new hashVo(103,1));
		input3.add(new hashVo(103,2));
		
		Group group = new Group();
		group.setData(input3);
		group.printData();
		
		System.out.println("----------------------------------------------------");

		int input5[] = new int[100000000];
		int input51[] = new int[100000000];
		int input52[] = new int[100000000];
		int input6[] = new int[10];
		
		Random random = new Random();

		for(int i=0;i<input5.length;i++) {
			input5[i]=random.nextInt(100000000-1)+1;
			input51[i]=input5[i];
			input52[i]=input5[i];
		}
	
		Sort sort = new Sort();

		//������
		long startTime = System.currentTimeMillis();
		sort.quickSort(input5, 0, input5.length-1);
		long endTime = System.currentTimeMillis();
		long lTime = endTime - startTime;
		System.out.println("Qsort TIME : " + lTime + "(ms)");
		
		//���� �� ������
		startTime = System.currentTimeMillis();
		sort.sort(input51,1000);
		endTime = System.currentTimeMillis();
		lTime = endTime - startTime;
		System.out.println("Dividesort TIME : " + lTime + "(ms)");
		
		
		//���� �ǹ� ������
		startTime = System.currentTimeMillis();
		int k=0;
		DualPivotQuicksort.sort(input52, 0, input52.length - 1, input6, k, input6.length);
		endTime = System.currentTimeMillis();
		lTime = endTime - startTime;
		System.out.println("Dualsort TIME : " + lTime + "(ms)");

//		����
		
//		ArrayList 40000000��  Collection.sort �ɸ� �ð� 21�� 
//		LinkedList 40000000��   Collection.sort �ɸ� �ð� 41��
//		HashSet ������ ���� ������ list ��ü�� ��ȯ�� �����ؾ���. �׷��� list������ ���� �ð��� �޶���.
	}
	
	
}
