package com.technosolution.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {

	List<MenuItem> menuItems;

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public Menu(int size) {
		menuItems = new ArrayList<>(size);

	}

	public void addItem(MenuItem item) {
		menuItems.add(item);
	}

	public void sortMenuBasedOnTimeToEat() {
		Collections.sort(menuItems);// (menuItems);
	}

	public void printMenu() {
		for (MenuItem item : menuItems) {

			System.out.println("item id: " + item.getItemId() + " TimeReq: " + item.getTimeRequiredToEat()
					+ " Satisfaction: " + item.getSatisfactionLevel());
		}
	}

	public void printOnlyTime() {
		int totalTime = 0;
		System.out.print("[");
		int indexForPrintingCommas = 0;
		for (MenuItem item : menuItems) {
			System.out.print(item.getTimeRequiredToEat());
			totalTime+=item.getTimeRequiredToEat();
			if (indexForPrintingCommas < menuItems.size() - 1) {
				System.out.print(", ");
			}
			indexForPrintingCommas++;
		}
		System.out.print("] = " + totalTime);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// return super.equals(obj);
		Menu comparingTo = (Menu) obj;
		Collections.sort(comparingTo.menuItems);
		Collections.sort(this.menuItems);
		try {
			for (int i = 0; i < comparingTo.menuItems.size(); i++) {
				if (comparingTo.menuItems.get(i) != this.menuItems.get(i))
					return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
