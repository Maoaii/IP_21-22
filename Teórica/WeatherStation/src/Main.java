import java.util.Scanner;
import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		writeToFile(readFromFile("test.txt"), "out.txt");
	}

	/**
	 * Cria uma esta��o meteorol�gica e l� uma sequ�ncia de temperaturas, de um ficheiro com o nome
	 * indicado, armazenando-as na esta��o meteorol�gica. Finalmente, devolve a esta��o
	 * meteorol�gica com as temperaturas registadas.
	 * 
	 * @return a esta��o meteorol�gica, ap�s lidas as temperaturas.
	 * @pre: fileName != null
	 * @throws FileNotFoundException
	 */
	private static WeatherStation readFromFile(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(fileName));
		WeatherStation ws = new WeatherStation();
		while (in.hasNextDouble()) {
			ws.addSample(in.nextDouble());
			in.nextLine();
		}
		in.close();
		return ws;
	}

	/**
	 * Escreve num ficheiro algumas estat�sticas sobre uma esta��o meteorol�gica.
	 * 
	 * @param ws A esta��o meteorol�gica.
	 * @pre: ws != null, fileName != null
	 * @throws FileNotFoundException
	 */
	private static void writeToFile(WeatherStation ws, String fileName)
			throws FileNotFoundException {
		PrintWriter out = new PrintWriter(fileName);
		if (ws.numberOfSamples() > 0) {
			out.println("Estat�sticas");
			out.println("Temperatura m�xima: " + ws.getMaximum());
			out.println("Temperatura m�nima: " + ws.getMinimum());
			out.printf("M�dia: %.2f\n", ws.getAverage());
		} else {
			out.println("N�o h� temperaturas registadas.");
		}
		out.close();
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static WeatherStation readFromConsole() {
		Scanner in = new Scanner(System.in);
		WeatherStation ws = new WeatherStation(); // Cria esta��o
		do { // L� valores, que guarda na esta��o
			System.out.print("Temperatura (car�cter n�o num�rico para fim): ");
			if (in.hasNextDouble()) { // Testa se input � num�rico
				ws.addSample(in.nextDouble());
				in.nextLine();
			}
		} while (in.hasNextDouble());
		in.close();
		return ws; // Retorna esta��o
	}

	/**
	 * 
	 * @param ws
	 */
	@SuppressWarnings("unused")
	private static void writeToConsole(WeatherStation ws) {
		if (ws.numberOfSamples() > 0) {
			System.out.println("Estat�sticas");
			System.out.println("Temperatura m�xima: " + ws.getMaximum());
			System.out.println("Temperatura m�nima: " + ws.getMinimum());
			System.out.printf("M�dia: %.2f\n", ws.getAverage());
		} else
			System.out.println("N�o h� temperaturas registadas!");
	}

}
