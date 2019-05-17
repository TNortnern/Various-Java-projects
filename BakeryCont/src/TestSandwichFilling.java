
public class TestSandwichFilling 
{
	SandwichFilling cd = new SandwichFilling();
	SandwichFilling Sandwich1 = new SandwichFilling("Egg Salad", 250);
	SandwichFilling Sandwich2 = new SandwichFilling("Good Sandwich", 350);
	
	public void printMoreSandwiches() 
	{
		cd.setSandwichType("Buffalo");
		cd.setCalroies(500);
		Sandwich1.printSandwich();
		Sandwich2.printSandwich();
		cd.printSandwich();
	}

}
