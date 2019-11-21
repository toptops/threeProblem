package problem_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.hashVo;

/**
 * �Է¹��� ArrayList<HashVO>�� Key�߽����� ���� �� ���� �����͵��� ArrayList�� ��� �ٽ� HashMap�� Key,Value�� ����, ���   
 * @author seong
 *
 */
public class group {
	/* �Էµ� List�� Key�߽����� ���� �����ͳ��� List�� ��� �̸� �ٽ� Map�� Key, value�� �����ϴ� �Լ� */
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
