package labprog;
import java.util.*;

public class MyEx extends Exception
{
	MyEx(String s){
	super(s);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		float res;
		try
		{
			if(b==0)
			{
				throw new MyEx("cannot divide");
			}
			res=a/b;
			System.out.println(res);
		}
		catch(MyEx e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("This is a final block");
		}
	}
}