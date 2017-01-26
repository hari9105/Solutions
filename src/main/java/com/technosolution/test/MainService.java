package com.technosolution.test;

import java.util.Collections;
import java.util.List;

import com.technosolution.model.Menu;
import com.technosolution.parser.DataParser;
import com.technosolution.util.Utility;

public class MainService {

	public void getMaxSatisfaction() {
		// TODO Auto-generated method stub
		String fileName = "C:\\Users\\Devkant Sharma\\Desktop\\hari\\data.txt";
		DataParser parser = new DataParser();
		Menu mainMenu = parser.readData(fileName);
		Utility.buildHashMap(mainMenu);
		Integer targetTimeToEat = parser.getTargetTimeToEat();
		mainMenu.printMenu();
		System.out.println("Given Target Time To Eat: " + targetTimeToEat);

		System.out.println("After Sorting on the basis of TimeToEat");
		Collections.sort(mainMenu.getMenuItems());

		mainMenu.printMenu();
		List<Menu> setOfMenuUnderTargetTime = Utility.getListOfSubMenus(mainMenu, targetTimeToEat);

		System.out.println("Printing List of Eligible Menus");
		for (Menu tempMenu : setOfMenuUnderTargetTime) {
			tempMenu.printOnlyTime();
			System.out.println();
		}

		Menu menuWithMaxSatisfaction = Utility.getMenuWithMaxSatisfaction(setOfMenuUnderTargetTime);
		//
		System.out.println("Max Satisfaction: " + Utility.getSatisfactionLevelOfMenu(menuWithMaxSatisfaction));
	}

}
