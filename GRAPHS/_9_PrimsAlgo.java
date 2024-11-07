package GRAPHS;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _9_PrimsAlgo {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        public Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // ascending
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Adding edges with weights
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 3, 50));
    }

    public static int prims(ArrayList<Edge> graph[], int V) {
        boolean visited[] = new boolean[V];
        int cost = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0));
        while (!pq.isEmpty()) {
            // neighbouring node
            Pair curr = pq.poll();
            if (visited[curr.node] == false) {
                visited[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    pq.offer(new Pair(e.dest, e.wt));
                }
                
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("The minimum cost of spanning tree is = "+prims(graph, V));
    }
}
