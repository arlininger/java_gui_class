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

public abstract class Sortable extends JInternalFrame implements Runnable, ActionListener
{
	int[] array;
	int size;
	boolean running;
	Random numberGenerator;
	JButton playButton;
	JButton resetButton;
	JButton pauseButton;

//	Lock lock = new ReentrantLock();

	public Sortable(String name)
	{
		super(name,true,true,true,true);
		this.size = 100;
		setup();
	}
	public Sortable(String name, int size)
	{
		super(name,true,true,true,true);
		this.size = size;
		setup();
	}

	void swap(int i, int j)
	{
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
		return;
	}

	private void setup()
	{
		setLayout(new FlowLayout());
		//JPanel buttons = new JPanel(new GridLayout(1,3));
		//buttons.setMaximumSize(new Dimension(30,1000000)); 
		playButton = new JButton("Play");
		resetButton = new JButton("Reset");
		pauseButton = new JButton("Pause");
		playButton.addActionListener(this);
		resetButton.addActionListener(this);
		pauseButton.addActionListener(this);
		add(playButton);
		add(resetButton);
		add(pauseButton);
		//add(buttons);
		numberGenerator = new Random();
		setSize(300,300);
		setVisible(true);
		toFront();
		reset();
		running = false;
		Executor executor = Executors.newCachedThreadPool();
		executor.execute(this);
	}

	/**
	 * Take one step in the sorting algorithm.
	 * @return True if more steps are available.
	 */
	public abstract boolean sortStep();

	/**
	 * Get the color of a line based on the algorithm in use.
	 */
	public abstract Color getColor(int index);

	public void play()
	{
		running = true;
		//System.out.println("play");
	}

	public void pause()
	{
		running = false;
		//System.out.println("pause");
	}

	public void reset()
	{
		//System.out.println("reset");
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

	public int getIndex(int i)
	{
		return array[i];
	}

	public void paint(Graphics g)
	{
		super.paint(g);

		for (int i = 0; i < size; i++)
		{
			g.setColor(getColor(i));
			g.drawLine(10+i,180-getIndex(i),10+i,180);
		}
	}

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

	boolean verify()
	{
		for (int i = 1; i < size; i++)
		{
			if (array[i-1] > array[i]) return false;
		}
		return true;
	}

	public void run()
	{
		while (true)
		{
			if (sortStep() == false)
			{
				running = false;
			}
			repaint();
			sleep(); //See function below
		}
	}

	void sleep()
	{
		try
		{
			while (running == false)
			{
				Thread.sleep(100); //Sleep longer when not running
			}
			Thread.sleep(10); //Always sleep a little bit
		} catch (InterruptedException ex)
		{
		}
	}
}


