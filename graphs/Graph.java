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
public class Graph {
    
    private int vertex;
    private int[][] graph;//Adjacency Matrix
    
    private ArrayList<Integer[]> graphList;
    
    Graph(int[][] graph,int vertex)
    {
        this.graph=graph;
        this.vertex=vertex;
    }
    Graph(ArrayList<Integer[]> graphList)
    {
        this.graphList=graphList;
    }
    
    int[][] getGraphMatrix()
    {
        return graph;
    }
    
    ArrayList<Integer[]> getGraphList()
    {
        return graphList;
    }
    
    
}
