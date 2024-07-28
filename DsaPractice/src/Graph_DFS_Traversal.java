package DsaPrac.DsaPractice.src;

import java.util.ArrayList;
import java.util.List;

public class Graph_DFS_Traversal {

    static List<Integer> dfsGraphTraversal(List<ArrayList<Integer>> adjMatrix){
        List<Integer> dfsOrderResult = new ArrayList<Integer>();
        boolean[] vis = new boolean[adjMatrix.size()];
        vis[0]=true;
        dfs(1,vis,adjMatrix,dfsOrderResult);
        return dfsOrderResult;
    }

    static  void dfs (int node, boolean[] vis , List<ArrayList<Integer>> adjMatrix, List<Integer> dfsOrderResult){
        System.out.print(node+" ");
        vis[node] = true;
        dfsOrderResult.add(node);

        for(int x: adjMatrix.get(node)){
              if(!vis[x]){
                  dfs(x,vis,adjMatrix,dfsOrderResult);
              }
        }
    }

    public static void main(String[] args) {
        List<ArrayList<Integer>> adjMatrix = new ArrayList<ArrayList<Integer>>() ;

        adjMatrix.add(new ArrayList<>(List.of())); // Node 0
        adjMatrix.add(new ArrayList<>(List.of(2,3))); // Node 1
        adjMatrix.add(new ArrayList<>(List.of(1,5,6))); // Node 2
        adjMatrix.add(new ArrayList<>(List.of(1,4,7))); // Node 3
        adjMatrix.add(new ArrayList<>(List.of(3,8))); // Node 4
        adjMatrix.add(new ArrayList<>(List.of())); // Node 5
        adjMatrix.add(new ArrayList<>(List.of())); // Node 6
        adjMatrix.add(new ArrayList<>(List.of(3,8))); // Node 7
        adjMatrix.add(new ArrayList<>(List.of(4,7))); // Node 8

        List<Integer> ans = dfsGraphTraversal(adjMatrix);

//        for (int x: ans){
//            System.out.println(x+" ");
//        }

    }
}
