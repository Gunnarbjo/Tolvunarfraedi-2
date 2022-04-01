import edu.princeton.cs.algs4.*;

public class ModifiedBinarySearch {
  public static int indexOf(int[] a, int key){
    //Binary search
    int lo = 0;
    int hi = a.length-1;

  /*  if(a.length > 2){
      if(a[0] == key){
        return 0;
      }else if(a[1] == key){
        return 1;
      }
      return -1;
    }*/

    while(lo <= hi){
      int mid = lo + (hi-lo)/2;
      if(key < a[mid]) hi = mid-1;
      else if(key > a[mid]) lo = mid+1;
      else if(mid != 0 && a[mid-1] == key){
        hi = mid;
      }
      else return mid;

    }
    return -1;
  }

  public static void main(String[] args){
    int[] a = {1,1,2,3,4,4};
    StdOut.println(indexOf(a,1));
    StdOut.println(indexOf(a,2));
    StdOut.println(indexOf(a,4));
  }
}
