package com.javaoopfund.objectmaster;

public class Samurai extends Human{
	public static int numberOfSamurai = 0;
	public Samurai() {
		this.health = 200;
		numberOfSamurai++;
		
	}
	
	public void deathBlow(Human person) {
		this.health= this.health / 2;
		person.health = 0;
		System.out.println("Samurai health: " + this.health);
		System.out.println("Human health: "+ person.health);
	}
	
	public void meditate() {
		this.health += this.health /2;
		System.out.println(this.health);
	}
	
	public static int howMany() {
		return numberOfSamurai;
		
	}
}
