
public class SandwichFilling 
{
	
	
    String SandwichType;
    int calories;
    
    public SandwichFilling() 
    {
    	
    }

	public SandwichFilling (String SandwichType, int calories)
    {
        this.SandwichType = SandwichType;
        this.calories = calories;
    }
	
	public void setSandwichType(String SandwichType) 
	{
		this.SandwichType = SandwichType;
	}
	
	public void setCalroies(int calories) 
	{
		this.calories = calories;
	}
	
	
	public String getSandwichType() 
	{
		return SandwichType;
	}
	
	public int getCalories() 
	{
		return calories;
	}
	
    public void printSandwich()
    {
        System.out.println(SandwichType + ": " + calories + " calories.");
    }

}
