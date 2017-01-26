package com.technosolution.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.technosolution.model.Menu;
import com.technosolution.model.MenuItem;

public class Utility {

	public static HashMap<Integer, MenuItem> map = new HashMap<>();

	public static List<Integer> getListOfHours(Menu menu) {

		List<Integer> hourList = new ArrayList<>();

		for (MenuItem item : menu.getMenuItems()) {
			hourList.add(item.getTimeRequiredToEat());
		}

		return null;
	}

	public static List<Menu> getListOfSubMenus(Menu mainMenu, int targetHours) {

		int[] arrayOfTimeToEat = getIntArrayOfTimeToEatOfMenu(mainMenu);
		// System.out.println("Initial Array: " + arrayOfTimeToEat);
		// printArray(arrayOfTimeToEat);
		SubsetsRetreiver retriever = new SubsetsRetreiver();
		retriever.setInitialMenu(mainMenu);
		System.out.println("here");
		retriever.printMaximalSubSetsToSum(arrayOfTimeToEat, targetHours);
		return retriever.getFinalMenuList();

	}

	public static int getSatisfactionLevelOfMenu(Menu menu) {

		int output = 0;

		for (MenuItem tempItem : menu.getMenuItems()) {
			output = output + tempItem.getSatisfactionLevel();
		}

		return output;
	}

	public static Menu getMenuWithMaxSatisfaction(List<Menu> menuList) {

		int currentMenuSatisfactionLevel = -1;
		int maxSatisfactionLevelSoFar = -1;
		Menu outputMenu = null;
		for (Menu tempMenu : menuList) {
			currentMenuSatisfactionLevel = getSatisfactionLevelOfMenu(tempMenu);
			System.out.print("Satisfaction Level of set: ");
			tempMenu.printOnlyTime();
			System.out.println(" is: " + currentMenuSatisfactionLevel);
			if (currentMenuSatisfactionLevel > maxSatisfactionLevelSoFar) {
				maxSatisfactionLevelSoFar = currentMenuSatisfactionLevel;
				outputMenu = tempMenu;
			}

		}
		return outputMenu;

	}

	public static MenuItem convertLineToMenuItem(String line, int id) {
		String[] data = line.split(" ");
		return new MenuItem(id, Integer.parseInt(data[0]), Integer.parseInt(data[1]));

	}

	public static MenuItem getItemWithGiveTimeToEat(int timeToEat, Menu menu) {
		for (MenuItem tempItem : menu.getMenuItems()) {
			if (tempItem.getTimeRequiredToEat() == timeToEat)
				return tempItem;
		}
		return null;
	}

	static public int[] getIntArrayOfTimeToEatOfMenu(Menu menu) {
		int[] output = new int[menu.getMenuItems().size()];
		int index = 0;
		for (MenuItem tempMenuItem : menu.getMenuItems()) {
			output[index] = tempMenuItem.getTimeRequiredToEat();
			index++;
		}
		return output;
	}

	static public void printArray(int[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.println("Array element: " + input[i]);
		}
	}

	public static void buildHashMap(Menu menu) {
		for (MenuItem tempMenuItem : menu.getMenuItems()) {
			map.put(tempMenuItem.getItemId(), tempMenuItem);
		}
	}

}
