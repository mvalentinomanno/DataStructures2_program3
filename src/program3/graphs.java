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

/**
 *
 * @author katsura496
 */
public class graphs {

    public void primsInput() {
        int value;
        BufferedReader reader = null; //reader

        try {

            File file = new File("input/primInput.txt"); //set up input file and reader
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

            File file = new File("input/kruskalInput.txt"); //set up input file and reader
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

            File file = new File("input/floydwarshallInput.txt"); //set up input file and reader
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
                System.out.println("Initial matrix before Floyd-Warshall's algorithm");
                printMatrix(amatrix);
                floydwarshalls(amatrix);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void floydwarshalls(String amatrix[][])
    {
        int x = amatrix.length;
        int a,b,c;
 
        for(int z = 1; z < x; z++)
        {
             amatrix[z][z-1] = "0";
        }
        
        System.out.println("Updated matrix for Floyd-Warshall's algorithm");
        printMatrix(amatrix);
        
        
       for(int k = 1; k < x; k++)
        {
           for(int i = 1; i < x; i++)
           {
               for(int j = 1; j < x; j++)
               {
                   
                   
                   
                   try
                   {    
                        a = Integer.parseInt(amatrix[i][j-1]);
                   }
                   catch(NumberFormatException e)
                   {
                        a = 9999999;
                   }
                   
                   try
                   {    
                        b = Integer.parseInt(amatrix[i][k-1]);
                   }
                   catch(NumberFormatException e)
                   {
                        b = 9999999;
                   }
                   
                   try
                   {    
                        c = Integer.parseInt(amatrix[k][j-1]);
                   }
                   catch(NumberFormatException e)
                   {
                        c = 9999999;
                   }
                  
                   if(a > b + c)
                   {
                      
                       amatrix[i][j-1] = Integer.toString(b+c);
                   }
                       
                       printMatrix(amatrix);
                   
                   
               }
            
           } 
        }
    }

    public void printMatrix(String amatrix[][]) {
        System.out.println("----------");
        for (int i = 0; i < amatrix.length; i++) {
            for (int j = 0; j < amatrix[i].length; j++) {
                System.out.print(amatrix[i][j]);
                if (amatrix[i].length - j > 1) {
                    System.out.print(",");
                }
            }
            System.out.println();

        }
        System.out.println("----------");
    }
}
