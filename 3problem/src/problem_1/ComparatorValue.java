package problem_1;

import java.util.Comparator;

/**
 * Collections.Sort 함수를 쓰기 위한 함수.
 * @author seong
 *
 */
public class ComparatorValue implements Comparator<hashVo>{
	@Override
	public int compare(hashVo o1, hashVo o2) {
		int ret = 0;
		if(o1.getKey() == o2.getKey()) {
			if(o1.getValue() > o2.getValue()) {
				ret = 1;
			}else if(o1.getValue() < o2.getValue()) {
				ret = -1;
			}
		}
		return ret;
	}
}
