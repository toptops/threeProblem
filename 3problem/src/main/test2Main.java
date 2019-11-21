package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.hashVo;
import problem_2.group;

public class test2Main {
	public static void main(String[] args) {
		List<hashVo> inputData1 = new ArrayList<hashVo>();
		HashMap<Integer, ArrayList<Integer>> answer;
		
		inputData1.add(new hashVo(101,1));
		inputData1.add(new hashVo(101,2));
		inputData1.add(new hashVo(101,3));
		inputData1.add(new hashVo(102,5));
		inputData1.add(new hashVo(102,6));
		inputData1.add(new hashVo(103,1));
		inputData1.add(new hashVo(103,2));
		
		group group = new group();
		answer = group.setData(inputData1);
	}
}

