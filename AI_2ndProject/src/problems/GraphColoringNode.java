package problems;

import java.util.Vector;

/**
 *
 * @author < zahra dehghanian>
 */
public class GraphColoringNode extends Node {

    GraphColoringProblem my_parent;
    int[] color;
    Node parent;

    GraphColoringNode(int[] color, GraphColoringProblem my_parent, Node parent) {
	this.color = color;
	this.my_parent = my_parent;
	this.parent = parent;
    }

    @Override
    public Vector<Node> getChild() {
	Vector<Node> n = new Vector<>();
	for (int i = 0; i < my_parent.V ; i++) {
	    int[] c = new int[my_parent.V];
	    for (int j = 0; j < my_parent.V; j++) {
		c[j] = color[j];
	    }
	    c[i]++;
	    c[i] = c[i] % (my_parent.numOfColors );
	    n.add(new GraphColoringNode(c, my_parent, this));
	}

	return n;
    }

    public int getEval() {
	int temp = my_parent.V;
	int Eval = 0 ;
	for (int i = 0; i < temp; i++) {
	    for (int j = 0; j < temp; j++) {
		if (my_parent.graph[i][j] == 1 && color[i]==color[j]) {
		    Eval++ ;
		}
	    }
	}
	return Eval ;
    }
    public void print () {
	System.out.print("Answer is : ");
	for(int i=0 ;i<my_parent.V;i++){
	    System.out.print(color[i]+" ");}
    
    }
}
