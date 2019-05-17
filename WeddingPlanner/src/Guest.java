import java.time.LocalDate;

public class Guest 
{
	private Person guest;
	private String weddingLocation;
	private LocalDate date;
	
	public Guest(String fName, String lName) 
	{
		guest = new Person(fName, lName);
	}
	public Guest(String location) 
	{
		this.weddingLocation = location;
	}
	public Guest(Person guest) 
	{
		this.guest = guest;
	}
	
	public String getName() 
	{
		return guest.getName();	
	}
	
	public void setWeddingLocation(String WeddingLocation) 
	{
		weddingLocation = WeddingLocation;
	}
	public String getWeddingLocation() 
	{
		return weddingLocation;
	}
	public void printLocation() 
	{
		System.out.println(weddingLocation);
	}
	public LocalDate getTodaysDate() 
	{
		LocalDate date = LocalDate.now();
		return date;
	}
	
}
