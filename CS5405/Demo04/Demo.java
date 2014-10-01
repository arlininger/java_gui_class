/*
 * Adam Lininger
 */

import javax.swing.*;
import javax.swing.border.*;
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

public class Demo extends JApplet
{
	Shape[] myShapes = new Shape[6];
	JButton circleButton;
	JButton squareButton;
	JButton triangleButton;
	JButton sphereButton;
	JButton cubeButton;
	JButton tetrahedronButton;
	Integer lastShapeIndex = -1;

	public Demo()
	{
		getContentPane().setLayout(new FlowLayout());

		Assignment thirdPanel = new Assignment();
		TitledBorder panelBorder = new TitledBorder("Assignment 4");
		thirdPanel.setBorder(panelBorder);
		getContentPane().add(thirdPanel);
		thirdPanel.setVisible(true);
		
		setSize(600,600);
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
	} 

}


class Assignment extends JPanel implements ActionListener
{
	Shape[] myShapes = new Shape[6];
	JButton circleButton;
	JButton squareButton;
	JButton triangleButton;
	JButton sphereButton;
	JButton cubeButton;
	JButton tetrahedronButton;
	Integer lastShapeIndex = -1;

	public Assignment()
	{
		//getContentPane().setLayout(new FlowLayout());
		
		Point trianglePoint1 = new Point(0,0,0);
		Point trianglePoint2 = new Point(30,0,0);
		Point trianglePoint3 = new Point(0,30,0);
		Point tetrahedronPoint4 = new Point(0,0,30);
		myShapes[0] = new Circle(15);
		myShapes[1] = new Square(30);
		myShapes[2] = new Triangle(trianglePoint1,trianglePoint2,trianglePoint3);
		myShapes[3] = new Sphere(15);
		myShapes[4] = new Cube(30);
		myShapes[5] = new Tetrahedron(trianglePoint1,trianglePoint2,trianglePoint3,tetrahedronPoint4);

		circleButton = new JButton("Circle");
		squareButton = new JButton("Square");
		triangleButton = new JButton("Triangle");
		sphereButton = new JButton("Sphere");
		cubeButton = new JButton("Cube");
		tetrahedronButton = new JButton("Tetrahedron");

		this.add(circleButton);
		this.add(squareButton);
		this.add(triangleButton);
		this.add(sphereButton);
		this.add(cubeButton);
		this.add(tetrahedronButton);

		circleButton.addActionListener(this);
		squareButton.addActionListener(this);
		triangleButton.addActionListener(this);
		sphereButton.addActionListener(this);
		cubeButton.addActionListener(this);
		tetrahedronButton.addActionListener(this);

		Dimension size = new Dimension(600,600);
		setPreferredSize(size);
		setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setFont(new Font("Helvatica", Font.BOLD,12));
		Point base = new Point(5,105,0);
		if (lastShapeIndex >= 0 && lastShapeIndex <= 5)
		{
			System.out.format("Drawing shape index: %d\n",lastShapeIndex);
			myShapes[lastShapeIndex].draw(g,base);
			if (myShapes[lastShapeIndex].is3D() == false)
			{			
				g.drawString("Shape " +
				             myShapes[lastShapeIndex].name() +
				             " has area: " +
				             myShapes[lastShapeIndex].getArea(), 50, base.y + 30);
			}
			else
			{
				g.drawString("Shape " + myShapes[lastShapeIndex].name() +
				             " has area: " + myShapes[lastShapeIndex].getArea() +
				             " and volume: " +
				             ((ThreeDimensionalShape)myShapes[lastShapeIndex]).getVolume(), 
				            50, base.y + 30);
			}
		}
	} 

	public void actionPerformed( ActionEvent e)
	{
		if (e.getSource() == circleButton)
		{
			lastShapeIndex = 0;
		} else if (e.getSource() == squareButton){
			lastShapeIndex = 1;
		} else if (e.getSource() == triangleButton){
			lastShapeIndex = 2;
		} else if (e.getSource() == sphereButton){
			lastShapeIndex = 3;
		} else if (e.getSource() == cubeButton){
			lastShapeIndex = 4;
		} else if (e.getSource() == tetrahedronButton){
			lastShapeIndex = 5;
		}
		//		System.out.format("Setting index: %d\n", lastShapeIndex);
		repaint();
	}		
}


class Point //This point will be used as relative or absolute positions in shapes below
{
	public int x;
	public int y;
	public int z;

	public Point(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	static Point crossProduct (Point a, Point b)
	{
		int x = (a.y*b.z - a.z*b.y);
		int y = (a.z*b.x - a.x*b.z);
		int z = (a.x*b.y - a.y*b.x);
		return new Point(x,y,z);
	}

	static int dotProduct (Point a, Point b)
	{
		return (a.x*b.x + a.y*b.y + a.z*b.z);
	}

	static Point minus(Point a, Point b)
	{
		return new Point(a.x-b.x, a.y-b.y, a.z-b.z);
	}
}

abstract class Shape 
{
	public abstract int getArea();
	public abstract void draw(Graphics g, Point position); //Provide a base point
	public abstract String name();
	public abstract boolean is3D();
}

abstract class TwoDimensionalShape extends Shape
{
	public boolean is3D()
	{
		return false;
	}
}

abstract class ThreeDimensionalShape extends Shape
{
	public abstract int getVolume();
	
	public boolean is3D()
	{
		return true;
	}
}

class Circle extends TwoDimensionalShape
{
	public String name() { return "Circle"; }
	private int radius;
	
	public Circle( int radius )
	{
		this.radius = radius;
	}

	public int getArea()
	{
		return (int)((double)radius * (double)radius * 3.14159623); // Find math library PI definition
	}

	public void draw(Graphics g, Point base)
	{
		g.drawOval(base.x,base.y,radius*2,radius*2); //3rd and 4th parameters are width and height
	}

}

class Square extends TwoDimensionalShape
{
	public String name() { return "Square"; }
	private int size;

	public Square (int size)
	{
		this.size = size;
	}

	public int getArea()
	{
		return (size * size);
	}
	public void draw(Graphics g, Point base)
	{
		g.drawRect((int)base.x,(int)base.y,(int)size,(int)size);
	}

}

class Triangle extends TwoDimensionalShape
{
	public String name() { return "Triangle"; }
	private Point point1;
	private Point point2;
	private Point point3;

	public Triangle (Point point1, Point point2, Point point3)
	{
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}

	public int getArea()
	{
		//look up this math
		return ( (point1.x*(point2.y - point3.y)) +
		         (point2.x*(point3.y - point1.y)) +
             (point3.x*(point1.y - point2.y)) ) /2;
	}

	public void draw(Graphics g, Point base)
	{
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		xPoints[0] = base.x + point1.x; yPoints[0] = base.y + point1.y;
		xPoints[1] = base.x + point2.x; yPoints[1] = base.y + point2.y;
		xPoints[2] = base.x + point3.x; yPoints[2] = base.y + point3.y;
		
		g.drawPolygon(xPoints,yPoints,3);
	}

}

class Sphere extends ThreeDimensionalShape
{
	public String name() { return "Sphere"; }
	private int radius;

	public Sphere (int radius)
	{
		this.radius = radius;
	}

	public int getArea ()
	{
		double rad = (double)radius;
		double intermediate = (4*rad*rad*3.14159);
		return (int)intermediate;
	}

	public int getVolume ()
	{
		double rad = (double)radius;
		double intermediate = (4*rad*rad*rad*3.14159)/3.0;
		return (int)intermediate;
	}
	public void draw(Graphics g, Point base)
	{
	}

}

class Cube extends ThreeDimensionalShape
{
	public String name() { return "Cube"; }
	private int size;

	public Cube (int size)
	{
		this.size = size;
	}

	public int getArea()
	{
		return (size * size * 6);
	}

	public int getVolume()
	{
		return (size * size * size);
	}
	public void draw(Graphics g, Point base)
	{
	}

}

class Tetrahedron extends ThreeDimensionalShape
{
	public String name() { return "Tetrahedron"; }
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

	public int getArea()
	{
		int side1 = Point.dotProduct(
		                  Point.minus(b,a),
		                  Point.minus(c,a)
                      ) /2;
		int side2 = Point.dotProduct(
		                  Point.minus(b,a),
		                  Point.minus(d,a)
                      ) /2;
		int side3 = Point.dotProduct(
		                  Point.minus(d,a),
		                  Point.minus(c,a)
                      ) /2;
		int side4 = Point.dotProduct(
		                  Point.minus(b,d),
		                  Point.minus(c,d)
                      ) /2;
                 
		return side1 + side2 + side3 + side4;
	}
	
	public int getVolume()
	{
		int numerator = (Point.dotProduct(
                           Point.minus(a,d),
                           Point.crossProduct(
		                             Point.minus(b,d),
		                             Point.minus(c,d)
                                 )
		                       )
		                  );
		if (numerator < 1) { numerator = -numerator; }
				
		return numerator/6;
	}
	
	public void draw(Graphics g, Point base)
	{
	}

}
