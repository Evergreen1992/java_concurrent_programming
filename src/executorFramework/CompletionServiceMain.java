package executorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * completionService使用示例
 * @author xiongxiao
 *
 */
public class CompletionServiceMain {
	private final ExecutorService executor = Executors.newFixedThreadPool(2);
	
	public void doTask(){
		//在线程池executor里面执行任务
		CompletionService<String> completionService = new ExecutorCompletionService<String>(executor);
		for( int i = 0 ; i < 10 ; i ++){
			completionService.submit(new Callable<String>(){
				public String call() throws Exception {
					Thread.sleep(1000);
					return "task done !!  " + Thread.currentThread().getName();
				}
			});
		}
		
		try {
			for (int i = 0; i < 10; i++) {
				Future<String> f = completionService.take();
				System.out.println(f.get());
			} 
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		CompletionServiceMain m = new CompletionServiceMain();
		m.doTask();
		m.executor.shutdown();
	}
}