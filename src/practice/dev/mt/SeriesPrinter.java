package practice.dev.mt;

import java.util.ArrayList;
import java.util.List;

public class SeriesPrinter {

	int i;
	boolean printStatusFlipFlop;
	
	public synchronized void evenPrinter() throws InterruptedException {
		notifyAll();
		System.out.println("Even Number Thread -- " + i++);
		printStatusFlipFlop = !printStatusFlipFlop;
		wait();
	}
	
	public synchronized void oddPrinter() throws InterruptedException {
		if(!printStatusFlipFlop) {
			wait();
		}
		notifyAll();
		System.out.println("Odd Number Thread -- " + i++);
		printStatusFlipFlop = !printStatusFlipFlop;
		//wait();//Indefinately waits
	}
}

class EvenNumberThread implements Runnable {
	
	protected SeriesPrinter sp;
	protected int printCount;
	private int pCount = 0;
	
	public EvenNumberThread(SeriesPrinter sp_, int printCount_) {
		this.sp = sp_;
		this.printCount = printCount_;
	}

	@Override
	public void run() {
		while(pCount < printCount) {
			try {
				this.sp.evenPrinter();
				this.pCount++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class OddNumberThread implements Runnable {

	protected SeriesPrinter sp;
	protected int printCount;
	private int pCount = 0;
	
	public OddNumberThread(SeriesPrinter sp_, int printCount_) {
		this.sp = sp_;
		this.printCount = printCount_;
	}
	
	@Override
	public void run() {
		while(pCount < printCount) {
			try {
				this.sp.oddPrinter();
				this.pCount++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

