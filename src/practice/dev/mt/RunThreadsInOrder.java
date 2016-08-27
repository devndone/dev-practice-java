package practice.dev.mt;

public class RunThreadsInOrder implements Runnable {

	static int numThread = 1;
	static int threadAllowedToRun = 1;
	int myThreadID;
	private static Object myLock = new Object();

	public RunThreadsInOrder() {
		this.myThreadID = numThread++;
		System.out.println("Thread ID:" + myThreadID);
	}

	@Override
	public void run() {
		synchronized (myLock) {
			while (myThreadID != threadAllowedToRun) {
				try {
					myLock.wait();
				} catch (InterruptedException e) {

				} catch (Exception e) {
				}
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

			System.out.println("myThreadID is running: " + myThreadID);
			myLock.notifyAll();
			threadAllowedToRun++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new RunThreadsInOrder());
		Thread t2 = new Thread(new RunThreadsInOrder());
		Thread t3 = new Thread(new RunThreadsInOrder());
		Thread t4 = new Thread(new RunThreadsInOrder());
		Thread t5 = new Thread(new RunThreadsInOrder());
		Thread t6 = new Thread(new RunThreadsInOrder());
		Thread t7 = new Thread(new RunThreadsInOrder());

		t7.start();
		t6.start();
		t5.start();
		t4.start();
		t3.start();
		t2.start();
		t1.start();

	}
}
