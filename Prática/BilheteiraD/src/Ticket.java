public class Ticket 
{
	private int age;
	private boolean isFirstYear;
	private int ticketPrice = 20;			//Base Price
	private int firstYearTicketPrice = 16;	//Freshman Ticket Price
	private int minorTicketPrice = 0;		//Minor Ticket Price
	private int senior = 65;				//Senior age requirement (> 65)
	private int minor = 5;					//Minor age requirement (< 5)
	
	//Ticket Constructor
	public Ticket (int _age, boolean _isFirstYear)
	{
		age = _age;
		isFirstYear = _isFirstYear;
	}
	
	//Pre: other != null
	public int getPriceWith (Ticket other)
	{
		if (isFirstYear == true)
		{
			ticketPrice = firstYearTicketPrice;

			//If it's the only senior in the group and is a freshman, apply discount on freshman's ticket price
			if (age > senior && other.getAge() <= senior)
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
			//If it's the only senior in the group, apply senior discount
			if (age > senior && other.getAge() <= senior)
			{
				ticketPrice = ticketPrice / 2;
			}
		}
		
		
		//If the other ticket owner is a senior, apply discount on non senior ticket price
		if (other.getAge() > 65)
		{
			return ticketPrice / 2;
		}
		
		//If not freshman and is not younger than 5 or older than 65, base price maintains
		return ticketPrice;
	}
	
	//Method to access the other ticket owner age
	public int getAge ()
	{
		return age;
	}
}
