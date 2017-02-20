package com.technosolution.test;

import java.util.List;

import com.technosolution.model.Menu;
import com.technosolution.model.MenuItem;
import com.technosolution.parser.DataParser;

public class MainService {
	
	public void getMaxSatisfaction() {
		// TODO Auto-generated method stub
		String fileName = "C:\\Users\\Devkant Sharma\\Desktop\\hari\\data.txt";
		DataParser parser = new DataParser();
		Menu mainMenu = parser.readData(fileName);
		int menuSize = mainMenu.getMenuItems().size();
		int[] satisfactionLevel = new int[menuSize];
		int[] requiredTimeToEat = new int[menuSize];
		List<MenuItem> items = mainMenu.getMenuItems();
		int i=0,j=0;
		for(MenuItem item : items){
			satisfactionLevel[i]=item.getSatisfactionLevel();
			requiredTimeToEat[j] = item.getTimeRequiredToEat();
			i++;j++;
		}
		
		int val = knapsack(satisfactionLevel,requiredTimeToEat,parser.getTargetTimeToEat(),menuSize);
		
		System.out.println("Maximum Satisfaction Gordon got :-  "+val);
	}
	
	
	 public static int knapsack(int satisfactionLevel[], int requiredTimeToEat[], int targetTimeToEat,int menuSize) {
	        
		 int[][] V = new int[menuSize + 1][targetTimeToEat + 1]; //Create a matrix. Indexes are in rows and timeToEat at in columns +1 on each side
	       
	        for (int index=1;index<=menuSize;index++){
	            //Let's fill the values row by row
	            for (int timeToEat=1;timeToEat<=targetTimeToEat;timeToEat++){
	                //Is the current index timeToEat less than or equal to running timeToEat
	                if (requiredTimeToEat[index-1]<=timeToEat){
	                    //Given a timeToEat, check if the value of the current index + value of the index that we could afford with the remaining timeToEat
	                    //is greater than the value without the current index itself
	                    V[index][timeToEat]=Math.max (satisfactionLevel[index-1]+V[index-1][timeToEat-requiredTimeToEat[index-1]], V[index-1][timeToEat]);
	                }
	                else {
	                    //If the current index's timeToEat is more than the running timeToEat, just carry forward the value without the current index
	                    V[index][timeToEat]=V[index-1][timeToEat];
	                }
	            }
	        }
	       
	        return V[menuSize][targetTimeToEat];
	    }

}
