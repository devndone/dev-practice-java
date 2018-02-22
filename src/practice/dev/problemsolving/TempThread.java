package practice.dev.problemsolving;

public class TempThread {

	class Mt extends Thread {
		public void run() {
			System.out.println(" bar");
		}
		public void run(String arg) {
			System.out.println(" baz");
		}
	}
	
	public static void main(String [] args) {
		Thread t = new TempThread().new Mt() {
			public void run() {
				System.out.println(" foo");
			}
		};
		t.start();
	}
}
