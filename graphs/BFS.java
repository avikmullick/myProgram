/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth First Search Using Queue Implementation
 * @author avik
 */
public class BFS {
    private Graph g;
    int vertex;
    Queue<Integer> bfsQueue;
    int startingVertex;
    Integer[] visited;
    Integer[] explored;
    
    BFS(Graph g,int vertex,int startingVertex)
    {
        this.g=g;
        this.vertex=vertex;
        bfsQueue=new LinkedList<Integer>();
        this.startingVertex=startingVertex;
        visited=new Integer[vertex];
        explored=new Integer[vertex];
        for(int i=0;i<visited.length;i++){
            visited[i]=0;
            explored[i]=0;
        }
    }
    
    
    public void bfsAListImpl()
    {
        Integer[] edges;
        Integer visit;
        bfsQueue.add(startingVertex);
        explored[startingVertex]=1;
        System.out.println("BFSList Order");
        while(!bfsQueue.isEmpty())
        {
            visit=bfsQueue.poll();
            visited[visit]=1;
            System.out.print(" ,"+visit);
            edges=g.getGraphList().get(visit);
            for(int i=0;i<edges.length;i++)
            {
                if(visited[edges[i]]!=1)
                {
                        if( explored[edges[i]]!=1)
                        {
                            bfsQueue.add(edges[i]);
                            explored[edges[i]]=1;
                        }
                }
                    
            }
        }
        System.out.println();
        
    }
    
    public void bfsAMatrixImpl()
    {
        int[][] edges;
        Integer visit;
        bfsQueue.add(startingVertex);
        explored[startingVertex]=1;
        System.out.println("BFSMatrix Order");
        while(!bfsQueue.isEmpty())
        {
            visit=bfsQueue.poll();
            visited[visit]=1;
            System.out.print(" ,"+visit);
            edges=g.getGraphMatrix();
            for(int i=0;i<vertex;i++)
            {
                if(edges[visit][i]==1){
                    if(visited[i]!=1)
                    {
                        if( explored[i]!=1)
                        {
                            bfsQueue.add(i);
                            explored[i]=1;
                        }
                }
                }
                    
            }
        }
        System.out.println();
        
    }
    
    
}
