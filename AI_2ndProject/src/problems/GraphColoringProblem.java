package problems;

import algorithms.HillClimbing;
import java.util.Scanner;

/**
 *
 * @author < zahra dehghanian>
 */
public class GraphColoringProblem extends Problem {

    int V;
    int[][] graph;
    int numOfColors;
    

    public GraphColoringProblem() {
	Scanner scan = new Scanner(System.in);
	System.out.println("Welcome to Graph Coloring Problem");
	/**
	 * Accept number of vertices *
	 */
	System.out.println("Enter number of verticesz\n");
	V = scan.nextInt();
	/**
	 * get graph *
	 */
	System.out.println("\nEnter matrix\n");
	graph = new int[V][V];
	for (int i = 0; i < V; i++) {
	    for (int j = 0; j < V; j++) {
		graph[i][j] = scan.nextInt();
		
	    }
	}

	System.out.println("\nEnter number of colors");
	numOfColors = scan.nextInt();
	
	HillClimbing hc = new HillClimbing(this);

    }

    public Node getFirstNode() {
	int[] color;
	color = new int[V];
	for (int i = 0; i < V; i++) {
	    color[i] = 1;
	}
	Node n = new GraphColoringNode(color , this, null);
	return n;

    }

    public Node getRandomNode() {
	int[] color = new int[V];
	for (int i = 0; i < V; i++) {
	    color[i] = ((int) (Math.random() * numOfColors))%V ;
	}
	Node n = new GraphColoringNode(color,this, null);
	return n;
    }

    public static void main(String arg0[]) {
	GraphColoringProblem gcp = new GraphColoringProblem();
    }
    
}
