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

import java.awt.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.net.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class Interactive extends JInternalFrame implements ActionListener
{
	/**
	 * Thread executor for this window.
	 */
	ExecutorService executor = null;

	AudioClip clip = null;
	JButton playButton = new JButton("Play");
	JButton stopButton = new JButton("Stop");
	JButton loopButton = new JButton("Loop");
	JButton selectButton = new JButton("Select");

	public Interactive()
	{
		super("Interactive",true,true,true,true);
		//setLayout(new GridLayout(2,2));
		setSize(300,300);
		toFront();

		JPanel panel = new JPanel();
		add(panel);

		panel.setLayout(new GridLayout(2,2));
		panel.add(playButton);
		panel.add(stopButton);
		panel.add(loopButton);
		panel.add(selectButton);
		playButton.addActionListener(this);
		stopButton.addActionListener(this);
		loopButton.addActionListener(this);
		selectButton.addActionListener(this);
		URL sound0 = getClass().getResource("/audio/GrumpyCat.wav");
		clip = Applet.newAudioClip(sound0);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == playButton)
		{
			clip.play();
		} else if (e.getSource() == stopButton)
		{
			clip.stop();
		} else if (e.getSource() == loopButton)
		{
			clip.loop();
		} else if (e.getSource() == selectButton)
		{
			JFileChooser chooser = new JFileChooser("./audio/");
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Sound Files", "aiff", "wav");
			chooser.setFileFilter(filter);
			if (chooser.showOpenDialog(this) ==
					JFileChooser.APPROVE_OPTION)
			{
				try{
					System.out.printf("%s\n",chooser.getSelectedFile().toURI().toURL().toString());
					URL sound = chooser.getSelectedFile().toURI().toURL();
					clip = Applet.newAudioClip(sound);
				} catch (MalformedURLException ex) {
				}
			}
		}
	}
}
