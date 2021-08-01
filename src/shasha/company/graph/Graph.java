package shasha.company.graph;

import java.util.LinkedList;

public class Graph {
    private int V; // No. of vertices

    // Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    public LinkedList<Integer>[] getAdjacencyList(){
        return adj;
    }

    // Constructor
    @SuppressWarnings("unchecked") Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }
}
