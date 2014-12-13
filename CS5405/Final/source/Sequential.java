/**
 * @author Adam Lininger
 */
package code;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Main window for the Sequential demo.
 */
public class Sequential extends JInternalFrame implements ActionListener,ListSelectionListener,LineListener
{
	/**
	 * Thread executor for this window.
	 */
	ExecutorService executor = null;

	/**
	 * Audio clip currently being played.
	 */
	Clip clip = null;

	/**
	 * Current audio input source.
	 */
	AudioInputStream audioInput = null;

	/**
	 * Play button.
	 */
	JButton playButton = new JButton("Play");

	/**
	 * Stop button.
	 */
	JButton stopButton = new JButton("Stop");

	/**
	 * Loop button.
	 */
	JButton loopButton = new JButton("Loop");

	/**
	 * List box for list of songs.
	 */
	JList listOfSongs;

	/**
	 * Index of currently selected audio clip.
	 */
	int currentIndex = 0;

	/**
	 * Number of audio clips.
	 */
	final int itemCount = 10;

	/**
	 * Whether we expect the audio clip to be playing.
	 */
	boolean shouldBePlaying = false;

	/**
	 * Array of images to be displayed.
	 */
	Image images[] = new Image[itemCount];

	/**
	 * Create the main window for the Sequential demo.
	 */
	public Sequential()
	{
		super("Sequential",true,true,true,true);
		FlowLayout layout = new FlowLayout();
		layout.setAlignOnBaseline(true);
		setLayout(layout);
		setSize(300,400);
		toFront();
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
		String songs[] = {
				"1.wav",
				"2.wav",
				"3.wav",
				"4.wav",
				"5.wav",
				"6.wav",
				"7.wav",
				"8.wav",
				"9.wav",
				"10.wav"
		};
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
		URL sound = getClass().getResource("/audio/1.wav");
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

	/**
	 * Re-draw the window.
	 * @param g Graphics object used for drawing.
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		Dimension currentSize = getSize();
		g.drawImage( images[currentIndex],
		             10,
		             70, 
		             150, 
		             150,
		             this);
	}
	
	/**
	 * Handle line updates.
	 * @param e Line Event to be handled.
	 */
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
			repaint();
		}
	}

	/**
	 * Handle List value changes.
	 * @param e Event to be handled.
	 */
	public void valueChanged(ListSelectionEvent e)
	{
		JList temp = (JList)e.getSource();
		currentIndex = temp.getSelectedIndex();
		URL sound = getClass().getResource("/audio/" + temp.getSelectedValue());
		try{
			clip.close();
			audioInput = AudioSystem.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.addLineListener(this);
		}
		catch (UnsupportedAudioFileException ex) {}
		catch (IOException ex) {}
		catch (LineUnavailableException ex) {}
		repaint();
	}

	/**
	 * Handle the actions from the buttons.
	 * @param e The event to be handled.
	 */
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
