import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BinaryHeap implements PriorityQueue{
	private class HeapData{
		private String data;
		private int priority;

		protected HeapData(String dat,int pri){
			data = dat;
			priority = pri;
		}
		protected String getData()
		{
			return this.data;
		}
		protected int getPri()
		{
			return this.priority;
		}

		protected void changePriority(int newPri){
			priority = newPri;
		}
		// Add additional functions here as necessary
		}

	private HeapData[] heap; 
	private int size;
	private Comparator<HeapData> comparator;

	public BinaryHeap(){
		this.heap = null;
		size = 0;
	}

	public BinaryHeap(int startArray){
		heap = new HeapData[startArray +1];//start index is 1 so must increase by 1
		size = 0;
	}
	public HeapData[] resize(int newLength)
	{
		return Arrays.copyOf(heap, size + newLength);
	}

	public boolean isEmpty(){
		return heap[1] == null;
	}

	public int size(){

		return this.size;
	}

	public String findMin(){
		if(isEmpty()) 
			throw new NullPointerException("Sorry. Queue is empty");
		return heap[1].getData();

	}

	public void insert(String data , int pri)
	{
			HeapData item = new HeapData(data , pri);
			if(this.size >= heap.length-1)
				heap = this.resize(heap.length+1);//resizes the array if all spots are filled 
			heap[++size] = item;
			int pos = size;
			while (pos != 1 && item.priority < heap[pos/2].priority)
			{
				heap[pos] = heap[pos/2];
				pos  = pos/2;
			}
			heap[pos] = item;    
	}



	public void makeEmpty(){
		try{
		for(HeapData elements: heap)
		{
			elements.equals(null);
		}
		}catch(NullPointerException e)
		{
			System.out.println("The Queue is now emptied");
		}
	}

	public boolean changePriority(String data, int newPri){
		boolean holder = false;
		for(HeapData obj : heap)
		{
			if(obj.getData() == data)
			{
				obj.priority = newPri;
				
				holder = true;
			}
			
		}
		return holder;
	}
	

	 public String deleteMin()
	    {
		 	String error = "Queue is empty";
	        int parent;
	        int child;
	        HeapData item;
	        HeapData temp;
	        item = heap[1];//root node
	        temp = heap[size--];//last node 
	        parent = 1;
	        child = 2;
	        try{
	        while (child <= size)//traversing rest of array 
	        {
	            if (child > size && heap[child].priority > heap[child + 1].priority)
	                child++;
	            if (temp.priority <= heap[child].priority)
	                break;
	 
	            heap[parent] = heap[child];
	            parent = child;
	            child *= 2;
	        }
	        heap[parent] = temp;
	        return item.data;
	        }catch(Exception e)
	        {
	        	return error;
	        }
	 
	    }
}
