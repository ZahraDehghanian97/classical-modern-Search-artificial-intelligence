package algorithms;

import java.util.Vector;
import problems.EightPuzzleNode;
import problems.Node;
import problems.Problem;

public class UniformCost {

    private Vector<Node> close_list;
    private Vector<Node> open_list;

    private Node first;
    private Problem my_problem;
    private String type;
    private Integer memory;
    private Integer expand;
    private Integer seenNodes;

    public UniformCost(Problem my_problem, String type) {

	this.my_problem = my_problem;
	this.type = type;
	close_list = new Vector<Node>();
	open_list = new Vector<Node>();
	first = my_problem.getFirstNode();
	open_list.add(first);
	expand = 0;
	seenNodes = 0;
	memory = 0;

	start_uniformCost_search();

    }

    public void start_uniformCost_search() {

	while (!open_list.isEmpty()) {

	    if (getMinCostGNode(open_list).isFinal()) {

		showResult(getMinCostGNode(open_list));
		return;
	    }

	    Node last = getMinCostGNode(open_list);
	    if (type.equals("graph")) {
		close_list.add(last);
	    }
	    open_list.remove(last);
	    expand++;

	    for (int i = 0; i < last.getChild().size(); i++) {

		boolean what = true;
		for (int j = 0; j < close_list.size(); j++) {
		    if (close_list.elementAt(j).isSame(last.getChild().elementAt(i))) {
			what = false;
		    }
		}

		if (what) {
		    seenNodes++;
		    boolean why = true;
		    for (int j = 0; j < open_list.size(); j++) {
			if (open_list.elementAt(j).isSameSetGcost(last.getChild().elementAt(i))) {
			    why = false;
			}
		    }
		    if (why) {
			open_list.add(last.getChild().elementAt(i));
		    }
		}
	    }

	    if (open_list.size() + close_list.size() > memory) {
		memory = open_list.size() + close_list.size();
	    }

	}

    }

    private Node getMinCostGNode(Vector<Node> current_node2) {

	int min = current_node2.get(0).getGcost();
	int index = 0;

	for (int i = 1; i < current_node2.size(); i++) {
	    if (current_node2.get(i).getGcost() < min) {
		index = i;
		min = current_node2.get(i).getGcost();
	    }
	}
	return current_node2.get(index);
    }

    private void showResult(Node node) {
	System.out.println();
	System.out.println("This is UniformCost search (" + type + ") : ");
	System.out.println("this is count of expanded nodes : " + expand);
	System.out.println("this is count of abserved nodes : " + seenNodes);
	System.out.println("and the memory usage : " + memory);
	System.out.println();
	Node lastNode = node;
	System.out.println("***************");
	while (node != null) {
	    node.print();
	    lastNode = node;
	    node = node.getParent();
	    //System.out.println("****************");

	}

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
