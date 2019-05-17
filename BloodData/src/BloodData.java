
public class BloodData {

	public static void main(String[] args) {
		TestBloodData tbd = new TestBloodData();
		System.out.println("Show the default has been initialized:");
		tbd.setBloodType("O");
		tbd.setRhFactor("+");
		System.out.println("Default Blood Type: " + tbd.getBloodType());
		System.out.println("Default RH Type: " + tbd.getRhFactor());
		System.out.printf("********************");
		System.out.println("Second Test: change the fields"); 
		tbd.setBloodType("A");
		tbd.setRhFactor("-");
		System.out.println("New Blood Type: " + tbd.getBloodType());
		System.out.println("New RH Type: " + tbd.getRhFactor());
		System.out.printf("**************");
		System.out.println("Third Test: Use overloaded constructor");
		TestBloodData tbd2 = new TestBloodData("AB", "+");
		System.out.printf("Blood type: %s\nRHFactor: %s", tbd2.getBloodType(),tbd2.getRhFactor());
	}

}
