package com.oopfundamentals.zoo;

public class Bat extends Mammal{
	public Bat() {
		super.setEnergy(300); 
	}
	
	public int fly(int n) {
		super.setEnergy(super.displayEnergy() - n);
		System.out.println("bzzzzzz");
		return super.displayEnergy();
		
	}
	
	public int eatHumans(int n) {
		System.out.println("so- well");
		super.setEnergy(super.displayEnergy() + n);
		return super.displayEnergy();
		
	}
	
	public int attackTown(int n) {
		super.setEnergy(super.displayEnergy() - n);
		return super.displayEnergy();
		
	}

}
