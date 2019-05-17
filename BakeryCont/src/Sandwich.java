import java.util.ArrayList;
public class Sandwich {
	Bread Bread1 = new Bread("White", 150);
	SandwichFilling newSandwich = new SandwichFilling("Mayonaise", 80);
	Bread Bread2 = new Bread("Wheat", 120);

	
	public void teststuff() 
	{
		Bread1.printBread();
		Bread2.printBread();
		newSandwich.printSandwich();
	}


}
