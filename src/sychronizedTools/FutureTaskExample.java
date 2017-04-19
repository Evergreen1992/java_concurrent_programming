package sychronizedTools;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//futuretask用于等待一个线程执行完成，将结果返回给调用者的情况。异步的情况。
public class FutureTaskExample {
	private final FutureTask<Result> future = new FutureTask<Result>(new Callable<Result>(){
		public Result call() throws Exception {
			Thread.sleep(3000);
			return new Result();
		}
	});
	
	private final Thread thread = new Thread(future);
	public void get() throws InterruptedException, ExecutionException{
		thread.start();
		System.out.println(future.get().name);
	}

	public static void main(String[] args) {
		try {
			new FutureTaskExample().get();
			System.out.println("hello .... still working...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
class Result{
	public String name = "fddafdas";
}
