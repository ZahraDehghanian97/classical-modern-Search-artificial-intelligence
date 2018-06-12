package problems;

import algorithms.*;
import java.util.*;

public class RobotProblem extends Problem {

    private Vector<Integer> walls;
    private RobotNode my_node;
    private RobotNode my_last_node;
    private int size;

    public RobotProblem() {
	walls = new Vector<Integer>();
	Scanner s = new Scanner(System.in);
	int inputNum1 = s.nextInt();
	int inputNum2 = s.nextInt();
	//int inputNum3 = 0 ;
	size = Integer.max(inputNum1, inputNum2);
	inputNum1 = s.nextInt();
	inputNum2 = 0;
	for (int i = 0; i < inputNum1; i++) {
	    for (int j = 0; j < 4; j++) {
		inputNum2 = (inputNum2 * 10) + (s.nextInt());

	    }
	    walls.add(inputNum2);
	    inputNum2 = 0;

	}

	parentx = size;
	parenty = size;
	my_node = new RobotNode(0, 0, size, 0, null, this);
	my_last_node = new RobotNode(size - 1, size - 1, size, 0, null, this);

//		UniformCost un = new UniformCost(this,"graph");
//		A_Star un2 = new A_Star(this , "graph");
//	BidirectionalSearch bd = new BidirectionalSearch(this, "graph");
		DFS df= new DFS(this , "graph");	 
    }

    public Node getFinalNode() {
	// TODO Auto-generated method stub
	return my_last_node;

    }

    public Node getFirstNode() {
	return my_node;
    }

    public Vector<Integer> getWalls() {
	return walls;
    }

    public int getHcost(Node n) {

	return (2 * size - ((RobotNode) n).getRow() + ((RobotNode) n).getCol());

	//return (Math.max(size-((RobotNode)n).getRow() , size-((RobotNode)n).getCol()));
    }

    /*public static void main(String arg0[]) {
	System.out.println("welcome to Robot problem ...");
	System.out.println("please enter your Maze :");
	RobotProblem qp = new RobotProblem();
    }
    */
}
/*
5 5
4
3 2 4 2
3 3 4 3
2 3 2 4
3 3 4 3

*/