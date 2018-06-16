package problems;

import java.util.Vector;

//import algorithms.A_Star;
//import algorithms.BidirectionalSearch;
//import algorithms.DFS;
//import algorithms.UniformCost;

public class MazeProblem extends Problem {

	private Vector <Integer> walls;
	private MazeNode my_node ;
	private MazeNode my_last_node;
	private int size ;
	
	public MazeProblem() {
		
		walls= new Vector<Integer>();
		
		walls.add(3242);
		walls.add(3343);
		walls.add(2324);
		walls.add(3334);
		
		
		size=5;
		 my_node = new MazeNode(0, 0, size, 0, null, this);
		 my_last_node = new MazeNode(size-1, size-1 , size, 0, null, this);
		 
//		UniformCost un = new UniformCost(this,"graph");
//		A_Star un2 = new A_Star(this , "graph");
//		 BidirectionalSearch bd= new BidirectionalSearch(this ,"graph");		 
//		DFS df= new DFS(this, 0, "tree");	 
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
	public int getHcost(Node n){
		
		return (2*size-((MazeNode)n).getRow()+((MazeNode)n).getCol());
		
		//return (Math.max(size-((MazeNode)n).getRow() , size-((MazeNode)n).getCol()));
		
		
	}
	/*public static void main(String arg0[]) {
		MazeProblem qp = new MazeProblem();
	}
	*/
}
