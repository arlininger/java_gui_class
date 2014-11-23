/**
 * @author Adam Lininger
 */

package code;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import javax.swing.*;

/**
 * Implements a sorting algorithm for visualization. This class should be extended
 * to implement a particular algorithm.
 */
public abstract class Sortable extends JInternalFrame implements Runnable, ActionListener
{
	int[] array;
	int size;
	int delay;
	boolean running;
	Random numberGenerator;
	JButton playButton;
	JButton resetButton;
	JButton pauseButton;

	boolean resetRequested;

	ExecutorService executor = null;

	/**
	 * Create an instance of the sortable object. This should always be called by the extending algorithm's constructor
	 * to properly set up the object.
	 * @param name The name of the window to be created.
	 */
	public Sortable(String name)
	{
		super(name,true,true,true,true);
		this.size = 100;
		setup();
	}

	/**
	 * Create an instance of the sortable object. This should always be called by the extending algorithm's constructor
	 * to properly set up the object.
	 * @param name The name of the window to be created.
	 * @param size The number of elements to be sorted.
	 */
	public Sortable(String name, int size)
	{
		super(name,true,true,true,true);
		this.size = size;
		setup();
	}

	/**
	 * A helper function. Since most sort algorithms depend on swapping the position of elements in an array,
	 * this function is provided for implementing algorithms to maintain simplicity.
	 * @param i Index of first element to be exchanged.
	 * @param j Index of second element to be exchanged.
	 */
	void swap(int i, int j)
	{
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
		return;
	}

	/**
	 * Set up the sortable object. This function should only be called by the constructor. It accomplishes
	 * most tasks that would normally be done in the constructor. This is used to avoid code 
	 * duplication for tasks common to all constructors.
	 */
	private void setup()
	{
		setLayout(new FlowLayout());
		playButton = new JButton("Play");
		resetButton = new JButton("Reset");
		pauseButton = new JButton("Pause");
		playButton.addActionListener(this);
		resetButton.addActionListener(this);
		pauseButton.addActionListener(this);
		add(playButton);
		add(resetButton);
		add(pauseButton);
		numberGenerator = new Random();
		setSize(250,200);
		setVisible(true);
		toFront();
		reset();
		running = false;
		delay = 10;
		//executor = Executors.newFixedThreadPool(1);
		//executor.execute(this);
	}

	/**
	 * Take one step in the sorting algorithm.
	 * @return True if more steps are available.
	 */
	public abstract boolean sortStep();

	/**
	 * Get the color of a line based on the algorithm in use.
	 * @param index Index of the entry for which to get the color.
	 */
	public abstract Color getColor(int index);

	/**
	 * Get the prefered position of this algorithm.
	 * Used to initially display all algorithms in a somewhat tiled position.
	 */
	public abstract Point getPreferedPosition();

	/**
	 * Handler for the play button. Sets the algorithm to a running state.
	 */
	public void play()
	{
		running = true;
		if (executor == null)
		{
			executor = Executors.newFixedThreadPool(1);
			executor.execute(this);
		}
	}

	/**
	 * Handler for the pause button. Sets the algorithm to a paused state.
	 */
	public void pause()
	{
		running = false;
	}

	/**
	 * Handler for the reset button. Resets the algorithm to an un-sorted and non-running state. 
	 * It is expected that implementing algorithms will overload this function to reset their own
	 * internal data. They should always ensure this function is called.
	 */
	public void reset()
	{
		resetRequested = true;
		if (executor != null)
		{
			executor.shutdown();
			try {
				if (!executor.awaitTermination(1,TimeUnit.SECONDS))
				{
					executor.shutdownNow();
					if (!executor.awaitTermination(1,TimeUnit.SECONDS))
					{
						System.out.printf("Failed to kill threads\n");
					}
				}
			} catch (InterruptedException ex)
			{
			}
		}
		executor = null;
		resetRequested = false; //Thread reset is complete

		running = false;
		array = new int[this.size];
		for (int i = 0; i < this.size; i++)
		{
			array[i] = i;
		}
		for (int i = 0; i < this.size; i++)
		{
			int offset = numberGenerator.nextInt(this.size);
			int temp = array[i];
			array[i] = array[offset];
			array[offset] = temp;
		}
	}

	/**
	 * Helper function for accessing the array. Intended to be overloaded in the event that an 
	 * implementing algorithm needs to display items from an alternate array. MergeSort may be
	 * an example of this need.
	 * @param i Index of element to get.
	 */
	public int getIndex(int i)
	{
		return array[i];
	}

	/**
	 * Draw the elements in the array.
	 * @param g Graphics object to use for painting.
	 */
	public void paint(Graphics g)
	{
		super.paint(g);

		for (int i = 0; i < size; i++)
		{
			g.setColor(getColor(i));
			g.drawLine(10+i,180-getIndex(i),10+i,180);
		}
	}

	/**
	 * Handle all actions in this object.
	 * @param e Event to be handled.
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == playButton)
		{
			play();
		} else if (e.getSource() == resetButton)
		{
			reset();
		} else if (e.getSource() == pauseButton)
		{
			pause();
		}
		repaint();

	}

	/**
	 * Verify the array is properly sorted.
	 */
	boolean verify()
	{
		for (int i = 1; i < size; i++)
		{
			if (array[i-1] > array[i]) 
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Main loop for the thread. In most instances, this main loop is used. 
	 * It will run the sortStep function once on each pass.
	 * If sortStep returns true (indicating another pass is needed), it 
	 * performs a short sleep and runs another iteration.
	 */
	public void run()
	{
		while (resetRequested == false && sortStep())
		{
			repaint();
			sleep(); //See function below
		}
		if (!verify())
		{
			System.out.printf("Failed to verify\n");
		}
		repaint();
		running = false;
	}

	/**
	 * Set the delay value
	 */
	void setDelay(int delay)
	{
		this.delay = delay;
	}

	/**
	 * Helper function to handle sleeping. This provides a consistant sleep for 
	 * all algorithms.Depending on whether the algorithm identifies as actively running,
	 * this function will sleep for a short or long period of time. The purpose of varrying the sleep time is
	 * to avoid using more cpu than necessary when the algorithm is paused or completed.
	 */
	void sleep()
	{
		try
		{
//			while (running == false)
//			{
//				Thread.sleep(100); //Sleep longer when not running
//			}
			Thread.sleep(delay); //Always sleep a little bit
		} catch (InterruptedException ex)
		{
		}
	}
}


