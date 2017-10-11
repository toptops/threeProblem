package problem_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import common.hashVo;

/**
 * �Է¹��� ArrayList<HashVO>�� Key�߽����� ���� �� ���� �����͵��� ArrayList�� ��� �ٽ� HashMap�� Key,Value�� ����, ���   
 * @author seong
 *
 */
public class group {
	HashMap<Integer, ArrayList<Integer>> saveDataMap;
	
	public group() {
		saveDataMap = new HashMap<>();
	}
	
	
	/* �Էµ� List�� Key�߽����� ���� �����ͳ��� List�� ��� �̸� �ٽ� Map�� Key, value�� �����ϴ� �Լ� */
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
	
	// �̺κ�. ����?
	/* ������ ��� �Լ� */
	public void printData() {
		Iterator<Integer> iterator = saveDataMap.keySet().iterator(); // �������� ����.
		
		while (iterator.hasNext()) { 
			int key = (int)iterator.next(); // Ű ���
			System.out.println(key +",  "+ this.saveDataMap.get(key));
		}
	}
	
}
