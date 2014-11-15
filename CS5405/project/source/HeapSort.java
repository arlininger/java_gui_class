/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;

public class HeapSort extends Sortable
{
	int heapSize;
	public HeapSort()
	{
		super("Heap Sort");
	}

	public HeapSort(int size)
	{
		super("Heap Sort",size);
	}
	
	public void reset()
	{
		super.reset();
		System.out.println("Heap Reset");
		heapSize = size;

	}

	int max(int x, int y, int z)
	{
		if (x >= y && x >= z) return x;
		if (y >= x && y >= z) return y;
		if (z >= x && z >= y) return z;
		return -1;
	}

	void maxHeapify(int start)
	{
		int l = leftChild(start);
		int r = rightChild(start);
		int largest = start;
		if (l < heapSize && l > 0 && array[l] > array[start])
		{
			largest = l;
		}
		if (r < heapSize && r > 0 && array[r] > array[largest])
		{
			largest = r;
		}
		if (largest != start)
		{
			swap(largest,start);
			repaint();
			sleep();
			maxHeapify(largest);
		}
	}

	void buildMaxHeap()
	{
		for (int i = size-1; i >= 0; i--)
		{
			maxHeapify(i);
		}
	}

	void sort()
	{
		buildMaxHeap();
		for (int i = size-1; i >= 0; i--)
		{
			swap(0,i);
			repaint();
			sleep();
			heapSize--;
			maxHeapify(0);
		}
	}

	public void run()
	{
		while (true)
		{
			if (running)
			{
				sort();
				System.out.printf("No Longer running\n");
				running = false;
			}
			repaint();
			sleep();
		}
	}

	public boolean sortStep()
	{
		return true;
	}

	int parent(int x)
	{
		return (x-1)/2;
	}

	int leftChild(int x)
	{
		return x*2 + 1;
	}
	int rightChild(int x)
	{
		return x*2 + 2;
	}

	public Color getColor(int index)
	{
			return Color.BLACK;
	}

}
