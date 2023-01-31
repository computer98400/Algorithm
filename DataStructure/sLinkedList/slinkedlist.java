public class slinkedlist {

  private int data;
  private slinkedlist next;
  public slinkedlist(int data){
    this.data = data;
  }
  public void setData(int data){
    this.data = data;
  }
  public int getData(){
    return data;
  }
  public void setNext(slinkedlist next){
    this.next =next;
  }
  public slinkedlist getNext(){
    return this.next;
  }

  int ListLength(slinkedlist headNode){
    int length = 0;
    slinkedlist current = headNode;
    while(current != null){
      length++;
      current = current.getNext();
    }
    return length;
  }

  slinkedlist Insert(slinkedlist head, slinkedlist nodetoInsert, int position){
    if(head == null){
      return nodetoInsert;
    }

    int size = ListLength(head);
    if(position > size+1 || position < 1){
      System.out.println("Position of node to insert is invalid.  the valid inputs are 1 to "+(size+1));
      return head;
    }

    if(position == 1){
      nodetoInsert.setNext(head);
      return nodetoInsert;
    }else{
      slinkedlist previousNode = head;
      int count =1;
      while(count < position-1){
        previousNode = previousNode.getNext();
        count++;
      }

      slinkedlist current = previousNode.getNext();
      nodetoInsert.setNext(current);
      previousNode.setNext(nodetoInsert);
    }

    return head;
  }
}