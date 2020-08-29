package Project4;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;


import javax.swing.*;

/**
 * MyEventHandler is the class that handles the events
 * that happen in the menu.
 * The "Quit" event terminates the program.
 * The "Open" event: activates the "Open" window, chooses the file,
 * uses the file to read the clock objects, displays the sorted/unsorted clock objects
 * 
 * @author nikolabaci
 *
 */
public class FileMenuHandler implements ActionListener{
	
	ClockGUI myframe;
	public static TreeMap<Clock, String> clockTree = new TreeMap<Clock, String>(new ClockComparator());
	
	//MyEventHandler constructor
	FileMenuHandler (ClockGUI clockFrame){			
		myframe = clockFrame;
		Container field = myframe.getContentPane();			//put the content pane of the object to 'field' container
		field.add(myframe.getTANotsorted());				//add the text area in the pane
		field.add(myframe.getTASorted());
		myframe.setLayout(new GridLayout(1,2));				//separate the pane into one row and two columns
		
	}
	
	//the method implemented from ActionListener
	public void actionPerformed(ActionEvent ae) {	
		String eventName = ae.getActionCommand();
		
		if(eventName.equals("Open")) {	//which one will be clicked by the user open or quit
			openFile();
		}
		else if(eventName.equals( "Quit")) {
			System.exit(0);
		}
	}
	/**
	 * This method enables the user to choose a file.
	 * Calls readSource().
	 */
	private void openFile()	{
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		if(chooser.getSelectedFile() != null)
			readSource(chooser.getSelectedFile());
	}
	
	/**
	 * Reads the name of the file. Calls readClock() and display() methods.
	 * @param chosenFile the file chosen by the user in openFile().
	 */
	private void readSource(File chosenFile) {
		String chosenFileName = chosenFile.getAbsolutePath();
		TextFileInput br = new TextFileInput(chosenFileName);		//Used to read the lines of the "input.txt" file
		readClock(br);
		
	}
	
	/**
	 * Reads the lines of the text given as an argument. Using StringTokenizer, 
	 * readClock creates a Clock object and initializes its variables.
	 * Finally, it calls the respective add() method of UnsortedClockList and
	 * SortedClockList
	 * @param unorderList 
	 * @param orderList
	 * @param line
	 */
	public void readClock(TextFileInput line){
		
		myframe.getTANotsorted().setText(null);		//remove previous text
		myframe.getTASorted().setText(null);
		clockTree.clear();							//removes the data from previous usage, in case user Opens another file
		
		myframe.getTANotsorted().append("List of not sorted times:\n\n");	//display message in the selected text area
		myframe.getTASorted().append("List of sorted times:\n\n");
		
		
		
		StringTokenizer tokens;		//array of tokens
		String fileLine;			//will store the line form readLine()
		int tempHour = 0;			//used to temporary save the clock numbers
		int tempMin = 0;			//that are used in the Clock(int, int, int)
		int tempSec = 0;			
		
		while((fileLine = line.readLine()) != null) {	
			
			tokens = new StringTokenizer(fileLine, ":");		//store the tokens that are separated by :
			
			if(tokens.countTokens() != 3) {
				System.out.println("Incomplete time: " + '\t' +fileLine);					//print in the console if invalid token
			}
			else {
				try {
					tempHour = Integer.parseInt(tokens.nextToken());		//parse the first token to an integer (hour)
					tempMin = Integer.parseInt(tokens.nextToken());			//parse the second token to an integer (minute)
					tempSec = Integer.parseInt(tokens.nextToken());			//parse the third token to an integer (second)
					
					Clock clock = new Clock(tempHour, tempMin, tempSec);	//The constructor might throw an exception
				
					clockTree.put(clock, fileLine);		//add Clock to the ordered list
					myframe.getTANotsorted().append(clock.toString());
				} catch (IllegalClockException e) {			//catch the exception thrown by constructor
					System.out.println(e.getMessage());		//display exception message
				}
			}
		}
		
		Set<Map.Entry<Clock, String>> set = clockTree.entrySet();
		for(Map.Entry<Clock, String> me : set) {
		 myframe.getTASorted().append(me.getValue()+'\n');
		}
	
		myframe.setVisible(true);	//show content
		
	}
	
}
