package problem_1;

/**
 * 1번문제 결과에 대한 클래스
 * Value1(Num), Value2(Char)가 들어가 있다.
 * 
 * 
 * @author seong
 *
 */
public class joinVo {

	private int intValue;
	private char charValue;
	
	public joinVo() {
	}
	
	public joinVo(int intValue, char charValue) {
		this.intValue = intValue;
		this.charValue = charValue;
	}

	public int getIntValue() {
		return intValue;
	}

	public char getCharValue() {
		return charValue;
	}

}
