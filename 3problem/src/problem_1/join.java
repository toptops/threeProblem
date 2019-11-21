package problem_1;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import common.comparatorValue;
import common.hashVo;

/**
 * �Է¹��� 2���� List<HashVo>�� DB�� Inner-Joinó�� ���� �Լ�.
 * @author seong
 *
 */
public class join {
	/* 
	 * �Է¹��� 2���� List�� Key�߽����� ���� �� Inner-join�� ��� ���� map �����ϴ� �Լ� 
	 * @param input1  join�ϰ����ϴ� list 
	 * @param input2  join�ϰ����ϴ� list
	 * 
	 * KeySite1 KeySite2 : Key�� ���� List�� Value ó�� �� 
	 * valueSite, valueSite2�� �ι�° list�� ���� ���� �� ó������ �ִ°� �ƴ϶� �־��� �� ���ĺ��� �ֱ� ���ؼ� üũ �ϴ� �κ�.
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
