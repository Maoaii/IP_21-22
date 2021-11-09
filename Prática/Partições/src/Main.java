import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Create a new scanner
		Scanner sc = new Scanner(System.in);
		
		//Read two ints from user input
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//Call the method and print number of partitions
		System.out.println(partitions(n, m));
		
		//Close current scanner
		sc.close();
	}
	
	/**
	 * Method that recursively calculates the partitions of a number 'n' until 'm' value
	 * 
	 * @param n
	 * @param m
	 * @return int
	 */
	private static int partitions(int n, int m) {
		
		if (n == 0 && m >= 0) {
			return 1;
		}
		else if (n > 0 && m == 0) {
			return 0;
		}
		else if (n < m && m > 0) {
			return partitions(n, m-1);
		}
		else {
			return partitions(n-m, m) + partitions(n, m-1);
		}
	}

}
