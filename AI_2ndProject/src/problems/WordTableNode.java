// Error reading included file Templates/Classes/Templates/Licenses/license-default.txtreading included file Templates/Classes/Templates/Licenses/license-default.txt
package problems;

import java.util.Vector;

/**
 *
 * @author  < zahra dehghanian>
 */
public class WordTableNode extends Node {

    char[][] table;
    int dimansion;
    WordTableProbem my_parent;
    WordTableNode parent;

    public WordTableNode(char[][] table, WordTableNode parent, WordTableProbem my_parent) {
	this.my_parent = my_parent;
	this.parent = parent;
	this.table = table;
	this.parent = parent;
	dimansion = my_parent.dimansion;
    }

    public Vector<Node> getChild() {
	Vector<Node> n = new Vector<Node>();
	char swap;
	/*for (int i = 0; i < dimansion; i++) {
	    for (int j = 0; j < dimansion; j++) {
		swap = table[i][j];
		table[i][j] = table[0][0];
		table[0][0] = swap;
		char[][] t = new char[dimansion][dimansion];
		for (int ii = 0; ii < dimansion; ii++) {
		    for (int jj = 0; jj < dimansion; jj++) {
			t[ii][jj] = table[ii][jj];
		    }
		}
		n.add(new WordTableNode(t, this, my_parent));
		swap = table[i][j];
		table[i][j] = table[0][0];
		table[0][0] = swap;

	    }
	}
	*/
	for (int i = 0; i < dimansion * dimansion; i++) {
	    swap = table[i / dimansion][i % dimansion];
	    table[i / dimansion][i % dimansion] = table[((i + 1) / dimansion)%dimansion][(i + 1) % dimansion];
	    table[((i + 1) / dimansion)%dimansion][(i + 1) % dimansion] = swap;
	    char[][] t = new char[dimansion][dimansion];
	    for (int ii = 0; ii < dimansion; ii++) {
		for (int jj = 0; jj < dimansion; jj++) {
		    t[ii][jj] = table[ii][jj];
		}
	    }
	    n.add(new WordTableNode(t, this, my_parent));
	    swap = table[i / dimansion][i % dimansion];
	    table[i / dimansion][i % dimansion] = table[((i + 1) / dimansion)%dimansion][(i + 1) % dimansion];
	    table[((i + 1) / dimansion)%dimansion][(i + 1) % dimansion] = swap;
	}

	return n;
    }

    public void print() {
	for (int i = 0; i < dimansion; i++) {
	    for (int j = 0; j < dimansion; j++) {
		System.out.print(table[i][j]);

	    }
	    System.out.println("");
	}

    }

    public int getEval() {
	int eval = 0;
	int wichNumber;
	for (int i = 0; i < my_parent.dictionary.size(); i++) {
	    wichNumber = 0;
	    for (int z = 0; z < dimansion; z++) {
		for (int j = 0; j < dimansion; j++) {
		    if (my_parent.dictionary.get(i).charAt(wichNumber) == table[z][j]) {
			if (z < dimansion - 1 && my_parent.dictionary.get(i).length() > wichNumber + 1 && my_parent.dictionary.get(i).charAt(wichNumber + 1) == table[z + 1][j]) {
			    wichNumber++;
			    eval = eval + 2;
			}
			if (j < dimansion - 1 && my_parent.dictionary.get(i).length() > wichNumber + 1 && my_parent.dictionary.get(i).charAt(wichNumber + 1) == table[z][j + 1]) {
			    wichNumber++;
			    eval = eval + 2;
			}
			eval++;
		    }

		}
	    }
	}
	return eval;
    }

}
