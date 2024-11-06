package GRAPHS;

import java.util.ArrayList;

public class _4_CycleDetectionDirected {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

         // (1)----->(0)<-----(3)
        //           |      /\
        //           |      /
        //           |     /
        //           |    /
        //           |   /
        //          \/  /
        //           (2)
        graph[1].add(new Edge(1, 0));
        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean detectCycleDfs(ArrayList<Edge> graph[], boolean visited[], boolean recStack[], int curr) {
        visited[curr] = true;
        recStack[curr] = true;
        System.out.print("\n edge = " + curr);
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            System.out.print(" -> " + e.dest);
            if (recStack[e.dest] == true)
                return true;
            else if (!visited[e.dest] && detectCycleDfs(graph, visited, recStack, e.dest)) {
                return true;
            }
        }
        recStack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];
        System.out.println("\nDoes the graph have cycle? -> " + detectCycleDfs(graph, visited, recStack, 0));
    }
}
// OUTPUT:
// edge = 0 -> 2
// edge = 2 -> 3
// edge = 3 -> 0
// Does the graph have cycle? -> true
