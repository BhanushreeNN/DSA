package GRAPHS;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class _2_GraphTraversals {
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

        // Graph structure (undirected):
        //
        // 0
        // / \
        // 1 2
        // \ \
        // 3---4
        // \ /
        // 5
        // \
        // 6
        //
        // Edges:
        // 0 - 1, 0 - 2
        // 1 - 3
        // 2 - 4
        // 3 - 4
        // 3 - 5
        // 4 - 5
        // 5 - 6

        // Adding edges for the undirected graph
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        graph[1].add(new Edge(1, 3));
        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 4));
        graph[4].add(new Edge(4, 2));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

        graph[3].add(new Edge(3, 5));
        graph[5].add(new Edge(5, 3));

        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));

        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge> graph[], int start, boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        if (vis[curr] == false) {
            System.out.print(curr + " ");
            vis[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean visited[] = new boolean[V];
        int start = 0;
        System.out.println("\nBFS : ");
        bfs(graph, start, visited);
        visited = new boolean[V];
        System.out.println("\nDFS : ");
        dfs(graph, start, visited);
    }
}
