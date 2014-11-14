/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;

public class MergeSort extends Sortable
{
	int sortedIndex;

	public MergeSort()
	{
		super("Merge Sort");
	}

	public MergeSort(int size)
	{
		super("Merge Sort",size);
	}
	
	public void reset()
	{
		super.reset();
	}

	public boolean sortStep()
	{
		return true;
	}

	private void sort(int lower, int upper)
	{
		if (upper - lower >= 1)
		{
			int midpoint = lower + (upper - lower) / 2; //Goes in the "left" half
			sort(lower, midpoint);
			sort(midpoint + 1, upper);
			merge(lower, midpoint, upper);
		}
	}

	private void merge(int lower, int midpoint, int upper)
	{
		int newArray[] = new int[upper-lower+1];
		int leftIndex = lower;
		int rightIndex = midpoint + 1;
		int nextSpot = 0;
		//System.out.printf("Merge: %d %d %d\n",lower, midpoint, upper);
		while (leftIndex <= midpoint && rightIndex <= upper)
		{
			if (array[leftIndex] < array[rightIndex])
			{
				newArray[nextSpot] = array[leftIndex];
				//System.out.printf("Adding value %d in spot %d ovar %d\n",newArray[nextSpot],nextSpot,array[rightIndex]);
				leftIndex++;
			} else {
				newArray[nextSpot] = array[rightIndex];
				//System.out.printf("Adding value %d in spot %d over %d\n",newArray[nextSpot],nextSpot,array[leftIndex]);
				rightIndex++;
			}
			nextSpot++;
			repaint();
			sleep();
		}
		while (leftIndex <= midpoint)
		{
			newArray[nextSpot] = array[leftIndex];
				//System.out.printf("Adding value %d in spot %d\n",newArray[nextSpot],nextSpot);
			nextSpot++;
			leftIndex++;
			repaint();
			sleep();
		}
		while (rightIndex <= upper)
		{
			newArray[nextSpot] = array[rightIndex];
				//System.out.printf("Adding value %d in spot %d\n",newArray[nextSpot],nextSpot);
			nextSpot++;
			rightIndex++;
			repaint();
			sleep();
		}
		for (int i = lower; i <= upper; i++)
		{
			array[i] = newArray[i-lower];
			//System.out.printf("    %d\n",array[i]);
			repaint();
			sleep();
		}
	}

	public void run()
	{
		while (true)
		{
			if (running)
			{
				sort(0,size-1);
				running = false;
			}
			sleep();
		}
	}

	public Color getColor(int index)
	{
		return Color.BLACK;
	}

}

class MergeSortStage
{
	public int lowerBound;
	public int upperBound;
	public boolean sorted;

	public MergeSortStage(int left, int right, boolean isSorted)
	{
		lowerBound = left;
		upperBound = right;
		sorted = isSorted;
	}
}

