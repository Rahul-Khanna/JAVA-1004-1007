package edu.columbia.cs.cs1007.hw3.problem2;
import java.awt.*; 
import java.awt.geom.*;


/**
   A car that can be moved around.
 */
public class CarShape implements MoveableShape
{
	
	/**
	 * The x-coordinate of the car
	 */
	private int x;
	/**
	 * The y-coordinate of the car
	 */
	private int y;
	/**
	 * The width of the car
	 */
	private int width;
	
	/**
    Constructs a car item.
    @param x the left of the bounding rectangle
    @param y the top of the bounding rectangle
    @param width the width of the bounding rectangle
	 */
	public CarShape(int x, int y, int width)
	{
		this.x = x;
		this.y = y;
		this.width = width;
	}

	/**
	 * A method which moves the car over by a certain amount
	 * @param dx the amount by which the car moves in the x direction
	 * @param dy the amount by which the car moves in the y direction
	 */
	public void translate(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	/**
	 * Returns the dimensions of the car
	 * @return the dimensions of the car
	 */
	public Dimension getSize() 
	{
		return new Dimension(width,width);
	}
	/**
	 * Returns the x-coordinate of the car
	 * @return the x-coordinate of the car
	 */
	public int getX()
	{
		return x;
	}
	/**
	 * Returns the y-coordinate of the car
	 * @return the y-coordinate of the car
	 */
	public int getY()
	{
		return y;
	}
	/**
	 * Draws the Car
	 * @param g2 the graphics context
	 */
	public void draw(Graphics2D g2)
	{
		Rectangle2D.Double body
		= new Rectangle2D.Double(x, y + width / 6, 
				width - 1, width / 6);
		Ellipse2D.Double frontTire
		= new Ellipse2D.Double(x + width / 6, y + width / 3, 
				width / 6, width / 6);
		Ellipse2D.Double rearTire
		= new Ellipse2D.Double(x + width * 2 / 3, y + width / 3,
				width / 6, width / 6);

		// The bottom of the front windshield
		Point2D.Double r1
		= new Point2D.Double(x + width / 6, y + width / 6);
		// The front of the roof
		Point2D.Double r2
		= new Point2D.Double(x + width / 3, y);
		// The rear of the roof
		Point2D.Double r3
		= new Point2D.Double(x + width * 2 / 3, y);
		// The bottom of the rear windshield
		Point2D.Double r4
		= new Point2D.Double(x + width * 5 / 6, y + width / 6);
		Line2D.Double frontWindshield
		= new Line2D.Double(r1, r2);
		Line2D.Double roofTop
		= new Line2D.Double(r2, r3);
		Line2D.Double rearWindshield
		= new Line2D.Double(r3, r4);

		g2.fill(frontTire);
		g2.fill(rearTire);
		g2.draw(body);
		g2.draw(frontWindshield);
		g2.draw(roofTop);
		g2.draw(rearWindshield);
	}
}
