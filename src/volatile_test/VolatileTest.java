package volatile_test;


public class VolatileTest  extends Thread{
	volatile boolean flag = false;
	public void run(){
		while( !flag){
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " sleep : " + flag);
			} catch (InterruptedException e) {
				
			}
		}
	}
	public void change(){
		flag = true ;
	}
	
	public static void main(String[] args) {
		VolatileTest t1 = new VolatileTest();
		VolatileTest t2 = new VolatileTest();
		
		t1.start();
		
		t2.start();
		t2.change();
	}
}