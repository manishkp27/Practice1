package com.manish;

public class CloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		StudentCln st1 = new StudentCln(new String("manish"),12,"V.I.P");
		StudentCln st2 = st1.clone();
		
		//rule: x.clone() != x
		System.out.println((st1==st2)+" "+(st1.name==st2.name) + " "+st1+ " "+st2);
		
		//rule:x.clone().equals(x)
		System.out.println(st1.equals(st2));//false
				
		System.out.println((st1.department==st2.department) + " "+(st1.department.schoolName==st2.department.schoolName));
		
		//rule:x.clone().getClass() == x.getClass()
		System.out.println(st1.getClass()==st2.getClass());//true, but this is not absolute requirements
		
	}
}

class StudentCln implements Cloneable{
	//By default, java cloning is ‘field by field copy’	
	//1) If the class has only primitive data type members then a completely new copy of the object will be created and the reference to the new object copy will be returned.
	int id;
	//2) If the class contains members of any class type then only the object references to those members are copied and hence the member references in both the original object as well as the cloned object refer to the same object.
	String name;
	Department department;
	StudentCln(String name,	int id,String schoolName){
		System.out.println("StudentCln() constructor is called");
		this.name=name;
		this.id=id;
		this.name=name;
		this.department= new Department(schoolName);
	}
	@Override
	protected StudentCln clone() throws CloneNotSupportedException{
		System.out.println("StudentCln clone() clonning");
		//required for deep copy
		StudentCln studentCln =(StudentCln) super.clone();
		studentCln.department = department.clone(); 
		
		return studentCln;
	}
	@Override
	public String toString(){
		return name+" "+id;
	}
	
}

class Department implements Cloneable{
	String schoolName;
	Department(String schoolName){this.schoolName=schoolName;}
	//required for deep copy
	public Department clone() throws CloneNotSupportedException{
		System.out.println("Department clone() clonning");
		return (Department)super.clone();
	}
}