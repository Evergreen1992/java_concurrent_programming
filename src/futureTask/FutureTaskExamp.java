package futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskExamp {
	private static final ConcurrentMap<Object, Future<String>> taskCache = 
			new ConcurrentHashMap<Object, Future<String>>();
	public static String executionTask(final String taskName) throws Exception{
		while(true){
			Future<String> future = taskCache.get(taskName);
			if( future == null){
				Callable<String> task = new Callable<String>(){
					public String call() throws Exception{
						return taskName ;
					}
				};
				FutureTask<String> futureTask = new FutureTask<String>(task);
				future = taskCache.putIfAbsent(taskName, futureTask);
				if( future == null ){
					future = futureTask ;
					futureTask.run();
				}
			}
			try{
				return future.get();
			}catch(Exception e){
				taskCache.remove(taskName, future);
			}
		}
	}
	public static void main(String[] args) {

	}
}