import edu.princeton.cs.algs4.*;
import java.util.Scanner;

public class Bottles2{
  public static int Bottles(int n){
    // Collatz conjecture
    int s = n;
    Stopwatch clock = new Stopwatch();
    StdOut.println("Input is now: " + s);
    int cnt = 0;
    while(n != 1){
      int i = n;
      if(n % 2 == 0){
        n /= 2 ;
        cnt++;
      }else{
        n = n*3 +1;
        cnt++;
      }
      /*System.out.println(i + " little bugs in the code. " + i +
       " little bugs. Track down one, fix it real good. " + n +
       " bugs in the code what the fuck!?! ");*/
    /*  try{
        Thread.sleep(1000);
      }catch(InterruptedException e){
        e.printStackTrace();
      }*/
    }
      StdOut.println("Number of repeat was: " + cnt);
      double time = clock.elapsedTime();
      StdOut.println("Time it took to run: " + time);
      return Bottles(s+1);
}
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    StdOut.println("This is a counter for Collatz conjecture");
    Bottles(n);


    }

}
