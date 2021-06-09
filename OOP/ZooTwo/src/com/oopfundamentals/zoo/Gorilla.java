package com.oopfundamentals.zoo;

public class Gorilla extends Mammal{
	public Gorilla() {
	}

	public void throwSomething(int n) {
		System.out.println("Gorilla throw something!!!");
		super.setEnergy(super.displayEnergy() - n);
	
	}
	
	public void eatBananas(int n) {
		System.out.println("Gorilla eats banana :)");
		super.setEnergy(super.displayEnergy() + n);
		
	}
	
	public void climb(int n) {
		System.out.println("Gorilla has climbed a tree");
		super.setEnergy(super.displayEnergy() - n);
	}
	}
