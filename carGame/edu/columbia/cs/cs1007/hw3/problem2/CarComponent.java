package edu.columbia.cs.cs1007.hw3.problem2;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

/**
 * A class which is responsible for putting two CarShape objects onto a single Component
 * It also compares how close the cars are
 * @author R_K
 */

public class CarComponent extends JComponent implements ActionListener {

    /**
     * The human's car
     */
	private CarShape humanCar;
	/**
	 * The computer's car
	 */
    private CarShape computerCar;
    /**
     * The boolean which indicates whether the two cars have collided
     */
    private boolean collide = false;
    /**
     * The boolean which indicates whether the user wants to quit
     */
    private boolean exit = false;
    
    /**
     * Constructs a Car Component object which has two CarShape objects on it, and has a timer which sees if the two cars are close
     * @param m the human's car
     * @param j the computer's car
     */
    public CarComponent(CarShape m, CarShape j) 
    {
    	humanCar = m;
    	computerCar = j;
    	Timer t  = new Timer(15,this);
    	t.start();
    }

    /**
     * Paints the cars onto the CarComponent
 	 * @param g is the graphics context
     */
    public void paintComponent(Graphics g) {

	Graphics2D g2 = (Graphics2D)g;
	g2.setColor(Color.BLUE);
	g2.clearRect(humanCar.getX(),humanCar.getY(),humanCar.getSize().width,humanCar.getSize().height);
	humanCar.draw(g2);
	g2.setColor(Color.RED);
	g2.clearRect(computerCar.getX(),computerCar.getY(),computerCar.getSize().width,computerCar.getSize().height);
	computerCar.draw(g2);

    }
    /**
     * Checks to see if the cars are close
     * @return the boolean close, which indicates if the cars are close
     */
    public boolean carsAreClose()
    {
    	boolean close= false;
    	if(humanCar.getX() <= computerCar.getX()) // all the different cases
    	{
    		if(humanCar.getX() + 30 >= computerCar.getX())
    		{
    			if(humanCar.getY()>=computerCar.getY())
    			{
    				if(humanCar.getY() -17 <=computerCar.getY()) // this was hard to pick, but 17 works well for most cases, I tried to make it so that the cars actually were hitting and not just the rectangles colliding
    				{
    					close= true;
    				}
    			}

    			else if(humanCar.getY()<=computerCar.getY())
    			{
    				if(humanCar.getY() +13 >=computerCar.getY()) // for some reason when the car your car is on top 13 works better, I tried to make it so the cars were actually colliding, and not just the rectangles
    				{
    					close= true;
    				}
    			}
    		}		
    	}
    	
    	if(humanCar.getX() >= computerCar.getX())
    	{
    		if(humanCar.getX() - 30 <= computerCar.getX())
    		{
    			if(humanCar.getY()>=computerCar.getY())
    			{
    				if(humanCar.getY() -17 <=computerCar.getY())
    				{
    					close= true;
    				}
    			}

    			else if(humanCar.getY()<=computerCar.getY())
    			{
    				if(humanCar.getY() +13 >=computerCar.getY())
    				{
    					close= true;
    				}
    			}
    		}		
    	}
    	return close;
    }
    /**
     * Returns the horizontal distance between two cars
     * @return the horizontal distance between two cars
     */
    public int getXDistance()
    {
    	return(Math.abs(humanCar.getX()-computerCar.getX()));
    }
    /**
     * Returns the vertical distance between two cars
     * @return the vertical distance between two cars
     */
    public int getYDistance()
    {
    	return(Math.abs(humanCar.getY()-computerCar.getY()));
    }
    /**
     * Resets collide to be false again
     */
    public void resetCollide()
    {
    	collide=false;
    }
    /**
     * Resets exit to be false again
     */
    public void resetExit()
    {
    	exit=false;
    }
    /**
     * Returns the boolean collide
     * @return the boolean collide
     */
    public boolean getCollide()
    {
    	return collide;
    }
    /**
     * Returns the boolean exit
     * @return the boolean exit
     */
    public boolean getExit()
    {
    	return exit;
    }
    
    /**
     * Sees if the two cars are close and if they are provides the boom message and then asks the user whether he/she would like to play again.
     */
    public void actionPerformed(ActionEvent ae) {

    	if(carsAreClose() && !collide)
    	{
    		JOptionPane.showMessageDialog(null,"BOOM!  ");
    		int answer= JOptionPane.showConfirmDialog(null, "Do you want to play again?");
    		collide=true;
    		if(answer==JOptionPane.YES_OPTION)// the user wants to play again
    			exit=false;
    		if(answer==JOptionPane.NO_OPTION || answer==JOptionPane.CANCEL_OPTION)// the user doesn't want to
    			exit=true;
    	}

    }

}

