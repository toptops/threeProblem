package problem_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * �Է¹��� ArrayList<HashVO>�� Key�߽����� ���� �� ���� �����͵��� ArrayList�� ��� �ٽ� HashMap�� Key,Value�� ����, ���   
 * @author seong
 *
 */
public class Group {
	HashMap<Integer, ArrayList<Integer>> saveDataMap;
	
	public Group() {
		saveDataMap = new HashMap<>();
	}
	
	
	/* �Էµ� List�� Key�߽����� ���� �����ͳ��� List�� ��� �̸� �ٽ� Map�� Key, value�� �����ϴ� �Լ� */
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
	
	/* ������ ��� �Լ� */
	void printData() {
		Iterator<Integer> iterator = saveDataMap.keySet().iterator();
		
		while (iterator.hasNext()) { 
			int key = (int)iterator.next(); // Ű ���
			System.out.println(key +",  "+ this.saveDataMap.get(key));
		}
	}
	
}
