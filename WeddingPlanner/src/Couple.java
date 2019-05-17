import java.util.Scanner;
public class Couple 
{
	//Person aPerson = new Person();
	private Person bride;
	private Person groom;
	
	
	public Couple(String fName, String lName) 
	{
		bride = new Person(fName, lName);
		groom = new Person(fName, lName);
	}
	public Couple(Person bride, Person groom)
	{
		this.bride = bride;
		this.groom = groom;
	}
	
	
	public void printCouple() 
	{
		System.out.printf("Details of %s and %s Wedding\n ", bride.getName(), groom.getName());
	}
}
