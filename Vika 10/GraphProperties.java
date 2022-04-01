import edu.princeton.cs.algs4.*;

public class GraphProperties{
  private int[] eccentricity;
  private int[] visited = new int[100000];
  private int diameter;
  private int radius;
  private int center;
  private Graph G;


  private GraphProperties(Graph G){
    this.G = G;

  }
  private int eccentricity(int v){
    if(isConnected(0,G.length,visited) == false){
      return 0;
    }
    return eccentricity(v);
  }
  private int diameter(){
    return diameter;
  }
  private int radius(){
    return radius;
  }
  private int center(){
    return center;
  }

  private boolean isConnected(int n, int end,int[] visited){
    for (int i = 0; i < G.length -1; i++) {
      if (G[i] == 1 && visited[i] == 0) {
          visited[i] =1;
          if (isConnected(i, end, visited)) return true;
          else return false;

      }
    }
  }

  public static void main(String[] args){

  }
}
