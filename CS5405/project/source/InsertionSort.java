/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;

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
	public void reset()
	{
		super.reset();
		next = 1; //technically we start at 0, but the first element is always sorted.
		current = 0;
		working = false;
	}

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
