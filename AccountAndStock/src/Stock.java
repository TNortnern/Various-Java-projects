
public class Stock {

	public static void main(String[] args) 
	{
		MakeStock Obj = new MakeStock();
		Obj.symbol = "ORCL";
		Obj.name = "Oracle Corporation";
		Obj.previousClosingPrice = 34.5;
		Obj.currentPrice = 34.35;
		Obj.printCompany();
		Obj.printPercentageChange();

	}

}
