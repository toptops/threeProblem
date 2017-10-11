package problem_1;


import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import common.comparatorAllValue;
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
	ArrayList<joinAllVo> saveDataArrayList;

	
	public join() {
		saveDataMap = new HashMap<>();
		saveDataMap2 = new HashMap<>();
		saveDataArrayList = new ArrayList<>();
	}
	
	/* 
	 * �Է¹��� 2���� List�� Key�߽����� ���� �� Inner-join�� ��� ���� map �����ϴ� �Լ� 
	 * @param input1  join�ϰ����ϴ� list 
	 * @param input2  join�ϰ����ϴ� list
	 * 
	 * KeySite1 KeySite2 : Key�� ���� List�� Value ó�� �� 
	 * valueSite, valueSite2�� �ι�° list�� ���� ���� �� ó������ �ִ°� �ƴ϶� �־��� �� ���ĺ��� �ֱ� ���ؼ� üũ �ϴ� �κ�.
	 * 
	 * Collection�Լ��� ���� input1, input2�� key�� �߽����� �������� �����Ѵ�.
	 * ���� ������ HashMap ������ input1 ù��° Ű���� �ִ��� ���� ���� �ִ� �κ�.
	 * ���� ��ǥ�� �Ű����� ����Ʈ�� ���׸����� ������ ����Ϸ��� �ߴ�.
	 * ����� hashVo.class�� �������� ����ϰ� �������.
	 * notKeyTotalVariableCount�� ���� hashVoŬ���� �ȿ� �ִ� key�ʵ带 �����ϰ� �ٸ� ���� �ʵ����  ī��Ʈ �Ѵ�.(input1, input2)
	 * �� �� ���� �ִ´�.
	 * 
	 */
	public void setData(ArrayList<hashVo> input1, ArrayList<hashVo> input2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		Collections.sort(input1, new comparatorValue());
		Collections.sort(input2, new comparatorValue());
		
		ArrayList<Object[]> temp;
		int KeySite1 = 0, KeySite2 = 0;
		int valueSite = 0, valueSite2 = 0;

		
//		for(int i=0;i<input1.size();i++) {
//			if(!saveDataMap.containsKey(input1.get(i).getKey())) {
//				
//				temp = new ArrayList<>();
//				int j;
//				for(j=KeySite1;j<input2.size();j++) {
//					
//					if(input2.get(j).getKey() != input1.get(i).getKey())
//						break;
//					
//					Object[] obj;
//					obj = new Object[notKeyTotalVariableCount(hashVo.class, hashVo.class)];
//					int count = 0;
//
//					for(int a=0;a<obj.length;a++) {
//						if(!input1.get(a).getClass().getDeclaredMethods()[a].getName().contains("Key") && input1.get(a).getClass().getDeclaredMethods()[a].getName().contains("get")) {
//							obj[count] = input1.get(a).getClass().getDeclaredMethods()[a].invoke(input1.get(i), null);
//							count++;
//						}
//						
//						if(!input2.get(a).getClass().getDeclaredMethods()[a].getName().contains("Key") && input2.get(a).getClass().getDeclaredMethods()[a].getName().contains("get")){
//							obj[count] = input2.get(a).getClass().getDeclaredMethods()[a].invoke(input2.get(valueSite), null);
//							count++;valueSite++;
//						}
//					}
//					
//					temp.add(obj);
//				}
//				saveDataMap.put(input1.get(i).getKey(), temp);
//				KeySite1 = j;
//			}else {	
//				int j;
//				for(j=KeySite2;j<input2.size();j++) {
//					
//					if(input2.get(j).getKey() != input1.get(i).getKey())
//						break;
//					
//					Object[] obj;
//					obj = new Object[notKeyTotalVariableCount(hashVo.class, hashVo.class)];
//
//					int count = 0;
//					for(int a=0;a<obj.length;a++) {
//						if(!input1.get(a).getClass().getDeclaredMethods()[a].getName().contains("Key") && input1.get(a).getClass().getDeclaredMethods()[a].getName().contains("get")) {
//							obj[count] = input1.get(a).getClass().getDeclaredMethods()[a].invoke(input1.get(i), null);
//							count++;
//						}
//						
//						if(!input2.get(a).getClass().getDeclaredMethods()[a].getName().contains("Key") && input2.get(a).getClass().getDeclaredMethods()[a].getName().contains("get")){
//							obj[count] = input2.get(a).getClass().getDeclaredMethods()[a].invoke(input2.get(valueSite2), null);
//							count++;valueSite2++;
//						}
//					}
//					saveDataMap.get(input1.get(i).getKey()).add(obj);
//				}
//				KeySite2 = j;
//			}	
//		}
		
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
	
	//class���� key�� ������ �ʵ� ������ ī��Ʈ.
	static int notKeyTotalVariableCount(Class c1, Class c2) {
		int i,count=0;
		for(i=0;i<c1.getDeclaredFields().length;i++) {
			if(!c1.getDeclaredFields()[i].getName().contains("key")) {
				count++;
			}
		}
		for(i=0;i<c2.getDeclaredFields().length;i++) {
			if(!c2.getDeclaredFields()[i].getName().contains("key")) {
				count++;
			}
		}
		return count;
	}
	
	public void setAllData(ArrayList<hashVo> input1, ArrayList<hashVo> input2) {
		for(int i=0;i<input1.size();i++) {
			for(int j=0;j<input2.size();j++) {
				if(input1.get(i).getKey() == input2.get(j).getKey()) {
					saveDataArrayList.add(new joinAllVo(input1.get(i).getKey(), input1.get(i).getValue(), input2.get(j).getValue()));
				}
			}
		}
		
		Collections.sort(saveDataArrayList, new comparatorAllValue());
	}
	
	public void printData() {
		for(int i=0;i<saveDataArrayList.size();i++) {
			System.out.println(saveDataArrayList.get(i).getKey()+", "+saveDataArrayList.get(i).getInput1Value()+", "+(char)saveDataArrayList.get(i).getInput2Value());
		}
	}
	
	/* Map ��� �Լ� */
//	public void printData() {
//		Iterator<Integer> iterator = saveDataMap.keySet().iterator();
//
//		while (iterator.hasNext()) { 
//			int key = (int)iterator.next(); // Ű ���
//			for(int i=0;i<saveDataMap.get(key).size();i++) {
//				System.out.println(key+",  ["+saveDataMap.get(key).get(i)[0]+", "+ (char)((int)saveDataMap.get(key).get(i)[1])+"]");
//			}
//		}
//	}
	
//	public void printData() {
//		Iterator<Integer> iterator = saveDataMap2.keySet().iterator();
//
//		while (iterator.hasNext()) { 
//			int key = (int)iterator.next(); // Ű ���
//			for(int i=0;i<saveDataMap2.get(key).size();i++) {
//				System.out.println(key+", ["+saveDataMap2.get(key).get(i).getIntValue()+", "+saveDataMap2.get(key).get(i).getCharValue()+"]");
//			}
//		}
//	}
	
}
