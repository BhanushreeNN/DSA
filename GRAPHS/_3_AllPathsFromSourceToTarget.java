package GRAPHS;

import java.util.ArrayList;

public class _3_AllPathsFromSourceToTarget {
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
    // O(V^V)
    public static void dfs(ArrayList<Edge> graph[], boolean vis[], int curr, int trgt, String path) {
        if (curr == trgt) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) {
                vis[curr] = true;
                dfs(graph, vis, e.dest, trgt, path + " " +e.dest);
                vis[curr] = false;
            }
        }
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0, trgt = 5;
        boolean vis[] = new boolean[V];
        dfs(graph, vis, src, trgt, src+"");
    }
}
