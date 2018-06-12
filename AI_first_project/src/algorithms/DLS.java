package algorithms;

import java.util.Vector;
import problems.Node;
import problems.Problem;

public class DLS {

    private Vector<Node> closed_list;
    private Vector<Node> open_list;
    private Node first;
    private Problem my_problem;
    private int depth, nowDepth;
    private Integer memory;
    private Integer expand;
    private Integer seen_nodes;
    private String type;
    private boolean found;

    public DLS(Problem my_problem, int depth, String type) {

	this.depth = depth;
	this.my_problem = my_problem;
	this.type = type;
	closed_list = new Vector<Node>();
	open_list = new Vector<Node>();
	memory = 0;
	expand = 0;
	seen_nodes = 0;
	found = false;
	nowDepth = 0;
	first = my_problem.getFirstNode();
	open_list.add(first);
	DLS_search();

    }

    public void DLS_search() {

	while (!open_list.isEmpty() ) {
	    //System.out.println("open list size : "+open_list.size()+"   now we search at depth : "+open_list.lastElement().getDepth()+" ");
	    if (open_list.lastElement().isFinal()) {
		showResult_g(open_list.lastElement());
		found = true;
		return;
	    }
	    //System.out.println(open_list.lastElement().depth);
	    Node last = open_list.lastElement();
	    nowDepth = last.getDepth();
	    if (type.equalsIgnoreCase("graph")) {
		closed_list.add(last);
	    }
	    //System.out.println("now depth = "+ last.depth);
	    open_list.remove(last);
	    if (nowDepth < depth) {
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
			seen_nodes++;
		    }

		}
		if (open_list.size() + closed_list.size() > memory) {
		    memory = open_list.size() + closed_list.size();
		}

	    }

	}
	if (nowDepth >= depth) {
	    System.out.println("the answer was not found in depth " + depth);
	}
    }

    private void showResult_g(Node node) {
// TODO Auto-generated method stub
	
	System.out.println("This is DLS search (" + type + ") in depth :"+depth);
	System.out.println("The Answer was found in depth : "+node.getDepth());
	System.out.println("this is count of expanded nodes : " + expand);
	System.out.println("this is count of abserved nodes : " + seen_nodes);
	System.out.println("and the memory usage : " + memory);
	found = true;

	System.out.println("***************");
	System.out.print("Answer is : ");
	while (node != null) {
	    node.print();
	    node = node.getParent();
	    // System.out.println("****************");

	}

	//System.out.println(" " + lastNode.myParent().answer);
    }

    public boolean checkDepth() {
	return found;
    }

}
