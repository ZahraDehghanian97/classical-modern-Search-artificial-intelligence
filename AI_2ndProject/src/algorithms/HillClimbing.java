package algorithms;

import java.util.Vector;
import problems.Node;
import problems.Problem;

public class HillClimbing {

	private Node first;
	private Problem my_problem;
	private int step ;
	private int seenNode ;
	private int starts ;
	//getFistNode getEval getChild getRandomNode 
	public HillClimbing(Problem my_Problem){
		
		this.my_problem=my_Problem;
		first=my_problem.getFirstNode();
		starts=1 ;
		
		
		step =0;
		seenNode=0;
		simple_HC(first) ;
		step =0;
		seenNode=0;
		stochastic_HC(first) ;
		step =0;
		seenNode=0;
		firstchoice_HC(first);
		step =0;
		seenNode=0;
		random_restart_hc(first);
		
		return ;
			
	}
	
	private void simple_HC (Node current){
		
		int current_Eval = current.getEval();
		int EVal=Integer.MAX_VALUE;
		Node Current_node = null;
		step++;
		seenNode+=current.getChild().size();
		
		for (int i = 0; i < current.getChild().size(); i++) {
		
			if(current.getChild().get(i).getEval()<EVal){
				EVal= current.getChild().get(i).getEval();
				Current_node= current.getChild().get(i);
			}
		}
		
		
		if(Current_node != null && EVal<current_Eval){
			simple_HC(Current_node);
		}
		else {
			showResult(current , "simple");
		}
		
	}
	
	private void stochastic_HC (Node current){
		
		int current_Eval = current.getEval();
		step++;
		seenNode+=current.getChild().size();
		Vector <Node> nodes = new Vector<Node>() ;
		
		for (int i = 0; i < current.getChild().size(); i++) {
		
			if(current.getChild().get(i).getEval()<current_Eval){
				nodes.add(current.getChild().get(i));
			}
		}
		
		
		if(nodes != null && nodes.size()>0 ){
			
			int index =(int)(Math.random()*nodes.size());
			stochastic_HC(nodes.elementAt(index));
		}
		else {
			showResult(current ,"stochastic");
		}
		
	}
	
	private void firstchoice_HC (Node current){
		
		int current_Eval = current.getEval();
		int EVal=Integer.MAX_VALUE;
		Node Current_node = null;
		step++;
		seenNode+=current.getChild().size();
	
		for (int i = 0; i < current.getChild().size(); i++) {
		
			if(current.getChild().get(i).getEval()<current_Eval){
				EVal= current.getChild().get(i).getEval();
				Current_node= current.getChild().get(i);
				break;
			}
	}
	
	
	if(Current_node != null ){
		firstchoice_HC(Current_node);
	}
	else {
		showResult(current , "firstChoice");
	}
		
	}
	

	private void random_restart_hc (Node current){
		
			Node node = simple_hc2(current);
			
		while (node.getEval()!=0){	
			starts++;
			node= simple_hc2 (my_problem.getRandomNode());
			
		}	
		
		showResult(node,"Random restart");
		System.out.println("explored " +starts+ " random places !");
	}
	
	
	private Node simple_hc2(Node current) {
		
		int current_Eval = current.getEval();
		int EVal=Integer.MAX_VALUE;
		
		Node Current_node = null;
		step++;
		seenNode+=current.getChild().size();
		
		for (int i = 0; i < current.getChild().size(); i++) {
		
			if(current.getChild().get(i).getEval()<EVal){
				EVal= current.getChild().get(i).getEval();
				Current_node= current.getChild().get(i);
			}
		}
		
		
		if(Current_node != null && EVal<current_Eval){
			 return simple_hc2(Current_node);
		}
		else {
			return current;
		}
		
	}

	private void showResult(Node current_node , String str) {
		
		System.out.println();
		System.out.println("result of "+ str +" HillClimbing with EVal : " + current_node.getEval());
		System.out.println("count of seenNodes : "+seenNode);
		System.out.println("count of steps : "+ step);
		current_node.print();
		System.out.println();
		System.out.println("****************");
		System.out.println();
		
		
	}
	
}
