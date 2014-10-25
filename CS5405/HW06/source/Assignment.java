/**
 * Adam Lininger
 */

package code;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Provides the primary implementation for the Fourth Homework Assignment
 * This class displays a set of button controls for the display of various
 * shapes, categorized by two dimensions vs three dimensions.
 */
public class Assignment extends JInternalFrame implements ActionListener
{
	/**
	 * The various shapes in this class are stored here.
	 */
	Shape[] myShapes = new Shape[6];

	/**
	 * A menu item for displaying the Circle.
	 */
	JMenuItem circleMenuItem;

	/**
	 * A menu item for displaying the Square.
	 */
	JMenuItem squareMenuItem;

	/**
	 * A menu item for displaying the Triangle.
	 */
	JMenuItem triangleMenuItem;

	/**
	 * A menu item for displaying the Sphere.
	 */
	JMenuItem sphereMenuItem;

	/**
	 * A button for displaying the Cube.
	 */
	JMenuItem cubeMenuItem;

	/**
	 * A menu item for displaying the Tetrahedron.
	 */
	JMenuItem tetrahedronMenuItem;

	/**
	 * This stores the most recently selected shape.
	 * Valid indices are those that are in range of the array myShapes.
	 * A value of -1 indicates that no shape is selected.
	 */
	Integer lastShapeIndex = -1;

	/**
	 * Handles creating the assignment panel. All object creation and positioning
	 * is done here.
	 */
	public Assignment()
	{
		super("Assignment", true, true, true, true);

		//getContentPane().setLayout(new FlowLayout());
		//TitledBorder panelBorder = new TitledBorder("Assignment Output");
		//setBorder(panelBorder);

		Point trianglePoint1 = new Point(0, 0, 0);
		Point trianglePoint2 = new Point(30, 0, 0);
		Point trianglePoint3 = new Point(0, 30, 0);
		Point tetrahedronPoint4 = new Point(0, 0, 30);
		myShapes[0] = new Circle(15);
		myShapes[1] = new Square(30);
		myShapes[2] = new Triangle(trianglePoint1, trianglePoint2, trianglePoint3);
		myShapes[3] = new Sphere(15);
		myShapes[4] = new Cube(30);
		myShapes[5] = new Tetrahedron(trianglePoint1, trianglePoint2, trianglePoint3, tetrahedronPoint4);

		circleMenuItem = new JMenuItem("Circle");
		squareMenuItem = new JMenuItem("Square");
		triangleMenuItem = new JMenuItem("Triangle");
		sphereMenuItem = new JMenuItem("Sphere");
		cubeMenuItem = new JMenuItem("Cube");
		tetrahedronMenuItem = new JMenuItem("Tetrahedron");

		circleMenuItem.addActionListener(this);
		squareMenuItem.addActionListener(this);
		triangleMenuItem.addActionListener(this);
		sphereMenuItem.addActionListener(this);
		cubeMenuItem.addActionListener(this);
		tetrahedronMenuItem.addActionListener(this);
		
		setSize(600, 530);
		setVisible(true);
	}

	/**
	 * Draws the selected object. The object itself is drawn as well as
	 * a descriptive text.
	 * @param g The graphs object on which stuff is drawn.
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setFont(new Font("Helvatica", Font.BOLD, 12));
		Point base = new Point(5, 105, 0);
		if (lastShapeIndex >= 0 && lastShapeIndex <= 5)
		{
			System.out.format("Drawing shape index: %d\n", lastShapeIndex);
			myShapes[lastShapeIndex].draw(g,base);
			if (myShapes[lastShapeIndex].is3D() == false)
			{			
				g.drawString("Shape " +
				             myShapes[lastShapeIndex].name() +
				             " has area: " +
				             myShapes[lastShapeIndex].getArea(), 50, base.y + 30);
			} else {
				g.drawString("Shape " + myShapes[lastShapeIndex].name() +
				             " has area: " + myShapes[lastShapeIndex].getArea() +
				             " and volume: " +
				             ((ThreeDimensionalShape)myShapes[lastShapeIndex]).getVolume(), 
				            50, base.y + 30);
			}
		}
	} 

	/**
	 * Returns a menu object containing items relevant to this object.
	 */
	public JMenu getMenu()
	{
		JMenu assignmentMenu = new JMenu("Assignment options");
		JMenu twoDMenu = new JMenu("2D");
		JMenu threeDMenu = new JMenu("3D");
		assignmentMenu.add(twoDMenu);
		assignmentMenu.add(threeDMenu);

		twoDMenu.add(circleMenuItem);
		twoDMenu.add(triangleMenuItem);
		twoDMenu.add(squareMenuItem);
		threeDMenu.add(sphereMenuItem);
		threeDMenu.add(cubeMenuItem);
		threeDMenu.add(tetrahedronMenuItem);
		
		return assignmentMenu;
	}

	/**
	 * Handles all actions for all buttons in this class. All object selection logic
	 * should be placed here.
	 * @param e The event that occurred.
	 */
	public void actionPerformed( ActionEvent e)
	{
		if (e.getSource() == circleMenuItem)
		{
			lastShapeIndex = 0;
		} else if (e.getSource() == squareMenuItem){
			lastShapeIndex = 1;
		} else if (e.getSource() == triangleMenuItem){
			lastShapeIndex = 2;
		} else if (e.getSource() == sphereMenuItem){
			lastShapeIndex = 3;
		} else if (e.getSource() == cubeMenuItem){
			lastShapeIndex = 4;
		} else if (e.getSource() == tetrahedronMenuItem){
			lastShapeIndex = 5;
		}
		//		System.out.format("Setting index: %d\n", lastShapeIndex);
		repaint();
	}		
}

/**
 * A Point describes a single location in 3 dimensional space. Helper functions for
 * commonly needed math operations are provided.
 */
class Point //This point will be used as relative or absolute positions in shapes below
{
	public int x;
	public int y;
	public int z;

	/**
	 * Constructs a new Point. 
	 */
	public Point(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Returns a new Point containing the cross product of a and b.
	 * @param a The left multiplicand.
	 * @param b The right multiplicand.
	 */
	static Point crossProduct (Point a, Point b)
	{
		int x = (a.y*b.z - a.z*b.y);
		int y = (a.z*b.x - a.x*b.z);
		int z = (a.x*b.y - a.y*b.x);
		return new Point(x,y,z);
	}

	/**
	 * Returns a new Point containing the dot product of a and b.
	 * @param a The left multiplicand.
	 * @param b The right multiplicand.
	 */
	static int dotProduct (Point a, Point b)
	{
		return (a.x*b.x + a.y*b.y + a.z*b.z);
	}

	/**
	 * Returns a new Point containing the difference between a and b.
	 * @param a The minuend.
	 * @param b The subtrahend.
	 */
	static Point minus(Point a, Point b)
	{
		return new Point(a.x-b.x, a.y-b.y, a.z-b.z);
	}
}

/**
 * A Shape object is a logical description of a geometric shape. Shapes can be of
 * two types: {@link TwoDimensionalShape} and {@link ThreeDimensionalShape}. 
 */
abstract class Shape 
{
	/**
	 * Returns an integer containing the surface area of the shape.
	 */
	public abstract int getArea();

	/**
	 * Displays the shape at the provided position.
	 * @param g The {@link Graphics} object to be used in displaying the shape.
	 * @param position The {@link Point} at the upper-left corner of the shape location.
	 */
	public abstract void draw(Graphics g, Point position); //Provide a base point

	/**
	 * Returns a string containing the name of the shape.
	 */
	public abstract String name();

	/**
	 * Gets whether or not the shape is a {@link ThreeDimensionalShape}.
	 */
	public abstract boolean is3D();
}

/**
 * A TwoDimensionalShape object is a logical description of a two dimensional 
 * geometric shape. 
 */
abstract class TwoDimensionalShape extends Shape
{
	public boolean is3D()
	{
		return false;
	}
}

/**
 * A ThreeDimensionalShape object is a logical description of a three dimensional 
 * geometric shape. 
 */
abstract class ThreeDimensionalShape extends Shape
{
	/**
	 * Returns the calculated volume of the shape.
	 */
	public abstract int getVolume();
	
	public boolean is3D()
	{
		return true;
	}
}

/**
 * A logical description of a circle.
 */
class Circle extends TwoDimensionalShape
{
	public String name() { return "Circle"; }

	/**
	 * Holds the radius of this circle.
	 */
	private int radius;
	
	/**
	 * Creates a circle object.
	 * @param radius The radius of the circle.
	 */
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

	/**
	 * Holds the edge length of the square.
	 */
	private int size;

	/**
	 * Creates a Square object.
	 * @param size The length of one edge of the square.
	 */
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

	/**
	 * Holds one vertex of the Triangle.
	 */
	private Point point1;
	/**
	 * Holds one vertex of the Triangle.
	 */
	private Point point2;
	/**
	 * Holds one vertex of the Triangle.
	 */
	private Point point3;

	/**
	 * Creates a Triangle object.
	 * @param point1 The location of one vertex of the triangle.
	 * @param point2 The location of one vertex of the triangle.
	 * @param point3 The location of one vertex of the triangle.
	 */
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
	/**
	 * Holds the radius of the sphere.
	 */
	private int radius;

	/**
	 * Creates a Sphere object.
	 * @param radius The radius of the sphere.
	 */
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
		g.drawOval(base.x,base.y,radius*2,radius*2); //3rd and 4th parameters are width and height
	}

}

class Cube extends ThreeDimensionalShape
{
	public String name() { return "Cube"; }
	/**
	 * Holds the length of one edge of the Cube.
	 */
	private int size;

	/**
	 * Creates a Cube object.
	 * @param size The length of one edge of the Cube.
	 */
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
		int offset = size/3;
		g.drawRect((int)base.x,(int)base.y,(int)size,(int)size);
		g.drawRect((int)base.x+offset,(int)base.y+offset,(int)size,(int)size);

		g.drawLine((int)base.x,          (int)base.y,          (int)base.x+offset,          (int)base.y+offset);
		g.drawLine((int)base.x+(int)size,(int)base.y,          (int)base.x+offset+(int)size,(int)base.y+offset);
		g.drawLine((int)base.x,          (int)base.y+(int)size,(int)base.x+offset,          (int)base.y+offset+(int)size);
		g.drawLine((int)base.x+(int)size,(int)base.y+(int)size,(int)base.x+offset+(int)size,(int)base.y+offset+(int)size);
	}

}

class Tetrahedron extends ThreeDimensionalShape
{
	public String name() { return "Tetrahedron"; }
	/**
	 * Holds one vertex of the Tetrahedron.
	 */
	private Point a;
	/**
	 * Holds one vertex of the Tetrahedron.
	 */
	private Point b;
	/**
	 * Holds one vertex of the Tetrahedron.
	 */
	private Point c;
	/**
	 * Holds one vertex of the Tetrahedron.
	 */
	private Point d;

	/**
	 * Creates a Tetrahedron object.
	 * @param a The location of one vertex of the tetrahedron.
	 * @param b The location of one vertex of the tetrahedron.
	 * @param c The location of one vertex of the tetrahedron.
	 * @param d The location of one vertex of the tetrahedron.
	 */
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
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		xPoints[0] = base.x + a.x; yPoints[0] = base.y + a.y;
		xPoints[1] = base.x + b.x; yPoints[1] = base.y + b.y;
		xPoints[2] = base.x + c.x; yPoints[2] = base.y + c.y;
		g.drawPolygon(xPoints,yPoints,3);

		xPoints[0] = base.x + a.x; yPoints[0] = base.y + a.y;
		xPoints[1] = base.x + b.x; yPoints[1] = base.y + b.y;
		xPoints[2] = base.x + d.x; yPoints[2] = base.y + d.y;
		g.drawPolygon(xPoints,yPoints,3);

		xPoints[0] = base.x + a.x; yPoints[0] = base.y + a.y;
		xPoints[1] = base.x + d.x; yPoints[1] = base.y + d.y;
		xPoints[2] = base.x + c.x; yPoints[2] = base.y + c.y;
		g.drawPolygon(xPoints,yPoints,3);

		xPoints[0] = base.x + d.x; yPoints[0] = base.y + d.y;
		xPoints[1] = base.x + b.x; yPoints[1] = base.y + b.y;
		xPoints[2] = base.x + c.x; yPoints[2] = base.y + c.y;
		g.drawPolygon(xPoints,yPoints,3);

	}

}
