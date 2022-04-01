import edu.princeton.cs.algs4.*;

public class Degrees{
  Digraph G;

  public Degrees(Digraph G){
    this.G = G;
  }
  public int indegree(int v){
    return G.indegree(v);
  }
  public int outdegree(int v){
    return G.outdegree(v);
  }
  public Iterable<Integer> sources(){
    Queue<Integer> q = new Queue<Integer>();
    for (int i = 0;i < G.V() ;i++) {
      if(G.indegree(i) == 0) q.enqueue(i);
    }
    return q;
  }
  public Iterable<Integer> sinks(){
    Queue<Integer> q = new Queue<Integer>();
    for (int i = 0;i < G.V(); i++) {
      if(G.outdegree(i) == 0) q.enqueue(i);
    }
    return q;
  }
  public boolean isMap(){
    for(int i = 0; i < G.V(); i++){
      if(G.outdegree(i) != 1) return false;
    }
    return true;
  }
}
