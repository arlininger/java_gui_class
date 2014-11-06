/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;

public class SelectionSort extends Sortable
{
	/**
	 * Holds the offset of the element currently being sorted.
	 */
	int current;
	int current_min;
	int selector;
	/**
	 * Holds whether there is an element currently being sorted.
	 */
	boolean working;
	public void reset()
	{
		super.reset();
		current = 0;
		current_min = 0;
		selector = 0;
	}

	public boolean sortStep()
	{
	//	System.out.printf("Current %d\nMin: %d\nSelector: %d\n", current, current_min, selector);
		selector++;
		if (current == size)
		{
			return false;
		}
		if (selector == size)
		{ //swap the elements
			array[current] ^= array[current_min];
			array[current_min] ^= array[current];
			array[current] ^= array[current_min];
			current++;
			current_min = current;
			selector = current;
		} else if (array[current_min] > array[selector])
		{
			current_min = selector;
		}
		return true;
	}

	public Color getColor(int index)
	{
		System.out.printf("Current %d\nMin: %d\nSelector: %d\n", current, current_min, selector);
		if (index < current)
		{
			return Color.GREEN;
		} else if (index == current)
		{
			return Color.BLUE;
		} else if (index == current_min)
		{
			return Color.YELLOW;
		} else if (index == selector)
		{
			return Color.RED;
		} else {
			return Color.BLACK;
		}
	}

}
