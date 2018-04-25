import java.util.Date;
public class Multithreading implements Runnable
{
	int startCount;
	static long total;
	String name;
	Thread t;
	
	public Multithreading(String name, int startCount)
	{
		this.name 		= name;
		this.startCount = startCount;
		t = new Thread(this, name);
		t.start();
	}
	
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + " running ...");
		long sum = 0;
		for(int i = startCount; i < startCount +10; i++)
			sum += i;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Sum of " + startCount + " to " + startCount+10 + " = " + sum);
		total += sum;		
	}
	
	
	public static void main(String[] args) 
	{
		int startCount = 1;
		Multithreading ob[] = new Multithreading[5];
		
		Date start = new Date();
		for(int i = 0; i < 5; i++)
		{
			String tName = "Thread_" + i;			
			ob[i] = new Multithreading(tName, startCount);
			startCount += 10;
		}
		
		try{
			for(int i = 0; i < 5; i++)
				ob[i].t.join();
			}
		catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		System.out.println("Total = " + total);
		Date end = new Date();
		
		long diff = end.getTime() - start.getTime();
		System.out.println("Computation time : " + diff + "ms");	
	}
}
