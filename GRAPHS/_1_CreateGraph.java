package GRAPHS;

import java.util.ArrayList;

public class _1_CreateGraph {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        // Undirected graph structure:
        // (Each edge is represented as: src --(weight)--> dest)
        //
        //      1           7
        // (0)------(1)----------(3)
        //  |        |           |
        //  |        |           |
        //  |        | 2         |
        //  |        |           |
        //  |        |           |
        //  4 ------(2)--------- 3
        //
        // Graph edges:
        // 0 --(1)--> 1 and 1 --(1)--> 0
        // 0 --(4)--> 2 and 2 --(4)--> 0
        // 1 --(2)--> 2 and 2 --(2)--> 1
        // 1 --(7)--> 3 and 3 --(7)--> 1
        // 2 --(3)--> 3 and 3 --(3)--> 2

        // Adding edges in both directions for undirected graph
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));

        graph[0].add(new Edge(0, 2, 4));
        graph[2].add(new Edge(2, 0, 4));

        graph[1].add(new Edge(1, 2, 2));
        graph[2].add(new Edge(2, 1, 2));

        graph[1].add(new Edge(1, 3, 7));
        graph[3].add(new Edge(3, 1, 7));

        graph[2].add(new Edge(2, 3, 3));
        graph[3].add(new Edge(3, 2, 3));
    }
    public static void main(String args[]){
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        for(int i = 0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest+" ");
        }
    }
    
}
