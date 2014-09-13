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
	public Demo()
	{
        getContentPane().setLayout(new FlowLayout());

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
		super.paint(g);
		g.setFont(new Font("Helvatica", Font.BOLD,12));
	} 

    public void actionPerformed( ActionEvent e)
    {
        repaint();
    }        
}

abstract class Shape 
{
    public abstract double getArea();
}

abstract class TwoDimensionalShape extends Shape
{
}

abstract class ThreeDimensionalShape extends Shape
{
    public abstract double getVolume();
}

class Circle extends TwoDimensionalShape
{
    private double radius;
    
    public Circle( double radius )
    {
        this.radius = radius;
    }

    public double getArea()
    {
        return (radius * radius * 3.14159623); // Find math library PI definition
    }
}

class Square extends TwoDimensionalShape
{
    private double size;

    public Square (double size)
    {
        this.size = size;
    }

    public double getArea()
    {
        return (size * size);
    }
}

class Triangle extends TwoDimensionalShape
{
    private double side1;
    private double side2;
    private double side3;

    public Triangle (double side1, float side2, float side3)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea()
    {
        //look up this math
        return 0.0;
    }
}

class Sphere extends ThreeDimensionalShape
{
    private double radius;

    public Sphere (double radius)
    {
        this.radius = radius;
    }

    public double getArea ()
    {
        //look up this math
        return 0.0;
    }

    public double getVolume ()
    {
        //look up this math
        return 0.0;
    }
}

class Cube extends ThreeDimensionalShape
{
    private double size;

    public Cube (double size)
    {
        this.size = size;
    }

    public double getArea()
    {
        return (size * size * 6);
    }

    public double getVolume()
    {
        return (size * size * size);
    }
}

class Tetrahedron extends ThreeDimensionalShape
{
    public class Point
    {
        public double x;
        public double y;
        public double z;
    }

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Tetrahedron (Point a, Point b, Point c, Point d)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double getArea()
    {
        //do this math
        return 0.0;
    }
    
    public double getVolume()
    {
        //do this math
        return 0.0;
    }
    
}
