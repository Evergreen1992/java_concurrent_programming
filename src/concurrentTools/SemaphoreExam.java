package concurrentTools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//信号量，用于控制同时访问一个资源的线程数量
public class SemaphoreExam {
	private static final int THREAD_COUNT = 30 ;
	private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
	private static Semaphore s = new Semaphore(10);
	
	public static void main(String[] args) {
		for(int i = 0; i < THREAD_COUNT; i ++){
			threadPool.execute(new Runnable(){
				public void run(){
					try{
						s.acquire();
						System.out.println(" data saved .. " + s.availablePermits());
						s.release();
					}catch(Exception e){
					}
				}
			});
		}
		
		threadPool.shutdown();
	}
}