package source;

import javax.swing.JOptionPane;

public class CodingExamA {
	public static void main(String[] args) {
		class Widget {
			boolean widgeted;
			public void doWidget() {
				try {
					Thread.sleep(500);
					widgeted = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		final int TOTAL_WIDGETS = 100;
		Widget[] widgets = new Widget[TOTAL_WIDGETS];
		for(int i = 0; i < TOTAL_WIDGETS; i++) {
			widgets[i] = new Widget();
		}
		
		System.out.println("STARTING");
		long startTime = System.currentTimeMillis();
		
		
		
		
		// Run the program and take note of the elapsed time.
		// This for loop is iterating through all the widgets and calling the doWidget() method on each one.
		// It takes a long time to complete (about a minute).
		// Your goal is to replace this loop with a more optimal solution by splitting this task in half using two threads.
		// Have each thread call doWidget() on half of the array of widgets.
		// If done correctly, the elapsed time should be approximately half of the original time.
//		for(int i = 0; i < TOTAL_WIDGETS; i++) {
//			widgets[i].doWidget();
//		}
		new Thread(()-> {
			for(int i = 0; i < TOTAL_WIDGETS/2; i++) {
			widgets[i].doWidget();
		}
		}).start();
	
		
//		Thread t2 = new Thread(() ->{
//			for(int i = TOTAL_WIDGETS/2; i < TOTAL_WIDGETS; i++) {
//			widgets[i].doWidget();
//		}
//		});
//		t1.start();
//		t2.start();
		//DO NOT ALTER
		for(int i = 0; i < TOTAL_WIDGETS; i++) {
			if(!widgets[i].widgeted) {
				JOptionPane.showMessageDialog(null, "ERROR! Widget #" + i + " have been widgeted.");
				System.exit(1);
			}
		}
		System.out.println("ENDING");
		System.out.println("Time: " + ((float)(System.currentTimeMillis() - startTime) / 1000.0f));
		
	}

}

