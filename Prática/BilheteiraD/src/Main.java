import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		boolean isFirstYear = input.nextInt() == 1;
		input.nextLine();
		Ticket ticket1 = new Ticket(age, isFirstYear);
		age = input.nextInt();
		isFirstYear = input.nextInt() == 1;
		input.nextLine();
		Ticket ticket2 = new Ticket(age, isFirstYear);
		input.close();
		System.out.println(ticket1.getPriceWith(ticket2));
		System.out.println(ticket2.getPriceWith(ticket1));
	}

}
