/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Nazmul Haque
 */
public class AStarSearch {

    /**
     * @param args the command line arguments
     */
    static int u,v;
    static String sNode,eNode; 
    public static void main(String[] args) throws FileNotFoundException {
       
        //Edge e=new Edge(u);
        Scanner k = new Scanner(new File("mapInfo.txt"));
 
        u = k.nextInt();
        
        //System.out.println(u);
        v = k.nextInt();
        //System.out.println(v);
        sNode=k.next();
        System.out.println("start node: "+sNode);
        eNode=k.next();
        System.out.println("target node: "+eNode);
        
        Graph g=new Graph();
        //JavaApplication8 j8=new JavaApplication8();
        for(int i=0;i<u;i++){
            
            String start=k.next();
            
            String end=k.next();
            
            Double c=Double.parseDouble(k.next());
            
            g.setEdge(start,end,c);
            //g.setParent();
          
        }
        
            
        while(k.hasNext()){
            
            String p=k.next();           
            Double q=Double.parseDouble(k.next());
            g.setHuristic(p,q);
            
        }
        g.search(sNode,eNode);
        
                               
    }
    
}
