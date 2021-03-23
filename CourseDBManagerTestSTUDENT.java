import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 * @author Rowan Barr
 *
 */
public class CourseDBManagerTestSTUDENT {

	private CourseDBManager cdm = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		cdm = new CourseDBManager();
	}

	/**
	 * Set cdm reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		cdm = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			cdm.add("ART100",11111,2,"CEM450","Molly Golly");
			System.out.println(cdm.get(11111));
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		cdm.add("POLI101",22222,3,"KI250","Joe Moe");
		cdm.add("BIO202",44444,4,"SC150","Jill Mill");
		cdm.add("ENG102",33333,3,"MK400","Bill Dill");
		ArrayList<String> list = cdm.showAll();
		
		assertEquals(list.get(0),"\nCourse:POLI101 CRN:22222 Credits:3 Instructor:Joe Moe Room:KI250");
		assertEquals(list.get(1),"\nCourse:ENG102 CRN:33333 Credits:3 Instructor:Bill Dill Room:MK400");
		assertEquals(list.get(2),"\nCourse:BIO202 CRN:44444 Credits:4 Instructor:Jill Mill Room:SC150");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("MATH140 30504 4 SC450 Joey Arkansas");
			inFile.print("ENG208 30503 4 SC450 Jill B. Mine");
			
			inFile.close();
			cdm.readFile(inputFile);
			System.out.println(cdm.showAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


