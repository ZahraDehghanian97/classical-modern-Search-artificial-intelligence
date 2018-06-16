package problems;

import java.util.Random;

public class EquationNode extends Node{

	double value ;
	private double varianse = .0000001;
	private double expected_value =0;
	private double fitness;
	private double cumultive ;
	private double lowerbound ;
	private double upperbound ;
	private Random randomno;
	
	public EquationNode(double value , Random randomno){
		
		this.randomno=randomno;
		lowerbound = 0;
		upperbound = 3.14;
		cumultive = 0;
		this.value=value;
		setFitness();
		
	}
	
	public void setCumultive(double cumultive) {
		this.cumultive = cumultive;
	}
	
	public double getCumultive(){
		return this.cumultive ;
	}
	public void setFitness() {

		this.fitness =1/( 1+Math.abs(Math.sin(Math.toRadians(value))-(value*(value-1))) );
		
	}
	public double getFitness(){		
		
		return this.fitness;		
	}
	
	public Node CrossOver(Node node , Node node2){
		
		EquationNode temp = new EquationNode(this.getvalue()+ node.getvalue() , this.randomno);
		return temp;
		
	}
	
	@Override
	public double getvalue() {
		return this.value;
	}
	
	public void setValue(double value){
		this.value=value;
		
	}
	
	public void mutation(){
		
		double gussianR = 0;
		  double num = 0;
		  boolean check = false;
		
		  while(!check){
		   gussianR = (randomno.nextGaussian()*varianse)+expected_value;
		   num = gussianR+this.value;
		   if(num <= upperbound && num >= lowerbound){
		    check = true;
		   }
		  }
		  this.value=num;
		
	}
}
