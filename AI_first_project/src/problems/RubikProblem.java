package problems;

import algorithms.*;
import java.util.Scanner;
import java.util.Vector;


public class RubikProblem extends Problem {

	Vector<Character> board ;
	Scanner s = new Scanner (System.in);
	int rand ;
	public RubikProblem() {
		board= new Vector<Character>();
		System.out.println("welcome to Rubik Problem :");
		   System.out.println("please enter your Rubik :");
		for (int i = 0; i < 24; i++) {
			board.add(s.next().charAt(0));
		}
		board.add(' ');
	    System.out.println();
		 BFS my_bfs = new BFS(this , "graph");
//		 DLS my_dls= new DLS(this,14 ,"graph");
//		IDDFS my_iddfs = new IDDFS(this , "graph");
		
	}

	
	public Node getFirstNode() {

		
		Node n = new RubikNode(board,null);
		// Node n = new QueenNode(board,0,0 ,null);
		return n;

	}


	public static void main(String arg0[]) {
		RubikProblem qp = new RubikProblem();
	}
	

}
/* 
w w w w
r r r r
b b b g
g b b b
y y y y
o o o o

w g w g 
r w r w 
b r b r
g b g b 
o o o o
y y y y

w w w w
r r r r
g g g g
b b b b
y y y y
o o o o

*/