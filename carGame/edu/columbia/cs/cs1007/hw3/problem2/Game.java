package edu.columbia.cs.cs1007.hw3.problem2;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
/**
 * A class that creates the game GUI and then plays the game. 
 * This class also includes the instructions on how the computer's car should move.
 * @author R_K
 */
public class Game {
	
	/**
	 * The integer value that denotes move left
	 */
	private final int LEFT = 1;
	/**
	 * The integer value that denotes move right
	 */
	private final int RIGHT = 2;
	/**
	 * The integer value that denotes move down
	 */
	private final int DOWN = 3;
	/**
	 * The integer value that denotes move up
	 */
	private final int UP=4;
	/**
	 * The width of the frame
	 */
	private final int FRAME_WIDTH=500;
	/**
	 * The height of the frame
	 */
	private final int FRAME_HEIGHT=600;
	/**
	 * The height of the panel
	 */
	private final int PANEL_HEIGHT=100;
	/**
	 * The width boundary of the frame, which the cars can't pass
	 */
	private final int WIDTH_BOUNDRY= FRAME_WIDTH-40;
	/**
	 * The height boundary of the frame, which the cars can't pass
	 */
	private final int HEIGHT_BOUNDRY= FRAME_HEIGHT-PANEL_HEIGHT-40;
	/**
	 * The Panel containing the two cars
	 */
    private  CarComponent carPanel;
    /**
     * The human's car
     */
    private  CarShape humanCar;
    /**
     * The computer's car
     */
    private  CarShape computerCar;
    /**
     * The left button
     */
    private  JButton leftButton;
    /**
     * The right button
     */
    private  JButton rightButton;
    /**
     * The down button
     */
    private  JButton downButton;
    /**
     * The up button
     */
    private  JButton upButton;
    /**
     * The frame where everything is put into
     */
    private  JFrame frame;
    /**
     * The panel for the controls
     */
    private  JPanel panel;
	/**
	 * Constructs a game object 
	 */
	
	private int level;
	/**
	 *the level of the game
	 */
    public Game()
	{
		level=1;
	}
    /**
     * Constructs the game 
     */
    public void constructBoard()
    {
    	frame = new JFrame();

    	frame.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
    	humanCar = new CarShape(0,0,30);
    	computerCar= new CarShape(FRAME_WIDTH-30, HEIGHT_BOUNDRY, 30);
    	carPanel = new CarComponent(humanCar, computerCar);
    	
    	leftButton = new JButton("Go left");
    	leftButton.addActionListener(
    				     createMovingButtonListener(LEFT));
    	
    	rightButton = new JButton("Go right");
    	rightButton.addActionListener(
    				      createMovingButtonListener(RIGHT));
    	
    	downButton= new JButton("Go down");
    	downButton.addActionListener(
    					createMovingButtonListener(DOWN));
    	
    	upButton= new JButton("Go up");
    	upButton.addActionListener(
    					createMovingButtonListener(UP));
    	
    	panel = new JPanel();
    	panel.setPreferredSize(new Dimension(FRAME_WIDTH,PANEL_HEIGHT));
    	panel.setLayout(new BorderLayout());
    	//an attempt to create a familiar layout of up, down, left, right
    	panel.add(leftButton, BorderLayout.WEST);
    	panel.add(rightButton, BorderLayout.EAST);
    	panel.add(downButton, BorderLayout.CENTER);
    	panel.add(upButton, BorderLayout.NORTH);
		
		frame.addKeyListener(createKeyListener());
		frame.setFocusable(true);
    	frame.setLayout(new BorderLayout());
    	frame.add(carPanel,BorderLayout.CENTER);
    	frame.add(panel,BorderLayout.SOUTH);	
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	frame.setResizable(false);
    	frame.pack();
    }
    /**
     * Plays the game, this method includes the computer's cars instructions
     */
    public void play()
    {
    	constructBoard();
    	Timer computerMover= new Timer(300, new
    			ActionListener()
    	{
    		public void actionPerformed(ActionEvent event)
    		{
    			boolean corner=false;// to so that both boundary and corner calls are not called at the same time
    			
    			if(carPanel.getXDistance()>=carPanel.getYDistance() && !(computerCar.getY()<9 || computerCar.getX()>(WIDTH_BOUNDRY) || computerCar.getY()>(HEIGHT_BOUNDRY) || computerCar.getX()<9))
    			{
    				if(humanCar.getY()>=computerCar.getY() && computerCar.getY()>9)
    					computerCar.translate(0, -10*level);


    				if(humanCar.getY()<=computerCar.getY()&& computerCar.getY()<(HEIGHT_BOUNDRY))
    					computerCar.translate(0, 10*level);
    			}
    			
    			if(carPanel.getXDistance()<=carPanel.getYDistance() && !(computerCar.getY()<9 || computerCar.getX()>(WIDTH_BOUNDRY) || computerCar.getY()>(HEIGHT_BOUNDRY) || computerCar.getX()<9))
    			{

    				if(humanCar.getX()>=computerCar.getX() && computerCar.getX()>9)
    					computerCar.translate(-10*level, 0);

    				if(humanCar.getX()<=computerCar.getX()&& computerCar.getX()<(WIDTH_BOUNDRY))
    				{
    					computerCar.translate(10*level, 0);
    				}
    			}
    		
    			//corner points, so the you can't corner the car as easily
    			if(computerCar.getY()<=10 && computerCar.getX()>=(WIDTH_BOUNDRY))
    			{	

    				if(carPanel.getXDistance()>=carPanel.getYDistance())
    					computerCar.translate(0, 85);

    				if(carPanel.getXDistance()<=carPanel.getYDistance())
    					computerCar.translate(-85, 0);	
    				corner=true;
    			}

    			if(computerCar.getY()<=10 && computerCar.getX()<=10)
    			{

    				if(carPanel.getXDistance()>=carPanel.getYDistance())
    					computerCar.translate(0, 85);	

    				if(carPanel.getXDistance()<=carPanel.getYDistance())
    					computerCar.translate(85, 0);
    				corner=true;
    			}

    			if(computerCar.getY()>=(HEIGHT_BOUNDRY) && computerCar.getX()>=(WIDTH_BOUNDRY))
    			{

    				if(carPanel.getXDistance()>=carPanel.getYDistance())
    					computerCar.translate(0, -85);	

    				if(carPanel.getXDistance()<=carPanel.getYDistance())
    					computerCar.translate(-85, 0);
    				corner=true;
    			}

    			if(computerCar.getY()>=(HEIGHT_BOUNDRY) && computerCar.getX()<=10)
    			{

    				if(carPanel.getXDistance()>=carPanel.getYDistance())
    					computerCar.translate(0, -85);	

    				if(carPanel.getXDistance()<=carPanel.getYDistance())
    					computerCar.translate(85, 0);
    				corner=true;
    			}
    			// the boundaries, again so you can't corner the car as easily
    			if(computerCar.getY()<=10 && !corner)
    			{
    				if(carPanel.getXDistance()<=20)//so that the car doesn't bounce right into you
    				{
    					if(humanCar.getX()>=computerCar.getX())
    						computerCar.translate(-10*level, 0);
    					else
    						computerCar.translate(10*level, 0);
    				}	
    				computerCar.translate(0, 85);
    			}
    			
    			if(computerCar.getY()>=(HEIGHT_BOUNDRY) && !corner)
    			{
    				if(carPanel.getXDistance()<=20)
    				{
    					if(humanCar.getX()>=computerCar.getX())
    						computerCar.translate(-10*level, 0);
    					else
    						computerCar.translate(10*level, 0);
    				}
    				
    				computerCar.translate(0, -85);
    			}
    			

    			if(computerCar.getX()<=10 && !corner)
    			{
    				if(carPanel.getYDistance()<=20)
    				{
    					if(humanCar.getY()>=computerCar.getY())
    						computerCar.translate(0, -10*level);
    					else
    						computerCar.translate(0, 10*level);
    				}
    				computerCar.translate(85, 0);
    			}
    				

    			if(computerCar.getX()>=(WIDTH_BOUNDRY) && !corner)
    			{
    				if(carPanel.getYDistance()<=20)
    				{
    					if(humanCar.getY()>=computerCar.getY())
    						computerCar.translate(0, -10*level);
    					else
    						computerCar.translate(0, 10*level);
    				}
    				computerCar.translate(-85,0);
    			}
    				
    			carPanel.repaint();	
    		}
    	}
    			);

    	computerMover.start();

    	while(!(carPanel.getCollide())){ 	// The TA helped me here, basically this loop continues and is checked every 400 milliseconds and doesn't execute the code below until the loop ends
    		try{Thread.sleep(400);} catch(Exception e){}
    	}
    	if(!carPanel.getExit())	// restarts the game
    	{	
			restartGame();
			level++;
		}
    	else					//quits everything
    		System.exit(0);
    }
    
    /**
     * Restarts the game, and resets the booleans
     */
    public void restartGame()
    {
    	frame.setVisible(false);
    	carPanel.resetExit();
    	carPanel.resetCollide();
    	play();
    }

    /**
     * Creates and Returns and ActionListner for the buttons controlling the human's car
     * @param direction the directions in which the user wants his/her car to move
     * @return an ActionListener for the buttons controlling the human's car
     */
    public ActionListener createMovingButtonListener(final int direction)
    {
	return new
	    ActionListener()
	    {
		public void actionPerformed(ActionEvent event)// to make the game more or less equal the human's car moves faster
		{
			if(direction==LEFT && humanCar.getX()>9) 
			{
				humanCar.translate(-20,0);
			} 
			
			if(direction==RIGHT && humanCar.getX()< (WIDTH_BOUNDRY-10)) 
			{
				humanCar.translate(20,0);
			}
			
			if(direction== DOWN && humanCar.getY()< (HEIGHT_BOUNDRY-10))
			{
				humanCar.translate(0, 20);
			}

			if(direction==UP && humanCar.getY()>9)
			{
				humanCar.translate(0, -20);
			}
			carPanel.repaint();
		}
	    };
    }
	
	public KeyListener createKeyListener()
	{
		return new
		KeyListener()
		{
			public void keyPressed(KeyEvent e)
			{
				final int keyCode=e.getKeyCode();
				if (keyCode == KeyEvent.VK_LEFT && humanCar.getX()>9)
					humanCar.translate(-10,0);
				
				else if (keyCode == KeyEvent.VK_RIGHT && humanCar.getX()< (WIDTH_BOUNDRY-10))
					humanCar.translate(10,0);
				
				else if (keyCode == KeyEvent.VK_UP && humanCar.getY()>9)
					humanCar.translate(0, -10);
				
				else if (keyCode == KeyEvent.VK_DOWN && humanCar.getY()< (HEIGHT_BOUNDRY-10))
					humanCar.translate(0, 10);
				
				carPanel.repaint();
			}
			
			public void keyReleased(KeyEvent e) {
				final int keyCode=e.getKeyCode();
				if (keyCode == KeyEvent.VK_LEFT && humanCar.getX()>9)
					humanCar.translate(-10,0);
				
				else if (keyCode == KeyEvent.VK_RIGHT && humanCar.getX()< (WIDTH_BOUNDRY-10))
					humanCar.translate(10,0);
				
				else if (keyCode == KeyEvent.VK_UP && humanCar.getY()>9)
					humanCar.translate(0, -10);
				
				else if (keyCode == KeyEvent.VK_DOWN && humanCar.getY()< (HEIGHT_BOUNDRY-10))
					humanCar.translate(0, 10);
				
				carPanel.repaint();
				
			}
			
			public void keyTyped(KeyEvent e) {
			}
		};
	}
}
