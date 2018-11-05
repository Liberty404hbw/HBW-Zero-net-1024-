package shiyanF;

import java.util.Scanner;

public class TT3 {
	public static int[][]returnTT3(int n)
	{
		int tt3[][]=new int[n][n];
		int count=1;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				tt3[i][j]=count++;
				
			}
		}
		return tt3;
	}
			public static int[][]reverseTT3(int[][] tt3)
			{
				int len=tt3.length;
				for(int i=0;i<len;i++)
				{
					for(int j=0;j<=i;j++)
					{
						int temp=tt3[i][j];
						tt3[i][j]=tt3[j][i];
						tt3[j][i]=temp;
					}
				}
				return tt3;
			}

			public static void printTT3(int[][] tt3)
			{
				int row=tt3.length;
				for(int i=0;i<row;i++)
				{
					for(int j=0;j<tt3[i].length;j++)
					{
						System.out.print(tt3[i][j]+"");
					}
					System.out.println("");
				}
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("输入矩阵的志：");
		Scanner st=new Scanner(System.in);
		int input=st.nextInt();
		int originaTT3[][]=returnTT3(input);
		System.out.println("原来的矩阵：");
		printTT3(originaTT3);
		int finalTT3[][]=reverseTT3(originaTT3);
		System.out.println("与原来下表和相等的矩阵：");
		printTT3(finalTT3);

	}

}
