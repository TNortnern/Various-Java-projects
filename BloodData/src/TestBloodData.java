
public class TestBloodData {
	private String bloodType;
	private String rhFactor;
	
	public void setBloodType(String theType)
	{
		bloodType = theType;
	}
	
	public void setRhFactor(String theRh) 
	{
		rhFactor = theRh;
	}
	
	public String getBloodType() 
	{
		return bloodType;
	}
	
	public String getRhFactor() 
	{
		return rhFactor;
	}
	
	public TestBloodData() //Just a placeholder
	{
		
	}
	
	public TestBloodData(String theType, String theRh) 
	{
		bloodType = theType;
		rhFactor = theRh;
	}
}