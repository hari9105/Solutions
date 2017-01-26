package com.technosolution.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.technosolution.model.Menu;
import com.technosolution.model.MenuItem;

public class SubsetsRetreiver {

	static Menu initialMenu = null;

	public Menu getInitialMenu() {
		return initialMenu;
	}

	public void setInitialMenu(Menu initialMenu) {
		this.initialMenu = initialMenu;
	}

	public List<Menu> getFinalMenuList() {
		return finalMenuList;
	}

	public void setFinalMenuList(List<Menu> finalMenuList) {
		this.finalMenuList = finalMenuList;
	}

	static List<Menu> finalMenuList = new ArrayList<>();

	public static void printMaximalSubSetsToSum(int[] alphabet, int sum) {

		if (alphabet == null || alphabet.length == 0) {
			return;
		}
		if (alphabet[0] > sum) {
			// no sense to search, since smallest element in array already
			// bigger than sum
			return;
		} else if (alphabet[0] == sum) {
			Set<Integer> subSet = new HashSet<>();
			subSet.add(alphabet[0]);
			printSubset(subSet);
		}
		Set<Integer> subSet = new HashSet<>();
		processMaximalSubSetToSum(alphabet, sum, 0, 0, subSet);
	}

	private static void processMaximalSubSetToSum(int[] alphabet, int sum, int sumSoFar, int startFrom,
			Set<Integer> subSet) {
		if (startFrom >= alphabet.length) {
			if (isMaximalSubSet(alphabet, subSet, sum - sumSoFar)) {
				printSubset(subSet);
			}
			return;
		}
		for (int i = startFrom; i < alphabet.length; i++) {
			int newSum = sumSoFar + alphabet[i];
			if (newSum > sum) {
				if (isMaximalSubSet(alphabet, subSet, sum - sumSoFar)) {
					printSubset(subSet);
				}
				return;
			} else {
				subSet.add(alphabet[i]);
				if (newSum == sum) {
					printSubset(subSet);
				} else {
					processMaximalSubSetToSum(alphabet, sum, newSum, i + 1, subSet);
				}
				subSet.remove(alphabet[i]);
			}
		}
	}

	private static boolean isMaximalSubSet(int[] alphabet, Set<Integer> subSet, int diff) {
		// search first mismatch element between alphabet and current SubSet
		Iterator<Integer> it = subSet.iterator();
		int i = 0;
		while (it.hasNext()) {
			if (it.next() != alphabet[i]) {
				break;
			}
			i++;
		}
		return i >= alphabet.length || alphabet[i] > diff;
	}

	private static void printSubset(Set<Integer> subset) {
		Menu tempMenu = new Menu(subset.size());
		for (Integer tempInteger : subset) {
			MenuItem tempItem = Utility.getItemWithGiveTimeToEat(tempInteger, initialMenu);
			tempMenu.addItem(tempItem);
		}
		System.out.println("subset: " + subset);
		finalMenuList.add(tempMenu);
	}

	// public static void main(String[] args) throws java.lang.Exception {
	// printMaximalSubSetsToSum(new int[] { 1, 2, 2, 3, 4, 5 }, 7);
	// // Correct output is: {1, 2, 3}; {1, 2, 4}; {1, 5}; {2, 5}; {3, 4}
	// }

}
