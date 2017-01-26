package com.technosolution.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.technosolution.model.Menu;
import com.technosolution.model.MenuItem;
import com.technosolution.util.Utility;


public class DataParser {

	int targetTimeToEat = -1;

	public Menu readData(String filePath) {

		Menu mainMenu = null;
		FileInputStream fis = null;
		BufferedReader reader = null;
		int index = 0;
		try {
			fis = new FileInputStream(filePath);
			reader = new BufferedReader(new InputStreamReader(fis));
			String line = reader.readLine();
			while (line != null) {
				MenuItem tempMenuitem = null;
				if (index == 0) {
					String[] firstLineData = line.split(" ");
					int sizeOfMenu = Integer.parseInt(firstLineData[1]);
					mainMenu = new Menu(sizeOfMenu);
					targetTimeToEat = Integer.parseInt(firstLineData[0]);
				} else {
					tempMenuitem = Utility.convertLineToMenuItem(line, index);
					mainMenu.addItem(tempMenuitem);
				}
				index++;
				line = reader.readLine();
			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(DataParser.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(DataParser.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				reader.close();
				fis.close();
			} catch (IOException ex) {
				Logger.getLogger(DataParser.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return mainMenu;
	}

	public int getTargetTimeToEat() {
		return targetTimeToEat;
	}
}
