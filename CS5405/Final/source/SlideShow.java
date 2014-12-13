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
 * Main window for SlideShow.
 */
public class SlideShow extends JInternalFrame
{
	/**
	 * Creates the SlideShow main window.
	 */
	public SlideShow()
	{
		super("SlideShow",true,true,true,true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		toFront();
		add(new SlideShowInternal());
	}
}

/**
 * The guts of the SlideShow window. This keeps displayed items from
 * overlapping the border of the window itself.
 */
class SlideShowInternal extends JPanel implements Runnable //, ActionListener
{
	/**
	 * Thread executor for this window.
	 */
	ExecutorService executor = null;

	/**
	 * Maximum number of images.
	 */
	int imageCount = 10;

	/**
	 * Maximum size of image.
	 */
	int maxSize = 100;

	/**
	 * Array of images to be displayed.
	 */
	Image images[] = new Image[imageCount];

	/**
	 * Horizontal offset of image to be displayed. Used for scrolling.
	 */
	int offset = 0;

	/**
	 * Index of image to be displayed.
	 */
	int index = 0;

	/**
	 * Creates the SlideShowInternal object.
	 */
	public SlideShowInternal()
	{
		setLayout(new GridLayout(1,1));
		setSize(100,100);
		URL image0 = null;
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
	 * @param g Graphics object used for re-drawing.
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		Dimension currentSize = getSize();
		int offsetPosition = (int)Math.round((currentSize.width * offset) / 100.0);
		g.drawImage( images[index],
		             -offsetPosition ,
		             5 , 
		             currentSize.width -5, 
		             currentSize.height -10,
		             this);
		g.drawImage( images[(index + 1) % imageCount], 
		             currentSize.width - offsetPosition,
		             5, 
		             currentSize.width -5, 
		             currentSize.height -10,
		             this);
	}
	
	/**
	 * Update the position of the image.
	 */
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

	/**
	 * Main loop for image animation.
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
