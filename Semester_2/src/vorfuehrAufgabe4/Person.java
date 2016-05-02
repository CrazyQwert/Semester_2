package vorfuehrAufgabe4;

public class Person {
	
	private String name;
	private int age;
	private boolean kid;
	
	//constructor(s)
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(String name, int age) {
		this(name);
		this.age = age;
		if (age < 18) {
			this.kid = true;
		}
	}
	
	//getter and setter
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setKid(boolean kid) {
		this.kid = kid;
	}
	
	public boolean isKid() {
		return this.kid;
	}

}
