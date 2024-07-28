package DsaPrac.DsaPractice.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_BFS_Traversal {

    static ArrayList<Integer> bfsGraphTraversal(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        // Start BFS from the first node (0-indexed)
        if (!adj.isEmpty()) {
            q.add(0);
            vis[0] = true;
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);

            //Adding the child nodes (adjacent nodes) of the current node in the graph
            for (int neigh : adj.get(node)) {
                if (!vis[neigh]) {
                    q.add(neigh);
                    vis[neigh] = true;
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        // Adjacency list for a 0-indexed graph
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        adjacencyList.add(new ArrayList<>(List.of(1, 2))); // Node 0
        adjacencyList.add(new ArrayList<>(List.of(3, 4))); // Node 1
        adjacencyList.add(new ArrayList<>(List.of(5, 6))); // Node 2
        adjacencyList.add(new ArrayList<>()); // Node 3
        adjacencyList.add(new ArrayList<>()); // Node 4
        adjacencyList.add(new ArrayList<>(List.of(7))); // Node 5
        adjacencyList.add(new ArrayList<>()); // Node 6
        adjacencyList.add(new ArrayList<>()); // Node 7

        List<Integer> ans = bfsGraphTraversal(adjacencyList);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
