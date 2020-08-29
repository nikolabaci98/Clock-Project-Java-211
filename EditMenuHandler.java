package Project4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.regex.*;

/**
 * 
 * @author nikolabaci
 *
 */
public class EditMenuHandler implements ActionListener {
	
	ClockGUI myframe;
	//EditMenuHandler constructor
	EditMenuHandler (ClockGUI clockFrame){			
		myframe = clockFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String editName = ae.getActionCommand();
		
		if(editName.equals("Search")) {
			Pattern pat = Pattern.compile("[0-9]+");	//using Regex to check if input is a number
			Matcher mat;
			String inputHour = JOptionPane.showInputDialog("Enter the hour you are looking for: ");
			mat = pat.matcher(inputHour);
			
			if(!mat.matches())
				JOptionPane.showMessageDialog(null, "Only numbers allowed.");
			else
				searchClock(Integer.parseInt(inputHour));
		}
	}
	
	/**
	 * This method responds to the "Search" menu item in "Edit" menu.
	 * It gets the integer parameter, checks if the input is valid,
	 * then in the for loop prints the similar clocks in the JOptionPane.
	 * 
	 * @param hour
	 */
	public void searchClock(int hour) {
		String listOfClocks = "Similar clocks: \n";
		if(hour >= 0 && hour <=23) {
			Set<Map.Entry<Clock, String>> set = FileMenuHandler.clockTree.entrySet();
			for(Map.Entry<Clock, String> me: set) {
				if(me.getKey().getHour() == hour) {
					listOfClocks += me.getKey().toString();		//toString() has a new line in its return
				}
			}
			JOptionPane.showMessageDialog(null, listOfClocks);
		}
		else 
			JOptionPane.showMessageDialog(null, "Please enter a number from 0 to 23");	
	}
}
