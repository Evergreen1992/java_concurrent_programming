package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExam {
	public void lock(){
		Lock lock = new ReentrantLock();
		lock.lock();
		try{
			
		}finally{
			lock.unlock();
		}
	}

	public static void main(String[] args) {
	}
}