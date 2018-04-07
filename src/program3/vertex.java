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
public class vertex {
    int weight;
    String name;
    public boolean visit;
    public String connectedTo;
    
    public vertex(int inWeight, String inVertex){
        weight = inWeight;
        name = inVertex;
        visit = false;
        connectedTo = null;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public String getVertex(){
        return name;
        
    }
    
    public boolean getVist(){
        return visit;
    }
}
