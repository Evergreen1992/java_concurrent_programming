package concurrentTools;

import java.util.concurrent.CountDownLatch;
//等待所有线程执行结束
public class CountDownLatchTest {
	static CountDownLatch c = new CountDownLatch(2);
	
	public static void main(String[] args) throws Exception{
		new Thread(new Runnable(){
			public void run() {
				System.out.println(" 1 ... ");
				c.countDown();
				System.out.println(" 2 ... ");
				c.countDown();
			}			
		}).start();
		
		c.await();//等待闭锁变为0。
		System.out.println(" 3 ... ");
	}
}