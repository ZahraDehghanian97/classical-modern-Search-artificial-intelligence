package algorithms;

import java.util.Vector;
import problems.*;

public class BFS {

	private Vector<Node> closeList;

	private Vector<Node> openList;
	private Node first;
	private RubikProblem my_problem;
	private String type;
	private Integer memory;
	private Integer expand;
	private Integer seen_nodes;

	public BFS(RubikProblem my_problem , String type) {
		this.my_problem = my_problem;

		closeList = new Vector<Node>();
		this.type=type;
		openList = new Vector<Node>();
		memory = 0;
		expand = 0;
		seen_nodes = 0;
		first = my_problem.getFirstNode();
		openList.add(first);

		start_BFS_search();

	}

	

	public void start_BFS_search() {

		while (!openList.isEmpty()) {

			if (openList.firstElement().isFinal()) {
				showResult_g(openList.firstElement());
				return;
			}

			Node last = openList.firstElement();
			
			if(type.equalsIgnoreCase("graph")){
			closeList.add(last);			
			}
			
			openList.remove(openList.firstElement());
			expand++;

			for (int i = 0; i < last.getChild().size(); i++) {

				boolean what = true;
				
				for (int j = 0; j < closeList.size(); j++) {
					if (closeList.elementAt(j).isSame(last.getChild().elementAt(i)))
						what = false;
				}
				if (what) {

					openList.add(last.getChild().elementAt(i));
					seen_nodes++;
				}
			}

			if (openList.size()+closeList.size() > memory) {
				memory = openList.size()+closeList.size();
			}

		}

	}

	

	private void showResult_g(Node node) {
		// TODO Auto-generated method stub

		System.out.println("This is BFS search ("+ type +") : ");
		System.out.println("this is count of expanded nodes : " + expand);
		System.out.println("this is count of abserved nodes : " + seen_nodes);
		System.out.println("and the memory usage : " + memory);
		System.out.println();
		System.out.println("***************");
		System.out.print("Answer is : ");
		while (node.getParent() != null) {
			node.print();
			node = node.getParent();
			

		}
		System.out.println();
		System.out.println();
		

	}

}
