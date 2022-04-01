import edu.princeton.cs.algs4.*;
import java.util.HashMap;
import java.util.Map;

public class GraphArithmetic{
    private static Map<Integer,Double> calculated = new HashMap<>();
    public static double calculate(Digraph dg, String[] vertexValues){
      calculated.clear();

      int root = 0;
      for(int i = 0; i < vertexValues.length; i++){
        if(dg.indegree(i) == 0){
           root = i;
           break;
         }
      }
      return partition(root,dg,vertexValues);
    }
    private static double partition(int root, Digraph dg, String[] vertexValues){
        if(calculated.containsKey(root)){
          return calculated.get(root);
        }
      if(vertexValues[root].equals("*")){
        double temp = 1.0;
        for(int w: dg.adj(root)){
          temp *= partition(w,dg,vertexValues);
        }
        calculated.put(root,temp);
        return temp;
      }
      else if(vertexValues[root].equals("+")){
        double temp = 0.0;
        for(int w: dg.adj(root)){
          temp += partition(w,dg,vertexValues);
        }
        calculated.put(root,temp);
        return temp;
      }
      else return Double.parseDouble(vertexValues[root]);
    }


    public static void main(String[] args){
      Digraph dg = new Digraph(9);

      dg.addEdge(0,1);
      dg.addEdge(0,3);
      dg.addEdge(1,2);
      dg.addEdge(1,3);
      dg.addEdge(2,4);
      dg.addEdge(2,5);
      dg.addEdge(3,6);
      dg.addEdge(3,7);
      dg.addEdge(4,7);
      dg.addEdge(4,8);

      String[] values = {"*","*","+","+","*","-1","4","5","2"};
      System.out.println(GraphArithmetic.calculate(dg,values));
    }
}
