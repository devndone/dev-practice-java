package practice.dev.mt;

public class SeriesPrinterTest {
	
	public static void main(String[] args) {
		SeriesPrinter sp = new SeriesPrinter();
		Thread even = new Thread(new EvenNumberThread(sp, 7));
		Thread odd = new Thread(new OddNumberThread(sp, 7));
		even.start();
		odd.start();
	}
}
