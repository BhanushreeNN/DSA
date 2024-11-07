package GRAPHS;

import java.util.ArrayList;

public class _6_CycleDetectionUndirected {
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
        // (1)------(0)------(3)
        //           |       /
        //           |      /
        //           |     /
        //           |    /
        //           |   /
        //           |  /
        //           (2)
        graph[1].add(new Edge(1, 0));
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));
    }

    // 3 cases:
    // vis[n]==T && parent==false --> cycle
    // vis[n]==T && parent==true --> do nothing
    // vis[n]==F --> visit
    public static boolean detectCycleDfs(ArrayList<Edge> graph[], boolean visited[], int curr, int parent) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[e.dest] == true && parent != e.dest) {
                return true;
            }
            if (visited[e.dest] == false) {
                if (detectCycleDfs(graph, visited, e.dest, curr) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean visited[] = new boolean[V];
        System.out.println(detectCycleDfs(graph, visited, 0, -1));
    }
}
