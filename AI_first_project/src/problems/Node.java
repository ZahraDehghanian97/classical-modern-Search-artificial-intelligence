package problems;

import java.util.Vector;

public class Node {
	public int   x , y ;
	Problem my_parent ;
	private int depth ; 
	public Problem myParent(){
	    return my_parent ;
	}
	public boolean isFinal() {
		// TODO Auto-generated method stub
		return false;
	}

	public Vector<Node> getChild() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCumultive(double cumultive) {
		
	}
	
	public double getCumultive(){
		return 0 ;
	}
	public void setParent(Node last) {
		// TODO Auto-generated method stub
		
		
	}

	public Node getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

	public boolean isSame(Node elementAt) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getGcost() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public boolean isSameSetGcost(Node elementAt) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasSameFcost(Node elementAt) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getFcost() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getDepth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getEval() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getvalue() {
		// TODO Auto-generated method stub
		return 0;
	}
	public double getFitness(){		
		return 0;		
	}
	public void mutation(){
		
		
	}
	public void setValue(int x , int y){
		this.x = x ;
		this.y = y ;
		
	}

	public void setValue(double value){
		
		
	}
	public void setDepth(int depth){
	    this.depth = depth ;
		
	}
}
