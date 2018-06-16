package problems;

import algorithms.Genetic;
import java.util.Random;
import java.util.Vector;

public class EquationProblem extends Problem {
	
	private int population ;
	private int generated_childs ;
	private double lowerbound ;
	private double upperbound ;
	private Vector<Node> individuals ;
	private Vector<Node> childs ;
	private int myrand=-1;
	private Random rand;
	private Vector<Double> min_fitness ;
	private Vector <Double> max_fitness ;
	private Vector <Double> mean_fitness ;
	
	
	public EquationProblem(int population , double lowerbound , double upperbound , int generated_childs){
		
		mean_fitness = new Vector<Double>();
		max_fitness = new Vector<Double>();
		min_fitness = new Vector<Double>();
		
		rand=  new Random();
		this.population= population;
		this.upperbound= upperbound;
		this.lowerbound= lowerbound;
		this.generated_childs=generated_childs;
		childs = new Vector<Node>();		
		individuals = new Vector<Node>();		
		Genetic gn = new Genetic(this);	
		
	}
	
	public Vector<Node> setPopulation() {
		
		Vector<Double> vec = new Vector<Double>();
		
		while (vec.size()<population) {
			double j = Math.random()*(upperbound-lowerbound)+lowerbound;			
			if(!vec.contains(j))
				vec.add(j);
			
		}			
		for (int i = 0; i < population; i++) {
			EquationNode eq = new EquationNode(vec.elementAt(i), this.rand);
			individuals.add(eq);
		}		
		return individuals ;
				
	}
	public Vector<Node> setChildsOFGeneration(){
		
		childs.removeAllElements();
		myrand++;
		Vector<Double> vec = new Vector<Double>();
		
		while (vec.size()<generated_childs) {			
			int x= (int) (Math.random()*population+myrand)%population;
			int y= (int) (Math.random()*population+myrand)%population;
			double j = (individuals.elementAt(x).getvalue()+individuals.elementAt(y).getvalue())/2;			
				vec.add(j);	
				
		}
		
		for (int i = 0; i < generated_childs; i++) {			
			EquationNode eq = new EquationNode(vec.elementAt(i), this.rand);
			
			childs.add(eq);
		}
				
		return childs ;
		
				
	}
	
	public double getGenerationFitness (){
		
		double temp=0;
		double min =1 ;
		double max =0 ;
		
		for (int i = 0; i < population; i++) {
			if(individuals.elementAt(i).getFitness()>max)
				max= individuals.elementAt(i).getFitness();
			if(individuals.elementAt(i).getFitness()<min)
				min =individuals.elementAt(i).getFitness() ;
			temp+=individuals.elementAt(i).getFitness();
		}
		
		min_fitness.add(min);
		max_fitness.add(max);
		mean_fitness.add(temp/population);
		
		System.out.println("min : "+min +" max is: "+ max +"average is :"+ temp/population);
		System.out.println();
		System.out.println();
		return (temp/population);		
	}
	
	public void print(){
		System.out.println("this is min");
		
		for (int i = 0; i < min_fitness.size(); i++) {
			System.out.println(min_fitness.elementAt(i));
		}
		
		System.out.println("max");
		for (int i = 0; i < max_fitness.size(); i++) {
			System.out.println(max_fitness.elementAt(i));
		}
		
		System.out.println("mean");
		for (int i = 0; i < mean_fitness.size(); i++) {
			System.out.println(mean_fitness.elementAt(i));
		}
	}
	
	public boolean found(){	
		
		for (int i = 0; i < population; i++) {
			if(individuals.elementAt(i).getFitness()==1){
				System.out.println();
				System.out.println(" answer found : "+individuals.elementAt(i).getvalue());
				return true;
			}				
		}
		return false;
		
	}
	
	public void mutateChilds (){
				
		for (int i = 0; i < generated_childs ; i++) {
			childs.elementAt(i).mutation();
		}	
		//System.out.println("finished");
	}
	
	public void selectParent(){
		
		for (int i = 0; i < population; i++) {
			childs.add(individuals.get(i));
		}
		individuals.removeAllElements();

		
		double sum =0;
		for (int i = 0; i < childs.size(); i++) {
			sum+=childs.get(i).getFitness();
		}
		
		childs.elementAt(0).setCumultive(childs.get(0).getFitness()/sum);
		for (int i = 1; i < childs.size(); i++) {
			childs.elementAt(i).setCumultive((childs.get(i).getFitness()/sum)+childs.get(i-1).getCumultive());
		}		
		//choose individuals
		while(individuals.size()<population)  {
			double rand = Math.random();
			int x =0 ;
			
			for (int j = 1; j < childs.size(); j++) {
				if(rand<=childs.get(j).getCumultive() && rand >=childs.get(j-1).getCumultive()){
					x=j;	
					break;
				}
			}			
			boolean add = true;		
			individuals.add(childs.get(x));
		}		

	
	}
	
	/*public static void main (String arg0[]){
		EquationProblem eq = new EquationProblem(20, 0.2, 3.14 ,20);
	}
	*/
}
