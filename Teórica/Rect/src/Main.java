import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		double left = input.nextDouble();
		double top = input.nextDouble();
		double right = input.nextDouble();
		double bottom = input.nextDouble();
		input.nextLine();
		Rect rect1 = new Rect(left, top, right, bottom);
		
		left = input.nextDouble();
		top = input.nextDouble();
		right = input.nextDouble();
		bottom = input.nextDouble();
		input.nextLine();
		Rect rect2 = new Rect(left, top, right, bottom);
		
		input.close();

		Rect hull = rect1.getHull(rect2);

		System.out.println(rect1.getPerimeter());
		System.out.println(rect2.getPerimeter());
		System.out.println(hull.getPerimeter());
		if (hull.isSquare())
		{
			System.out.println("The hull is a square");
		}
		


	}

}
