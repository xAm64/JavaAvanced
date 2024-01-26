package TestThread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTime {

	public static void main(String[] args) {
	    DateFormat df = new SimpleDateFormat("HH:mm:ss");
	    Thread thread = new Thread(new MonRunnable(1000));

	    System.out.println(df.format(new Date()));
	    

	    thread.start();
	  }
	
	private static class MonRunnable implements Runnable {
		
		DateFormat df = new SimpleDateFormat("HH:mm:ss");

	    private long delai;

	    public MonRunnable(long delai) {
	      this.delai = delai;
	    }

	    @Override
	    public void run() {
	    	while(true) {
		      try {
		        Thread.sleep(delai);
		        System.out.println(df.format(new Date()));
		        run();
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
	    	}
	    }
	  }
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	} 

}
