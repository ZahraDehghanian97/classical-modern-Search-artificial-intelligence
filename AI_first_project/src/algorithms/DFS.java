package algorithms;

import java.util.Vector;
import problems.EightPuzzleNode;
import problems.Node;
import problems.Problem;

public class DFS {

    private Vector<Node> closed_list;
    private Vector<Node> open_list;
    private Node first;
    private Problem my_problem;
    private Integer memory;
    private Integer expand;
    private Integer seen_nodes;
    private String type;
    private boolean found;

    public DFS(Problem my_problem, String type) {

	this.my_problem = my_problem;
	this.type = type;
	closed_list = new Vector<Node>();
	open_list = new Vector<Node>();
	memory = 0;
	expand = 0;
	seen_nodes = 0;
	found = false;
	first = my_problem.getFirstNode();
	open_list.add(first);
	DFS_search();

    }

//isFinal  showResult getchild issame 
    public void DFS_search() {

	while (!open_list.isEmpty()) {
	    // here we print the state for Rubik problem
	    // System.out.println(open_list.size()+" "+((RubikNode)open_list.lastElement()).getBoard().toString());
	    if (open_list.lastElement().isFinal()) {
		showResult_g(open_list.lastElement());
		found = true;
		return;
	    }

	    Node last = open_list.lastElement();
	    if (type.equalsIgnoreCase("graph")) {
		closed_list.add(last);
	    }
	    open_list.remove(last);
	    expand++;
	    for (int i = 0; i < last.getChild().size(); i++) {
		boolean check = true;
		for (int j = 0; j < closed_list.size(); j++) {
		    if (closed_list.elementAt(j).isSame(last.getChild().elementAt(i))) {
			check = false;
		    }
		}
		if (check == true) {
		    open_list.add(last.getChild().elementAt(i));
		    //System.out.println(last.getChild().elementAt(i).toString());

		    seen_nodes++;
		}

	    }

	    if (open_list.size() + closed_list.size() > memory) {
		memory = open_list.size() + closed_list.size();
	    }

	}
	//System.out.println("finish");
    }

    private void showResult_g(Node node) {
// TODO Auto-generated method stub
	System.out.println();
	System.out.println("This is DFS search (" + type + ")");
	//System.out.println("The Answer was found in depth : "+node.getDepth());
	System.out.println("this is count of expanded nodes : " + expand);
	System.out.println("this is count of abserved nodes : " + seen_nodes);
	System.out.println("and the memory usage : " + memory);
	Node lastNode = node;
	//System.out.println("***************");
	while (node != null) {
	    node.print();
	    lastNode = node;
	    node = node.getParent();
	    // System.out.println("****************");

	}
	System.out.println("****************");
	if (lastNode.getClass().equals(EightPuzzleNode.class)) {
	    String ans = "";
	    for (int i = lastNode.myParent().answer.length() - 1; i >= 0; i--) {
		ans = ans + lastNode.myParent().answer.charAt(i);
	    }
	    System.out.println("Answer is : " + ans);
	} else if (lastNode.myParent() != null) {
	    System.out.println("Answer is : " + lastNode.myParent().answer);
	}

    }

}
