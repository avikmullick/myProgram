/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import dataStructure.Node;
import java.util.ArrayList;

/**
 *
 * @author avik
 */
public class CreateGraph {
    
    
    public void createGraphMatrix()
    {
        int[][] adjGraph={
                  {0,1,1,0,0,0,0,0},
                  {1,0,0,1,1,0,0,0},
                  {1,0,0,0,0,1,1,0},
                  {0,1,0,0,0,0,0,1},
                  {0,1,0,0,0,0,0,1},
                  {0,0,1,0,0,0,0,1},
                  {0,0,1,0,0,0,0,1},
                  {0,0,0,1,1,1,1,0}
                 };
        Graph g=new Graph(adjGraph,8);
        
        g.getGraphMatrix();
        
        BFS bb=new BFS(g, 8, 0);
        bb.bfsAMatrixImpl();
        
        System.out.println("DFS Matrix Order");
        DFS dd=new DFS(g, 8, 0);
        dd.dfsAMatrixImpl(0);
        System.out.println("");
                  
    }
    
    public void createGraphList()
    {
        
        ArrayList<Integer[]> vertexList=new ArrayList<Integer[]>();
        Integer[] vertex0={1,2};
        Integer[] vertex1={0,3,4};
        Integer[] vertex2={0,5,6};
        Integer[] vertex3={1,7};
        Integer[] vertex4={1,7};
        Integer[] vertex5={2,7};
        Integer[] vertex6={2,7};
        Integer[] vertex7={3,4,5,6};       
        
        vertexList.add(vertex0);
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);
        vertexList.add(vertex4);
        vertexList.add(vertex5);
        vertexList.add(vertex6);
        vertexList.add(vertex7);
        
        Graph g=new Graph(vertexList);
        
        BFS bb=new BFS(g, 8, 0);
        bb.bfsAListImpl();
        
        System.out.println("DFS List Order");
        DFS dd=new DFS(g, 8, 0);
        dd.dfsAListImpl(0);
        System.out.println("");
  
       
    }
    
}
