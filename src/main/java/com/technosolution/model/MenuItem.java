package com.technosolution.model;

public class MenuItem implements Comparable<MenuItem> {

	int itemId;
	int satisfactionLevel;
	int timeRequiredToEat;

	public MenuItem(int itemId, int satisfactionLevel, int timeToEat) {
		// super();
		this.itemId = itemId;
		this.satisfactionLevel = satisfactionLevel;
		this.timeRequiredToEat = timeToEat;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	@Override
	public int compareTo(MenuItem o) {
		// TODO Auto-generated method stub
		if (o.getTimeRequiredToEat() < this.timeRequiredToEat)
			return 1;
		else if (o.getTimeRequiredToEat() == this.timeRequiredToEat)
			return 0;
		else
			return -1;
	}

}
