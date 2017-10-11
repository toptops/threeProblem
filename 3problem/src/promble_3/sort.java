package promble_3;

/**
 * 분할을 통한 피벗이 1개인 퀵정렬을 하기위한 클래스로 퀵정렬 함수와 분할 후 정렬 클래스가 있다.
 * @author seong
 *
 */
public class sort {

	//퀵정렬 함수.
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
	 * 들어온 정적인 배열 숫자들을 원하는 크기만큼 분할하여 퀵정렬하는 함수.
	 * @param data 숫자 데이터의 집합.
	 * @param divideValue 분할하려는 수. EX) divideValue = 10; 이면 data.length / 10 만큼 분할한다.
	 * 
	 * divdeSize : 분할된 크기 
	 * divideOriginData : 분할 된 오리지널 데이터 2차원 배열
	 * divideSortData : 정렬된 데이터들을 넣는 2차원 배열
	 * dividedRangeCount : 분할된 크기의 데이터 크기
	 * buf : 들어갈 범위를 지정해주는 것. 
	 * EX) 만개의 데이터를 10개로 분할 할때, 범위는 0~999, 1000~1999 ... 9000 ~ 9999 인데
	 * n번째 값이 1200일 때 분할된 크기로 나누면 몫은 1이다 그럼 divideOriginData배열에서 divideOriginData[1][] 배열로 들어가게된다. 들어가면 dividedRangeSize[1]++ 해준다.
	 * dividedRangeSize를 값을 따로 더해주는 이유는 divideOriginData는 정적으로 선언되어있어서 이를 동적 비슷하게 배열을 선언하기 위해서.
	 * 이후 divideSortData에 divideOriginData를 옮겨 넣은 퀵정렬을 한다.
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
