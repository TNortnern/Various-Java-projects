import java.util.ArrayList;
import java.util.Scanner;
public class CollegeList {

	public static void main(String[] args) 
	{
		String choice = " ";
		String fName, lName, pNum;
		Scanner ms = new Scanner(System.in);
		ArrayList <Person> collegeList = new ArrayList<Person>();
		

		


		while (!choice.equals("Q")) 
		{
			System.out.println("Enter 'F' for Faculty Member, 'S' for Student, 'C' for College Employee");
			choice = ms.nextLine();
			if (choice.equals("F")) 
			{
				System.out.println("Enter first name: ");
				fName = ms.nextLine();
				System.out.println("Enter last name: ");
				lName = ms.nextLine();
				System.out.println("Enter phone number: ");
				pNum = ms.nextLine();
				Faculty aFac = new Faculty(fName, lName, pNum);
				System.out.println("Enter address: ");
				aFac.setAddress(ms.nextLine());
				System.out.println("Enter zip code: ");
				aFac.setZipCode(ms.nextLine());
				System.out.println("Tenured? Type 'true' or 'false' ");
				aFac.setTenured(ms.nextBoolean());
				ms.nextLine();
				collegeList.add(aFac);
			}
			else if (choice.equals("S"))
			{
				System.out.println("Enter first name: ");
				fName = ms.nextLine();
				System.out.println("Enter last name: ");
				lName = ms.nextLine();
				System.out.println("Enter phone number: ");
				pNum = ms.nextLine();
				Student aStud = new Student(fName, lName, pNum);
				System.out.println("Enter address: ");
				aStud.setAddress(ms.nextLine());
				System.out.println("Enter zip code: ");
				aStud.setZipCode(ms.nextLine());
				System.out.println("Enter Field of Study: ");
				aStud.setStudy(ms.nextLine());
				System.out.println("Enter GPA: ");
				aStud.setGpa(ms.nextDouble());
				ms.nextLine();
				
				collegeList.add(aStud);
			}
			else if (choice.equals("C")) 
			{
				System.out.println("Enter first name: ");
				fName = ms.nextLine();
				System.out.println("Enter last name: ");
				lName = ms.nextLine();
				System.out.println("Enter phone number: ");
				pNum = ms.nextLine();
				CollegeEmployee aEmploy = new CollegeEmployee(fName, lName, pNum);
				System.out.println("Enter address: ");
				aEmploy.setAddress(ms.nextLine());
				System.out.println("Enter zip code: ");
				aEmploy.setZipCode(ms.nextLine());
				System.out.println("Social Security Number: ");
				aEmploy.setSsn(ms.nextLine());
				System.out.println("Department: ");
				aEmploy.setDepartment(ms.nextLine());
				System.out.println("Enter Salary: ");
				aEmploy.setSalary(ms.nextDouble());
				ms.nextLine();
				collegeList.add(aEmploy);
			}
			

		}
		
		for(Person printList: collegeList) 
		{
			printList.printPerson();
		}

	}

}





