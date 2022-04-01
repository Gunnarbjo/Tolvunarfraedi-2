import edu.princeton.cs.algs4.*;

public class Dfsbridge{
	//4.1.10

	private boolean[] marked;
	private Integer return_v;

	public int find(Graph G){
		//skrifa kóða
		if(G.V() == 1){
			return -1;
		}
		marked = new boolean[G.V()];
		return_v = null;
		dfs(G,0);
		return return_v;
	}
	/*
	Iterator it = G.adj(v).iterator();
	int w;
	while(it.hasNext()){
		w = it.next();
		......
	}
	*/
	private void dfs(Graph G, int v){
		marked[v] = true;

		boolean allAdjacentMarked = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				allAdjacentMarked = false;
				dfs(G,w);
			}
		}
		if(allAdjacentMarked){
			if(return_v == null){
				return_v = v;
			}
		}
	}
}
