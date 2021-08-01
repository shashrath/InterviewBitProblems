package shasha.company.graph;

import java.util.*;

public class CriticalConnections {

    Map<Integer, List<Integer>> adjList = new HashMap<>();

    public static void main(String[] args) {
        CriticalConnections critical = new CriticalConnections();
        List<List<Integer>> connect = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> a = new ArrayList<>(Arrays.asList(0, 1));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> c = new ArrayList<>(Arrays.asList(2, 0));
        List<Integer> d = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> e = new ArrayList<>(Arrays.asList(3, 4));
        List<Integer> f = new ArrayList<>(Arrays.asList(4, 5));
        List<Integer> g = new ArrayList<>(Arrays.asList(5, 3));
        connect.add(a);
        connect.add(b);
        connect.add(c);
        connect.add(d);
        connect.add(e);
        connect.add(f);
        connect.add(g);
        result = critical.criticalConnections(6, connect);
        for (List<Integer> res : result) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashSet<List<Integer>> connectionSet = new HashSet<>();
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections.size(); i++) {
            adj[connections.get(i).get(0)].add(connections.get(i).get(1));
            adj[connections.get(i).get(1)].add(connections.get(i).get(0));
            connectionSet.add(connections.get(i));
        }
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfsUtil(adj, 0, 0, rank, connectionSet);
        return new ArrayList<>(connectionSet);
    }

    public int dfsUtil(List<Integer>[] adj, int node, int depth, int[] rank, HashSet<List<Integer>> connectionSet) {
        if (rank[node] >= 0)
            return rank[node];
        int mindepthSoFar = depth;
        for (Integer neighbour : adj[node]) {
            if (rank[neighbour] == depth - 1)
                continue;
            rank[node] = depth;
            int minDepth = dfsUtil(adj, neighbour, depth + 1, rank, connectionSet);
            mindepthSoFar = Math.min(minDepth, mindepthSoFar);
            if (minDepth <= depth) {
                connectionSet.remove(Arrays.asList(node, neighbour));
                connectionSet.remove(Arrays.asList(neighbour, node));
            }
        }
        return mindepthSoFar;
    }


}
