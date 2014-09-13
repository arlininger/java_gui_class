/*
 * Adam Lininger
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame
{
    public MainFrame(JApplet demo)
    {
        super ("MainFrame");
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(demo);
        demo.init();
    }
}

public class Demo extends JApplet implements ActionListener
{
	private JTextField field1;
	private JLabel label1;
	private String str;
    int lastval;

	public Demo()
	{
        lastval = 0;
        
		field1 = new JTextField( "10", 10 );
        label1 = new JLabel("Enter a number: ");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add( label1 );
		getContentPane().add( field1 );
		field1.addActionListener( this );

        setSize(400,400);
        setVisible(true);
	}

	public static void main(String[] args)
	{
        new MainFrame(new Demo());
		System.out.println("\n\n\nFrame Demo Application");
	}

	public void paint(Graphics g)
	{
        String factorstring;
		super.paint(g);
		g.setFont(new Font("Helvatica", Font.BOLD,12));
        int counter = 0;
        for ( int i = 1; i <=lastval; i++)
        {
            if (isPerfect(i))
            {
                factorstring = "Factors are: ";
                for (int j = 1; j < i; j++)
                {
                    if ((i % j) == 0)
                    {
                        factorstring += (j + " ");
                    }
                }
                g.drawString("" + i + " is perfect.", 50, 50 + 14*2*counter);
                g.drawString(factorstring,65, 50 + 14 + 14*2*counter);
                counter++;
            }
        }

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

abstract class Shape 
{
    public abstract int getArea();
}

abstract class TwoDimensionalShape extends Shape
{
}

abstract class ThreeDimensionalShape extends Shape
{
    public abstract int getVolume();
}

class Circle extends TwoDimensionalShape
{
}

class Square extends TwoDimensionalShape
{
}

class Triangle extends TwoDimensionalShape
{
}

class Sphere extends ThreeDimensionalShape
{
}

class Cube extends ThreeDimensionalShape
{
}

class Tetrahedron extends ThreeDimensionalShape
{
}

