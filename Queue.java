
public class Queue 
{
  static Node head;
  static Node tail;
  public Queue()
  {
	  head = null;
	  tail = null;
  }
  public static void main(String[] args)
  {
	  enQueue(12);
	  enQueue(13);
	  enQueue(14);
	  peek();
	  //deQueue(head);
	  peek();

	  
  }
  static Node deQueue(Node item)
  {
	  if(head != null)
	  {
		 item = head;
		 head = head.link;
		 return item;
	  }
	  return null;
  }
  void enQueue(Node item)
  {
	  item = new Node();
	  if(head== null)
	  {
		  tail = item;
		  head = item;
	  }
	  else{
		  tail.link = item;
		  tail = tail.link;
	  }
  }
  public static void enQueue(int data)//adds to the back of the list
  {
	  Node item = new Node(data);
	  if(head == null)//list is empty
	  {
		  head = item;
		  tail = item;
	  }
	  else
	  {
		  item.link = tail;
		  tail = item;
	  }		  
  }

	 

 public static void peek()
 {
	 if(head == null)
	 {
		 System.out.println("The list is empty");;
	 }
	 else
	 {
		System.out.println(head.data); 
	 }
	 
 }
}
