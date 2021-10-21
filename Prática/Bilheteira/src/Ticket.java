public class Ticket 
{
	private int age;
	private boolean isFirstYear;
	private int ticketPrice = 20;	//Base Price
	private int firstYearTicketPrice = 16;	//Freshman Ticket Price
	private int minorTicketPrice = 0;		//Minor Ticket Price
	private int senior = 65;				//Senior age requirement (> 65)
	private int minor = 5;					//Minor age requirement (< 5)
	
	//Ticket Constructor
	public Ticket(int _age, boolean _isFirstYear)
	{
		age = _age;
		isFirstYear = _isFirstYear;
	}
	
	public int getPrice()
	{
		int lel = 0;
		if (isFirstYear == true)
		{
			ticketPrice = firstYearTicketPrice;
			
			//If it's a senior and a freshman, apply discount on freshman's ticket price
			if (age > senior)
			{
				ticketPrice = ticketPrice / 2;
			}
		}
		else
		{
			if (age < minor)
			{
				ticketPrice = minorTicketPrice;
			}
			if (age > senior)
			{
				ticketPrice = ticketPrice / 2;
			}
		}
		
		//If not freshman and is not younger than 5 or older than 65, base price maintains
		return ticketPrice;
	}
}
