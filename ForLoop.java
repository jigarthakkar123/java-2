package com.core;

public class ForLoop {

	public static void main(String[] args) {
		int i,j,k;
		for(i=1;i<10;i++)
		{
			for(k=1;k<10-i;k++)
			{
				System.out.print(" ");
			}
			for(j=1;j<=i;j++)
			{
				System.out.print(j);
			}
			for(j=i;j>=1;j--)
			{
				if(i==j)
				{
					continue;
				}
				else
				{
					System.out.print(j);
				}
			}
			System.out.println();
		}
	}
}
