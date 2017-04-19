package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {
	static Map<String, Object> map = new HashMap<String, Object>();
	static ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
	static Lock r = rw.readLock();
	static Lock w = rw.writeLock();
	
	public static final Object get(String key){
		r.lock();
		try{
			return map.get(key);
		}finally{
			r.unlock();
		}
	}
	public static final Object put(String key, Object value){
		w.lock();
		try{
			return map.put(key, value);
		}finally{
			w.unlock();
		}
	}
	public static final void clear(){
		w.lock();
		try{
			map.clear();
		}finally{
			w.unlock();
		}
	}
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}