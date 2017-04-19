package executorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * executor框架的使用
 * @author xiongxiao
 *
 */
public class ExecutorMain {
	public ExecutorService executor = Executors.newFixedThreadPool(300);
	
	/**
	 * 返回结果的执行
	 * @return
	 */
	public String runWithResult(){
		Callable<String> cal = new Callable<String>(){
			public String call() throws Exception {
				return Thread.currentThread().getName();
			}
		};
		//使用future获取执行的结果
		Future<String> futur = executor.submit(cal);
		try {
			return futur.get();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (ExecutionException e) {
		}
		return "";
	}
	
	/**
	 * 无输出结果的executor
	 */
	public void runWithoutResult(){
		Runnable cal = new Runnable(){
			public void run()  {
				for( int i = 0 ; i < 3; i ++){
					System.out.println(Thread.currentThread().getName() + " : " + i );
				}
			}
		};
		executor.execute(cal);
	}
	
	public static void main(String[] args){
		ExecutorMain exe = new ExecutorMain();
		for( int i = 10 ; i < 200 ; i ++)
			System.out.println(exe.runWithResult());
		
		exe.executor.shutdown();
	}
}