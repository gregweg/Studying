package TreesAndGraphs;

public class TreeNodeWithParent {
	char data;
	TreeNodeWithParent left;
	TreeNodeWithParent right;
	TreeNodeWithParent parent;
	
	public TreeNodeWithParent(char label) {
		data = label;
		left = null;
		right = null;
		parent = null;
	}
	
	public TreeNodeWithParent(char label, TreeNodeWithParent parent, 
			TreeNodeWithParent left, TreeNodeWithParent right) {
		data = label;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
	
	public TreeNodeWithParent getParent() {
		return this.parent;
	}
}
