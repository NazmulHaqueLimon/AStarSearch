/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Nazmul Haque
 */
public class Graph { 
    
    private int v;//number of vertics 
    private static String min;
    private final LinkedList<String> stList;
    private final LinkedList<String> visited; 
    private final LinkedList<String> path;
    private final HashMap<String,Double> cost;
    private final HashMap<String,String> parent;
    private final HashMap<String,Double> hr;
    private final HashMap<String,Double> totalCost;
    private final HashMap<String, LinkedList<String>> edgeMap;
    
    public Graph(){
       
        this.edgeMap =  new HashMap<>();
        this.cost=new HashMap<>();
        this.parent=new HashMap<>();
        this.path=new LinkedList<>();
        this.hr=new HashMap<>();
        this.totalCost=new HashMap<>();
        this.stList = new LinkedList<>();
        this.visited=new LinkedList<>();
        //edgeMap.put();
       
    }
    //private LinkedList<String> eList= new LinkedList<>();
   
    void setEdge(String start, String end, Double c) {
        LinkedList<String> eList= new LinkedList<>();
        //eList.add(end);
        cost.put(end,c);
        parent.put(end,start);
        //System.out.println(end+"->"+start);
        
        if(edgeMap.containsKey(start)){
            (edgeMap.get(start)).add(end);
        }
        else{
            edgeMap.put(start,eList);
            eList.add(end);
        }        
    }    

    void setHuristic(String p, Double q) {
        
        hr.put(p,q);
    }
    
    

    void search(String sNode,String eNode) {
        if(!sNode.equals(eNode)){
           visited.add(sNode);
           
           LinkedList<String> edgeList = new LinkedList<String>();
           edgeList=edgeMap.get(sNode);
           //for each adjecence in edgelist 
           //if not visited...put in stackList
           //System.out.println("size of"+edgeList.size());
           for(int i=0;i<edgeList.size();i++){  
               for(int j=0;j<visited.size();j++){
                   if(!edgeList.get(i).equals(visited.get(j))){
                       stList.add(edgeList.get(i));
                       //System.out.println("ohh..."+stList.get(i));
                   }
                   else{
                       //if already visited...do nothing
                   }
               }                                                             
           }
           //System.out.println("hi");
           min=stList.get(1);
           if(stList.size()>1){
           
           //System.out.println(min);
               for(int c=0;c<stList.size();c++){
                  setTotalCost(stList.get(c));
                  setTotalCost(min);
                  if(totalCost.get(stList.get(c))< totalCost.get(min)){
                      min=stList.get(c);
                      //System.out.println("hi");
                  }
                  else{
                     min=min;
                     
                  }
                  //System.out.print("hiiiii  ");
               } 
           }
           
           stList.remove(min);
           //System.out.println("the min is"+min);
           String finalNode=eNode;
           search(min,finalNode);
        } 
        else{
            visited.add(sNode);
            setTotalCost(sNode);
            printResult();
        }
    }
    void setTotalCost(String n) {
        String p=parent.get(n);
        //System.out.println("dhurr"+p);
         if(!cost.containsKey(p)){
             
              double c=cost.get(n)+hr.get(n);     
             totalCost.put(n,c);
             //System.out.println("hi");
            
         }
         else{
             //
            
             double d=cost.get(n)+cost.get(p);
              //System.out.println("hi"+d);
              //System.out.println("parent of "+n+"="+parent.get(n));
             cost.replace(n, d);
             //System.out.println("kisu nai"+cost.get("b"));
             double c=d+hr.get(n);
             totalCost.put(n,c);
              //totalCost.put(n,d);
         }
         
                
             
         
    }
    void printResult(){
        System.out.print("the search result is: ");
        for(int i=0;i<visited.size();i++){
           
          System.out.print(visited.get(i)+"-> ");
        }
        
        System.out.println();
        
        //System.out.println(totalCost.get("e"));
          
    }
      
}
