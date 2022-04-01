import edu.princeton.cs.algs4.*;

public class printTwoStrings{

  public static void twoArray(int[] a, int[] b){
    int cnta = 0;
    int cntb = 0;

    for(int i = 0; i < (a.length + b.length); i++){
      if(a.length == cnta){
        StdOut.print(b[cntb]);
        cntb++;
      }
      else if(b.length == cntb){
        StdOut.print(a[cnta]);
        cnta++;
      }
      else if(a[cnta] > b[cntb]){
        StdOut.print(b[cntb]);
        cntb++;
      }
      else{
        StdOut.print(a[cnta]);
        cnta++;
      }
      StdOut.print(", ");
    }
  }

  public static void main(String[] args){

    int[] a = {1,2,4,5,6,7,8,9,12};
    int[] b = {0,2,5,6,7,9,14};

    twoArray(a,b);


  }

}
