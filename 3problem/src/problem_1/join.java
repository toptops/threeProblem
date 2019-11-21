package problem_1;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import common.comparatorValue;
import common.hashVo;

/**
 * �Է¹��� 2���� List<HashVo>�� DB�� Inner-Joinó�� ���� �Լ�.
 * @author seong
 *
 */
public class join {
	HashMap<Integer, ArrayList<Object[]>> saveDataMap;
	HashMap<Integer, ArrayList<joinVo>> saveDataMap2;
//	ArrayList<joinAllVo> saveDataArrayList;

	
	public join() {
		saveDataMap = new HashMap<>();
		saveDataMap2 = new HashMap<>();
//		saveDataArrayList = new ArrayList<>();
	}
	
	/* 
	 * �Է¹��� 2���� List�� Key�߽����� ���� �� Inner-join�� ��� ���� map �����ϴ� �Լ� 
	 * @param input1  join�ϰ����ϴ� list 
	 * @param input2  join�ϰ����ϴ� list
	 * 
	 * KeySite1 KeySite2 : Key�� ���� List�� Value ó�� �� 
	 * valueSite, valueSite2�� �ι�° list�� ���� ���� �� ó������ �ִ°� �ƴ϶� �־��� �� ���ĺ��� �ֱ� ���ؼ� üũ �ϴ� �κ�.
	 * 
	 */
	public void setData(ArrayList<hashVo> input1, ArrayList<hashVo> input2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		Collections.sort(input1, new comparatorValue());
		Collections.sort(input2, new comparatorValue());
		
		int KeySite1 = 0, KeySite2 = 0;
		
		ArrayList<joinVo> temp2;
		
		for(int i=0;i<input1.size();i++) {
			if(!saveDataMap2.containsKey(input1.get(i).getKey())) {
				temp2 = new ArrayList<>();
				
				int j;
				for(j=KeySite1;j<input2.size();j++) {
					if(input2.get(j).getKey() != input1.get(i).getKey())
						break;
					
					temp2.add(new joinVo(input1.get(i).getValue(), (char)input2.get(j).getValue()));
				}
				saveDataMap2.put(input1.get(i).getKey(), temp2);
				KeySite1 = j;
				
			}else {	
				int j;
				for(j=KeySite2;j<input2.size();j++) {
					if(input2.get(j).getKey() != input1.get(i).getKey())
						break;
					
					saveDataMap2.get(input1.get(i).getKey()).add(new joinVo(input1.get(i).getValue(), (char)input2.get(j).getValue()));
				}
				KeySite2 = j;
			}	
		}
		
	}
}
