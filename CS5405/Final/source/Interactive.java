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

	public Interactive()
	{
		super("Interactive",true,true,true,true);
		setLayout(new GridLayout(1,1));
		setSize(300,300);
		toFront();
		executor = Executors.newFixedThreadPool(1);
		executor.execute(this);
	}

	public void run()
	{
	}
}
