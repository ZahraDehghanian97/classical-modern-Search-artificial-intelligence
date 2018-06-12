package problems;

import algorithms.*;
import java.util.*;

public class EightPuzzleProblem extends Problem {

    private Vector<Integer> order, finalOrder;
    private EightPuzzleNode my_node;
    private EightPuzzleNode my_last_node;
    private int size;

    public EightPuzzleProblem() {
	
	order = new Vector<Integer>();
	finalOrder = new Vector<Integer>();
	Scanner s = new Scanner(System.in);
	for (int i = 0; i < 9; i++) {
	    order.add(s.nextInt());
	    finalOrder.add(i);
	}

	my_node = new EightPuzzleNode(order, 0, null, this);
	my_last_node = new EightPuzzleNode(finalOrder, 0, null, this);

		UniformCost un = new UniformCost(this,"graph");
//		A_Star un2 = new A_Star(this , "graph");
//	BidirectionalSearch bd = new BidirectionalSearch(this, "graph");
//		DFS df= new DFS(this , "graph");	 
    }

    public Node getFinalNode() {
	// TODO Auto-generated method stub
	return my_last_node;

    }

    public Node getFirstNode() {
	return my_node;
    }

    public int getHcost(Node n) {
	int temp = 0;
	EightPuzzleNode here = (EightPuzzleNode) n;
	for (int i = 0; i < 9; i++) {
	    temp = temp+ distance(here.getOrder().get(i),i);
	}
	return temp ;
    }

/*    public static void main(String arg0[]) {
	System.out.println("welcome to eight puzzle prblem ...");
	System.out.println("please enter your puzzle :");
	EightPuzzleProblem qp = new EightPuzzleProblem();
    }
*/
    private int distance (int source,int dest){
	return Math.abs(source%3 - dest%3)+ Math.abs(source/3 - dest/3);
    }
    
}
/*
3 1 2
4 5 0
6 7 8

3 1 2
6 4 5
7 8 0

*/