package com.core;

class Student
{
	int rno;
	String sname;
	public Student() {
		System.out.println("Default Constructor");
	}
	public Student(int rno,String sname) {
		this();
		System.out.println("Para Constructor");
		this.rno=rno;
		this.sname=sname;
	}
	void show(int rno,String sname)
	{
		System.out.println("Roll No : "+rno);
		System.out.println("Student Name : "+sname);
	}
	void display()
	{
		show(this.rno,this.sname);
	}
}

public class thisDemo {

	public static void main(String[] args) {
		Student s1=new Student(1, "Jigar");
		s1.display();
		System.out.println(args[0]);
	}
}
