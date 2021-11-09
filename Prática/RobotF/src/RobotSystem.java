
public class RobotSystem {
	
	//Constants
		//Identifiers
	private static final int ROBOT1 = 1;
	private static final int ROBOT2 = 2;
	private static final int TIE = 3;

	
	//Instance variables
		//Robot objects
	private Robot robot1;
	private Robot robot2;
	
	/**
	 * Creates robots regarding their initial positions, X and Y
	 * 
	 * @param initX1
	 * @param initY1
	 * @param initX2
	 * @param initY2
	 */
	public RobotSystem(int initX1, int initY1, int initX2, int initY2) {
		robot1 = new Robot(initX1, initY1);
		robot2 = new Robot(initX2, initY2);
	}
	
	/**
	 * Method that moves "robotNumber" by "moveBy" distance in the heading that it's facing
	 * 
	 * @param robotNumber
	 * @param moveBy
	 * @pre (robotNumber == 1 || robotNumber == 2) && moveBy > 0
	 */
	public void systemMove(int robotNumber, int moveBy) {
		if (robotNumber == ROBOT1)
		{
			robot1.move(moveBy);
			robot1.recordMaxMove(moveBy);
		}
		else
		{
			robot2.move(moveBy);
			robot2.recordMaxMove(moveBy);
		}
	}
	
	/**
	 * Method that sets "robotNumber" direction to "headTo"
	 * 
	 * @param robotNumber
	 * @param headTo
	 * @pre (robotNumber == 1 || robotNumber == 2) && (headTo == 'N' || headTo == 'S' ||
	 * headTo == 'E' || headTo == 'O')
	 */
	public void systemSetHeading(int robotNumber, String headTo) {
		if (robotNumber == ROBOT1)
			robot1.setHeading(headTo);
		else
			robot2.setHeading(headTo);
	}
	
	/**
	 * Method that marks "robotNumber" current position as a point of interest
	 * 
	 * @param robotNumber
	 * @pre robotNumber == 1 || robotNumber == 2
	 */
	public void systemMark(int robotNumber) {
		if (robotNumber == ROBOT1)
			robot1.mark();
		else
			robot2.mark();
	}
	
	/**
	 * Returns "robotNumber" X position
	 * 
	 * @param robotNumber
	 * @return int
	 * @pre robotNumber == 1 || robotNumber == 2
	 */
	public int systemGetXPos(int robotNumber) {
		if (robotNumber == ROBOT1)
			return robot1.getXPos();
		else
			return robot2.getXPos();
	}
	
	/**
	 * Returns "robotNumber" Y position
	 * 
	 * @param robotNumber
	 * @return int
	 * @pre robotNumber == 1 || robotNumber == 2
	 */
	public int systemGetYPos(int robotNumber) {
		if (robotNumber == ROBOT1)
			return robot1.getYPos();
		else
			return robot2.getYPos();
	}
	
	/**
	 * Returns "robotNumber" total distance traveled
	 * 
	 * @param robotNumber
	 * @return int
	 * @pre robotNumber == 1 || robotNumber == 2
	 */
	public int systemGetTotalDistance(int robotNumber) {
		if (robotNumber == ROBOT1)
			return robot1.getTotalDistance();
		else
			return robot2.getTotalDistance();
	}
	
	/**
	 * Returns "robotNumber" current distance to the last Point of Interest
	 * 
	 * @param robotNumber
	 * @return int
	 * @pre robotNumber == 1 || robotNumber == 2
	 */
	public int systemGetPIDistance(int robotNumber) {
		if (robotNumber == ROBOT1)
			return robot1.getPIDistance();
		else
			return robot2.getPIDistance();
	}
	
	/**
	 * Returns the robot's number that traveled the farthest in its' life
	 * 
	 * @return int
	 */
	public int systemWhoTraveledMore() {
		
		if (robot1.getTotalDistance() > robot2.getTotalDistance())
			return ROBOT1;
		else if (robot1.getTotalDistance() < robot2.getTotalDistance())
			return ROBOT2;
		else
			return TIE;
	}
}
