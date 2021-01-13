package xdatastructures.lists;

class DoublyLinkedList {
    class Node{
        int data;
        Node nextElement;
        Node previousElement;
    }

   
  //checks if the list is empty
  public boolean isEmpty(){
  if(headNode==null)
    return true; //is empty  
  
  return false; //is not empty
  }
  
  //prints the list 
  public boolean printList(){  
    if(isEmpty()) {
      System.out.println("List is Empty");
      return false;
    }    
    Node temp=headNode; //temp used to traverse the list
     
    while(temp.nextElement!=null){ //traverse the list till the end
       System.out.print(temp.data+"->");
       temp=temp.nextElement; //move to the next node
    }
    System.out.println(temp.data+"->null");
    return true;    
  } //end of print list
  
  public void insertAtHead(int dt){
    //create node and put in the data
    Node newNode = new Node(); 
    newNode.data = dt;
  
    // Make next of new node as head and previous as NULL
    newNode.nextElement = headNode; 
    newNode.previousElement = null; 
  
    //Change previous of head node to new node
    if (headNode != null) 
        headNode.previousElement = newNode; 
  
    //move the head to point to the new node
    headNode = newNode; 
  }
  
  //delete the head node
 public String deleteAtHead() {

   //Get Head of List  
   Node head = this.headNode;

   //if List is not empty then link head to the
   //nextElement of firstElement.
   if (head != null) {
     this.headNode = head.nextElement;
     this.headNode.previousElement = null;
   }
   return elements(this);
 }


  public static String elements(DoublyLinkedList list) {

      String elementsList = "";

      Node start = list.headNode;

      while (start != null) {
        elementsList += start.data;
        elementsList += "->";
        start = start.nextElement;
      }

      elementsList += "null";
      return elementsList;
  }
      
     
  public String delete(int value) {

    if (this.isEmpty()) {
        System.out.println("List is Empty");
        return elements(this);
    }
  //if list is not empty, start traversing it from the head
    Node currentNode = this.headNode;

    if (currentNode.data == value) {
        deleteAtHead();
          return elements(this);
    }
    //Traversing/Searching for Node to Delete
    while (currentNode != null) {

        //Node to delete is found
        if (value == currentNode.data) {
                  //delete the found node
            currentNode.previousElement.nextElement = currentNode.nextElement;
          
            if(currentNode.nextElement != null)
                currentNode.nextElement.previousElement = currentNode.previousElement;

            return elements(this);
        }
        
        currentNode = currentNode.nextElement;
      }
      return elements(this);
  }//end of delete()


  public static void main(String args[]) {
		DoublyLinkedList list = new DoublyLinkedList();

		for (int i = 1; i <= 10; i++) {
			list.insertAtHead(i);
		}
    System.out.println("Original List:" + elements(list));
    
    System.out.println("After deleting 10 from List:" + list.delete(10));
    System.out.println("After deleting 1 from List:" + list.delete(1));
    System.out.println("After deleting 5 from List:" + list.delete(5));
	} //end of main method
  
	private Node headNode;
}