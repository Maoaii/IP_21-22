public class Robot 
{
	// Constants
	public static final String NORTH = "N";
	public static final String SOUTH = "S";
	public static final String EAST = "E";
	public static final String WEST = "O";

	// Instance variables
	private int currentX, currentY;
	private String currentHeading;
	private int totalDistance;
	private int markedX, markedY;
	private int maxMove;

	//Creates the robot and initializes its' position, direction, max movement and make that position a PoI
	public Robot(int initX, int initY) 
	{
		currentX = markedX = initX;
		currentY = markedY = initY;
		currentHeading = NORTH;
		maxMove = 0;
	}
	
	//Returns robot's X position
	public int getXPos() 
	{
		return currentX;
	}
	
	//Returns robot's Y position
	public int getYPos() 
	{
		return currentY;
	}
	
	//Returns robot's total distance traveled
	public int getTotalDistance() 
	{
		return totalDistance;
	}
	
	//Return Manhattan's absolute distance between PoI and robot
	public int getPIDistance() 
	{
		return Math.abs(currentX - markedX) + Math.abs(currentY - markedY);
	}
	
	//Move robot along a graph. North-South is the Y axis and East-West is the X axis
	public void move(int distance) 
	{
		switch (currentHeading)
		{
			case NORTH:
				currentY += distance;
				break;
			case SOUTH:
				currentY -= distance;
				break;
			case EAST:
				currentX += distance;
				break;
			case WEST:
				currentX -= distance;
				break;
		}
		
		//Add distance to total distance the robot traveled
		totalDistance += distance;
	}
	
	//Change robot's direction
	public void setHeading(String heading) 
	{
		currentHeading = heading;
	}
	
	//Mark current position as a PoI
	public void mark() 
	{
		markedX = currentX;
		markedY = currentY;
	}
	
	//Record the biggest movement
	public void recordMaxMove(int moveBy)
	{
		if (maxMove < moveBy)
			maxMove = moveBy;
	}
	
	//Return the biggest movement
	public int getMaxMove()
	{
		return maxMove;
	}
		
}
