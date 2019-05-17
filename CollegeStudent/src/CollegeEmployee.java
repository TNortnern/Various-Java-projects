
public class CollegeEmployee extends Person
{
	protected double salary;
	protected String ssn, department;
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public CollegeEmployee(String fName, String lName, String pNumber) 
	{
		super(fName, lName, pNumber);
	}
	
	@Override
	public void printPerson() 
	{
		System.out.println("*** College Employee ***");
		System.out.printf("%s %s, Contact Details:\nPhone Number: %s\nAddress: %s-%s\nSocial Security Number:%s\nDepartment:%s\nSalary:$%.2f\n", fName, lName, pNumber, address, zipCode, ssn, department, salary);
	}
}







