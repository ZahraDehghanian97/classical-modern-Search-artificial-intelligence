package problems;

import java.util.Vector;

public class MazeNode extends Node {

	
	private Vector <Vector<Integer>> board ;
	private int size ;
	private Node parent;

	private int row ;
	private int col ;
	private int Gcost ;
	private Problem my_parent ;
	private int fCost ;
	private int hCost ;
	
	public MazeNode(int row , int col , int size , int Gcost , Node parent , Problem my_parent){
		
		this.my_parent=my_parent;
		this.size=size;
		this.row=row;
		this.col=col;
		this.Gcost=Gcost;
		this.parent=parent;
		this.hCost=my_parent.getHcost(this);
		this.setBoard(row , col);
		setFcost();
		
		
	}
	
	private void setFcost() {
		// TODO Auto-generated method stub
		this.fCost=this.Gcost+this.hCost;
		
	}

	public boolean isFinal() {
		
		
		if(getRow()==size-1 && getCol()==size-1)
			return true;
		
		return false;
	}

	public Vector<Node> getChild() {
		
		Vector <Node> child = new Vector<Node>();
		
		if(getCol()>0){
			
			int first= ((getCol()+1)*10+getRow()+1)*100 + ((getCol()+1-1)*10+getRow()+1) ;
			int second= ((getCol()-1+1)*10+getRow()+1)*100 + ((getCol()+1)*10+getRow()+1) ;
			
			if(!my_parent.getWalls().contains(first) && ! my_parent.getWalls().contains(second)){
				MazeNode mn = new MazeNode(getRow(), getCol()-1 , size , getGcost()+1 ,this, my_parent);
				child.add(mn);
			}
		}
		
		if(getCol()<size-1){
			
			int first= ((1+getCol())*10+getRow()+1)*100 + ((getCol()+1+1)*10+getRow()+1) ;
			int second= ((getCol()+1+1)*10+getRow()+1)*100 + ((getCol()+1)*10+getRow()+1) ;
			
			if(!my_parent.getWalls().contains(first) && ! my_parent.getWalls().contains(second)){
				MazeNode mn = new MazeNode(getRow(), getCol()+1 , size , getGcost()+1 ,this, my_parent);
				child.add(mn);
			}
		}
		
		if(getRow()>0){
			
			int first= ((getCol()+1)*10+getRow()+1)*100 + ((getCol()+1)*10+(getRow()-1+1)) ;
			int second= ((getCol()+1)*10+(getRow()-1+1))*100 + ((getCol()+1)*10+getRow()+1) ;
			
			if(!my_parent.getWalls().contains(first) && ! my_parent.getWalls().contains(second)){
				MazeNode mn = new MazeNode(getRow()-1, getCol() , size , getGcost()+1 ,this, my_parent);
				child.add(mn);
			}
		}
		if(getRow()<size-1){
			
			int first= ((getCol()+1)*10+getRow()+1)*100 + ((getCol()+1)*10+(getRow()+1+1)) ;
			int second= ((getCol()+1)*10+(getRow()+1+1))*100 + ((getCol()+1)*10+getRow()+1) ;
			
			if(!my_parent.getWalls().contains(first) && ! my_parent.getWalls().contains(second)){
				MazeNode mn = new MazeNode(getRow()+1, getCol() , size , getGcost()+1 ,this, my_parent);
				child.add(mn);
			}
		}
			//this written arguman getGcost+1 in this case is like this , but consider we have a graph where each path has it's
		//	special cost then it will be different and we need one function to return cost of the way of the path between this two states.
		return child;
	}

	

	public void setParent(Node last) {
	
		this.parent=last;
		
	}

	public Node getParent() {
		
		return this.parent;
	}

	public void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			System.out.println(board.get(i));
		}
		
		
	}

	public Vector < Vector<Integer>> getBoard() {
		return board;
	}

	public void setBoard(int row , int col) {
	
		board= new Vector<Vector<Integer>>();
		
		for (int i = 0; i < size; i++) {
			Vector <Integer>current = new Vector<Integer>();
			for (int j = 0; j < size; j++) {
				current.add(0);
			}
			board.add(current);
		}
		
		board.get(row).set(col, 1);
		
	}
	
	public int getGcost() {
		
		return this.Gcost;
	}
	public void setGcost(int gcost) {
		Gcost = gcost;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public boolean isSame(Node elementAt) {
		
		if(((MazeNode) elementAt).getRow()==this.getRow() &&
				((MazeNode) elementAt).getCol() ==this.getCol())
			return true;
		return false;
		
	}

	public boolean isSameSetGcost(Node elementAt) {
		
		if(((MazeNode) elementAt).getRow()==this.getRow() &&
				((MazeNode) elementAt).getCol() ==this.getCol()){
			
			if(elementAt.getGcost()<this.getGcost()){
				this.setParent(elementAt.getParent());
				this.setGcost(elementAt.getGcost());}
			return true;
		}
		
		return false;
	}
	
	public boolean isSameSetFcost(Node elementAt) {

		if(((MazeNode) elementAt).getRow()==this.getRow() &&
				((MazeNode) elementAt).getCol() ==this.getCol()){
			
			if(elementAt.getFcost()<this.getFcost()){
				this.setParent(elementAt.getParent());
				this.setFcost(elementAt.getFcost());}
			
			return true;
		}
		
		return false;
	}

	private void setFcost(int fcost2) {
		// TODO Auto-generated method stub
		this.fCost=fcost2;
	}

	public int getFcost() {
	
		return this.fCost;
		
	}
	
}
