import java.util.Scanner;
import java.io.*;

public class Main {

	private static final String FILENAME = "C:/Users/lucas/eclipse-workspace/LaboratorioSimples/src/test";

	public static void main(String[] args) throws FileNotFoundException {
		sumUp(FILENAME);
	}

	private static void sumUp(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(fileName));
		int projectId = 0;
		int colabs = 0;
		
		projectId = in.nextInt();
		in.nextLine();
		in.nextLine();
		in.nextLine();
		in.nextLine();
		colabs = in.nextInt();
		
		System.out.printf("Project id: %d\nAmount of collaborators: %d", projectId, colabs);
		in.close();
	}

}
