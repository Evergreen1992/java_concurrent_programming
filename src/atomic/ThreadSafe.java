package atomic;

import java.util.concurrent.atomic.AtomicLong;

public class ThreadSafe {
	private final AtomicLong count = new AtomicLong(0);
	
	public long getCoung(){
		return count.get();
	}
	
	public void service(){
		long current = count.incrementAndGet();
		System.out.println("current : " + current);
	}
	
	public static void main(String[] args) {
		ThreadSafe t = new ThreadSafe();
		for( int i = 0 ; i < 5; i ++){
			t.service();
			
		}
	}

}
