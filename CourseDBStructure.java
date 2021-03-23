import java.io.IOException;
import java.util.LinkedList;

/**
 * This class creates a hash table out of an array of LinkedLists (to use a 
 * bucket hash technique) and then adds CourseDBElements to it. You can also
 * retrieve a CourseDBElement if you have its CRN, or retrieve the size of the
 * table.
 * 
 * @author Rowan Barr
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	public LinkedList[] hashTable;

	public CourseDBStructure(int i) {
		hashTable = new LinkedList[i];
	}

	public CourseDBStructure(String string, int i) {
		hashTable = new LinkedList[i];
	}
	/**
	 * This adds a CourseDBElement to the hash table at a specific position according
	 * to the remainder of the course registration number divided by the hash table length.
	 * If there isn't a LinkedList at that position already, the method creates one,
	 * then adds the CourseDBElement to that new list, otherwise it just adds it
	 * to the existing list.
	 * @param A CourseDBElement
	 */
	public void add(CourseDBElement e) {
		int crn = e.getCRN();
		int hash = crn%hashTable.length;
		if (hashTable[hash]==null)
		{
			LinkedList<CourseDBElement> list = new LinkedList();
			list.add(e);
			hashTable[hash] = list;
		}
		else
		{
			hashTable[hash].add(e);
		}
	}
	/**
	 * This searches the hash table for the right LinkedList based on a hash 
	 * created from the course registration number in the same way as add.
	 * If the table doesn't have a LinkedList at the hash location, it throws
	 * an IOException. If it does, it searches the list for a CourseDBElement 
	 * with the crn provided as a parameter, and returns it if it finds it.
	 * If it doesn't, it throws a IOException.
	 * @param int crn
	 * @return A CourseDBElement with the crn from the parameter
	 */
	public CourseDBElement get(int crn) throws IOException {
		int hash = crn%hashTable.length;
		if (hashTable[hash]==null)
		{
			throw new IOException("Data does not exist!");
		}
		else
		{
			LinkedList<CourseDBElement> listCopy = hashTable[hash];
			for (int i = 0; i < listCopy.size();i++)
			{
				if (listCopy.get(i).getCRN() == crn)
				{
					return listCopy.get(i);
				}
			}
			throw new IOException("Data does not exist!");
		}
	}
	/**
	 * This returns the size of the hash table created by the constructor.
	 * @return int hashTable.length
	 */
	
	public int getTableSize() {
		return hashTable.length;
	}

}
