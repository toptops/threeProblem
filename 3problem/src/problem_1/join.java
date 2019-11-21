package problem_1;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import common.comparatorValue;
import common.hashVo;

/**
 * 입력받은 2개의 List<HashVo>를 DB의 Inner-Join처럼 만든 함수.
 * @author seong
 *
 */
public class join {
	/* 
	 * 입력받은 2개의 List를 Key중심으로 정렬 후 Inner-join후 결과 값을 map 저장하는 함수 
	 * @param input1  join하고자하는 list 
	 * @param input2  join하고자하는 list
	 * 
	 * KeySite1 KeySite2 : Key가 같은 List의 Value 처음 값 
	 * valueSite, valueSite2는 두번째 list의 값을 넣을 때 처음부터 넣는게 아니라 넣어진 값 이후부터 넣기 위해서 체크 하는 부분.
	 * 
	 */
	public HashMap<Integer, ArrayList<joinVo>> setData(List<hashVo> input1Data, List<hashVo> input2Data) {
		Collections.sort(input1Data, new comparatorValue());
		Collections.sort(input2Data, new comparatorValue());
		
		HashMap<Integer, ArrayList<joinVo>> answer = new HashMap<>();
		int KeySite1 = 0, KeySite2 = 0;
		
		ArrayList<joinVo> temp2;
		
		for(int i=0;i<input1Data.size();i++) {
			if(!answer.containsKey(input1Data.get(i).getKey())) {
				temp2 = new ArrayList<>();
				
				int j;
				for(j=KeySite1;j<input2Data.size();j++) {
					if(input2Data.get(j).getKey() != input1Data.get(i).getKey())
						break;
					
					temp2.add(new joinVo(input1Data.get(i).getValue(), (char)input2Data.get(j).getValue()));
				}
				answer.put(input1Data.get(i).getKey(), temp2);
				KeySite1 = j;
				
			}else {	
				int j;
				for(j=KeySite2;j<input2Data.size();j++) {
					if(input2Data.get(j).getKey() != input1Data.get(i).getKey())
						break;
					
					answer.get(input1Data.get(i).getKey()).add(new joinVo(input1Data.get(i).getValue(), (char)input2Data.get(j).getValue()));
				}
				KeySite2 = j;
			}	
		}
		
		return answer;
	}
}
