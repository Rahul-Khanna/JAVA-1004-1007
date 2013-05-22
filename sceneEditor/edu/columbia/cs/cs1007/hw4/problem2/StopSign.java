package edu.columbia.cs.cs1007.hw4.problem2;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;

/**
   A stopSign.
*/
public class StopSign extends CompoundShape
{
   /**
      Constructs a StopSign.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public StopSign(int x, int y, int width)
   {
	  this.x=x;
	  this.y=y;
	   
	   //the main sign
	   Ellipse2D.Double sign= new Ellipse2D.Double(x,y,width+4,width);
	   //the post for the sign
	   Rectangle2D.Double post= new Rectangle2D.Double((x+width/4)+2,y+width,width/2, width/2);
	   
	   //creating the letter s
	   Point2D.Double s1= new Point2D.Double(x+width/4,y+width/4);
	   Point2D.Double s2= new Point2D.Double(x+width/8,y+(3*width)/8);
	   Point2D.Double s3= new Point2D.Double(x+width/4,y+(5*width)/8);
	   Point2D.Double s4= new Point2D.Double(x+width/8,y+(3*width)/4);
	   Line2D.Double s11= new Line2D.Double(s1, s2);
	   Line2D.Double s22= new Line2D.Double(s2, s3);
	   Line2D.Double s33= new Line2D.Double(s3, s4);
	   
	   //creating the letter t
	   Point2D.Double t1= new Point2D.Double(x+(3*width)/8,y+width/4);
	   Point2D.Double t2= new Point2D.Double(x+(7*width)/16,y+width/4);
	   Point2D.Double t3= new Point2D.Double(x+width/2,y+width/4);
	   Point2D.Double t4= new Point2D.Double(x+(7*width)/16,y+(3*width)/4);
	   Line2D.Double t11= new Line2D.Double(t1, t3);
	   Line2D.Double t22= new Line2D.Double(t2, t4);
	   
	   //creating the letter o
	   Ellipse2D.Double o= new Ellipse2D.Double(x+ (5*width)/8, y+ width/4,width/8,width/2);
	   
	   //creating the letter p
	   Ellipse2D.Double p11= new Ellipse2D.Double(x+(7*width)/8,y+width/4,width/8,width/4);
	   Point2D.Double p1= new Point2D.Double(x+(7*width)/8,y+width/2);
	   Point2D.Double p2= new Point2D.Double(x+(7*width)/8,y+(3*width)/4);
	   Line2D.Double p22= new Line2D.Double(p1, p2);
	   
	   
	   add(sign);
	   add(post);
	   add(s11);
	   add(s22);
	   add(s33);
	   add(t11);
	   add(t22);
	   add(o);
	   add(p11);
	   add(p22);
   }

   /**
    * Gets the x-coordinate
    * @return the x-coordinate
    */
   public int getX() {

	   return x;
   }

   /**
    * Gets the y-coordinate
    * @return the y-coordinate
    */
   public int getY() {

	   return y;
   }

}