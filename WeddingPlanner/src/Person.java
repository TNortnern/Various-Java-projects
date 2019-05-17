import java.util.Scanner;
public class Person 
{
	private String fN, lN;
	Scanner pn = new Scanner(System.in);
	
	public Person(String fName, String lName) 
	{
		this.fN = fName;
		this.lN = lName;
	}
		
	public String getfName() 
	{
		return fN;
	}
	
	public String getlName() 
	{
		return lN;
	}
	
	public String getName() 
	{
		return getfName() + "" + getlName();
	}

}
