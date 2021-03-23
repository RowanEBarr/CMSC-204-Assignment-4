import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * This is the level above the CourseDBStructure, which interacts with the GUI.
 * It allows either information typed into the text fields, or read from a file,
 * to be added and retrieved from a CourseDBStructure hash table.
 * It also implements the CourseDBManagerInterface.
 * 
 * @author Rowan Barr
 */
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBElement cde;
	CourseDBStructure cds = new CourseDBStructure(500);
	ArrayList<String> showAllList;
	
	/**
	 * This takes in five fields of a CourseDBElement, creates a new CourseDBElement,
	 * then adds it to a CourseDBStructure using the add function of the 
	 * CourseDBStructure.
	 * @param String id, int crn, int credits, String roomNum, String instructor
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		cde = new CourseDBElement(id,crn,credits,roomNum,instructor);
		cds.add(cde);
	}
	/**
	 * This takes in a course registration number and searches the hash table
	 * for a course with that CRN, then returns that course as a 
	 * CourseDBElement. If no such course is found, an IOException
	 * is handled in the method.
	 * @param int crn
	 * @return The CourseDBElement with that CRN
	 */
	public CourseDBElement get(int crn) {
		CourseDBElement cdbe = new CourseDBElement();
		try
		{
			cdbe = cds.get(crn);
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return cdbe;
	}
	/**
	 * This reads a file for the five elements of a CourseDBElement line by line,
	 * then creates new CourseDBElements and adds them to the hashtable using
	 * the add function of the CourseDBStructure.
	 * @param a text file with course information.
	 */
	public void readFile(File input) throws FileNotFoundException { 
		String[] fileLines = new String[20];	
		Scanner sc;
		Scanner sc2;
		if (input!=null) {
			sc = new Scanner(input);
			sc2 = new Scanner(input);
		}
		else
		{
			throw new FileNotFoundException();
		}
		int i = 0;
		int size = 0;
		while (sc2.hasNextLine())
		{
			size++;
			sc2.nextLine();
		}
		while (i<size)
		{
			fileLines[i] = sc.nextLine();
			
			i++;
		}
		int j = 0;
		int k = 0;
		CourseDBElement[] cdbInput = new CourseDBElement[20];
		String[] splitLines;
		while(fileLines[j]!=null)
		{
			splitLines = fileLines[j].split(" ");
			splitLines[4]= splitLines[4]+ " " + splitLines[5];
			if (splitLines.length>6)
			{
				splitLines[4]=splitLines[4]+ " " + splitLines[6];
			}
			if (splitLines.length>7)
			{
				splitLines[4]=splitLines[4]+ " " + splitLines[7];
			}
			cdbInput[j] = new CourseDBElement(splitLines[0],Integer.parseInt(splitLines[1]),Integer.parseInt(splitLines[2]),splitLines[3],splitLines[4]);
			cds.add(cdbInput[j]);
			j++;
		}
		
	}

	/**
	 * This gets a string version of every CourseDBElement in the hash table, 
	 * adds them to a String ArrayList, and then returns that ArrayList to
	 * the GUI, to be displayed using an alert.
	 * @return An ArrayList<String> of all the CourseDBElements in the hash table
	 */
	public ArrayList<String> showAll() {
		showAllList = new ArrayList<String>();
		LinkedList<CourseDBElement> listCopy = new LinkedList<CourseDBElement>();
		for (int i = 0; i<cds.getTableSize();i++)
		{
			if (cds.hashTable[i]!=null) 
			{
				listCopy = cds.hashTable[i];
				
				for (int j = 0; j < listCopy.size(); j++)
				{
					showAllList.add(listCopy.get(j).toString());
				}
			} 
			
			
		}
		return showAllList;
			
	}

}
