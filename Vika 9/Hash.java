import edu.princeton.cs.algs4.*;
import java.util.HashSet;
import java.util.Set;

public class Hash{

  private int[] function(){
    int [] value = new int[2];
    int[] letterValues = {83,69,65,82,67,72,88,77,80,86};

    for (int m = letterValues.length; m <= 26; m++){
      for(int a = 1; a < m; a++){
        Set<Integer> hashSet = new HashSet<>();
          for(int letterValue : letterValues){
            int hashValue = hashvalue(a,letterValue,m);
            hashSet.add(hashValue);
          }
          if(hashSet.size() == 10){
            value[0] = a;
            value[1] = m;
            return value;
          }
        }
      }
      return null;
  }

  private int hashvalue(int a, int k, int m){
    return (a * k) % m;
  }

  public static void main(String[] args){
    Hash hash = new Hash();
    int[] value = hash.function();

    if(value != null){
      System.out.println("a er " + value[0]);
      System.out.println("M er " + value[1]);
    }
  }
}
