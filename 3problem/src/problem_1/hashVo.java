package problem_1;

/**
 * hashMap �� key, value�� ������ �ڷᱸ������ key���� �ߺ��Ͽ� value���� ���� �� ��� ���� ��ü.
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
