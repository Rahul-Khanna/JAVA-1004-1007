package edu.columbia.cs.cs1007.hw4.problem2;
import java.awt.*;
import java.awt.geom.*;

/**
   A scene shape that is composed of multiple geometric shapes.
*/
public abstract class CompoundShape extends SelectableShape
{
   public CompoundShape()
   {
      path = new GeneralPath();
   }

   protected void add(Shape s)
   {
      path.append(s, false);
   }

   public boolean contains(Point2D aPoint)
   {
      return path.contains(aPoint);
   }

   public void translate(int dx, int dy)
   {
      path.transform(
            AffineTransform.getTranslateInstance(dx, dy));
     x=x+dx;
     y=y+dy;
   }

   public void draw(Graphics2D g2)
   {
      g2.draw(path);
   }
   
   private GeneralPath path;
   protected int x;
   protected int y;
   
}
