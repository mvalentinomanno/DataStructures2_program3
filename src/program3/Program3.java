/*
 * Authors: Michael Valentino-Manno
 * Date: 4/10/18
 * Overview: Program that reads in an adjacency matrix and works prim's, kruskal's
 * and floyd warshall's algorithms
 */
package program3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Program3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        graphs graphWork = new graphs();
       // graphWork.primsInput();
       // graphWork.kruskalsInput();
        graphWork.floydwarshallsInput();
    } // end main()

}
