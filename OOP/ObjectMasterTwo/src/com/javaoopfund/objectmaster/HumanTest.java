package com.javaoopfund.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human personOne = new Human();
		Human personTwo = new Human();
		System.out.println(personOne.attack(personTwo));
		
		Ninja ninja = new Ninja();
		ninja.steal(personTwo);
		
		Samurai sam = new Samurai();
		Samurai samTwo = new Samurai();
		sam.meditate();
		sam.deathBlow(personTwo);
		System.out.println(Samurai.howMany());
		
		Wizard wizard = new Wizard();
		wizard.heal(personOne);
		wizard.fireball(personOne);
//		
		
	}

}
