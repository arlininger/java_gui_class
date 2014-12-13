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

/**
 * Main window for the Zoom demo.
 */
public class ZoomShow extends JInternalFrame
{
	/**
	 * Create the Zoom demo.
	 */
	public ZoomShow()
	{
		super("ZoomShow",true,true,true,true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		toFront();
		add(new ZoomShowInternal());
	}
}

/**
 * The guts of the Zoom demo.
 */
class ZoomShowInternal extends JPanel implements Runnable //, ActionListener
{
	/**
	 * Thread executor for this window.
	 */
	ExecutorService executor = null;

	/**
	 * Total number of images.
	 */
	final int imageCount = 10;

	/**
	 * Maximum size of the images to be displayed.
	 */
	int maxSize = 200;

	/**
	 * Array of images to be displayed.
	 */
	Image images[] = new Image[imageCount];

	/**
	 * The current scale.
	 */
	int scale = 0;

	/**
	 * The current image being displayed.
	 */
	int index = 0;

	/**
	 * Whether or not the image is currently increasing.
	 */
	boolean increasing = true;

	/**
	 * Create the guts of the Zoom demo.
	 */
	public ZoomShowInternal()
	{
		setLayout(new GridLayout(1,1));
		images[0] = new ImageIcon(getClass().getResource("/images/1.jpg")).getImage();
		images[1] = new ImageIcon(getClass().getResource("/images/2.jpg")).getImage();
		images[2] = new ImageIcon(getClass().getResource("/images/3.jpg")).getImage();
		images[3] = new ImageIcon(getClass().getResource("/images/4.jpg")).getImage();
		images[4] = new ImageIcon(getClass().getResource("/images/5.jpg")).getImage();
		images[5] = new ImageIcon(getClass().getResource("/images/6.jpg")).getImage();
		images[6] = new ImageIcon(getClass().getResource("/images/7.jpg")).getImage();
		images[7] = new ImageIcon(getClass().getResource("/images/8.jpg")).getImage();
		images[8] = new ImageIcon(getClass().getResource("/images/9.jpg")).getImage();
		images[9] = new ImageIcon(getClass().getResource("/images/10.jpg")).getImage();
		executor = Executors.newFixedThreadPool(1);
		executor.execute(this);
	}

	/**
	 * Re-draw the window.
	 * @param g Graphics object used for drawing.
	 */
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
	
	/**
	 * Update the image location.
	 */
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

	/**
	 * Main loop for animation.
	 */
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
