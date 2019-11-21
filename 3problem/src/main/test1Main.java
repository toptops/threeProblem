package main;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.hashVo;
import problem_1.join;
import problem_1.joinVo;

public class test1Main {
	public static void main(String[] args) throws Exception {
		List<hashVo> inputData1 = new ArrayList<hashVo>();
		List<hashVo> inputData2 = new ArrayList<hashVo>();
		HashMap<Integer, ArrayList<joinVo>> answer;
		
		inputData1.add(new hashVo(101, 2));
		inputData1.add(new hashVo(101, 1));
		inputData1.add(new hashVo(102, 6));
		inputData1.add(new hashVo(102, 7));
		inputData1.add(new hashVo(103, 3));
		inputData1.add(new hashVo(103, 2));
		
		inputData2.add(new hashVo(101, 'e'));
		inputData2.add(new hashVo(101, 'a'));
		inputData2.add(new hashVo(102, 'b'));
		inputData2.add(new hashVo(102, 'c'));
		inputData2.add(new hashVo(103, 'a'));
		inputData2.add(new hashVo(103, 'd'));
		
		join join = new join();
		answer = join.setData(inputData1, inputData2);
	}
}
