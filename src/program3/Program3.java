/*
 * Authors: Michael Valentino-Manno, Benjamin Seal
 * Date: 4/10/18
 * Overview: Program that reads in an adjacency matrix and works prim's, kruskal's
 * and floyd warshall's algorithms. The input files are required to be CSV files with
 * x's to represent infinity and the first row is the vertex names. Inputs must be in a 
 * folder named input, and the file names must be "primInput.csv", "kruskalInput.csv", "floydwarshallInput.csv"
 */
package program3;

public class Program3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        graphs graphWork = new graphs(); //new instance of graphs class
        graphWork.floydwarshallsInput();
        graphWork.primsInput(); //call each method to read in their respective files
        graphWork.kruskalsInput();
    } // end main()

}
