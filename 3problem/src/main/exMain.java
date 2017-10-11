package main;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

import common.hashVo;

public class exMain {
	public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchFieldException {
		ArrayList<hashVo> input1, input2;
		input1 = new ArrayList<>(); input2 = new ArrayList<>(); 
		input1.add(new hashVo(1, 1));
		input1.add(new hashVo(1, 2));
		input1.add(new hashVo(1, 3));
		input1.add(new hashVo(1, 4));
		Object[] obj = new Object[(countVariable(hashVo.class)-1) * 2];
		Field []field = totalVariable(hashVo.class, hashVo.class);
		Type superclassType = input1.getClass().getGenericSuperclass();
//		System.out.println(superclassType);
//		System.out.println(((ParameterizedType)superclassType).getActualTypeArguments()[0]);
//		
	//	GenericClass g = new GenericClass(input1);
		//System.out.println(g.getClass().getFields()[0]);
		
//		System.out.println(input1.get(0).getClass().getDeclaredMethods()[0].invoke(input1.get(1), null));
//		
//		
//		System.out.println(input1.getClass().getTypeParameters());
		
		ArrayList<hashVo> lst = new ArrayList<hashVo>(){};
		Type genType = lst.getClass().getGenericSuperclass();

		Class templatClazz = null;

		if(ParameterizedType.class.isInstance(genType))
		{
		  ParameterizedType parameterizedType = (ParameterizedType) genType;
		 templatClazz = (Class) parameterizedType.getActualTypeArguments()[0];
		 System.out.println(templatClazz);
		}
	}
	
	static Field[] totalVariable(Class c1, Class c2) {
		Field []field = new Field[c1.getDeclaredFields().length-1 + c2.getDeclaredFields().length-1];
		int i,count=0;
		for(i=0;i<c1.getDeclaredFields().length;i++) {
			if(!c1.getDeclaredFields()[i].getName().contains("key")) {
				
				field[count] = c1.getDeclaredFields()[i];
				count++;
				
			}
		}
		for(int j=0;j<c2.getDeclaredFields().length;j++) {
			if(!c2.getDeclaredFields()[j].getName().contains("key")) {
				
				field[count] = c2.getDeclaredFields()[j];
				count++;
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
}

class GenericClass{

    private ArrayList type;

    public GenericClass(ArrayList type) throws NoSuchFieldException, SecurityException {
         this.type = type;
    }

//    public Type getMyType() throws NoSuchFieldException, SecurityException {
//        return this.getClass().getField("type").getGenericType();
//    }
}
