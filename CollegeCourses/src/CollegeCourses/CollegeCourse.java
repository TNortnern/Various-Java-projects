package CollegeCourses;
public class CollegeCourse 
{
	private String course;
	private int courseNum, credits, fee;
	
	public String getCourse() {
		return course;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public int getCredits() {
		return credits;
	}

	public CollegeCourse(String course, int courseNum, int credits) 
	{
		this.course = course;
		this.courseNum = courseNum;
		this.credits = credits;
		fee = 120 * credits;
	}
	
	public int getFee() 
	{
		return fee;
	}
	
	public void display() 
	{
		System.out.printf("The lab course %s %d is a %d credit class and the fee is %d.", course, courseNum, credits, fee);
	}

}
