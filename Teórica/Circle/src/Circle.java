import java.awt.geom.Point2D;

public class Circle {
	
	private double x, y;
	private double r;
	private String pointInCircle = "Point is in Circle\n";	
	private String pointIsNotInCircle = "Point is not in Circle\n";
	private String doesntIntersect = "Circles don't intersect\n";
	private String intersects = "Circles intersects\n";
	private String isInside = "First circle contains second\n";
	
	//Constructor
	public Circle(double x, double y, double r)
	{
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	//Returns the circle radius
	public double getRadius()
	{
		return this.r;
	}
	
	//Calculates and returns the perimeter of the circle
	public double getPerimeter()
	{
		return (2 * Math.PI * this.r);
	}
	
	//Calculates and returns the area of the circle
	public double getArea()
	{
		return (Math.PI * this.r * this.r);
	}
	
	//Sees if a given point is inside the circle
	public String getLP(double x, double y)
	{
		//Calculates the distance between the center of the circle and the given point
		double distance = Point2D.distance(this.x, this.y, x, y);
		
		if (distance <= r)
		{
			return pointInCircle;
		}
		else
		{
			return pointIsNotInCircle;
		}
	}
	
	//Sees the relation between the two circles
	public String getLC(double x, double y, double r)
	{
		//Calculates the distance between the center of the circle and the given point
		double distance = Point2D.distance(this.x, this.y, x, y);
		//Calculates the sum of the radiuses
		double sumOfRadius = this.r + r;
		//Returns true if the second circle is inside the first
		boolean isInsideCondition = distance + r <= this.r;
		
		if (distance > sumOfRadius)
		{
			return doesntIntersect;
		}
		else if (!isInsideCondition)
		{
			return intersects;
		}
		else
		{
			return isInside;
		}
	}
	
	
}
