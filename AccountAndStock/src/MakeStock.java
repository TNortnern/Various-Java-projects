
public class MakeStock 
{
    public static void main(String[] args) 
	{
	}
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	public double getChangePercentage()
	{
		return ((currentPrice - previousClosingPrice)/currentPrice)*100;
	}
	
	public void printCompany() 
	{
		System.out.printf("%s %s\nOriginal Price: %.2f\nCurrent Price: %.2f\n", symbol, name, previousClosingPrice, currentPrice);
	}
	

	
	public void printPercentageChange() 
	{
		System.out.printf("Percentage Change: %.2f%%", getChangePercentage());
	}
	
}
