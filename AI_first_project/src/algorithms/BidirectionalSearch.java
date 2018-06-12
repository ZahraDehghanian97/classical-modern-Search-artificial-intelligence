package algorithms;

import java.util.Vector;
import problems.EightPuzzleNode;
import problems.Node;
import problems.Problem;
import problems.RobotNode;

public class BidirectionalSearch {

    private Vector<Node> closed_list_1;
    private Vector<Node> closed_list_2;

    private Vector<Node> open_list_1;
    private Vector<Node> open_list_2;
    private Node first;
    private Node last;
    private Problem my_problem;
    private String type;
    private Integer memory;
    private Integer expand;
    private Integer seen_nodes;

    public BidirectionalSearch(Problem my_problem, String type) {

	this.my_problem = my_problem;
	this.type = type;
	closed_list_1 = new Vector<Node>();

	open_list_1 = new Vector<Node>();

	closed_list_2 = new Vector<Node>();

	open_list_2 = new Vector<Node>();

	memory = 0;
	expand = 0;
	seen_nodes = 0;

	first = my_problem.getFirstNode();
	last = my_problem.getFinalNode();

	open_list_1.add(first);

	open_list_2.add(last);

	start_tree();

    }

    public void start_tree() {

	while (!open_list_1.isEmpty() && !open_list_2.isEmpty()) {

	    Node last = open_list_1.firstElement();
	    expand++;
	    open_list_1.remove(last);

	    if (type.equalsIgnoreCase("graph")) {
		closed_list_1.add(last);
	    }

	    for (int i = 0; i < last.getChild().size(); i++) {
		seen_nodes++;
		boolean what = true;

		for (int j = 0; j < closed_list_1.size(); j++) {
		    if (closed_list_1.elementAt(j).isSame(
			    last.getChild().elementAt(i))) {
			what = false;
		    }
		}

		if (what) {
		    open_list_1.add(last.getChild().elementAt(i));
		}

	    }

	    if (open_list_2.size() + open_list_1.size() + closed_list_1.size() + closed_list_2.size() > memory) {
		memory = open_list_2.size() + open_list_1.size() + closed_list_1.size() + closed_list_2.size();
	    }

	    last = open_list_2.firstElement();
	    expand++;
	    open_list_2.remove(last);
	    if (type.equalsIgnoreCase("graph")) {
		closed_list_2.add(last);
	    }

	    for (int i = 0; i < last.getChild().size(); i++) {
		seen_nodes++;
		open_list_2.add(last.getChild().elementAt(i));

		boolean what = true;
		for (int j = 0; j < closed_list_2.size(); j++) {
		    if (closed_list_2.elementAt(j).isSame(
			    last.getChild().elementAt(i))) {
			what = false;
		    }
		}
		if (what) {
		    open_list_2.add(last.getChild().elementAt(i));
		}
	    }
	    for(int i = 0 ; i<open_list_2.size(); i++ ){
		for (int j = 0; j < open_list_1.size(); j++) {

		    if (open_list_1.elementAt(j).isSame(open_list_2.elementAt(i))) {
			printPath(open_list_1.elementAt(j), open_list_2.elementAt(i));

			if (open_list_2.size() + open_list_1.size() + closed_list_1.size() + closed_list_2.size() > memory) {
			    memory = open_list_2.size();
			}
			return;
		    }
		}

	    }

	    if (open_list_2.size() + open_list_1.size() + closed_list_1.size() + closed_list_2.size() > memory) {
		memory = open_list_2.size() + open_list_1.size() + closed_list_1.size() + closed_list_2.size();
	    }
	}

    }

    private void printPath(Node first, Node end) {
	System.out.println();
	System.out.println("This is BDirectional search (" + type + ") : ");
	System.out.println("this is count of expanded nodes : " + expand);
	System.out.println("this is count of abserved nodes : " + seen_nodes);
	System.out.println("and the memory usage : " + memory);
	System.out.println("************");
	Node lastNode = first;
	while (first != null) {
	    first.print();
	    lastNode = first;
	    first = first.getParent();
	     // System.out.println("************");
	}
	String str = "";
	String str2 = "";
	if (lastNode.getClass().equals(RobotNode.class)) {

	    for (int i = lastNode.myParent().answer.length() - 1; i >= 0; i--) {
		if (lastNode.myParent().answer.charAt(i) == 'D') {
		    str = str + "R ";
		} else if (lastNode.myParent().answer.charAt(i) == 'R') {
		    str = str + "D ";
		}

		// System.out.println(str);
	    }

	   
	    lastNode = null;
	}
	
	else if (lastNode.getClass().equals(EightPuzzleNode.class)) {
	    
	    for (int i = lastNode.myParent().answer.length() - 1; i >= 0; i--) {
		
		    str = str + lastNode.myParent().answer.charAt(i);
		
		// System.out.println(str);
	    }
	    
	    for(int i=0;i<str.length()-2;i++)
		str2=str2+str.charAt(i);
	    lastNode = null;
	}
	//System.out.println("***************************");
	lastNode = end;    
	Node x = end ;
	int xSize = str2.length();
	while (end != null) {
	    end.print();
	    lastNode = end;
	    end = end.getParent();
	    //System.out.println("************");
	}
	if (lastNode.getClass().equals(RobotNode.class)) {
	    str = "";
	    for (int i = lastNode.myParent().answer.length() - 1; i >= 0; i--) {
		str = str + lastNode.myParent().answer.charAt(i);
		//System.out.println(str);
	    }
	    System.out.println(str);

	}
		if (lastNode.getClass().equals(EightPuzzleNode.class)) {
		    str = "";

	    for (int i =0 ; i < lastNode.myParent().answer.length(); i++) {
		if (lastNode.myParent().answer.charAt(i) == 'D') {
		    str = str + "U";
		} else if (lastNode.myParent().answer.charAt(i) == 'R') {
		    str = str + "L";
		}
		else if (lastNode.myParent().answer.charAt(i) == 'U') {
		    str = str + "D";
		}
		else if (lastNode.myParent().answer.charAt(i) == 'L') {
		    str = str + "R";
		}
		
		 //System.out.println(str+str.length()+str2.length());
	    }
	    /////herre must be check in soon 
	     int xSize2 = str.length()-str2.length();
	    for(int i=xSize+1+(xSize2%2);i<str.length();i++)
	    {str2=str2+str.charAt(i);
	    
	    }
	    str = "";
	    for(int i=0 ;i<str2.length();i++){
	    str = str + " "+str2.charAt(i);}
	    System.out.println("Answer is : "+ str);

	}
    }

}
/*
3 1 2
6 4 5
7 8 0

*/