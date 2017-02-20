package com.technosolution.model;

import java.util.ArrayList;
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

	
}
