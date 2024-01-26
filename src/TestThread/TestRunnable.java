package TestThread;

public class TestRunnable implements Runnable {
	
	String[] z = {"!","\"", "#", "$", "%", "&", "'", "(", ")", "*"};
	
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.print(z[i]);
			for (int j=0;j<=i; j++) {
				System.out.print("*");
			}
			System.out.print(z[i]+"\n");
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new TestRunnable());
		thread.start();
	}

}
