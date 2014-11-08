/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;
import java.util.*;

public class QuickSort extends Sortable
{
	boolean sorting;
	int pivot;
	int pivotValue;
	int left;
	int right;
	int i;
	int storeIndex;
	Stack<QuickSortStage> st;

	public QuickSort()
	{
		super("Quick Sort");
	}

	public QuickSort(int size)
	{
		super("Quick Sort",size);
	}
	
	public void reset()
	{
		super.reset();
		st = new Stack<QuickSortStage>();
		st.push(new QuickSortStage(0,size-1));
		sorting = false;
		pivot = -1;
		pivotValue = -1;
		left = 0;
		right = size-1;
		i = 0;
		storeIndex = 0;
		//System.out.println("Quick Reset");
	}

	public boolean sortStep()
	{
		if (st.empty() && sorting == false)
		{
//			for(int i = 0; i < size; i++)
//			{
//				System.out.printf("%d %d\n",i,array[i]);
//			}
//			while (true) ;
			return false;
		}
		if (!sorting)
		{
			//System.out.println("Pivoting");
			QuickSortStage temp = st.pop();
			left = temp.lowerBound;
			right = temp.upperBound;
			pivot = choosePivot(left, right);
			pivotValue = array[pivot];
			sorting = true;
			i = left;
			swap(pivot,right);
			storeIndex = left;
			System.out.printf("left %d, right %d, pivot %d pivotValue %d\n",left, right, pivot, pivotValue);
		} else if (i < right)
		{
			//System.out.format("Sorting position %d %n", i);
			if (array[i] < pivotValue)
			{
				swap(i,storeIndex);
				storeIndex++;
			}
			i++;
		} else { //array split in half now, shift pivot back to location
			swap(storeIndex,right);
			System.out.printf("%d %d\n",storeIndex,array[storeIndex]);
			if (storeIndex == array[storeIndex])
			{
				if (storeIndex+1 <= right) st.push(new QuickSortStage(storeIndex+1,right));
				if (storeIndex-1 >= left) st.push(new QuickSortStage(left,storeIndex-1));
			} else {
				System.out.printf("Got bad result\n");
			}
			sorting = false;
		}
		return true;
	}

	public Color getColor(int index)
	{
		return Color.BLACK;
	}

	private int choosePivot(int left, int right)
	{
		return right;
	}

}

class QuickSortStage
{
	public int lowerBound;
	public int upperBound;

	public QuickSortStage(int left, int right)
	{
		lowerBound = left;
		upperBound = right;
	}
}
