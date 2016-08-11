package structure;

import edu.princeton.cs.algs4.In;

public class Graph {
	
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	/**
	 * 创建一个含有V个定点但不含有边的图
	 * @param V
	 */
	public Graph(int V){
		this.V = V;
		this.adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++){
			adj[v] = new Bag<Integer>();
		}
	}
	/**
	 * 从一个标准输入流中读入一幅图
	 * @param in
	 */
	public Graph(In in){
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++){
			int v = in.readInt();
			int w = in.readInt();
			this.addEdge(v, w);
		}
	}
	
	/**
	 * 返回节点数量
	 * @return
	 */
	public int V(){
		return this.V;
	}
	
	/**
	 * 返回边数量
	 * @return
	 */
	public int E(){
		return this.E;
	}
	
	/**
	 * 插入一条边v-w
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	/**
	 * 返回和v相邻的所有节点
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public String toString(){
		String s = V + "条边, " + E + "个定点\n";
		for(int v = 0; v < V; v++){
			s += v + " : ";
			for(int w : this.adj[v]){
				s += w + " ";
			}
				s += "\n";
		}
		return s;
	}
	
}
