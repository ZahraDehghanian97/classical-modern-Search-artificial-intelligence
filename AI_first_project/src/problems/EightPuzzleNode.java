package problems;

import java.util.Vector;

public class EightPuzzleNode extends Node {

    private Problem my_parent;
    private Node parent;
    private Vector<Integer> order;
    private int Gcost;
    private int fCost;
    private int hCost;
    public Problem myParent(){
	    return this.my_parent ;
	}
    public EightPuzzleNode(Vector<Integer> order, int Gcost, Node parent, Problem my_parent) {
	this.order = order;
	this.Gcost = Gcost;
	this.parent = parent;
	this.my_parent = my_parent;
	this.hCost = my_parent.getHcost(this);
	//System.out.println("order" + order.toString() + "hcost " + hCost);
	setFcost();
    }

    public Vector<Integer> getOrder() {
	return order;
    }

    private void setFcost() {
	// TODO Auto-generated method stub
	this.fCost = this.Gcost + this.hCost;

    }

    public boolean isFinal() {

	for (int i = 0; i < 9; i++) {
	    if (order.get(i) != i) {
		return false;
	    }
	}

	return true;
    }

    @Override
    public String toString() {
	String s = "";
	for (int i = 0; i < 9; i++) {
	    s = s + order.get(i) + " ";
	}
	return s;
    }

    public Vector<Node> getChild() {
	EightPuzzleNode leftNode, rightNode, upNode, downNode;
	Vector<Integer> orderL, orderR, orderU, orderD;
	Vector<Node> child = new Vector<Node>();
	int zeroPlace = whereIsZero();
	if (zeroPlace == 1000) {
	    System.out.println("error : there is no Zero  !");
	    return null;
	}
	if (zeroPlace % 3 != 0) {
	    orderL = new Vector<>();
	    for (int i = 0; i < 9; i++) {
		if (zeroPlace - i == 1) {
		    orderL.add(0);
		} else if (zeroPlace == i) {
		    orderL.add(order.get(i - 1));
		} else {
		    orderL.add(order.get(i));
		}
	    }
	    leftNode = new EightPuzzleNode(orderL, Gcost + 1, this, my_parent);
	    child.add(leftNode);
	}
	if (zeroPlace % 3 != 2) {
	    orderR = new Vector<>();
	    for (int i = 0; i < 9; i++) {
		if (i - zeroPlace == 1) {
		    orderR.add(0);
		} else if (zeroPlace == i) {
		    orderR.add(order.get(i + 1));
		} else {
		    orderR.add(order.get(i));
		}
	    }
	    rightNode = new EightPuzzleNode(orderR, Gcost + 1, this, my_parent);
	    child.add(rightNode);
	}
	if (zeroPlace / 3 != 0) {
	    orderU = new Vector<>();
	    for (int i = 0; i < 9; i++) {
		if (zeroPlace - (i + 3) == 0) {
		    orderU.add(0);
		} else if (zeroPlace == i) {
		    orderU.add(order.get(i - 3));
		} else {
		    orderU.add(order.get(i));
		}
	    }
	    upNode = new EightPuzzleNode(orderU, Gcost + 1, this, my_parent);
	    child.add(upNode);
	}
	if (zeroPlace / 3 != 2) {
	    orderD = new Vector<>();
	    for (int i = 0; i < 9; i++) {
		if ((i) - zeroPlace == 3) {
		    orderD.add(0);
		} else if (zeroPlace == i) {
		    orderD.add(order.get(zeroPlace + 3));
		} else {
		    orderD.add(order.get(i));
		}
	    }
	    downNode = new EightPuzzleNode(orderD, Gcost + 1, this, my_parent);
	    child.add(downNode);
	}

	//this written arguman getGcost+1 in this case is like this , but consider we have a graph where each path has it's
	//	special cost then it will be different and we need one function to return cost of the way of the path between this two states.
	return child;
    }

    public int whereIsZero() {
	for (int i = 0; i < 9; i++) {
	    if (order.get(i) == 0) {
		return i;
	    }
	}
	return 1000;
    }

    public void setParent(Node last) {

	this.parent = last;

    }

    public Node getParent() {

	return this.parent;
    }

    public void print() {
	// TODO Auto-generated method stub
	Node n = new Node();
	for (int i = 0; i < 9; i++) {

	   // System.out.print(order.get(i));
	    if (order.get(i) == 0) {
		n.setValue(i % 3, i / 3);
	    }
	    if (i % 3 == 2) {
		//System.out.println("");
	    }

	}
	if (n.x == this.my_parent.parentx & n.y < this.my_parent.parenty) {
	    this.my_parent.answer = this.my_parent.answer + "D";
	} else if (n.x < this.my_parent.parentx & n.y == this.my_parent.parenty) {
	    this.my_parent.answer = this.my_parent.answer + "R";
	}
	else if (n.x == this.my_parent.parentx & n.y > this.my_parent.parenty) {
	    this.my_parent.answer = this.my_parent.answer + "U";
	} else if (n.x > this.my_parent.parentx & n.y == this.my_parent.parenty) {
	    this.my_parent.answer = this.my_parent.answer + "L";
	}
	//else{ my_parent.answer = my_parent.answer + n.x + n.y +" "+my_parent.parenty + my_parent.parentx+"//"  ; }
	//System.out.println(this.my_parent.parentx + n.x+this.my_parent.parenty+ n.y);
	//System.out.println(this.my_parent.answer);
	this.my_parent.parentx = n.x;
	this.my_parent.parenty = n.y;
	

    }

    public int getGcost() {

	return this.Gcost;
    }

    public void setGcost(int gcost) {
	Gcost = gcost;
    }

    public boolean isSame(Node elementAt) {
	for (int i = 0; i < 9; i++) {
	    if (((EightPuzzleNode) elementAt).order.get(i) != this.order.get(i)) {
		return false;
	    }
	}
	return true;

    }

    public boolean isSameSetGcost(Node elementAt) {

	if (((EightPuzzleNode) elementAt).getRow() == this.getRow()
		&& ((EightPuzzleNode) elementAt).getCol() == this.getCol()) {

	    if (elementAt.getGcost() < this.getGcost()) {
		this.setParent(elementAt.getParent());
		this.setGcost(elementAt.getGcost());
	    }
	    return true;
	}

	return false;
    }

    public int getRow() {
	for (int i = 0; i < 9; i++) {
	    if (this.order.get(i) == 0) {
		return i / 3;
	    }
	}
	return 1000;
    }

    public int getCol() {
	for (int i = 0; i < 9; i++) {
	    if (this.order.get(i) == 0) {
		return i % 3;
	    }
	}
	return 1000;
    }

    public boolean isSameSetFcost(Node elementAt) {

	if (((EightPuzzleNode) elementAt).getRow() == this.getRow()
		&& ((EightPuzzleNode) elementAt).getCol() == this.getCol()) {

	    if (elementAt.getFcost() < this.getFcost()) {
		this.setParent(elementAt.getParent());
		this.setFcost(elementAt.getFcost());
	    }

	    return true;
	}

	return false;
    }

    private void setFcost(int fcost2) {
	// TODO Auto-generated method stub
	this.fCost = fcost2;
    }

    public int getFcost() {

	return this.fCost;

    }

}
