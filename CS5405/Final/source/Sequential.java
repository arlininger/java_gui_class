/**
 * @author Adam Lininger
 */
package code;

import java.awt.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.net.*;
import javax.swing.*;

public class Sequential extends JInternalFrame implements Runnable //, ActionListener
{
	/**
	 * Thread executor for this window.
	 */
	ExecutorService executor = null;

	public Sequential()
	{
		super("Sequential",true,true,true,true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
//		setVisible(true);
		toFront();
		URL sound0 = getClass().getResource("/audio/GrumpyCat.wav");
		executor = Executors.newFixedThreadPool(1);
		executor.execute(this);
	}

//	public void paint(Graphics g)
//	{
//		super.paint(g);
//		g.drawImage(images[index],5 - offset,30 ,105 - offset,130,this);
//		g.drawImage(images[(index + 1) % imageCount],105 - offset,30 ,205 - offset,130,this);
//	}
	
	public void run()
	{
//		while (true)
//		{
//			updateImage();
//			repaint();
//			try
//			{
//				Thread.sleep(50); //Always sleep a little bit
//			} catch (InterruptedException ex)
//			{
//			}
//		}
	}
}
