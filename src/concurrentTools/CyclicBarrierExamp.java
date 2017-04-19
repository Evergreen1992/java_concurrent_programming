package concurrentTools;

import java.util.concurrent.CyclicBarrier;

//所有线程到达屏障，才打开屏障继续执行。
public class CyclicBarrierExamp {
	static CyclicBarrier c = new CyclicBarrier(2);
	
	public static void main(String[] args) {
		new Thread(new Runnable(){
			public void run(){
				try{
					System.out.println("thread 1 arrived ... ");
					c.await();
				}catch(Exception e){
				}
				System.out.println("thread 1 finished ... ");
			}
		}).start();
		
		try{
			System.out.println("thread 2 arrived ... ");
			c.await();
		}catch(Exception e){
		}
		System.out.println("thread 2 finished ... ");
	}
}