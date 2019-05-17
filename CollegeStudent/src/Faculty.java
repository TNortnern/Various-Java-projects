
public class Faculty extends Person
{
	protected boolean tenured = true;
	protected Person faculty;
	
	public Faculty(String fName, String lName, String pNumber) 
	{
		super(fName, lName, pNumber);
	}
	
	public void setTenured(boolean tenured) 
	{
		this.tenured = tenured;
	}
	
	public boolean getTenured() 
	{
		return tenured;
	}
	@Override
	public void printPerson()
	{
		System.out.println("*** Falculty Member ****");
		System.out.printf("%s %s, Contact Details:\nPhone Number: %s\nAddress: %s-%s\nTenured:%s\n", fName, lName, pNumber, address, zipCode, tenured);
	}
}
