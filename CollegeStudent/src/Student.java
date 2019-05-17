
public class Student extends Person
{
	protected String study;
	protected double gpa;
	public String getStudy() {
		return study;
	}
	public void setStudy(String study) {
		this.study = study;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public Student(String fName, String lName, String pNumber) 
	{
		super(fName, lName, pNumber);
	}
	
	@Override
	public void printPerson() 
	{
		System.out.println("*** Student ***");
		System.out.printf("%s %s, Contact Details:\nPhone Number: %s\nAddress: %s-%s\nField of Study:%s\nGPA:%.2f\n", fName, lName, pNumber, address, zipCode, study, gpa);
	}
}
	
