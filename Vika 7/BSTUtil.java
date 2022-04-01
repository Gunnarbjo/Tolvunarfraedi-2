import edu.princeton.cs.algs4.*;

public class BSTUtil{
	public static BSTNode min(BSTNode x){
		//code
		if(x == null) return null;

		while(x.left != null){
			x = x.left;
		}
		//for(;x.left != null; x = x.left)
		return x;
	}

	public static BSTNode secondMin(BSTNode x){
		//code
		if(x == null) return null;
		if(x.left == null && x.right == null)return null;

		BSTNode y = min(x);
		if(y.right != null) return min(y.right);

		while(x.left.left != null){
			x = x.left;
		}
		//x.left != null, x.left.left = null
		return x;
	}
	public static int randomKey(){
		int n = Std.random.uniform(0,size());
		return select(n);
	}
	public static void main(String[] args){
		StdOut.println(min(null));
	//	StdOut.println(secondMin(null));

		StdOut.println(min(new BSTNode("A")).key);
		StdOut.println(secondMin(new BSTNode("A")));

		BSTNode A = new BSTNode("A");
		BSTNode B = new BSTNode("B");
		BSTNode C = new BSTNode("C");
		BSTNode D = new BSTNode("D");

		D.left = C;
		C.left = B;
		B.left = A;

		StdOut.println(secondMin(D));
/*
		D.left = B;
		B.right = C;

		StdOut.println(min(D).key);
		StdOut.println(secondMin(A));

		B.right = null;
		StdOut.println(secondMin(D).key);
		*/
	}
}
