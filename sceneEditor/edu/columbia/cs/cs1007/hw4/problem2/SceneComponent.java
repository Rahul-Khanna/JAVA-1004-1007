package edu.columbia.cs.cs1007.hw4.problem2;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

/**
   A component that shows a scene composed of shapes.
*/
public class SceneComponent extends JComponent
{
   public SceneComponent()
   {
      shapes = new ArrayList<SceneShape>();

      addMouseListener(new
         MouseAdapter()
         {
            public void mousePressed(MouseEvent event)
            {
               mousePoint = event.getPoint();
               for (SceneShape s: shapes)
               {
                  if (s.contains(mousePoint))
                     s.setSelected(!s.isSelected());
               }
               repaint();
            }
         });

      addMouseMotionListener(new
         MouseMotionAdapter()
         {
            public void mouseDragged(MouseEvent event)
            {
               Point lastMousePoint = mousePoint;
               mousePoint = event.getPoint();
               for (SceneShape s : shapes)
               {
                  if (s.isSelected())
                  {
                     double dx = mousePoint.getX() - lastMousePoint.getX();
                     double dy = mousePoint.getY() - lastMousePoint.getY();
                     s.translate((int) dx, (int) dy);
                  }
               }
               repaint();
            }
         });
   }
   /**
    * A method to find the x-coordinate corner with the least amount of shapes around it
    * @param the width of the component the shapes are in
    * @return the x-coordinate of the corner
    */
   public int getXStopSign(int width)
   {
	   	ArrayList<Integer> x= new ArrayList<Integer>();
		ArrayList<Double> originalX= new ArrayList<Double>();
		int counter=0;
		int counter2=0;
		
		for(int i=0; i<shapes.size(); i++)
		{
			originalX.add((double) shapes.get(i).getX());
			
		}
		
		for(int i=0; i<originalX.size(); i++)
		{
			if(originalX.get(i)<=width/2)
			{
				x.add(width-54);
			}
			
			else
			{
				x.add(0);
			}
		}
		
		for(int i=0; i<x.size(); i++)
		{
			if(x.get(i)==width-54)
				counter++;
			if(x.get(i)==0)
				counter2++;
		}
			if(counter>=counter2)
				return (width-54);
			else
				return 0;
	}
		

   /**
    * A method to find the x-coordinate corner with the least amount of shapes around it
    * @param the height of the component the shapes are in
    * @return the x-coordinate of the corner
    */
   public int getYStopSign(int height)
   {
	   	ArrayList<Integer> x= new ArrayList<Integer>();
		ArrayList<Double> originalX= new ArrayList<Double>();
		int counter=0;
		int counter2=0;
		
		for(int i=0; i<shapes.size(); i++)
		{
			originalX.add((double) shapes.get(i).getY());
			
		}
		
		for(int i=0; i<originalX.size(); i++)
		{
			if(originalX.get(i)<=(height/2))
			{
				x.add(height-75);
			}
			
			else
			{
				x.add(0);
			}
		}
		
		for(int i=0; i<x.size(); i++)
		{
			if(x.get(i)==height-75)
				counter++;
			if(x.get(i)==0)
				counter2++;
		}
			if(counter>=counter2)
				return (height-75);
			else
				return 0;
		}
		
   /**
      Adds an shape to the scene.
      @param s the shape to add
   */
   public void add(SceneShape s)
   {
      shapes.add(s);
      repaint();
   }

   /**
      Removes all selected shapes from the scene.
   */
   public void removeSelected()
   {
      for (int i = shapes.size() - 1; i >= 0; i--)
      {
         SceneShape s = shapes.get(i);
         if (s.isSelected()) shapes.remove(i);
      }
      repaint();
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      for (SceneShape s : shapes)
      {
    		s.draw(g2);
    	  
         if (s.isSelected())
            s.drawSelection(g2);
      }
   }

   private ArrayList<SceneShape> shapes;
   private Point mousePoint;
}
