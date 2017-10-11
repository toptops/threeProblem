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
 * 입력받은 2개의 List<HashVo>를 DB의 Inner-Join처럼 만든 함수.
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
	 * 입력받은 2개의 List를 Key중심으로 정렬 후 Inner-join후 결과 값을 map 저장하는 함수 
	 * @param input1  join하고자하는 list 
	 * @param input2  join하고자하는 list
	 * 
	 * KeySite1 KeySite2 : Key가 같은 List의 Value 처음 값 
	 * valueSite, valueSite2는 두번째 list의 값을 넣을 때 처음부터 넣는게 아니라 넣어진 값 이후부터 넣기 위해서 체크 하는 부분.
	 * 
	 * Collection함수를 통해 input1, input2를 key를 중심으로 오름차순 정렬한다.
	 * 이후 저장할 HashMap 변수에 input1 첫번째 키값이 있는지 비교후 값을 넣는 부분.
	 * 원래 목표는 매개변수 리스트를 제네릭으로 받은후 계산하려고 했다.
	 * 현재는 hashVo.class를 중점으로 계산하게 만들었다.
	 * notKeyTotalVariableCount를 통해 hashVo클래스 안에 있는 key필드를 제외하고 다른 변수 필드들을  카운트 한다.(input1, input2)
	 * 그 후 값을 넣는다.
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
	
	//class에서 key를 제외한 필드 변수들 카운트.
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
	
	/* Map 출력 함수 */
//	public void printData() {
//		Iterator<Integer> iterator = saveDataMap.keySet().iterator();
//
//		while (iterator.hasNext()) { 
//			int key = (int)iterator.next(); // 키 얻기
//			for(int i=0;i<saveDataMap.get(key).size();i++) {
//				System.out.println(key+",  ["+saveDataMap.get(key).get(i)[0]+", "+ (char)((int)saveDataMap.get(key).get(i)[1])+"]");
//			}
//		}
//	}
	
//	public void printData() {
//		Iterator<Integer> iterator = saveDataMap2.keySet().iterator();
//
//		while (iterator.hasNext()) { 
//			int key = (int)iterator.next(); // 키 얻기
//			for(int i=0;i<saveDataMap2.get(key).size();i++) {
//				System.out.println(key+", ["+saveDataMap2.get(key).get(i).getIntValue()+", "+saveDataMap2.get(key).get(i).getCharValue()+"]");
//			}
//		}
//	}
	
}
