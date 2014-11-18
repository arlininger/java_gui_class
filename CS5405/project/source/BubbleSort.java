/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;
import java.awt.Point;

/**
 * Implements the Bubble Sort algorithm. 
 */
public class BubbleSort extends Sortable
{
	int i;
	int j;

	/**
	 * Create a BubbleSort object. 
	 */
	public BubbleSort()
	{
		super("Bubble Sort");
	}

	/**
	 * Create a BubbleSort object of the given size. 
	 * @param size The number of elements in the array to be sorted.
	 */
	public BubbleSort(int size)
	{
		super("Bubble Sort",size);
	}
	
	/**
	 * Reset the object.
	 */
	public void reset()
	{
		super.reset();
		i = size;
		j = 0;
	}

	/**
	 * Get the prefered position of this algorithm.
	 * Used to initially display all algorithms in a somewhat tiled position.
	 */
	public Point getPreferedPosition()
	{
		return new Point(0,400);
	}

	/**
	 * Take one step in BubbleSort.
	 */
	public boolean sortStep()
	{
		if (i == 0)
		{
			return false;
		}
		if (array[j] > array[j+1])
		{
			this.swap(j,j+1);
			//array[j] ^= array[j+1];
			//array[j+1] ^= array[j];
			//array[j] ^= array[j+1];
		}
		j++;
		if (j >= i-1)
		{
			j = 0;
			i--;
		}
		return true;
	}

	/**
	 * Return the proper color for the item at a given index.
	 * @param index The entry to be colored.
	 */
	public Color getColor(int index)
	{
		if (index == i)
		{
			return Color.BLUE;
		} else if (index > i)
		{
			return Color.GREEN;
		} else if (index == j)
		{
			return Color.RED;
		} else {
			return Color.BLACK;
		}
	}

}
