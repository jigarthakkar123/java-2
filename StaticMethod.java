package com.core;

public class StaticMethod {

	static int a=10;
	static int b;
	{
		System.out.println("Block 1");
		b=a*4;
	}
	static void meth(int x)
	{
		System.out.println("X : "+a);
		System.out.println("A : "+a);
		System.out.println("B : "+b);
	}
	static
	{
		System.out.println("Static Block Initialized");
		
	}
	
	public StaticMethod() {
		System.out.println("Default Constructor");
	}
	{
		System.out.println("Block 2");
	}
	public static void main(String[] args) {
		StaticMethod s=new StaticMethod();
		meth(12);
	}
}
