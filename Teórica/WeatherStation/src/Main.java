import java.util.Scanner;
import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		writeToFile(readFromFile("test.txt"), "out.txt");
	}

	/**
	 * Cria uma estação meteorológica e lê uma sequência de temperaturas, de um ficheiro com o nome
	 * indicado, armazenando-as na estação meteorológica. Finalmente, devolve a estação
	 * meteorológica com as temperaturas registadas.
	 * 
	 * @return a estação meteorológica, após lidas as temperaturas.
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
	 * Escreve num ficheiro algumas estatísticas sobre uma estação meteorológica.
	 * 
	 * @param ws A estação meteorológica.
	 * @pre: ws != null, fileName != null
	 * @throws FileNotFoundException
	 */
	private static void writeToFile(WeatherStation ws, String fileName)
			throws FileNotFoundException {
		PrintWriter out = new PrintWriter(fileName);
		if (ws.numberOfSamples() > 0) {
			out.println("Estatísticas");
			out.println("Temperatura máxima: " + ws.getMaximum());
			out.println("Temperatura mínima: " + ws.getMinimum());
			out.printf("Média: %.2f\n", ws.getAverage());
		} else {
			out.println("Não há temperaturas registadas.");
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
		WeatherStation ws = new WeatherStation(); // Cria estação
		do { // Lê valores, que guarda na estação
			System.out.print("Temperatura (carácter não numérico para fim): ");
			if (in.hasNextDouble()) { // Testa se input é numérico
				ws.addSample(in.nextDouble());
				in.nextLine();
			}
		} while (in.hasNextDouble());
		in.close();
		return ws; // Retorna estação
	}

	/**
	 * 
	 * @param ws
	 */
	@SuppressWarnings("unused")
	private static void writeToConsole(WeatherStation ws) {
		if (ws.numberOfSamples() > 0) {
			System.out.println("Estatísticas");
			System.out.println("Temperatura máxima: " + ws.getMaximum());
			System.out.println("Temperatura mínima: " + ws.getMinimum());
			System.out.printf("Média: %.2f\n", ws.getAverage());
		} else
			System.out.println("Não há temperaturas registadas!");
	}

}
