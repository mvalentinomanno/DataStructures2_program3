/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 *
 * @author katsura496
 */
public class graphs {

    public void primsInput() {
        int value;
        BufferedReader reader = null; //reader

        try {

            File file = new File("input/primInput.csv"); //set up input file and reader
            reader = new BufferedReader(new FileReader(file));
            int count = 0;
            String firstl;
            if ((firstl = reader.readLine()) != null) {
                String[] firstline = firstl.split(",");
                String[][] amatrix = new String[firstline.length + 1][firstline.length];

                for (int i = 0; i < amatrix[count].length; i++) {
                    amatrix[count][i] = firstline[i];
                }
                String line;

                while ((line = reader.readLine()) != null) { //read in line by line
                    count++;
                    String[] temp = line.split(","); //splits line
                    if (count < 7) {
                        for (int i = 0; i < amatrix[count].length; i++) {
                            amatrix[count][i] = temp[i];

                        }
                    }
                }
                System.out.println("Initial matrix before Prim's algorithm");
                printMatrix(amatrix);
                primsAlgoo(amatrix);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void kruskalsInput() {
        int value;
        BufferedReader reader = null; //reader

        try {

            File file = new File("input/kruskalInput.csv"); //set up input file and reader
            reader = new BufferedReader(new FileReader(file));
            int count = 0;
            String firstl;
            if ((firstl = reader.readLine()) != null) {
                String[] firstline = firstl.split(",");
                String[][] amatrix = new String[firstline.length + 1][firstline.length];

                for (int i = 0; i < amatrix[count].length; i++) {
                    amatrix[count][i] = firstline[i];
                }
                String line;

                while ((line = reader.readLine()) != null) { //read in line by line
                    count++;
                    String[] temp = line.split(","); //splits line
                    if (count < 7) {
                        for (int i = 0; i < amatrix[count].length; i++) {
                            amatrix[count][i] = temp[i];

                        }
                    }
                }
                System.out.println("Initial matrix before Kruskal's algorithm");
                printMatrix(amatrix);
                kruskals(amatrix);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void floydwarshallsInput() {
        int value;
        BufferedReader reader = null; //reader

        try {

            File file = new File("input/floydwarshallInput.csv"); //set up input file and reader
            reader = new BufferedReader(new FileReader(file));
            int count = 0;
            String firstl;
            if ((firstl = reader.readLine()) != null) {
                String[] firstline = firstl.split(",");
                String[][] amatrix = new String[firstline.length + 1][firstline.length];

                for (int i = 0; i < amatrix[count].length; i++) {
                    amatrix[count][i] = firstline[i];
                }
                String line;

                while ((line = reader.readLine()) != null) { //read in line by line
                    count++;
                    String[] temp = line.split(","); //splits line
                    if (count < 7) {
                        for (int i = 0; i < amatrix[count].length; i++) {
                            amatrix[count][i] = temp[i];

                        }
                    }
                }
                floydAlgo(amatrix);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printMatrix(String amatrix[][]) {
        System.out.println("---------------------");
        for (int i = 0; i < amatrix.length; i++) {
            for (int j = 0; j < amatrix[i].length; j++) {
                System.out.print(amatrix[i][j]);
                if (amatrix[i].length - j > 1) {
                    System.out.print(",");
                }
            }
            System.out.println();

        }
        System.out.println("--------------------");
    }

    public void printMatrixInts(int amatrix[][], String[] vert) {
        for (int i = 0; i < amatrix.length; i++) {
            System.out.print(vert[i] + " ");
            for (int j = 0; j < amatrix[i].length; j++) {
                if (amatrix[i][j] > 10000000) {
                    System.out.print("x");
                } else {
                    System.out.print(amatrix[i][j]);
                }

                if (amatrix[i].length - j > 1) {
                    System.out.print(",");
                }
            }
            System.out.println();

        }
        System.out.println("--------------------");
    }
/*
    public int[][] primsAlgo(String G[][]) {
        String verticies[] = new String[G[0].length];
        boolean visit[] = new boolean[verticies.length];
        int D[] = new int[verticies.length];
        int T[][] = new int[verticies.length][verticies.length];
        int intG[][] = new int[verticies.length][verticies.length];

        visit[0] = true;
        for (int o = 1; o < visit.length; o++) {
            visit[o] = false;
        }

        for (int i = 0; i < G[0].length; i++) {
            verticies[i] = G[0][i];
        }

        D[0] = 0;
        for (int i = 1; i < D.length; i++) {
            D[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T.length; j++) {
                T[i][j] = 0;

                if (G[i + 1][j].equals("x")) {
                    intG[i][j] = Integer.MAX_VALUE;
                } else {
                    intG[i][j] = Integer.parseInt(G[i + 1][j]);
                }

            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < D.length; i++) {
            pq.add(new Node(D[i], i, i));

        }

        Node u;
        while (!pq.isEmpty()) {
            u = pq.remove();

            for (int i = 0; i < D.length; i++) {
                if (intG[u.vertexa][i] < D[i]) {

                    D[i] = intG[u.vertexa][i];

                    System.out.println(D[i] + " " + verticies[u.vertexa] + " " + verticies[i]);
                    u.vertexb = i;
                    //    visit[i] = true;
                    T[u.vertexa][i] = D[i];

                    pq.add(new Node(D[i], u.vertexa, i));

                }
            }
            // printMatrixInts(T, verticies);
        }

        return T;
    }
    */

    public void floydAlgo(String amatrix[][]) {
        String vert[] = amatrix[0];
        int d[][] = new int[amatrix[0].length][amatrix[0].length];

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                if (amatrix[i + 1][j].equals("x")) {
                    d[i][j] = 400000000;
                } else {
                    d[i][j] = Integer.parseInt(amatrix[i + 1][j]);
                }
            }
        }

        for (int i = 0; i < d.length; i++) {
            d[i][i] = 0;
        }
        System.out.println("Initial matrix before Floyd-Warshall's algorithm");
        printMatrixInts(d, vert);
        for (int k = 0; k < d.length; k++) {
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d.length; j++) {
                    if (d[i][j] > (d[i][k] + d[k][j])) {
                        d[i][j] = d[i][k] + d[k][j];
                        System.out.print("  ");
                        for (int y = 0; y < vert.length; y++) {
                            System.out.print(vert[y]);
                            if (vert.length - y > 1) {
                                System.out.print(",");
                            }
                        }
                        System.out.println();
                        printMatrixInts(d, vert);
                    }
                }
            }
        }
        System.out.println("The final matrix is as follows:");
        System.out.println("--------------------");
        System.out.print("  ");
        for (int y = 0; y < vert.length; y++) {
            System.out.print(vert[y]);
            if (vert.length - y > 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        printMatrixInts(d, vert);
    }

    public int[][] kruskals(String G[][]) {
        String verticies[] = new String[G[0].length];
        boolean visit[] = new boolean[verticies.length];
        int T[][] = new int[verticies.length][verticies.length];
        int intG[][] = new int[verticies.length][verticies.length];

        for (int o = 0; o < visit.length; o++) {
            visit[o] = false;
        }

        for (int i = 0; i < G[0].length; i++) {
            verticies[i] = G[0][i];
        }

        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T.length; j++) {
                T[i][j] = 0;

                if (G[i + 1][j].equals("x")) {
                    intG[i][j] = Integer.MAX_VALUE;
                } else {
                    intG[i][j] = Integer.parseInt(G[i + 1][j]);
                }

            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < intG.length; i++) {
            for (int j = 0; j < intG[i].length; j++) {
                if (intG[i][j] < Integer.MAX_VALUE) {
                    pq.add(new Node(intG[i][j], i, j));
                }
            }
        }
        int count = T.length;
        Node u = null;
        boolean stop = false;
        System.out.println("Kruskal's MST edges:");
        while (count > 1 && !stop) {
            if (!pq.isEmpty()) {
                u = pq.remove();
            }else{
                stop = true;
            }

            if (visit[u.vertexa] == false || visit[u.vertexb] == false) {
                T[u.vertexa][u.vertexb] = u.weight;
                count--;
                visit[u.vertexa] = true;
                visit[u.vertexb] = true;
                System.out.println(verticies[u.vertexa] + " --> " + verticies[u.vertexb] + " " + u.weight);
            }

        }
          System.out.println("--------------------");
        return T;
    }

    public void primsAlgoo(String G[][]) {
        String verticies[] = new String[G[0].length];
        boolean visit[] = new boolean[verticies.length];
        int intG[][] = new int[verticies.length][verticies.length];

        for (int o = 1; o < visit.length; o++) {
            visit[o] = false;
        }

        for (int i = 0; i < G[0].length; i++) {
            verticies[i] = G[0][i];
        }

        for (int i = 0; i < intG.length; i++) {
            for (int j = 0; j < intG.length; j++) {
                if (G[i + 1][j].equals("x")) {
                    intG[i][j] = Integer.MAX_VALUE;
                } else {
                    intG[i][j] = Integer.parseInt(G[i + 1][j]);
                }

            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < intG.length; i++) {
                if (intG[0][i] < Integer.MAX_VALUE) {
                    pq.add(new Node(intG[0][i], 0, i));
                } 
        }

        Node u;
        System.out.println("Prim's MST edges:");
        while (!pq.isEmpty()) {
            u = pq.remove();

            if (visit[u.vertexa] == false || visit[u.vertexb] == false) {
                visit[u.vertexa] = true;
                visit[u.vertexb] = true;
                System.out.println(verticies[u.vertexa] + " --> " + verticies[u.vertexb] + ", weight: " + u.weight);
                
                for(int i = 0; i < intG.length; i++){
                    pq.add(new Node(intG[u.vertexb][i], u.vertexb,i));
                }
            }
        }
        System.out.println("--------------------");
    }
}
