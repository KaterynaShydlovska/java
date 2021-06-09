package com.javaoopfund.objectmaster;

public class Ninja extends Human{
	public Ninja() {
		this.stealth=10;
	}
	
	public void steal(Human person) {
		System.out.println("here ");
		
		this.health+=this.stealth;
		person.health -= this.stealth;
		System.out.println("Ninjas health: "+ this.health);
		System.out.println("Human health: "+ person.health);
	}
	
	public void runAway() {
		this.health -= 10;
		System.out.println("Ninjas health: "+ this.health);
	}

}
