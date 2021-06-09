package com.javaoopfund.objectmaster;

public class Wizard  extends Human{
	public Wizard() {
		this.health = 50;
		this.intelligence = 50;
		
		
	}
	
	public void heal(Human person) {
		person.intelligence += this.intelligence;
		System.out.println(person.intelligence);
	}
	
	public void fireball(Human person) {
		person.health -= (this.intelligence * 3);
		System.out.println(person.health);
		
	}

}
