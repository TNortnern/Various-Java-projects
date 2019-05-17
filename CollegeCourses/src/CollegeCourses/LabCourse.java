package CollegeCourses;
public class LabCourse extends CollegeCourse
{
	private String course;
	private int courseNum, credits, fee;
	
	public LabCourse(String course, int courseNum, int credits) 
	{
		super(course, courseNum, credits);
		this.course = super.getCourse();
		this.courseNum = super.getCourseNum();
		this.credits = super.getCredits();
	}
	
	public int getFee() 
	{
		return super.getFee() + 50;
	}
	
	@Override
	public void display() 
	{
		System.out.printf("The lab course %s %d is a %d credit class and the fee is %d.", course, courseNum, credits, getFee());
	}
}
