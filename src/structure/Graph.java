package structure;

import edu.princeton.cs.algs4.In;

public class Graph {
	
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	/**
	 * ����һ������V�����㵫�����бߵ�ͼ
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
	 * ��һ����׼�������ж���һ��ͼ
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
	 * ���ؽڵ�����
	 * @return
	 */
	public int V(){
		return this.V;
	}
	
	/**
	 * ���ر�����
	 * @return
	 */
	public int E(){
		return this.E;
	}
	
	/**
	 * ����һ����v-w
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	/**
	 * ���غ�v���ڵ����нڵ�
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public String toString(){
		String s = V + "����, " + E + "������\n";
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
