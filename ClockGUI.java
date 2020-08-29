package Project4;

import java.awt.TextArea;
import javax.swing.*;

/**
 * 
 * @author nikolabaci
 *
 */
@SuppressWarnings("serial")
public class ClockGUI extends JFrame {
	
	/**
	 * TextAreas are instance variables because if the user
	 * opens several files, then the program only needs to 
	 * re-write the same TextArea's and not create new ones.
	 */
	TextArea notSorted = new TextArea();				//Text area for the unsorted (original) Clocks
	TextArea sorted = new TextArea();					//Text area for the sorted Clocks
	/**
	 * ClockGUI constructor.
	 * Calls the constructor of JFrame.
	 * Sets up the GUI window with the right parameters.
	 * Creates the menu bar which will be passed as a
	 * parameter to the Menus being created.
	 * @param unorderList
	 * @param orderList
	 */
	public ClockGUI() {
		super();
		setSize(500,350);									
		setLocation(200,200);							
		setTitle("Clock Display");
		setDefaultCloseOperation(ClockGUI.EXIT_ON_CLOSE);
		
		JMenuBar bar = new JMenuBar();
		createFileMenu(bar);
		createEditMenu(bar);
		setJMenuBar(bar);
		
	}
	
	public TextArea getTANotsorted() {return notSorted;}
	public TextArea getTASorted() {return sorted;}
	
	/**
	 * The method adds Menus in the JFrame.
	 * Creates the menus, and the menu items.
	 * Also, it handles the events of the menu items.
	 */
	private void createFileMenu(JMenuBar bar){
		JMenu file = new JMenu("File");
		JMenuItem open, quit;
		file.add(open = new JMenuItem("Open"));
		file.add(quit = new JMenuItem("Quit"));
		FileMenuHandler fmh = new FileMenuHandler(this);
		open.addActionListener(fmh);
		quit.addActionListener(fmh);
		bar.add(file);
	}
	
	private void createEditMenu(JMenuBar bar){
		JMenu edit = new JMenu("Edit");
		JMenuItem search;
		edit.add(search = new JMenuItem("Search"));
		EditMenuHandler emh = new EditMenuHandler(this);
		search.addActionListener(emh);
		bar.add(edit);
	}

}//ClockGUI-class
