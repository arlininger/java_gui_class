/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;
import java.awt.Point;

/**
 * Implements the Insertion Sort algorithm. 
 */
public class InsertionSort extends Sortable
{
	/**
	 * Holds the offset of the next element to be sorted.
	 * All elements lower than this one are sorted among themselves. The only exception
	 * is what ever element current points to.
	 */
	int next;
	/**
	 * Holds the offset of the element currently being sorted.
	 */
	int current;
	/**
	 * Holds whether there is an element currently being sorted.
	 */
	boolean working;

	
	/**
	 * Create a InsertionSort object. 
	 */
	public InsertionSort()
	{
		super("Insertion Sort");
	}

	/**
	 * Create a InsertionSort object. 
	 * @param size The number of elements in the array to be sorted.
	 */
	public InsertionSort(int size)
	{
		super("Insertion Sort",size);
	}
	
	/**
	 * Reset the internal data.
	 */
	public void reset()
	{
		super.reset();
		next = 1; //technically we start at 0, but the first element is always sorted.
		current = 0;
		working = false;
	}

	/**
	 * Get the prefered position of this algorithm.
	 * Used to initially display all algorithms in a somewhat tiled position.
	 */
	public Point getPreferedPosition()
	{
		return new Point(500,200);
	}

	/**
	 * Take one more step in the Insertion sort algorithm.
	 */
	public boolean sortStep()
	{
		if (working == false && next == size)
		{
			return false;
		}
		if (working == true)
		{
			if (array[current] < array[current-1])
			{ //swap the elements
				array[current] ^= array[current-1];
				array[current-1] ^= array[current];
				array[current] ^= array[current-1];
			}
			current--;
			if (current == 0)
			{
				working = false;
			}
		} else {
			current = next;
			next++;
			working = true;
		}
		return true;
	}

	/**
	 * Return the proper color for the item at a given index.
	 * @param index The entry to be colored.
	 */
	public Color getColor(int index)
	{
		if (index == current)
		{
			return Color.BLUE;
		} else if (index == next)
		{
			return Color.RED;
		} else {
			return Color.BLACK;
		}
	}

}
