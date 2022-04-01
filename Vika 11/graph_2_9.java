import edu.princeton.cs.algs4.*;


public class graph_2_9{
//Write a method that checks whether or not a given permutation of vertices
//is a topological order of that DAG.
/*

  //Þessi aðferð virkar ekki ef nóðan sem vísað er í er stærri en lengd visited
  //fylkisins

    public boolean checkorder(Diagraph dg, Integer[] topologicalOrder){

      if(dg == null) return true;
      if(topologicalOrder.length < dg.V()) return false;

      boolean[] visited = new boolean[dg.V()];

      for(int i = 0; i = topologicalOrder.length; i++){
        for(int node; dg.adj(topologicalOrder)){
          if(visited[node]) return false;
        }
        visited[topologicalOrder] = true;
      }
      return true;
    }
*/
      public static boolean checkOrder(Digraph dg, Integer[] topologicalOrder){
      //jaðartilvik

      if(dg == null) return true;
      if(topologicalOrder.length < dg.V()) return false;

      for(int i = topologicalOrder.length-1; i >= 0; i--){
        for(int node: dg.adj(topologicalOrder[i])){
          for(int j = i-1;j >= 0; j-- ){
            if(node == topologicalOrder[j]) return false;
          }
        }
      }
      return true;
    }
}
