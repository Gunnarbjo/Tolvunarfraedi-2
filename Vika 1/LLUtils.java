import edu.princeton.cs.algs4.*;

public class LLUtils{

  public static LLNode findLast(LLNode first, String strengur){

    LLNode lastItem = null;

    for(LLNode x = first; x != null; x = x.next){
      if(x.item.equals(strengur)){
        lastItem = x;
      }
    }

    return lastItem;
  }

  public static LLNode removeLast(LLNode first) {

    if(first == null|| first.next == null){
      return null;
    }

    LLNode x;
    for(x = first; x.next.next != null; x = x.next){}

      x.next= null;

      return first;
  }
  public static void printList(LLNode first){

    //for(int i = 0; i < n; i++)
    for(LLNode x = first; x != null; x = x.next){
      StdOut.print(x.item);
      if(x.next != null){
      StdOut.print(" --> ");
      }
    }
    StdOut.print("\n");
  }

  public static void main(String[] args) {
    LLNode n1 = new LLNode();
    n1.item = "1";

    LLNode n2 = new LLNode();
    n2.item = "2";
    n1.next = n2;

    LLNode n3 = new LLNode();
    n3.item = "3";
    n2.next = n3;

    LLNode n4 = new LLNode();
    n4.item = "4";
    n3.next = n4;

    //printList(n1);
    //LLNode ret = removeLast(n1);
    LLNode test = findLast(n1, "2");
    printList(test);
  }
}
