import edu.princeton.cs.algs4.*;

public class BST{
  private class Node{
    String key;
    Node left,right;
    int size;
  }
  private Node root;

  public string RandomKey(){
    Node x = root;

    if(x == null) return null;
    while(true){
      double random = Math.random();
      int lsize = 0;
      if(x.left != null) lsize = x.left.size;
      if(random < lsize/((double)size){
        x = x.left;
      }
      else if(random < (lsize + 1)/((double)size)){
        return x;
      }else x.right;
    }
  }
}
