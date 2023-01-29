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
}