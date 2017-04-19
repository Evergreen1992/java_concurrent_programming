package forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCompute extends RecursiveTask<Integer>{
	private static final long serialVersionUID = 1L;
	//任务划分粒度
	private static final int THRESHOLD = 2;
	private int start ;
	private int end ;
	public ForkJoinCompute(int start, int end){
		this.start = start ;
		this.end = end ;
	}
	@Override
	protected Integer compute() {
		int sum = 0;
		//任务足够小，直接计算
		boolean canCompute = (end - start) <= THRESHOLD;
		if( canCompute){
			for(int i = start; i <= end; i ++)
				sum += i ;
		}else{//分解任务
			int middle = (start + end) / 2 ;
			ForkJoinCompute leftTask = new ForkJoinCompute(start, middle);
			ForkJoinCompute rightTask = new ForkJoinCompute(middle + 1, end);
			//执行子任务
			leftTask.fork();
			rightTask.fork();
			//等待子任务执行结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			//任务合并
			sum = leftResult + rightResult ;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		//生成一个计算任务
		ForkJoinCompute task = new ForkJoinCompute(1,4);
		Future<Integer> result = forkJoinPool.submit(task);
		try {
			System.out.println(result.get());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}