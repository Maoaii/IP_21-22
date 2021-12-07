
public class WeatherStation {

	private static final int DEFAULT_CAPACITY = 100;
	private static final int GROWTH_FACTOR = 2;

	private int size;
	private double[] samples;

	public WeatherStation() {
		size = 0;
		samples = new double[DEFAULT_CAPACITY];
	}

	public void addSample(double sample) {
		if (isFull())
			grow();
		samples[size++] = sample;
	}

	public int numberOfSamples() {
		return size;
	}

	public double getSample(int i) {
		return samples[i - 1];
	}

	public double getMaximum() {
		double max = 0;
		for (int i = 0; i < samples.length; i++) {
			if (max < getSample(i))
				max = getSample(i);
		}
		return max;
	}

	public double getMinimum() {
		double min = 0;
		for (int i = 0; i < samples.length; i++) {
			if (min > samples[i])
				min = samples[i];
		}
		return min;
	}

	public double getAverage() {
		double sum = 0;
		for (int i = 0; i < size; i++) {
			sum += samples[i];
		}
		return sum / size;
	}

	public int firstPositionOfSample(double tmp) {
		for (int i = 0; i < samples.length; i++) {
			if (samples[i] == tmp)
				return i;
		}
		return 0;
	}

	public int lastPositionOfSample(double tmp) {
		int last = 0;
		for (int i = 0; i < samples.length; i++) {
			if (samples[i] == tmp)
				last = i;
		}
		return last;
	}

	public void removeFrom(int pos) {
		int posV = pos - 1; // índice do elemento a remover
		for (int i = posV; i < size - 1; i++) {
			samples[i] = samples[i + 1]; // desloca para a
		} // esquerda
		size--; // decrementa o número de amostras
	}

	public void insertAt(double temp, int pos) {
		int posV = pos - 1; // posição no vetor
		if (isFull())
			grow();
		openSpace(posV);
		samples[posV] = temp; // coloca temp em posV
		size++; // incrementa o número de amostras
	}

	private void openSpace(int posV) {
		for (int i = size - 1; i >= posV; i--)
			samples[i + 1] = samples[i];
	}

	private boolean isFull() {
		return size == samples.length;
	}

	private void grow() {
		double[] tmp = new double[GROWTH_FACTOR * samples.length];
		for (int i = 0; i < samples.length; i++) {
			tmp[i] = samples[i];
		}
		samples = tmp;
	}
}
