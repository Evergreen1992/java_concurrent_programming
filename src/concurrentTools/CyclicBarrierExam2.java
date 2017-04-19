package concurrentTools;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExam2 {
	static CyclicBarrier c = new CyclicBarrier(2);
	
	public static void main(String[] args) throws Exception {
		Thread thread = new Thread(new Runnable(){
			public void run(){
				try{
					c.await();
				}catch(Exception e){
					
				}
			}
		});
		thread.start();
		thread.interrupt();
		try{
			c.await();
		}catch(Exception e){
			System.out.println(c.isBroken());
			//c.reset();
		}
	}
}