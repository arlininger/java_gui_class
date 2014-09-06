/*
 * Adam Lininger
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Perfect extends JFrame implements ActionListener
{
	private JTextField field1;
	private JLabel label;
	private String str;

	public Perfect( String title )
	{
		super(title);
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(400,400);

		field1 = new JTextField( 10 );
		add( field1 );
//		TextFieldHandler handler = new TextFieldHandler();
//		field1.addActionListener( handler );
	}

	public void init()
	{
		Container c;
		c = getContentPane();
		c.setLayout (new FlowLayout());

		c.add( label = new JLabel("Enter a number and press Enter:"));

		field1 = new JTextField("10000", 20);
		c.add(field1);
		field1.addActionListener(this);
	}

	public static void main(String[] args)
	{
		new Perfect("Title");
		System.out.println("\n\n\nFrame Demo Application");
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setFont(new Font("Helvatica", Font.BOLD,16));
		g.drawString("Testing AFrame Window",100,100);	
	} 

	public void actionPerformed( ActionEvent e)
	{
		str = field1.getText();
		field1.setText("");
		label.setText(str);
	}
}

