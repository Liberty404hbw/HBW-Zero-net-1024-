package hbw;
class Fun1 implements Average


{
	public double avg(double [] arr)
	{
		double sum=0.0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		return sum/(double)arr.length;
	}

	@Override
	public double avg(double[] arr, double[] a) {
		// TODO Auto-generated method stub
		return 0;
	}
}
class Fun2 implements Average
{
	public double avg(double [] arr)
	{
	double tem=0.0;
	double sum=0.0;
	for(int i=1;i<arr.length;i++)
	{
		if(arr[i-1]>arr[i])
		{
			tem=arr[i-1];
			arr[i-1]=arr[i];
			arr[i]=tem;
		}
		sum+=arr[i-1];
	}
	sum-=arr[0];
	return sum/((double)arr.length-2);
	}

	@Override
	public double avg(double[] arr, double[] a) {
		// TODO Auto-generated method stub
		return 0;
	}

}

 class Fun3 implements Average
{
	public double avg(double [] arr,double [] a)
	{
		
		double sum=0.0;
		for(int i=0;i<arr.length ;i++)
		
			sum+=arr[i]*a[i];
		return sum/(double)arr.length;
	}

	@Override
	public double avg(double[] arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	}
	
	

		
	
		
		

	



public class Favg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [] arr= {78.2,90.5,67.7,89.4,99.0,89.0};
		double [] arr1= {78.2,90.5,67.7,89.4,99.0,52.0};
		double [] arr2={78.2,90.5,67.7,89.4,99.0,52.0};
		double [] a={0.3,0.5,0.7,0.9,0.52,0.6};
		Average average=new Fun1();
		double result=average.avg(arr);
		System.out.println("全体平均分="+result);
		Average average1=new Fun2();
		double resultl=average1.avg(arr1);
		System.out.println("去掉最高、最低分后的平均分："+resultl);
		Average average2=new Fun3();
		double result2=average2.avg(arr2, a);
		System.out.println("加权平均分："+result2);
	}

}
