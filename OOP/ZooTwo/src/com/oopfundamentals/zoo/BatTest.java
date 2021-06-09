package com.oopfundamentals.zoo;

public class BatTest {

	public static void main(String[] args) {
		Bat bat = new Bat();
		
		System.out.print(bat.attackTown(100));
		bat.attackTown(100);
		bat.attackTown(100);
		
		
		bat.eatHumans(25);
		bat.eatHumans(25);
		
		bat.fly(50);
		bat.fly(50);
		

	}

}
