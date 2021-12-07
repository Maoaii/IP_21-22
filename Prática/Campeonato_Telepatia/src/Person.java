/**
 * Person object class. Stores the sequence of numbers the person is thinking and how long that
 * sequence is
 * 
 * @author Lucas Girotto
 */
public class Person {
	// Instance variables
	private int[] numbers;
	private int size;

	/**
	 * Person Constructor: updates the sequence of numbers and amount of numbers in sequence
	 * 
	 * @param numbers: sequence of numbers
	 * @param size:    amount of numbers in sequence
	 * @pre numbers != null && size != null && size >= 2 && size <= 30 && numbers[i] >= 1 &&
	 *      numbers[i] <= 9
	 */
	public Person(int[] numbers, int size) {
		this.numbers = numbers;
		this.size = size;
	}

	/**
	 * @return the sequence of numbers of this person
	 */
	public int[] getNumbers() {
		return numbers;
	}

	/**
	 * @return the amount of numbers in the sequence
	 */
	public int getSize() {
		return size;
	}
}
