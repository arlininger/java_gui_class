/*
 * Adam Lininger
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Perfect extends JFrame extends JApplet implements ActionListener
//public class Perfect
{
	private JTextField field1;
	private JLabel label1;
	private String str;
    int lastval;

	public Perfect( String title )
	{
		super(title);
	//	JFrame application = new JFrame();
	//	self.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(400,400);
        lastval = 0;

        
		field1 = new JTextField( "10", 10 );
        label1 = new JLabel("Enter a number: ");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add( label1 );
		getContentPane().add( field1 );
		field1.addActionListener( this );

        pack();
        setSize(400,400);
        setVisible(true);
	}

	public void init()
	{

	}

	public static void main(String[] args)
	{
		Perfect application = new Perfect("Title");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JLabel label = new JLabel("Hi");
//        application.getContentPane().add(label);
//        application.pack();
//        application.setVisible(true);
		System.out.println("\n\n\nFrame Demo Application");
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setFont(new Font("Helvatica", Font.BOLD,12));
        int counter = 0;
        for ( int i = 1; i <=lastval; i++)
        {
            if (isPerfect(i))
            {
                g.drawString("" + i, 50, 50 + 14*counter);
                counter++;
            }
        }

//		g.drawString("Testing AFrame Window",100,100);	
//		g.drawString("Testing AFrame Window",125,150);	
	} 

    public Boolean isPerfect(int x)
    {
        int total = 0;
        for (int i = 1; i <= x/2; i++)
        {
            if ((x % i) == 0)
            {
                total += i;
            }
        }
        return (total == x);
    }

	public void actionPerformed( ActionEvent e)
	{
		str = field1.getText();
		field1.setText("");
		label1.setText(str);
        lastval = Integer.parseInt(str);
        repaint();
	}
}

