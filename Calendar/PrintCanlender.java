package printcalendar;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
public class PrintCalendar {
	
	public static void main(String[] args)
	{	
		Scanner ns = new Scanner(System.in);
		int userMonth = 0;
		int userYear = 0;
		int userDate = 0;
		String monthName = "";
		Locale locale = Locale.getDefault();
		System.out.println("Enter the month (0 - 11): ");
		userMonth = ns.nextInt(); //gets user month of choice based on number of the month
		ns.nextLine();
		System.out.println("Enter the year: ");
		userYear = ns.nextInt();
		ns.nextLine();
		System.out.println("Enter the date: ");
		userDate = ns.nextInt();
		GregorianCalendar calendar = new GregorianCalendar(); // creates a calendar object
		calendar.set(2019, 2, 1); 
		calendar.set(Calendar.MONTH, userMonth); // setting month based off user input
		calendar.set(Calendar.DATE, userDate); // setting date based off user input
		calendar.set(Calendar.YEAR, userYear); // setting year based off user input
		int date = calendar.get(Calendar.DATE);
		int year = calendar.get(Calendar.YEAR);
		int amount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
		

		switch(userMonth) // Just converts the userMonth into a string
		{
		case 0: monthName = "January"; break;
	      case 1: monthName = "February"; break;
	      case 2: monthName = "March"; break;
	      case 3: monthName = "April"; break;
	      case 4: monthName = "May"; break;
	      case 5: monthName = "June"; break;
	      case 6: monthName = "July"; break;
	      case 7: monthName = "August"; break;
	      case 8: monthName = "September"; break;
	      case 9: monthName = "October"; break;
	      case 10: monthName = "November"; break;
	      case 11: monthName = "December";
		}
		System.out.printf("%33s, %s\n", monthName, year); // title
		System.out.println("----------------------------------------------------------------");
		System.out.println("   Sunday   Monday Tuesday Wednesday Thursday   Friday Saturday"); // days
		
                int days7 = 0;
                
                
                for (int i = 1; i <= amount; i++) 
		{
			
			if (i == 1) // every 7 lines the loop will break a line to keep the table looking neat
			{
				for(int x = 1; x < firstDay; x++) // spacing for first day of the day
				{
					
                                    System.out.printf("         "); 
                                    days7 = x;
					
					
					
				}
				
				System.out.printf("%9d", i);
				
				
			}
			
			else if(i >= 1) {
				if ((i + days7) % 7 == 0) // every 7 lines the loop will break a line to keep the table looking neat
				{
                                    System.out.printf("%9d\n", i);
				}
				else {
                                    System.out.printf("%9d", i);
				}
			}
			
		}
		
		
		System.out.println("\nThe date is is: " + monthName + " " + date + " " + year + " and there's " + amount + " days.");

		
		
		
		
		
		

	}
	
	
	

}


