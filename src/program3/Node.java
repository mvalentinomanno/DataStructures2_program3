/*
 * Authors: Michael Valentino-Manno, Benjamin Seal
 * Date: 4/10/18
 * Overview: Program that reads in an adjacency matrix and works prim's, kruskal's
 * and floyd warshall's algorithms. The input files are required to be CSV files with
 * x's to represent infinity and the first row is the vertex names. Inputs must be in a 
 * folder named input, and the file names must be "primInput.csv", "kruskalInput.csv", "floydwarshallInput.csv"
 */
package program3;

public class Node implements Comparable <Node> { //node class to represent an edge
    int weight; //edge has a weight and two verticies
    public int vertexa;
    public int vertexb;
    
    Node(int inWeight, int va, int vb){
        weight = inWeight;
        vertexa = va;
        vertexb = vb;
    }
    
    @Override
    public int compareTo(Node t){ //comparable so priority Q can sort
        if(this.weight > t.weight){
            return 1;
        }else if(this.weight < t.weight){
            return -1;
        }
        return 0;
    }
}
