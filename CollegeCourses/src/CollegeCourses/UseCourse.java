package CollegeCourses;
import java.util.Scanner;

public class UseCourse 
{

	public static void main(String[] args) 
	{
		String course;
		int courseNum, credits, fee;
		Scanner pt = new Scanner(System.in);
		System.out.println("Enter your course: ");
		course = pt.next();
		courseNum = pt.nextInt();
		System.out.println("How many credits is this class? ");
		pt.nextLine();
		credits = pt.nextInt();
		LabCourse newC = new LabCourse(course, credits, courseNum);//course, credits, year
		newC.display();
	}

}
