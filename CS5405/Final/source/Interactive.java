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

public class Interactive extends JInternalFrame implements Runnable //, ActionListener
{
	/**
	 * Thread executor for this window.
	 */
	ExecutorService executor = null;

	int imageCount = 10;
	int maxSize = 200;
	Image images[] = new Image[imageCount];
	int offset = 0;
	int index = 0;

	public Interactive()
	{
		super("Interactive",true,true,true,true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		setVisible(true);
		toFront();
		URL image0 = null;
//		image0 = getClass().getResource("/images/1.jpg");
		images[0] = new ImageIcon(getClass().getResource("/images/0.jpg")).getImage();
		images[1] = new ImageIcon(getClass().getResource("/images/1.jpg")).getImage();
		images[2] = new ImageIcon(getClass().getResource("/images/2.jpg")).getImage();
		images[3] = new ImageIcon(getClass().getResource("/images/3.jpg")).getImage();
		images[4] = new ImageIcon(getClass().getResource("/images/4.jpg")).getImage();
		images[5] = new ImageIcon(getClass().getResource("/images/5.jpg")).getImage();
		images[6] = new ImageIcon(getClass().getResource("/images/6.jpg")).getImage();
		images[7] = new ImageIcon(getClass().getResource("/images/7.jpg")).getImage();
		images[8] = new ImageIcon(getClass().getResource("/images/8.jpg")).getImage();
		images[9] = new ImageIcon(getClass().getResource("/images/9.jpg")).getImage();
		executor = Executors.newFixedThreadPool(1);
		executor.execute(this);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(images[index],5 - offset,30 ,105 - offset,130,this);
		g.drawImage(images[(index + 1) % imageCount],105 - offset,30 ,205 - offset,130,this);
	}
	
	void updateImage()
	{
		offset++;
		if (offset >= maxSize)
		{
			index++;
			offset = 0;
		}
		if (index >= imageCount)
		{
			index = 0;
		}
	}

	public void run()
	{
		while (true)
		{
			updateImage();
			repaint();
			try
			{
				Thread.sleep(50); //Always sleep a little bit
			} catch (InterruptedException ex)
			{
			}
		}
	}
}
