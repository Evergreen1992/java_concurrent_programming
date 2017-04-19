package concurrentTools;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//用于线程之间的数据交换
public class ExchangerExamp {
	private static final Exchanger<String> exgr = new Exchanger<String>();
	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		threadPool.execute(new Runnable(){
			public void run(){
				try {
					String A = "银行流水A";
					
					System.out.println("thread A : " + exgr.exchange(A));
				} catch (Exception e) {
				}
			}
		});
		
		threadPool.execute(new Runnable(){
			public void run(){
				try{
					String B = "银行流水B";
					String A = exgr.exchange(B);
					System.out.println("thread B : " + A);
				}catch(Exception e){
					
				}
			}
		});
		
		threadPool.shutdown();
	}
}