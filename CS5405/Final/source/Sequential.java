/**
 * @author Adam Lininger
 */
package code;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.net.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.*;

public class Sequential extends JInternalFrame implements ActionListener,ListSelectionListener,LineListener
{
	/**
	 * Thread executor for this window.
	 */
	ExecutorService executor = null;

	Clip clip = null;
	AudioInputStream audioInput = null;
	JButton playButton = new JButton("Play");
	JButton stopButton = new JButton("Stop");
	JButton loopButton = new JButton("Loop");
	JList listOfSongs;
	int currentIndex = 0;
	final int itemCount = 2;
	boolean shouldBePlaying = false;

	public Sequential()
	{
		super("Sequential",true,true,true,true);
		setLayout(new FlowLayout());
		setSize(300,300);
		toFront();
		String songs[] = {"GrumpyCat.aiff","GrumpyCat.wav"};
		listOfSongs = new JList<String>(songs);
		listOfSongs.setSelectedIndex(currentIndex);
		listOfSongs.addListSelectionListener(this);
		add(playButton);
		add(stopButton);
		add(loopButton);
		add(new JScrollPane(listOfSongs));
		playButton.addActionListener(this);
		stopButton.addActionListener(this);
		loopButton.addActionListener(this);
		URL sound = getClass().getResource("/audio/GrumpyCat.wav");
		try{
			audioInput = AudioSystem.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.addLineListener(this);
		}
		catch (UnsupportedAudioFileException ex) {}
		catch (IOException ex) {}
		catch (LineUnavailableException ex) {}
		pack();
	}

	public void update(LineEvent e)
	{
		if (!shouldBePlaying)
		{
				clip.stop();
				return;
		}
		if (e.getType() == LineEvent.Type.STOP)
		{
			try {
				clip.close();
				currentIndex++;
				if (currentIndex >= itemCount)
				{
					currentIndex = 0;
				}
				listOfSongs.setSelectedIndex(currentIndex);
				URL sound = getClass().getResource("/audio/" + listOfSongs.getSelectedValue());
				audioInput = AudioSystem.getAudioInputStream(sound);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.addLineListener(this);
				clip.start();
			}
			catch (LineUnavailableException ex) {}
			catch (IOException ex) {}
			catch (UnsupportedAudioFileException ex) {}
		}
	}

	public void valueChanged(ListSelectionEvent e)
	{
		JList temp = (JList)e.getSource();
		currentIndex = temp.getSelectedIndex();
		URL sound = getClass().getResource("/audio/" + temp.getSelectedValue());
		try{
			audioInput = AudioSystem.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.addLineListener(this);
		}
		catch (UnsupportedAudioFileException ex) {}
		catch (IOException ex) {}
		catch (LineUnavailableException ex) {}
		System.out.printf("Value changed\n");
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == playButton)
		{
			clip.start();
			shouldBePlaying = true;
		} else if (e.getSource() == stopButton)
		{
			shouldBePlaying = false;
			clip.stop();
		} else if (e.getSource() == loopButton)
		{
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			shouldBePlaying = true;
		}
	}
}
