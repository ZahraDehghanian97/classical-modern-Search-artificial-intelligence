package algorithms;

import problems.Problem;

/**
 *
 * @author Your Name < zahra dehghanian>
 */


public class IDDFS {
    Problem my_Problem ;
    String type ;
    int depth;

    public IDDFS(Problem my_problem, String type) {
	this.my_Problem = my_problem ;
	this.type = type ;
	depth = 0 ;
	System.out.println("This is IDDFS search ("+type+") :");
	System.out.println("***************");
	while(true){
	 DLS my_dls= new DLS(my_Problem,depth ,"graph");
	 if(my_dls.checkDepth()){
	  break ;}
	 else depth++ ;
	
	}
    
}
}