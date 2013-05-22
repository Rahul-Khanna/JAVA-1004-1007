
/**
 * A Class that is the hard-coded Administrator 
 * @author R_K
 */
public class Admin {
	/**
	 * The admin ID
	 */
	private int adminID;
	/**
	 * The admin password
	 */
	private String password;
	/**
	 * Constructs an Admin object, which has a hard coded ID and password
	 */
	public Admin()
	{
		adminID= 112358; //Fibonacci's sequence under 10
		password= "helloWorld"; 
	}
	/**
	 * Returns the adminID
	 * @return the adminID
	 */
	public int getAdminID()
	{
		return adminID;
	}
	/**
	 * Returns the Admin's password
	 * @return the Admin's password
	 */
	public String getAdminPassword()
	{
		return password;
	}

}
