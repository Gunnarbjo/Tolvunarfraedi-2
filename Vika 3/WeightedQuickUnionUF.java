import edu.princeton.cs.algs4.*;

public class WeightedQuickUnionUF{
  private int[] id; // parent link (site indexed)
  private int[] sz; // size of component for roots (site indexed)
  private int count; // number of components
  public WeightedQuickUnionUF(int N){
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++){
      id[i] = i;
    }
    sz = new int[N];
    for (int i = 0; i < N; i++){
       sz[i] = 1;
     }
  }
  //Bætum við staðfestunar testi til þess að sýna ef reynt er að fara útfyrir
  private void validate(int p) {
      int n = id.length;
      if (p < 0 || p >= n) {
          throw new IllegalArgumentException("rótin " + p + " er ekki milli 0 og " + (n-1));
      }
  }
  public int count(){
    return count; }
  public boolean connected(int p, int q){
    return find(p) == find(q); }
  private int find(int p){
    // Follow links to find a root.
    //staðfestum að p sé gilt
    validate(p);
    //finnum efstu rótina
    int root = p;
    while(root != id[root]){
      root = id[root];
    }
    //færum töluna upp í efstu rótina
    while (p != root){
      int newp = id[p];
       id[p] = root;
       p = newp;
     }
    return root;
  }
  public void union(int p, int q){
    int rootp = find(p);
    int rootq = find(q);

    if (rootp == rootq){
       return;
     }
    // Make smaller root point to larger one.
    if (sz[rootp] < sz[rootq]) {
       id[rootp] = rootq; sz[rootq] += sz[rootp];
     }
    else {
      id[rootq] = rootp; sz[rootp] += sz[rootq];
    }
    count--;
  }
  //Bætum við main falli til þess að geta prufað og séð hvað var að gerast
  public static void main(String[] args){
    int n = StdIn.readInt();
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (uf.find(p) == uf.find(q)){
         continue;
       }
      uf.union(p,q);
      StdOut.println(p + " " + q);
        }
      StdOut.println(uf.count() + " components");
  }
}
