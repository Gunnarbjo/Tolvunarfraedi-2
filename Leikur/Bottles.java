import edu.princeton.cs.algs4.*;
import java.util.Scanner;

public class Bottles{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    // Collatz conjecture
    while(n != 1){
      int i = n;
      if(n % 2 == 0){
        n /= 2 ;
      }else{
        n = n*3 +1;
      }
      System.out.println(i + " little bugs in the code. " + i +
       " little bugs in the code. Take one down, patch it around. " + n +
       " bugs in the code fuck em all!! ");
      try{
        Thread.sleep(500);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }
}
