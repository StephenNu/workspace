package assign5Package;

import java.util.ArrayList;

public class ArrayListWithIterators extends AbstractList {
	
	private ArrayList<Integer> table;
	private int numElementsInTable = 0;
	
	@Override
	public AbstractIterator createIterator(int numElements) {
		return new Iterator(numElements);
	}

	@Override
	public void append(int v) {
		if (numElementsInTable == 0)
		{
			table.add(0, v);
			System.out.println("table.get0 = " + table.get(0));
			++numElementsInTable;
		}
		else
		{
			if (table.get(numElementsInTable-1).compareTo(v) >= 0	)
			{
				table.add(v);
				++numElementsInTable;
				System.out.println("table.get(last) = " + table.get(numElementsInTable-1));
			}
			else
			{
				for (int i = 0; i < numElementsInTable; i++)
				{
					if (table.get(i) < v)
					{
						table.add(i, v);
						++numElementsInTable;
					}
					for (int j = 0; j < numElementsInTable; ++j)
						System.out.println("table.get(j) = " + table.get(j));
				}
			}
		}
	}
	
	public ArrayListWithIterators()
	{
		table = new ArrayList<Integer>(100);
	}
	
	public class Iterator extends AbstractIterator
	{
		private ArrayList<Integer> result;
		private int currentElement;
		private int numElementsInResult = 0; // Stores the number of elements in result
		private boolean endOfTable;
		
		public Iterator(int n)
		{
			result = new ArrayList<Integer>(n); // result stores the array to be returned
			for (int i = 0; i < numElementsInTable && i < n; i++){
				result.add(table.get(i));
				++numElementsInResult;
			}
		}

		@Override
		public void first() {
			currentElement = 0;
			if (numElementsInResult > 0) 
				endOfTable = false;
			else 
				endOfTable = true;
		}

		@Override
		public void next() {
			if (currentElement < numElementsInResult - 1)
				currentElement++;
			else 
				endOfTable = true;
		}
		
		@Override
		public boolean isDone() {
			return endOfTable;
		}

		@Override
		public Integer currentItem() {
			return result.get(currentElement);
		}
		
	}

}