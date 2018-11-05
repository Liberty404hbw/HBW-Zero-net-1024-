package hbw;

public class Xun {
	public static int Fun1(int n)
	{
		if(n==0|n==1)
		{
			return 1;
		}
		else
			return n*Fun1(n-1);
		
	}
public static void Fun2(int n)
{
	int i=1;
	int sum=1;
	while(i<n)
	{
		sum=sum*i;
		i++;
	}
	System.out.println("While循环结果："+sum);
	}
public static void Fun3(int n)
{
	int i=1;
	int sump=1;
	for(i=1;i<=n;i++)
	{
		sump=sump*i;
	}
	System.out.println("For循环结果为："+sump);
	}
public static void Fun4(int n)
{
	int i=1;
	int suml=1;
	do
	{
		suml=suml*i;
		i++;
	}
	while(i<=n);
	System.out.println("do-while循环结果为："+suml);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xun x=new Xun();
		
	int n=10;
		x.Fun2(10);
		
		x.Fun3(10);
	
		x.Fun4(10);
		System.out.println("递归实现的结果为："+Fun1(10));
	

	}

}
