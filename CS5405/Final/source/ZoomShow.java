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

public class ZoomShow extends JInternalFrame
{
	public ZoomShow()
	{
		super("ZoomShow",true,true,true,true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		toFront();
		add(new ZoomShowInternal());
	}
}

class ZoomShowInternal extends JPanel implements Runnable //, ActionListener
{
	/**
	 * Thread executor for this window.
	 */
	ExecutorService executor = null;

	int imageCount = 10;
	int maxSize = 200;
	Image images[] = new Image[imageCount];
	int scale = 0;
	int index = 0;
	boolean increasing = true;

	public ZoomShowInternal()
	{
		setLayout(new GridLayout(1,1));
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
		Dimension currentSize = getSize();
		currentSize.height -= 10;
		currentSize.width -= 10;
		int width = (int)Math.round((currentSize.width * scale) / 100.0);
		int height = (int)Math.round((currentSize.height * scale) / 100.0);

		g.drawImage( images[index],
		             5 + (currentSize.width - width)/2,
			     5 + (currentSize.height - height)/2,
			     width,
			     height,
			     this);
	}
	
	void updateImage()
	{
		if (increasing)
		{
			scale++;
			if (scale == 100)
			{
				increasing = false;
			}
		} else {
			scale--;
			if (scale == 0)
			{
				increasing = true;
				index++;
			}
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
