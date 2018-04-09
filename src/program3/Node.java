/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program3;

/**
 *
 * @author katsura496
 */
public class Node implements Comparable <Node> {
    int weight;
    public int vertexa;
    public int vertexb;
    
    Node(int inWeight, int va, int vb){
        weight = inWeight;
        vertexa = va;
        vertexb = vb;
    }
    
    @Override
    public int compareTo(Node t){
        if(this.weight > t.weight){
            return 1;
        }else if(this.weight < t.weight){
            return -1;
        }
        return 0;
    }
    
    public int getWeight(){
        return weight;
    }
   
}
