package problem_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import common.hashVo;

/**
 * 입력받은 ArrayList<HashVO>를 Key중심으로 정렬 후 같은 데이터들을 ArrayList에 담고 다시 HashMap에 Key,Value로 저장, 출력   
 * @author seong
 *
 */
public class group {
	HashMap<Integer, ArrayList<Integer>> saveDataMap;
	
	public group() {
		saveDataMap = new HashMap<>();
	}
	
	
	/* 입력된 List를 Key중심으로 같은 데이터끼리 List에 담고 이를 다시 Map에 Key, value로 저장하는 함수 */
	public void setData(ArrayList<hashVo> list) {
		ArrayList<Integer> temp;
		int bufValue, bufKey;
		
		for(int i=0;i<list.size();i++) {
			bufKey = list.get(i).getKey();
			bufValue = list.get(i).getValue();
			
			if(!saveDataMap.containsKey(bufKey)) {
				temp = new ArrayList<>();
				temp.add(list.get(i).getValue());
				saveDataMap.put(bufKey, temp);
			}else{
				saveDataMap.get(bufKey).add(bufValue);
			}
		}
	}
	
	// 이부분. 정렬?
	/* 데이터 출력 함수 */
	public void printData() {
		Iterator<Integer> iterator = saveDataMap.keySet().iterator(); // 오름차순 정렬.
		
		while (iterator.hasNext()) { 
			int key = (int)iterator.next(); // 키 얻기
			System.out.println(key +",  "+ this.saveDataMap.get(key));
		}
	}
	
}
