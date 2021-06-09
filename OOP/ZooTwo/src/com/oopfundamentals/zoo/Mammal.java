package com.oopfundamentals.zoo;

public class Mammal {
	private int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int displayEnergy() {
//		System.out.println(this.energyLevel);
		return this.energyLevel;
		}
	public void setEnergy(int en) {
		this.energyLevel = en;
	}
	}
