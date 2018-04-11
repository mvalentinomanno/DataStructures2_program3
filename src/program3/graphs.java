/*
 * Authors: Michael Valentino-Manno, Benjamin Seal
 * Date: 4/10/18
 * Overview: Program that reads in an adjacency matrix and works prim's, kruskal's
 * and floyd warshall's algorithms. The input files are required to be CSV files with
 * x's to represent infinity and the first row is the vertex names. Inputs must be in a 
 * folder named input, and the file names must be "primInput.csv", "kruskalInput.csv", "floydwarshallInput.csv"
 */
package program3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class graphs {

    public void primsInput() { //method that reads in the input file for prims
        BufferedReader reader = null; //reader

        try {

            File file = new File("input/primInput.csv"); //set up input file
            reader = new BufferedReader(new FileReader(file)); //new file
            int count = 0; //keeps track of current line
            String firstl;
            if ((firstl = reader.readLine()) != null) { //read in first line (vertex labels)
                String[] firstline = firstl.split(","); //split and read in
                String[][] amatrix = new String[firstline.length + 1][firstline.length];

                for (int i = 0; i < amatrix[count].length; i++) {
                    amatrix[count][i] = firstline[i]; //save data to 2 d matrix
                }
                String line;

                while ((line = reader.readLine()) != null) { //read in line by line
                    count++;
                    String[] temp = line.split(","); //splits line
                    if (count < amatrix.length) { 
                        for (int i = 0; i < amatrix[count].length; i++) {
                            amatrix[count][i] = temp[i]; //read into the adjacency matrix

                        }
                    }
                }
                System.out.println("Initial matrix before Prim's algorithm");
                printMatrix(amatrix); //prints the initial matrix
                primsAlgo(amatrix); //execute prims
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void kruskalsInput() {
        BufferedReader reader = null; //reader

        try {

            File file = new File("input/kruskalInput.csv"); //set up input file and reader
            reader = new BufferedReader(new FileReader(file)); //new file
            int count = 0; //keeps track of current line 
            String firstl;
            if ((firstl = reader.readLine()) != null) { //read in first line (vertex names)
                String[] firstline = firstl.split(",");
                String[][] amatrix = new String[firstline.length + 1][firstline.length];

                for (int i = 0; i < amatrix[count].length; i++) {
                    amatrix[count][i] = firstline[i]; //insert what was just read into the 2d matrix
                }
                String line;

                while ((line = reader.readLine()) != null) { //read in line by line
                    count++;
                    String[] temp = line.split(","); //splits line
                    if (count < amatrix.length) { 
                        for (int i = 0; i < amatrix[count].length; i++) {
                            amatrix[count][i] = temp[i]; //save line just read into adjacency matrix

                        }
                    }
                }
                System.out.println("Initial matrix before Kruskal's algorithm");
                printMatrix(amatrix); //print initial matrix
                kruskals(amatrix); //execute kruskals
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void floydwarshallsInput() {
        BufferedReader reader = null; //reader

        try {

            File file = new File("input/floydwarshallInput.csv"); //set up input file and reader
            reader = new BufferedReader(new FileReader(file)); //input file
            int count = 0;
            String firstl;
            if ((firstl = reader.readLine()) != null) { //reads in the first line
                String[] firstline = firstl.split(","); //splits on commas
                String[][] amatrix = new String[firstline.length + 1][firstline.length];

                for (int i = 0; i < amatrix[count].length; i++) {
                    amatrix[count][i] = firstline[i]; //save the rist input line into a 2d array
                }
                String line;

                while ((line = reader.readLine()) != null) { //read in line by line
                    count++;
                    String[] temp = line.split(","); //splits line
                    if (count < amatrix.length) {
                        for (int i = 0; i < amatrix[count].length; i++) {
                            amatrix[count][i] = temp[i]; //insert what was just read into the adjacency matrix

                        }
                    }
                }
                floydAlgo(amatrix); //execute floyd warshalls 
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printMatrix(String amatrix[][]) { //method to print initial matricies
        System.out.println("---------------------"); //different from other print b/c
        for (int i = 0; i < amatrix.length; i++) { //this one allows to print the string 2d array
            for (int j = 0; j < amatrix[i].length; j++) { // (initially with the letters for verticies
                System.out.print(amatrix[i][j]);
                if (amatrix[i].length - j > 1) {
                    System.out.print(",");
                }
            }
            System.out.println();

        }
        System.out.println("--------------------");
    }

    public void printMatrixInts(int amatrix[][], String[] vert) { //print used in floyd warshalls
        for (int i = 0; i < amatrix.length; i++) {
            System.out.print(vert[i] + " "); //prints out the vertex labels on the left
            for (int j = 0; j < amatrix[i].length; j++) {
                if (amatrix[i][j] > 10000000) {
                    System.out.print("x"); //print x if the number is infinite (near infinite)
                } else {
                    System.out.print(amatrix[i][j]); //if not infinite, print the number
                }

                if (amatrix[i].length - j > 1) {
                    System.out.print(",");
                }
            }
            System.out.println();

        }
        System.out.println("--------------------");
    }

    public void floydAlgo(String amatrix[][]) {
        String vert[] = amatrix[0]; //stores vertex names
        int d[][] = new int[amatrix[0].length][amatrix[0].length]; //stores the adjacency matrix

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                if (amatrix[i + 1][j].equals("x")) {
                    d[i][j] = 400000000; //"infinity", if MAX_VALUE was used, there would be overflow, and negative numbers would occur
                } else {
                    d[i][j] = Integer.parseInt(amatrix[i + 1][j]); //read in value
                }
            }
        }

        for (int i = 0; i < d.length; i++) {
            d[i][i] = 0; //this diagonal is always going to have zeros
        }
        System.out.println("Initial matrix before Floyd-Warshall's algorithm");
        printMatrixInts(d, vert); //prints initial matrix
        for (int k = 0; k < d.length; k++) { //triple for the go through the table
            for (int i = 0; i < d.length; i++) { //and compare paths
                for (int j = 0; j < d.length; j++) { 
                    if (d[i][j] > (d[i][k] + d[k][j])) { //if the weight of the sum is less
                        d[i][j] = d[i][k] + d[k][j]; //new lowest weight found
                        System.out.print("  ");
                        for (int y = 0; y < vert.length; y++) {
                            System.out.print(vert[y]); //print vertex labels
                            if (vert.length - y > 1) {
                                System.out.print(",");
                            }
                        }
                        System.out.println();
                        printMatrixInts(d, vert); //print matrix each update
                    }
                }
            }
        }
        System.out.println("The final matrix is as follows:");
        System.out.println("--------------------");
        System.out.print("  ");
        for (int y = 0; y < vert.length; y++) {
            System.out.print(vert[y]); //print final matrix verticies
            if (vert.length - y > 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        printMatrixInts(d, vert);//print final matrix
    }

    public void primsAlgo(String G[][]) {
        String verticies[] = new String[G[0].length]; //holds vertex labels
        boolean visit[] = new boolean[verticies.length]; //if vertex is visited
        int intG[][] = new int[verticies.length][verticies.length]; //adjacency matrix

        for (int o = 1; o < visit.length; o++) { //initially nothing is visited
            visit[o] = false;
        }

        for (int i = 0; i < G[0].length; i++) { //read in verticies
            verticies[i] = G[0][i];
        }

        for (int i = 0; i < intG.length; i++) { //update adjacency matrix
            for (int j = 0; j < intG.length; j++) {
                if (G[i + 1][j].equals("x")) {
                    intG[i][j] = Integer.MAX_VALUE;
                } else {
                    intG[i][j] = Integer.parseInt(G[i + 1][j]);
                }

            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(); //new priority Q using edges, sorting by weights
        for (int i = 0; i < intG.length; i++) {
            if (intG[0][i] < Integer.MAX_VALUE) {
                pq.add(new Node(intG[0][i], 0, i)); //add first row to be checked, the A line
            }                                       //always starts from the first verticy
        }

        Node u;
        System.out.println("Prim's MST edges:");
        while (!pq.isEmpty()) { //go until the Q is empty
            u = pq.remove(); //remove the lowest weight

            if (visit[u.vertexa] == false || visit[u.vertexb] == false) { //if a vertex of the edge isnt visited
                visit[u.vertexa] = true; //add the edge to the MST
                visit[u.vertexb] = true; //update visited booleans
                System.out.println(verticies[u.vertexa] + " <--> " + verticies[u.vertexb] + ", weight: " + u.weight);
                //print the edge
                for (int i = 0; i < intG.length; i++) { //add the new line, the row of the vertex just added
                    pq.add(new Node(intG[u.vertexb][i], u.vertexb, i));
                }
            }
        }
        System.out.println("--------------------");
    }

    public void kruskals(String G[][]) {
        String verticies[] = new String[G[0].length]; //vertex labels
        String clusters[] = new String[256]; //arrays hold clusters
        String clusters2[] = new String[256];
        int intG[][] = new int[verticies.length][verticies.length]; //adjacency matrix

        for (int i = 0; i < G[0].length; i++) { //read in verticies
            verticies[i] = G[0][i];
        }

        for (int i = 0; i < clusters.length; i++) { //initialize clusters with symbols that wont be used
            clusters[i] = "'";
            clusters2[i] = "%";
        }

        for (int i = 0; i < verticies.length; i++) { //read in adjacency matrix
            for (int j = 0; j < verticies.length; j++) {
                if (G[i + 1][j].equals("x")) {
                    intG[i][j] = Integer.MAX_VALUE;
                } else {
                    intG[i][j] = Integer.parseInt(G[i + 1][j]);
                }

            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(); //initialize priority queue
        for (int i = 0; i < intG.length; i++) {
            for (int j = 0; j < intG[i].length; j++) { //add every edge (non infinity) to the Q
                if (intG[i][j] < Integer.MAX_VALUE) {
                    pq.add(new Node(intG[i][j], i, j));
                }
            }
        }
        int count = verticies.length; //keeps track of how many edges are remaining to be added
        Node u = null;
        boolean same = false; //booleans used for cases in following while
        boolean ck = false;
        boolean kk = false;
        boolean yes1 = false;
        boolean yes2 = false;
        int cind = 0;

        System.out.println("Kruskal's MST edges:");
        while (count > 1) { //# of verticies - 1 is the amount of edges in the MST
            same = false; //all initially false
            yes1 = false;
            yes2 = false;
            ck = false;
            kk = false;

            if (!pq.isEmpty()) {
                u = pq.remove(); //remove first item
            }

            for (int i = 0; i < clusters.length; i++) {
                if (verticies[u.vertexa].equals(clusters[i])) {
                    for (int j = 0; j < clusters.length; j++) {
                        if (verticies[u.vertexb].equals(clusters[j])) {
                            same = true; //if they're in same cluster
                        }
                    }
                }
            }

            for (int i = 0; i < clusters.length; i++) {
                if (verticies[u.vertexa].equals(clusters2[i])) {
                    for (int j = 0; j < clusters.length; j++) {
                        if (verticies[u.vertexb].equals(clusters2[j])) {
                            same = true; //if they're in same cluster
                        }
                    }
                }
            }

            int uu = 0;
            for (int i = 0; i < clusters.length; i++) { //checks if items are in different clusters
                for (int j = 0; j < clusters.length; j++) {
                    if (clusters[i].equals(clusters2[j])) {
                        for (int t = 0; t < clusters2.length; t++) {
                            if (!(clusters2[t].equals("%")) && !(clusters2[t].equals(clusters2[j]))) {
                                if (uu < 10) { //if they're in different clusters, add one cluster to the other
                                    clusters[cind] = clusters2[t];
                                    cind++;
                                    uu++;
                                }
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < clusters.length; i++) { //checks if items are in the same cluster
                if (verticies[u.vertexb].equals(clusters[i])) {
                    ck = true; 
                }
                if (verticies[u.vertexa].equals(clusters[i])) {
                    kk = true;
                }

            }

            for (int i = 0; i < clusters.length; i++) { //checks if items are in the same clusers
                if (verticies[u.vertexb].equals(clusters2[i])) {
                    ck = true;
                }
                if (verticies[u.vertexa].equals(clusters2[i])) {
                    kk = true;
                }

            }

            if (count < verticies.length) {
                if (!ck && !kk) { //if the items aren't in a cluster
                    System.out.println(verticies[u.vertexa] + " <--> " + verticies[u.vertexb] + ", weight: " + u.weight);
                    count--; //add the vertex, decrease the remaining edges
                    clusters2[cind] = verticies[u.vertexa]; //add the edes to the new cluster
                    cind++;
                    clusters2[cind] = verticies[u.vertexb];
                    cind++;
                    same = true;
                }
            }

            if (!same) { //if the items aren't in the same cluster
                System.out.println(verticies[u.vertexa] + " <--> " + verticies[u.vertexb] + ", weight: " + u.weight);
                count--; //add vertex, decrease remaining edges

                for (int i = 0; i < clusters.length; i++) { //checks for the edge that isnt already a part of a cluster
                    if (clusters[i].equals(verticies[u.vertexa])) { //vertex a is?
                        yes1 = true;
                    }
                    if (clusters[i].equals(verticies[u.vertexb])) { //vertex b is?
                        yes2 = true;
                    }
                }

                if (!yes1) { //if a wasnt found, add it to cluster
                    clusters[cind] = verticies[u.vertexa];
                    cind++;
                }
                if (!yes2) { //if b wasnt found, add it to cluster
                    clusters[cind] = verticies[u.vertexb];
                    cind++;
                }

            }
        }
        System.out.println("--------------------");
    }
}
