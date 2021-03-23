/**
	 * This class creates a representation of a course with five fields that
	 * can be added to a database. It also implements Comparable.
	 * 
	 * @author Rowan Barr
	 */
public class CourseDBElement implements Comparable {

	String courseId;
	int CRN;
	int credits;
	String roomNum;
	String teachName;
	
	public CourseDBElement(String ID, int cnum, int cred, String rNum, String tName) {
		courseId = ID;
		CRN = cnum;
		credits = cred;
		roomNum = rNum;
		teachName = tName;
	}
	public CourseDBElement() {
		courseId = "";
		CRN = 0;
		credits = 0;
		roomNum = "";
		teachName = "";
	}
	/**
	 * This compares two CourseDBElements and returns true if they are equal, 
	 * false if they aren't.
	 * 
	 * @param A CourseDBElement
	 * @return A boolean representing if the two elements are equal or not.
	 */
	public boolean compareTo(CourseDBElement e) {
		if (courseId.contentEquals(e.courseId))
			if(CRN==e.CRN)
				if(credits==e.credits)
					if(roomNum.contentEquals(e.roomNum))
						if(teachName.contentEquals(e.teachName))
							return true;
		return false;
	}
	
	/**
	 * This returns the CRN field of a CourseDBElement.
	 * @return int CRN
	 */
	public int getCRN() {
		return CRN;
	}
	/**
	 * This sets the CRN field of a CourseDBElement.
	 * @param int CRN
	 */
	public void setCRN(int i) {
		CRN = i;
		
	}
	/**
	 * This returns the CRN field of a CourseDBElement to be used as a hash code.
	 * @return int CRN
	 */
	public int hashCode()
	{
		return CRN;
	}
	/**
	 * This returns a string representation of a CourseDBElement
	 * @return a string description of a CourseDBElement
	 */
	public String toString()
	{
		String s = "\nCourse:" + courseId + " CRN:" +
	CRN+" Credits:"+ credits+ " Instructor:" +teachName+ " Room:" +roomNum;
		return s;
	}
	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
