package labprog;
public class MyRunnable implements Runnable{
	private String message;
	public MyRunnable(String message)
	{
		this.message=message;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
			System.out.println(message);
		}
		try {
			Thread.sleep(100);
		}
		catch(InterruptedException e) {
			System.out.println("Thread interrupted");
		}
	}
	public static void main(String[] args)
	{
		MyRunnable run1=new MyRunnable("This is thread 1");
		MyRunnable run2=new MyRunnable("This is thread 2");
		
		Thread thread1=new Thread(run1);
		Thread thread2=new Thread(run2);
		
		thread1.start();
		thread2.start();
	}
}

































//public class MyRunnable implements Runnable {
//	
//	private String message;
//	public MyRunnable(String message) {
//		this.message=message;
//	}
//	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		for(int i=0;i<10;i++)
//		{
//			System.out.println(message);
//		}
//		try {
//			Thread.sleep(100);
//		}
//		catch(InterruptedException e)
//		{
//			System.out.println("Thread interrupted!");
//		}
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		MyRunnable run1=new MyRunnable("Hello From Thread 1!");
//		MyRunnable run2=new MyRunnable("Hello From Thread 2!");
//		
//		Thread thread1=new Thread(run1);
//		Thread thread2=new Thread(run2);
//		thread1.start();
//		thread2.start();
//	}
//
//	
//
//}
