import edu.princeton.cs.algs4.*;

public class Bacon{
  private static void baconHistogram(String filename, String delimiter, String source){
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.graph();
        if (!sg.contains(source)) {
            StdOut.println(source + " not in database.");
        }
        int index = sg.indexOf(source);
        BreadthFirstPaths bfp = new BreadthFirstPaths(G, index);
        int max = 500;
        int[] hist = new int[max + 1];
        for (int v = 0; v < G.V(); v++) {
            int bacon = Math.min(max, bfp.distTo(v));
            hist[bacon]++;
            if (bacon/2 >= 7 && bacon < max)
                StdOut.printf("%d %s\n", bacon/2, sg.nameOf(v));
        }
        for (int i = 0; i < max; i += 2) {
            if (hist[i] == 0) break;
            StdOut.printf("%3d %8d\n", i/2, hist[i]);
        }
        StdOut.printf("Inf %8d\n", hist[max]);
  }
  private static void baconNr(String filename, String delimiter, String source, String movie){
    SymbolGraph sg = new SymbolGraph(filename, delimiter);
    Graph G = sg.graph();
    if (!sg.contains(source)) {
        StdOut.println(source + " not in database.");
      }
      int index = sg.indexOf(movie);
      for(int i : G.adj(index)){
        BreadthFirstPaths bfp = new BreadthFirstPaths(G,i);
        StdOut.printf("|%-20s|Bacon tala: %d| \n",sg.nameOf(i),bfp.distTo(sg.indexOf(source))/2);
      }
    }

  public static void main(String[] args) {
    //festi breyturnar þar sem við erum bara að keyra með sömu breyturnar
    //ef ekki á að nota sömu breyturnar má taka inn sem arguments eða með Scanner
    String filename  = "movies.txt"; // args[0]
    String delimiter = "/";          // args[1]
    String source    = "Bacon, Kevin";// args[2]
    String movie     = "Glengarry Glen Ross (1992)";// args[3]

    baconHistogram(filename, delimiter, source);
    StdOut.println("------------------------------");
    baconNr(filename,delimiter,source,movie);

  }

}
