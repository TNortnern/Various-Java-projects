import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Wedding {

	public static void main(String[] args) 
	{
		Scanner pn = new Scanner(System.in);
		String location = " ";
		Guest newLocation = new Guest(location);
		System.out.println("What's the Bride's name? ");
		Person bride = new Person(pn.next(), pn.next());
		System.out.println("What's the Groom's name? ");
		Person groom = new Person(pn.next(), pn.next());
		System.out.println("Date of the wedding: ");
		LocalDate WeddingDate = LocalDate.of(pn.nextInt(), pn.nextInt(), pn.nextInt()); //year, month, day
		System.out.println("What is the location? ");
		pn.nextLine();
		newLocation.setWeddingLocation(pn.next());
		Couple aCouple = new Couple(bride, groom);
		System.out.printf("Details of %s %s and %s %s Wedding ", bride.getfName(), bride.getlName(), groom.getfName(), groom.getlName());System.out.println("");
		System.out.println("The wedding will be held at " + newLocation.getWeddingLocation());
		System.out.println(WeddingDate);
		String guestCheck = " ";
		ArrayList<Guest> theGuest = new ArrayList<Guest>();
		while (!guestCheck.equals("quit")) 
		{
			System.out.println("Guest Name: [enter 'quit' to stop] ");
			Person guest = new Person(pn.next(), pn.nextLine());
			guestCheck = guest.getfName();
			if (!guestCheck.equals("quit")) 
			{
				theGuest.add(new Guest(guest));
			}
			
		}
		for(Guest printList: theGuest) 
		{
			System.out.println(printList.getName() + " RSVP'D: " + printList.getTodaysDate());
			
		}
	}

}
