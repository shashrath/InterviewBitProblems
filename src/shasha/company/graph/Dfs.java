package shasha.company.graph;

import java.util.Arrays;
import java.util.Iterator;

public class Dfs {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        depthFirstSearch(g,5);
    }

    public static void depthFirstSearch(Graph g, int size){
        Boolean []visited = new Boolean[size];
        Arrays.fill(visited,false);
        for(int i =0;i<size;i++){
            if(!visited[i])
                dfsUtil(i,g,visited);
        }
    }

    public static void dfsUtil(int vertex, Graph g, Boolean[] visited){
        visited[vertex] = true;
        System.out.println(vertex + " ");
        Iterator<Integer> iterator = g.getAdjacencyList()[vertex].listIterator();
        while(iterator.hasNext()){
            int n = iterator.next();
            if(!visited[n])
                dfsUtil(n,g,visited);
        }
    }
}
