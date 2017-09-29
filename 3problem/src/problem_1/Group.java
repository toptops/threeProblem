package problem_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 입력받은 ArrayList<HashVO>를 Key중심으로 정렬 후 같은 데이터들을 ArrayList에 담고 다시 HashMap에 Key,Value로 저장, 출력   
 * @author seong
 *
 */
public class Group {
	HashMap<Integer, ArrayList<Integer>> saveDataMap;
	
	public Group() {
		saveDataMap = new HashMap<>();
	}
	
	
	/* 입력된 List를 Key중심으로 같은 데이터끼리 List에 담고 이를 다시 Map에 Key, value로 저장하는 함수 */
	void setData(ArrayList<hashVo> list) {
		ArrayList<Integer> temp;
		int subValue, subKey;
		
		for(int i=0;i<list.size();i++) {
			subKey = list.get(i).getKey();
			subValue = list.get(i).getValue();
			
			if(!saveDataMap.containsKey(subKey)) {
				temp = new ArrayList<>();
				temp.add(list.get(i).getValue());
				saveDataMap.put(subKey, temp);
			}else{
				saveDataMap.get(subKey).add(subValue);
			}
		}
	}
	
	/* 데이터 출력 함수 */
	void printData() {
		Iterator<Integer> iterator = saveDataMap.keySet().iterator();
		
		while (iterator.hasNext()) { 
			int key = (int)iterator.next(); // 키 얻기
			System.out.println(key +",  "+ this.saveDataMap.get(key));
		}
	}
	
}
