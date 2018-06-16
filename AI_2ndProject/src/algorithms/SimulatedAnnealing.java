package algorithms;


import problems.Node;
import problems.Problem;
import problems.WordTableProbem;

public class SimulatedAnnealing {

	private Node first;
	private Problem my_problem;
	private int step ;
	private int seenNode ;
	private double prob ;
	private double temperature ;
	private final double alpha ;
	private double initTemperature ;
	
	
	public SimulatedAnnealing (Problem my_Problem){
		this.my_problem=my_Problem;
		first=my_Problem.getFirstNode();
		step=0;
		seenNode=0;
		alpha=0.9;
		setTemperature(100);
		beginSearch(first);
		prob = 0.2 ;
		
	}
		
	private void fixProb(int EVal1 , int EVal2){
		
		setProb(Math.exp(-(EVal1-EVal2)/getTemperature()));		
	}
	private void beginSearch (Node node){
		
		while( getTemperature()> 1 ){
			step++;
			seenNode+=node.getChild().size();
			int index = (int)(Math.random()*node.getChild().size()) ;
			Node current = node.getChild().elementAt(index);
			
			if(current.getEval()>node.getEval()){
				node=current;
			}
			else {
				fixProb(current.getEval() ,node.getEval()) ;
				double r= Math.random();
				
				if(r>=getProb()){
					node=current;					
				}
			}
			fixTemperature_one();
		//	fixTemperature_two();
		//	fixTemperature_three();
		}
		
		showResult( node );

	}
	
	private void fixTemperature_one(){
		setTemperature(getTemperature()*alpha);
		
	}
	
	private void fixTemperature_two(){
		setTemperature(1/(1+alpha*step*step));		
	}
	
	private void fixTemperature_three(){
		setTemperature(1/(1+alpha*Math.log(1+step)));		
	}
	
	
	private void showResult( Node current_node ) {
		
	    float c=0 , temp;
		for(int i = 0 ; i < ((WordTableProbem ) my_problem).getDictionary().size();i++){
		temp =  ((WordTableProbem ) my_problem).getDictionary().get(i).length();
		c= c + temp + (temp-1)*2 ;
		}
		c = (current_node.getEval()/c )*100 ;
		System.out.println();
		
		System.out.println("result of simmulated annealing with fix Teperature ONE ");
		System.out.println("match percentage : " + (int)c +"% ");
		System.out.println("count of seenNodes : "+seenNode);
		System.out.println("count of steps : "+ step);
		current_node.print();
		System.out.println();
		System.out.println("****************");
		System.out.println();
		
	}

	private void setProb(double prob) {
		this.prob = prob;
	}
	
	private double getProb() {
		return prob;
	}
	
	private double getTemperature() {
		return temperature;
	}
	
	private void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
}
