/**
 * 
 * @author lucas
 *
 */
public class Person {
	//Instance variables
	private int[] numbers;
	private int size;
	
	/**
	 * 
	 * @param numbers
	 */
	public Person(int[] numbers, int size) {
		this.numbers = numbers;
		this.size = size;
	}
	
	/**
	 * 
	 * @return
	 */
	public int[] getNumbers() {
		return numbers;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}
}
