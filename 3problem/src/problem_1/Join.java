package problem_1;


import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * �Է¹��� 2���� List<HashVo>�� DB�� Inner-Joinó�� ���� �Լ�.
 * @author seong
 *
 */
public class Join {
	HashMap<Integer, ArrayList<Object[]>> saveDataMap;
	
	public Join() {
		saveDataMap = new HashMap<>();
	}
	
	/* 
	 * �Է¹��� 2���� List�� Key�߽����� ���� �� Inner-join�� ��� ���� map �����ϴ� �Լ� 
	 * @param input1  join�ϰ����ϴ� list 
	 * @param input2  join�ϰ����ϴ� list
	 * 
	 * KeySite1 KeySite2 : Key�� ���� List�� Value ó�� �� 
	 */
	void setData(ArrayList<hashVo> input1, ArrayList<hashVo> input2, Class voClass) {
		Collections.sort(input1, new ComparatorValue());
		Collections.sort(input2, new ComparatorValue());
		
		ArrayList<Object[]> temp;
		int KeySite1 = 0, KeySite2 = 0;
		
		
		for(int i=0;i<input1.size();i++) {
			if(!saveDataMap.containsKey(input1.get(i).getKey())) {
				temp = new ArrayList<>();
				
				int j;
				for(j=KeySite1;j<input2.size();j++) {
					if(input2.get(j).getKey() != input1.get(i).getKey())
						break;
					
					Object[] obj = new Object[(countVariable(voClass)-1) * 2];
					GenericList<> 
					//Field []field = totalVariable(input1.getClass().get, c2)
					
					
					temp.add(obj);
				}
				saveDataMap.put(input1.get(i).getKey(), temp);
				KeySite1 = j;
			}else {	
				int j;
				for(j=KeySite2;j<input2.size();j++) {
					if(input2.get(j).getKey() != input1.get(i).getKey())
						break;
					
					saveDataMap.get(input1.get(i).getKey()).add(new joinVo(input1.get(i).getValue(), (char)input2.get(j).getValue()));
				}
				KeySite2 = j;
			}	
		}
	}
	static Field[] totalVariable(Class c1, Class c2) {
		Field []field = new Field[c1.getDeclaredFields().length + c2.getDeclaredFields().length];
		int i,count=0;
		for(i=0;i<c1.getDeclaredFields().length;i++) {
			if(!c1.getDeclaredFields()[i].getName().contains("key")) {
				field[count++] = c1.getDeclaredFields()[i];
			}
		}
		for(;i<c2.getDeclaredFields().length;i++) {
			if(!c2.getDeclaredFields()[i].getName().contains("key")) {
				field[count++] = c2.getDeclaredFields()[i];
			}
		}
		return field;
	}
	
	static int countVariable(Class c) {
		Class buf = c;
		Method[] m = c.getDeclaredMethods();
		int count=0;
		for(int i=0;i<m.length;i++) {
			if(m[i].getName().contains("get")) count++;
		}
		return count;
	}
	/* Map ��� �Լ� */
	void printData() {
		Iterator<Integer> iterator = saveDataMap.keySet().iterator();

		while (iterator.hasNext()) { 
			int key = (int)iterator.next(); // Ű ���
			for(int i=0;i<saveDataMap.get(key).size();i++) {
				System.out.println(key+",  ["+saveDataMap.get(key).get(i).getIntValue()+", "+saveDataMap.get(key).get(i).getCharValue()+"]");
			}
		}
	}
	
}
