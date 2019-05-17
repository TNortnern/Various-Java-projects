
public class PetsSold extends ItemSold
{
	private boolean vaccinated = true, neutered = false, housebroken = false;

	public boolean isVaccinated() {
		return vaccinated;
	}

	public boolean isNeutered() {
		return neutered;
	}

	public boolean isHousebroken() {
		return housebroken;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	public void setNeutered(boolean neutered) {
		this.neutered = neutered;
	}

	public void setHousebroken(boolean housebroken) {
		this.housebroken = housebroken;
	}
}
