package problem_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.hashVo;

/**
 * 입력받은 ArrayList<HashVO>를 Key중심으로 정렬 후 같은 데이터들을 ArrayList에 담고 다시 HashMap에 Key,Value로 저장, 출력   
 * @author seong
 *
 */
public class group {
	/* 입력된 List를 Key중심으로 같은 데이터끼리 List에 담고 이를 다시 Map에 Key, value로 저장하는 함수 */
	public HashMap<Integer, ArrayList<Integer>> setData(List<hashVo> list) {
		HashMap<Integer, ArrayList<Integer>> answer = new HashMap<>();
		ArrayList<Integer> temp;
		int bufValue, bufKey;
		
		for(int i=0;i<list.size();i++) {
			bufKey = list.get(i).getKey();
			bufValue = list.get(i).getValue();
			
			if(!answer.containsKey(bufKey)) {
				temp = new ArrayList<>();
				temp.add(list.get(i).getValue());
				answer.put(bufKey, temp);
			}else{
				answer.get(bufKey).add(bufValue);
			}
		}
		return answer;
	}
}
