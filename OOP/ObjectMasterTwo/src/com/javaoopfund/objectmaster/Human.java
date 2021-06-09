package com.javaoopfund.objectmaster;

public class Human {
	protected int strength;
	protected int stealth;
	protected int intelligence;
	protected int health;
	
	public Human() {
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 3;
		this.health = 100;
	}
	
	
	
	public int attack(Human person){
		person.health -= this.strength;
		return person.health;
		
	}
}
