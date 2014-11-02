/**
 * @author Adam Lininger
 */

package code;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.*;
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

	public Sortable()
	{
		super("Bubble Sort",true,true,true,true);
		this.size = 100;
		setup();
	}
	public Sortable(int size)
	{
		super("Bubble Sort",true,true,true,true);
		this.size = size;
		setup();
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
	public abstract boolean sort_step();

	public void play()
	{
		running = true;
		System.out.println("play");
	}

	public void pause()
	{
		running = false;
		System.out.println("pause");
	}

	public void reset()
	{
		System.out.println("reset");
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

	public void paint(Graphics g)
	{
		super.paint(g);

		for (int i = 0; i < size; i++)
		{
			g.drawLine(10+i,180-array[i],10+i,180);
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

	public void run()
	{
		while (true)
		{
			if (running)
			{
				System.out.println("running");
				if (sort_step() == false)
				{
					running = false;
				}
			}
			repaint();
			try
			{
				if (running) 
				{
					Thread.sleep(1); //Run quickly when running
				}
				else {
					Thread.sleep(100); //Don't waste time when not running
				}
			} catch (InterruptedException ex)
			{
			}
		}
	}
}


