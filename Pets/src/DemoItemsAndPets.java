
public class DemoItemsAndPets {

	public static void main(String[] args) 
	{
		PetsSold pit = new PetsSold();
		pit.setDescription("A good looking dog.");
		pit.setPrice(5000);
		pit.setInvoiceNumber(357);
		pit.setHousebroken(false);
		pit.setNeutered(true);
		pit.setVaccinated(true);
		
		System.out.printf("Description: %s\nPrice:%d$\nNumber:%d\nHousebroken:%s\nNeutured:%s\nVaccinated:%s", pit.getDescription(), pit.getPrice(), pit.getInvoiceNumber(), pit.isHousebroken(), pit.isNeutered(), pit.isVaccinated());

	}

}
