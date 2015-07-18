package DataStructures;

public class Graph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	/**
	 * Initializes an empty graph with vertices and 0 edges.
	 */
	public Graph(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	
	/**
	 * Initializes a graph from an input stream.
	 * The format is th enumber of vertices V
	 * followed by the number of edges E
	 * followed by pairs of vertices, with each entry seperated by whitespace.
	 * @param in the input stream
	 * @throws java.lang.IndexOutOfBoundException if the endpoints of any edge are not in prescribed range
	 * @throws java.lang.IllegalArgumentException if the number of vertices or edges is negative
	 */
	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	
	/**
	 * Returns the number of vertices in the graph
	 * @return the number of vertices in the graph
	 */
	public int V() {
		return V;
	}
	
	/**
	 * Returns the number of edges in the graph
	 * @return the number of edges in the graph
	 */
	public int E() {
		return E;
	}

	// throw an IndexOutOfBoundsException unless 0 <= v < V
	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and v " + (V-1));
	}
	
	/**
	 * Adds the undirected edge v-w to the graph.
	 * @param v one vertex in the edge
	 * @param w the other vertex in the edge
	 * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
	 */
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adj[v].add(w);;
		adj[w].add(v);
	}
	
	/**
	 * Returns the vertices adjacent to vertex V
	 * @return the vertices adjacent to vertex v as an Iterable
	 * @param v the vertex
	 * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
	 */
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}
	
	/**
	 * Returns the degree of vertex V
	 * @return the degree of vertex V
	 * @param v the vertex
	 * @throws java.lang.IndexOutOfBoundsexception unless 0 <= v < V
	 */
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	/**
	 * Returns a string representation fo the graph.
	 * This method takes time proportional to E + V
	 * @return the number of vertices V, followed by the number of edges E
	 * 	followed by the V adjacency lists
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.seperator");
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : adj[v]) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
	
	/**
	 * Unit tests the Graph data type.
	 */
	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph G = new Graph(in);
		StdOut.println(G);
	}
}
