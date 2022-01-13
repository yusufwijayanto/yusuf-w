package com.juaracoding.shopsqa.driver.strategies;
import javax.swing.SpringLayout.Constraints;

import com.juaracoding.shopsqa.utils.Constants;

public class DriverStrategyImplementor {
	
	public static DriverStrategy chooseStrategy(String strategy) {
		switch (strategy) {
		case Constants.CHROME:
			return new Chrome();
		case Constants.FIREFOX:
			return new Firefox();
		default:
			return null;
		}
	}

}
