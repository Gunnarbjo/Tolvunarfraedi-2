import edu.princeton.cs.algs4.*;

public class Triplicate{
  public static String triplicate(String[] a,String[] b,String[] c){
    //Return the empty string if no match is found
    String repeat = "";

    Merge.sort(a);
    Merge.sort(b);
    Merge.sort(c);

    for (int i = 0; i < a.length; i++){
      int lob = 0;
      int loc = 0;
      int hib = b.length-1;
      int hic = c.length-1;
      while(lob <= hib){
        int midb = lob + (hib-lob)/2;
        if(a[i].compareTo(b[midb]) < 0){
          hib = midb - 1;
        }
        else if(a[i].compareTo(b[midb]) > 0){
          lob = midb + 1;
        }else{
            while(loc <= hic){
              int midc = loc + (hic-loc)/2;
              if(a[i].compareTo(c[midc]) < 0){
                hic = midc-1;
              }
              else if(a[i].compareTo(c[midb]) > 0){
                loc = midc+1;
              }else{
                return a[i];
              }
            }
            break;
        }
      }
    }
    return repeat;
  }

     public static void main(String[] args){
       String[] a = {"a","b","k","f","c"};
       String[] b = {"b"};
       String[] c = {"e","b","c","f"};
       StdOut.println(triplicate(a,b,c));
     }

}
