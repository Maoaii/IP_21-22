
public class Rect 
{
	private double left;
	private double top;
	private double right;
	private double bottom;
	
	//Construtor
	public Rect(double xMin, double yMax, double xMax, double yMin)
	{
		left = xMin;
		top = yMax;
		right = xMax;
		bottom = yMin;
	}

	//Pre: other != null
	public Rect getHull (Rect other)
	{
		double xMin = Math.min(left, other.getLeft());
		double xMax = Math.max(right, other.getRight());
		double yMin = Math.min(bottom, other.getBottom());
		double yMax = Math.max(top, other.getTop());

		return new Rect(xMin, yMax, xMax, yMin);
	}

	public double getLeft ()
	{
		return left;
	}

	public double getRight ()
	{
		return right;
	}

	public double getTop ()
	{
		return top;
	}

	public double getBottom ()
	{
		return bottom;
	}

	public double getWidth ()
	{
		return right - left;
	}

	public double getHeight ()
	{
		return top - bottom;
	}

	public double getPerimeter ()
	{
		return 2 * (this.getWidth() + this.getHeight());
	}

	public boolean isSquare ()
	{
		return this.getWidth() == this.getHeight();
	}
}
