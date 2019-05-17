
public abstract class Person 
{
	protected String fName, lName, address, zipCode, pNumber;


	public Person(String fName, String lName, String pNumber) 
	{
		this.fName = fName;
		this.lName = lName;
		this.pNumber = pNumber;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getpNumber() {
		return pNumber;
	}
	
	abstract void printPerson();
}
