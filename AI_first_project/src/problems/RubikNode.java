package problems;

import java.util.Vector;

public class RubikNode extends Node {

    private Vector<Character> board;
    private Node parent;
    private int depth;
//isFinal  showResult getchild issame 	

    public RubikNode(Vector<Character> board, Node parent) {
	this.setBoard(board);
	this.parent = parent;
	setDepth();
    }

    public int getDepth() {

	return this.depth;
    }

    private void setDepth() {
	
	if (parent == null) {
	    this.depth = 0;
	    //System.out.println("here");
	} else {
	    this.depth = parent.getDepth() + 1;
	    //System.out.println("hereeeeee "+depth);
	}
    }

    public boolean isFinal() {

	if (board.get(0) == board.get(1) && board.get(2) == board.get(1) && board.get(2) == board.get(3)
		&& board.get(4) == board.get(5) && board.get(5) == board.get(6) && board.get(6) == board.get(7)
		&& board.get(8) == board.get(9) && board.get(9) == board.get(10) && board.get(10) == board.get(11)
		&& board.get(12) == board.get(13) && board.get(13) == board.get(14) && board.get(14) == board.get(15)
		&& board.get(16) == board.get(17) && board.get(17) == board.get(18) && board.get(18) == board.get(19)
		&& board.get(20) == board.get(21) && board.get(21) == board.get(22) && board.get(22) == board.get(23)) {
	    return true;
	}
	return false;
    }

    public Vector<Node> getChild() {

	Vector<Node> child = new Vector<Node>();
	Vector<Character> temp_Board = new Vector<Character>();
	//T
	for (int i = 0; i < 24; i++) {
	    temp_Board.add(board.get(i));
	}
	temp_Board.add(' ');
	char temp1, temp2;
	temp1 = temp_Board.get(0);
	temp_Board.set(0, temp_Board.get(3));
	temp_Board.set(3, temp_Board.get(2));
	temp_Board.set(2, temp_Board.get(1));
	temp_Board.set(1, temp1);
	temp1 = temp_Board.get(4);
	temp2 = temp_Board.get(5);
	temp_Board.set(4, temp_Board.get(20));
	temp_Board.set(5, temp_Board.get(21));
	temp_Board.set(20, temp_Board.get(15));
	temp_Board.set(21, temp_Board.get(14));
	temp_Board.set(15, temp_Board.get(16));
	temp_Board.set(14, temp_Board.get(17));
	temp_Board.set(16, temp1);
	temp_Board.set(17, temp2);
	temp_Board.set(24, 'T');
	////////
	//System.out.println(temp_Board.toString());
	child.add(new RubikNode(temp_Board, this));
	//TC
	 temp_Board = new Vector<Character>();
	for (int i = 0; i < 24; i++) {
	    temp_Board.add(board.get(i));
	}
	temp_Board.add(' ');
	temp1 = temp_Board.get(0);
	temp_Board.set(0, temp_Board.get(1));
	temp_Board.set(1, temp_Board.get(2));
	temp_Board.set(2, temp_Board.get(3));
	temp_Board.set(3, temp1);
	temp1 = temp_Board.get(4);
	temp2 = temp_Board.get(5);
	temp_Board.set(4, temp_Board.get(16));
	temp_Board.set(5, temp_Board.get(17));
	temp_Board.set(16, temp_Board.get(15));
	temp_Board.set(17, temp_Board.get(14));
	temp_Board.set(15, temp_Board.get(20));
	temp_Board.set(14, temp_Board.get(21));
	temp_Board.set(20, temp1);
	temp_Board.set(21, temp2);
	temp_Board.set(24, 'U');
	///////////
	//System.out.println(temp_Board.toString());
	child.add(new RubikNode(temp_Board, this));
	//F
	temp_Board = new Vector<Character>();
	for (int i = 0; i < 24; i++) {
	    temp_Board.add(board.get(i));
	}
	temp_Board.add(' ');
	temp1 = temp_Board.get(7);
	temp_Board.set(7, temp_Board.get(5));
	temp_Board.set(5, temp_Board.get(4));
	temp_Board.set(4, temp_Board.get(6));
	temp_Board.set(6, temp1);
	temp1 = temp_Board.get(8);
	temp2 = temp_Board.get(9);
	temp_Board.set(8, temp_Board.get(22));
	temp_Board.set(9, temp_Board.get(20));
	temp_Board.set(22, temp_Board.get(3));
	temp_Board.set(20, temp_Board.get(2));
	temp_Board.set(3, temp_Board.get(17));
	temp_Board.set(2, temp_Board.get(19));
	temp_Board.set(17, temp1);
	temp_Board.set(19, temp2);
	temp_Board.set(24, 'F');
	///////////
	//System.out.println(temp_Board.toString());
	child.add(new RubikNode(temp_Board, this));
	//FC
	temp_Board = new Vector<Character>();
	for (int i = 0; i < 24; i++) {
	    temp_Board.add(board.get(i));
	}
	temp_Board.add(' ');
	temp1 = temp_Board.get(4);
	temp_Board.set(4, temp_Board.get(5));
	temp_Board.set(5, temp_Board.get(7));
	temp_Board.set(7, temp_Board.get(6));
	temp_Board.set(6, temp1);
	temp1 = temp_Board.get(8);
	temp2 = temp_Board.get(9);
	temp_Board.set(8, temp_Board.get(17));
	temp_Board.set(9, temp_Board.get(19));
	temp_Board.set(17, temp_Board.get(3));
	temp_Board.set(19, temp_Board.get(2));
	temp_Board.set(3, temp_Board.get(22));
	temp_Board.set(2, temp_Board.get(20));
	temp_Board.set(22, temp1);
	temp_Board.set(20, temp2);
	temp_Board.set(24, 'G');
	
	///////////
	//System.out.println(temp_Board.toString());
	child.add(new RubikNode(temp_Board, this));
	//R
	temp_Board = new Vector<Character>();
	for (int i = 0; i < 24; i++) {
	    temp_Board.add(board.get(i));
	}
	temp_Board.add(' ');
	temp1 = temp_Board.get(20);
	temp_Board.set(20, temp_Board.get(22));
	temp_Board.set(22, temp_Board.get(23));
	temp_Board.set(23, temp_Board.get(21));
	temp_Board.set(21, temp1);
	temp1 = temp_Board.get(1);
	temp2 = temp_Board.get(3);
	temp_Board.set(1, temp_Board.get(5));
	temp_Board.set(3, temp_Board.get(7));
	temp_Board.set(5, temp_Board.get(9));
	temp_Board.set(7, temp_Board.get(11));
	temp_Board.set(9, temp_Board.get(13));
	temp_Board.set(11, temp_Board.get(15));
	temp_Board.set(13, temp1);
	temp_Board.set(15, temp2);
	temp_Board.set(24, 'R');
	
	///////////
	//System.out.println(temp_Board.toString());
	child.add(new RubikNode(temp_Board, this));
	//RC
	temp_Board = new Vector<Character>();
	for (int i = 0; i < 24; i++) {
	    temp_Board.add(board.get(i));
	}
	temp_Board.add(' ');
	temp1 = temp_Board.get(20);
	temp_Board.set(20, temp_Board.get(21));
	temp_Board.set(21, temp_Board.get(23));
	temp_Board.set(23, temp_Board.get(22));
	temp_Board.set(22, temp1);
	temp1 = temp_Board.get(1);
	temp2 = temp_Board.get(3);
	temp_Board.set(1, temp_Board.get(13));
	temp_Board.set(3, temp_Board.get(15));
	temp_Board.set(13, temp_Board.get(9));
	temp_Board.set(15, temp_Board.get(11));
	temp_Board.set(9, temp_Board.get(5));
	temp_Board.set(11, temp_Board.get(7));
	temp_Board.set(5, temp1);
	temp_Board.set(7, temp2);
	temp_Board.set(24, 'S');
	
	///////////
	//System.out.println(temp_Board.toString());
	/*child.add(new RubikNode(temp_Board, this));
	for(int i = 0 ; i<child.size();i++){
	    System.out.println(((RubikNode) child.get(i)).getBoard().toString());
	}
	*/
	return child;
    }

    public boolean isSame(Node elementAt) {
	for (int i = 0; i < 24; i++) {
	    if (getBoard().get(i) != ((RubikNode) elementAt).getBoard().get(i)) {
		
		return false;
	    }
	    
	//System.out.print(((RubikNode) elementAt).getBoard().elementAt(i)+" ");
	}
	//System.out.println(((RubikNode) elementAt).getBoard().toString()+" ");
	return true;

    }
    public Vector<Character> getBoard() {
	return board;
    }

    public void setBoard(Vector<Character> board) {
	this.board = board;
    }

    public void setParent(Node last) {

	this.parent = last;

    }

    public Node getParent() {

	return this.parent;
    }

    public void print() {
	// TODO Auto-generated method stub
	if (board.get(24).equals('R')) {
	    System.out.println(" R ");
	}
	if (board.get(24).equals('T')) {
	    System.out.println(" T ");
	}
	if (board.get(24).equals('F')) {
	    System.out.println(" F ");
	}
	if (board.get(24).equals('G')) {
	    System.out.println(" FC ");
	}
	if (board.get(24).equals('U')) {
	    System.out.println(" TC ");
	}
	if (board.get(24).equals('S')) {
	    System.out.println(" RC ");
	}

    }

    
}
