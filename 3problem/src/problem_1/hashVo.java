package problem_1;

/**
 * hashMap 등 key, value로 구성된 자료구조들은 key값을 중복하여 value값을 넣을 수 없어서 만든 객체.
 * @author seong
 * 
 */
public class hashVo{
	private int key;
	private int value;

	public hashVo(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
