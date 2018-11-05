package shiyanF;



public class Hbj {
	public static boolean equals(int a[],int b[])
	{
		if(a.length!=b.length )
			return false;
		
			for(int i=0;i<a.length||i<b.length ;i++)
			
				if(a[i]!=b[i])
				
					return false;
			
				return true;		
	}
	public static boolean equals(Object m[],Object n[])
	{
		if(m.length!=m.length)
			return false;
		
			for(int i=0;i<m.length||i<n.length ;i++)
			
				if(m[i]!=n[i])
				
					return false;
			
				return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hbj p=new Hbj();
		int a1[]= {1,2,3};
		int b1[]= {1,2,3};
		System.out.println(p.equals(a1,b1));
		int a2[]= {1,2,5};
		int b2[]= {1,2,9};
		System.out.println(p.equals(a2,b2));
		Object m1[]= {"abcde"};
		Object n1[]= {"abcde"};
		System.out.print(p.equals(m1,n1));
		System.out.println();
		Object m2[]= {"abcde"};
		Object n2[]= {"abcdef"};
		System.out.println(p.equals(m2,n2));

	}
	
	

}
