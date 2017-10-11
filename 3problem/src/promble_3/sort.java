package promble_3;

/**
 * ������ ���� �ǹ��� 1���� �������� �ϱ����� Ŭ������ ������ �Լ��� ���� �� ���� Ŭ������ �ִ�.
 * @author seong
 *
 */
public class sort {

	//������ �Լ�.
	public void quickSort(int[] data, int l, int r) {
		int left = l;
		int right = r;
		int pivot = data[(l + r) / 2];
		
		do {
			while (data[left] < pivot)
				left++;
			while (data[right] > pivot) 
				right--;

			if (left <= right) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		} while (left <= right);

		if (l < right)
			quickSort(data, l, right);
		if (r > left)
			quickSort(data, left, r);
	}

		
	/*
	 * ���� ������ �迭 ���ڵ��� ���ϴ� ũ�⸸ŭ �����Ͽ� �������ϴ� �Լ�.
	 * @param data ���� �������� ����.
	 * @param divideValue �����Ϸ��� ��. EX) divideValue = 10; �̸� data.length / 10 ��ŭ �����Ѵ�.
	 * 
	 * divdeSize : ���ҵ� ũ�� 
	 * divideOriginData : ���� �� �������� ������ 2���� �迭
	 * divideSortData : ���ĵ� �����͵��� �ִ� 2���� �迭
	 * dividedRangeCount : ���ҵ� ũ���� ������ ũ��
	 * buf : �� ������ �������ִ� ��. 
	 * EX) ������ �����͸� 10���� ���� �Ҷ�, ������ 0~999, 1000~1999 ... 9000 ~ 9999 �ε�
	 * n��° ���� 1200�� �� ���ҵ� ũ��� ������ ���� 1�̴� �׷� divideOriginData�迭���� divideOriginData[1][] �迭�� ���Եȴ�. ���� dividedRangeSize[1]++ ���ش�.
	 * dividedRangeSize�� ���� ���� �����ִ� ������ divideOriginData�� �������� ����Ǿ��־ �̸� ���� ����ϰ� �迭�� �����ϱ� ���ؼ�.
	 * ���� divideSortData�� divideOriginData�� �Ű� ���� �������� �Ѵ�.
	 * 
	*/
	public int[][] divideQuickSort(int data[], int divideValue) {
		int divdeSize = data.length / divideValue;
		int divideOriginData[][] = new int[divideValue][divdeSize + divdeSize / 4];
		int divideSortData[][] = new int[divideValue][];
		int dividedRangeSize[] = new int[divideValue];
		int buf,k=0;
		int temp[] = new int[10];
		
		
		for (int i = 0; i < data.length; i++) {
			buf = data[i] / divdeSize;   
			divideOriginData[buf][dividedRangeSize[buf]] = data[i];
			dividedRangeSize[buf]++;
		}

		for (int i = 0; i < divideValue; i++) {
			divideSortData[i] = new int[dividedRangeSize[i]];
			for(int j=0;j<dividedRangeSize[i];j++)
				divideSortData[i][j] = divideOriginData[i][j];
			
			quickSort(divideSortData[i], 0, divideSortData[i].length - 1);
		}
		
		return divideSortData;
	}
	
	public int[][] divideDualPivotQuickSort(int data[], int divideValue) {
		int divdeSize = data.length / divideValue;
		int divideOriginData[][] = new int[divideValue][divdeSize + divdeSize / 2];
		int divideSortData[][] = new int[divideValue][];
		int dividedRangeSize[] = new int[divideValue];
		int buf,k=0;
		int temp[] = new int[1000];
		
		
		for (int i = 0; i < data.length; i++) {
			buf = data[i] / divdeSize;   
			divideOriginData[buf][dividedRangeSize[buf]] = data[i];
			dividedRangeSize[buf]++;
		}

		for (int i = 0; i < divideValue; i++) {
			divideSortData[i] = new int[dividedRangeSize[i]];
			for(int j=0;j<dividedRangeSize[i];j++)
				divideSortData[i][j] = divideOriginData[i][j];
			
			DualPivotQuicksort.sort(divideSortData[i], 0, divideSortData[i].length - 1, temp, k, temp.length);
		}
		return divideSortData;
	}
}
