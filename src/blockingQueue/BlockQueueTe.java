package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueueTe extends Thread{
	ArrayBlockingQueue<Integer> abq ;
	public BlockQueueTe(ArrayBlockingQueue<Integer> abq){
		this.abq = abq ;
	}
	public void run(){
		try {
			abq.put(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(1);
		BlockQueueTe bqt1 = new BlockQueueTe(abq);
		BlockQueueTe bqt2 = new BlockQueueTe(abq);
		BlockQueueTe bqt3 = new BlockQueueTe(abq);
		bqt1.start();
		bqt2.start();
		bqt3.start();
	}
}