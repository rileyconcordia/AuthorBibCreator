//------------------------------------------------------------------------
//Written by: Kwok Ho, Chan 40091211 | Lang Zhu 27890575
//COMP249
//Assignment 3
//Question 1
//Due Date: March 17, 2019
//------------------------------------------------------------------------
/**
 * 
 * @author riley
 *
 */
public class FileExistsException extends Exception{
	
	/**
	 * default constructor
	 */
	public FileExistsException() {
		super("Exception: There is already an existing file for that author. File will be renamed as BU, and older BU files will be deleted!\n");
	}
	
	/**
	 * parameterized constructor
	 * @param s
	 */
	public FileExistsException(String s) {
		super(s);
	}
	
	/**
	 * return the message for exception
	 */
	public String getMessage() {
		return super.getMessage();
	}

}
