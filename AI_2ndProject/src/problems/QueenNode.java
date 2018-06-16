package problems;

import java.util.Vector;

public class QueenNode extends Node {
	
	private Vector <Integer> board ;
	private int size ;
	private Node parent;
	private int depth ;
	
	public QueenNode(Vector <Integer> board, int size , int depth , Node parent){
		
		this.setBoard(board);
		this.size=size;
		this.parent=parent;
		this.depth=depth;
		//System.out.println("depth os "+ this.depth);
	}
	
	public boolean isFinal() {
		
		if (size != 8)
		return false;
		for (int i = 0; i < 6; i++) {
			if(getBoard().elementAt(size-1)==getBoard().elementAt(i))
				return false;
			if((getBoard().elementAt(i)-getBoard().elementAt(size-1)) == i-size+1 ||
					(getBoard().elementAt(size-1)-getBoard().elementAt(i)) == i-size+1)
					return false;
			
		}
		
		return true ;
	}

	public Vector<Node> getChild() {
		
		Vector <Node> child = new Vector<Node>();
		
		for (int i = 0; i < 8; i++) {
			Vector<Integer> my_board = new Vector<Integer>();
			for (int j = 0; j < 8; j++) {
				my_board.add( j , getBoard().elementAt(j)) ;
			}
			
			my_board.set( size , i+1 );
			boolean what = true;
			for (int p = 0; p <size ; p++) {
				
				if(my_board.elementAt(p)==i+1 || 
						my_board.elementAt(p)-(i+1)== p-(size) || 
						my_board.elementAt(p)-(i+1) == size-p )
					what = false;
			
			}
			
			if(what){
				QueenNode n= new QueenNode(my_board, size+1 , depth+1 ,this);
				child.add(n);
				
			}

			
		}
		return child;
	}

	public boolean isSame(Node elementAt) {
	
		if(this.size!=((QueenNode)elementAt).size)
		return false;
		
		for (int i = 0; i < size; i++) {
			if(getBoard().elementAt(i)!=((QueenNode)elementAt).getBoard().elementAt(i))
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
	public int getDepth() {
		// TODO Auto-generated method stub
		return this.depth;
	}
}
