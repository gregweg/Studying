package TreesAndGraphs;

public class GraphNode<T> implements Comparable<GraphNode<T>> {
	protected T data;
	protected boolean visited;
	public Integer index = null;
	public Integer lowLink = null;
	public double distance = Double.POSITIVE_INFINITY;
	public GraphNode<T> predecessor = null;
	
	public GraphNode(T data) {
		this.data = data;
	}
	
	public GraphNode() {
		
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void visit() {
		visited = true;
	}
	
	public void unVisit() {
		visited = false;
	}
	
	public int compareTo(GraphNode<T> ob) {
		String tempA = this.toString();
		String tempB = ob.toString();
		
		return tempA.compareTo(tempB);
	}
	
	public String toString() {
		return data.toString();
	}
	
	
}
