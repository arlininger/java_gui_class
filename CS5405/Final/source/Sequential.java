/**
 * @author Adam Lininger
 */
package code;

import java.applet.*;
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

	AudioClip clip = null;

	public Sequential()
	{
		super("Sequential",true,true,true,true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		toFront();
		URL sound0 = getClass().getResource("/audio/GrumpyCat.wav");
		clip = Applet.newAudioClip(sound0);
		clip.play();
		executor = Executors.newFixedThreadPool(1);
		executor.execute(this);
	}

	public void run()
	{
	}
}
