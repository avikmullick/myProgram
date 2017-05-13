/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author avik
 */
public class DFS {
    private Graph g;
    int vertex;
    int startingVertex;
    Integer[] visited;
    Integer[] explored;
    
    DFS(Graph g,int vertex,int startingVertex)
    {
        this.g=g;
        this.vertex=vertex;
        this.startingVertex=startingVertex;
        visited=new Integer[vertex];
        explored=new Integer[vertex];
        for(int i=0;i<visited.length;i++){
            visited[i]=0;
            explored[i]=0;
        }
    }
    
    
    
    public void dfsAListImpl(Integer curVertex)
    {
        Integer[] edges; 
        System.out.print(" ,"+curVertex);
        if(visited[curVertex]!=1)
        {
            edges=g.getGraphList().get(curVertex); 
            visited[curVertex]=1;
        for(int i=0;i<edges.length;i++)
        {
            if(visited[edges[i]]!=1)
              dfsAListImpl(edges[i]);
        }
        }
    }
    
    public void dfsAMatrixImpl(Integer curVertex) {
        int[][] edges;
        System.out.print(" ," + curVertex);
        if (visited[curVertex] != 1) {
            edges = g.getGraphMatrix();
            visited[curVertex] = 1;

            for (int i = 0; i < vertex; i++) 
            {
                if (edges[curVertex][i] == 1) 
                {
                    for (int j = 0; j < edges[i].length; j++) 
                    {
                        if (visited[j] != 1) 
                        {
                            dfsAMatrixImpl(j);
                        }
                    }

                }

            }
        }
    }
    
}
