//This is a linked list implementation using a Train Car as the "node"
public class LinkedListImplementation 
{
	public TrainCar firstCar = null;
	public TrainCar lastCar = null;
	
	LinkedListImplementation()//first link is always a null value
	{
		firstCar = null;
		lastCar = null;
	}
	 public boolean isEmpty()//checks to see if the Linked List is empty
	 {
		 return(firstCar.equals(null));
	 }
	 public boolean iCircular(TrainCar first)
	 {
		 TrainCar slow = first;
		 TrainCar fast = first;
		 while(fast != null && fast.link != null)
		 {
			 slow = slow.link;
			 fast = fast.link.link;
			 if(slow == fast)
				 return true;
		 }
		 return false;
	 }
	 public void inputSpecific()
	 {
		TrainCar current = firstCar;
		int cnt = 0;
		 while (cnt < 4 && current !=
		 null)
		 {
		 current = current.link;
		 cnt++;
		 }
		 if (current != null)
		 current.carNumber = 10;
	 }
	 public void getLength()
	 {
		 double length = 0;
		 TrainCar car = firstCar;
		 while(car != null)
		 {
			 length +=1;
			 car = car.link;
		 }
		 System.out.println(length);
	 }
	/**
	 * adds a car to the train 
	 * @param item
	 */
	 public void reverse1(TrainCar first)
	 {
		 TrainCar current, prev , next;
		 current = first;
		 prev = null;
		 next = null;
		 while(current != null)
		 {
			 next = current.link;
			 current.link = prev;
			 prev = current;
			 current = next;
			 
		 }
	 }

	 public void reverse(TrainCar car) 
	 {
	      TrainCar currentCar = firstCar;
	      TrainCar nextCar = null;
	      TrainCar previousCar = null;
	      while(currentCar != null)
	      {
	    	  nextCar = currentCar.link;
	    	  currentCar.link = previousCar;
	    	  previousCar = currentCar;
	    	  currentCar = nextCar;
	      }
	      firstCar = previousCar;
	      displayTrain();
	 }
	 
	 public void addCar(TrainCar item)
	 {
		 if(firstCar == null)//list is emtpy
		 {
			 firstCar = item;
			 lastCar = item;
		 }
		 else
		 {
			 lastCar.link = item;
			 lastCar = item;
		 }
	 }
	 /**
	  * adds a car to the front of the train 
	  * @param item
	  */
	 public void addToFront(TrainCar item)
	 {
		 if(firstCar == null)//list is empty
		 {
			 firstCar = item;
			 lastCar = item;
			 
		 }
		 else
		 {
			 TrainCar temp = firstCar;
			 firstCar = item;
			 item.link = temp;
		 }
	 }
	 /**
	  * removes the first car in the train 
	  * @return
	  */
	 public TrainCar removeFirstCar()//
	 {
		 TrainCar carReference = firstCar;
		 if(!isEmpty())
		 {
			 firstCar = firstCar.link;
		 }
		 else
		 {
			 System.out.print("There are no train cars");
		 }
		 return carReference;
	 }
	 /**
	  * displays all the cars with descriptions in the train 
	  */
	 public void displayTrain()//displays the cars in the train 
	 {
		 TrainCar car = firstCar;
		 while(car != null)
		 {
			 System.out.println("The next car is " + car.carNumber);
			 car.display();
			 System.out.println();
			 car = car.link;
		 }
		 
	 }
	 /**
	  * method that iterates through the train and returns the total weight load
	  * @return
	  */
	 public double getTotalWeight()
	 {
		 double weight = 0;
		 TrainCar car = firstCar;
		 while(car != null)
		 {
			 weight = weight + car.weightCapacity;
			 car = car.link;
		 }
		 return weight;
	 }
	 /**
	  * iterates through the entire train and returns the type of cargo that the train is holding 
	  * @return
	  */
	 public String getCargo()
	 {
		 String temp = " ";
		 TrainCar car = firstCar;
		 while( car != null)
		 {
			 temp = temp + car.cargoType + " ";
			 car = car.link;
		 }
		 return temp;
	 }
	 
	 public TrainCar findCar(String cargo)//finds a specific car in the train 
	 {
		 TrainCar car = firstCar;
		 if(!isEmpty())
		 {
			 while(!car.cargoType.equals(cargo))
			 {
				 if(car.link ==null)//checks if we are at the end of the list 
				 {
					 return null;//train car is not found 
				 }
				 else
				 {
					 car = car.link;//train car was found 
				 }
			 }
		 }
		 else
		 {
			 System.out.println("The train is empty");
		 }
		 System.out.println("The car was found");
		 return car;
	 }
	 int findMax()
	 {
		 TrainCar temp = firstCar;
		 if(temp==null)
			 return -1;//list empty
		 else
		 {
			 int max = temp.carNumber;
			 while(temp.link != null)
			 {
				 if(max < temp.link.carNumber)
					 max = temp.link.carNumber;
				 temp = temp.link;
			 }
			 return max;
		 }
	 }
	 
	
	 public TrainCar createLL(int[] a)
	 {
		 TrainCar head = new TrainCar();
		 head.carNumber = a[a.length -1];
		 head.link = null;
		 for(int i = a.length -2; i >= 0; i--)
		 {
			 TrainCar n = new TrainCar();
			 n.carNumber = a[i];
			 n.link = head.link;
		 }
		 return head;  
	 }
	 public boolean findOrder(TrainCar car)
	 {
		 if(car == null | car.link == null)
		 {
			 return true;
		 }
		 if(car.carNumber > car.link.carNumber)//returns false if descending order
		 {
			 return false;
		 }
		 return findOrder(car.link);
	 }
	
}
