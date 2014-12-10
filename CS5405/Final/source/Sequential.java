/**
 * @author Adam Lininger
 */
package code;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.net.*;
import javax.swing.*;

public class Sequential extends JInternalFrame implements ActionListener
{
	/**
	 * Thread executor for this window.
	 */
	ExecutorService executor = null;

	AudioClip clip = null;
	JButton playButton = new JButton("Play");
	JButton stopButton = new JButton("Stop");
	JButton loopButton = new JButton("Loop");

	public Sequential()
	{
		super("Sequential",true,true,true,true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		toFront();
		URL sound0 = getClass().getResource("/audio/GrumpyCat.wav");
		clip = Applet.newAudioClip(sound0);
		add(playButton);
		add(stopButton);
		add(loopButton);
		playButton.addActionListener(this);
		stopButton.addActionListener(this);
		loopButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == playButton)
		{
			System.out.printf("Playing\n");
			clip.play();
		} else if (e.getSource() == stopButton)
		{
			System.out.printf("Stoping\n");
			clip.stop();
		} else if (e.getSource() == loopButton)
		{
			System.out.printf("Looping\n");
			clip.loop();
		}
	}
}
