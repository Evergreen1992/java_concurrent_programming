package sychronizedTools;

import java.util.concurrent.CountDownLatch;

//闭锁测试
public class CountDownLatchTest {
	public static long timeTasks(int nThreads) throws Exception{
		final CountDownLatch startGate = new CountDownLatch(1);//开始门
		final CountDownLatch endGate = new CountDownLatch(nThreads);//结束门
		
		for(int i = 0 ; i < nThreads; i ++){
			Thread t = new Thread(){
				public void run(){
					try{
						startGate.await();//大于0，则等待
						System.out.println("thread started..");
					}catch(Exception e){
						
					}finally{
						endGate.countDown();
					}
				}
			};
			t.start();
		}
		
		System.out.println("..............");
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		
		return end - start ;
	}

	public static void main(String[] args) {
		try {
			System.out.println(timeTasks(5));
		} catch (Exception e) {
			
		}
	}

}
