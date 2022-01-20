package multiThreadingExample;

class Hi implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hi!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Hello implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) throws Exception {

		Runnable r = new Hi();
		Runnable r2 = new Hello();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r2);

		t1.start();

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		t2.start();

		t1.join();

		t2.join();

		System.out.println(t1.isAlive());

		System.out.println("Finished.");

	}

}
