package problems;

import java.util.Vector;

public class QueenNode2 extends Node{

	private Vector <Integer> board ;
	private Node parent;
	private int fCost;
	private int depth;
	
	public QueenNode2(Vector <Integer> board, Node parent ){
		
		this.setBoard(board);
		this.parent=parent;
		this.setFcost();
		setDepth();
	}
	
	public int getDepth() {
		
		return this.depth;
	}
	private void setDepth() {
		if(parent==null)
			this.depth=0;
		else
		this.depth= parent.getDepth()+1;
	}
	
	public int getEval() {
		
		int count =0;
		for (int j = 0; j < 8; j++) {	
			for (int i = j+1; i < 8; i++) {				
			if((getBoard().elementAt(i)-getBoard().elementAt(j)) == i-j ||
					(getBoard().elementAt(j)-getBoard().elementAt(i)) == i-j)
				count++;
							
											}
									}
		return (count) ;
		
	}

	private void setFcost() {
		
		int count =0;
		for (int j = 0; j < 8; j++) {	
			for (int i = j+1; i < 8; i++) {				
			if((getBoard().elementAt(i)-getBoard().elementAt(j)) == i-j ||
					(getBoard().elementAt(j)-getBoard().elementAt(i)) == i-j)
				count++;
							
											}
									}
		this.fCost=count;
		
	}

	public boolean isFinal() {
		
		for (int j = 0; j < 8; j++) {	
			for (int i = j+1; i < 8; i++) {				
			if((getBoard().elementAt(i)-getBoard().elementAt(j)) == i-j ||
					(getBoard().elementAt(j)-getBoard().elementAt(i)) == i-j)
					return false;		
										}
									}
		return true ;
	}

	public int getFcost() {
		
		return this.fCost;
	}

	public Vector<Node> getChild() {
	
		
		Vector <Node> child = new Vector<Node>();
		
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 8; j++) {
				
				Vector<Integer> my_board = new Vector<Integer>();
				for (int k = 0; k < 8; k++) {
					my_board.add( k , getBoard().elementAt(k)) ;
				}
				
				int swap = my_board.elementAt(i);
				int swap2= my_board.elementAt(j);
				my_board.set(i, swap2);
				my_board.set(j, swap);
				QueenNode2 n = new QueenNode2 (my_board, this);
				child.add(n);
				
			}
			
		}
		return child;
	}

	public boolean isSame(Node elementAt) {
	
		
		for (int i = 0; i < 8; i++) {
			if(getBoard().elementAt(i)!=((QueenNode2)elementAt).getBoard().elementAt(i))
				return false;
		}
		
		return true;
		
	}

	public void setParent(Node last) {
	
		this.parent=last;
		
	}

	public Node getParent() {
		
		return this.parent;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println(getBoard());
		
	}

	public Vector <Integer> getBoard() {
		return board;
	}

	public void setBoard(Vector <Integer> board) {
		this.board = board;
	}
}
