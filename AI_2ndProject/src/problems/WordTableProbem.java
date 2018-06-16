// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package problems;

import algorithms.SimulatedAnnealing;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author  < zahra dehghanian>
 */

public class WordTableProbem extends Problem  {
   char [][] table ;
   int dimansion ;
   int numOfWords ;
   Vector<String> dictionary ;
   public WordTableProbem (){
       System.out.println("welcome to  word table problem ");
       System.out.println("enter dimansion ");
       Scanner s = new Scanner (System.in) ;
       dimansion = s.nextInt();
       table = new char[dimansion][dimansion];
       System.out.println("enter table");
       for(int i = 0 ; i< dimansion ; i++)
	   for(int j=0 ; j< dimansion ; j++)
	      table[i][j] = s.next().charAt(0);
       System.out.println("enter number of word in dictionary ");
       numOfWords = s.nextInt();
       dictionary = new Vector<String>();
       System.out.println("enter dictionary");
       for(int i = 0 ; i< numOfWords ; i++)
	   
	      dictionary.add ( s.next());
       
       SimulatedAnnealing sa = new SimulatedAnnealing(this);
   }
   
 public Node getFirstNode (){
     WordTableNode n = new WordTableNode(table , null , this);
     return n ;
 }
 
 public Vector<String> getDictionary(){
 return dictionary ;
 }
public static void main(String arg0[]){
WordTableProbem wtp = new WordTableProbem();
}
 
}
/*
3
e r t
e h l
e i d
3
ret
hel
tli


*/