package com.technosolution.model;

public class MenuItem {

	int satisfactionLevel;
	int timeRequiredToEat;

	public MenuItem(int satisfactionLevel, int timeToEat) {
		this.satisfactionLevel = satisfactionLevel;
		this.timeRequiredToEat = timeToEat;
	}


	public int getSatisfactionLevel() {
		return satisfactionLevel;
	}

	public void setSatisfactionLevel(int satisfactionLevel) {
		this.satisfactionLevel = satisfactionLevel;
	}

	public int getTimeRequiredToEat() {
		return timeRequiredToEat;
	}

	public void setTimeRequiredToEat(int timeToEat) {
		this.timeRequiredToEat = timeToEat;
	}

}
