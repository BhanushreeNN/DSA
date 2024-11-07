package GRAPHS;

import java.util.ArrayList;
import java.util.PriorityQueue;

// GREEDY - shortest distance from one source to all vertices(weight of edges are positive)
public class _7_Dijkstra {
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
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }
        @Override
        public int compareTo(Pair p2){
           return this.dist - p2.dist; //ascending
           // return p2.dist - this.dist; // descending
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
             /*
               (2)         (7)         (1)
           0 ------> 1 --------> 3 --------> 5
           |          |          ^          ^
           | (4)      | (1)      |(2)       |
           |          v          |          |
           ---------->2 --------> 4 ---------
                          (3)            (5)
        */
        
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    // O(E + E log V)
    public static int[] dijkstra(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        boolean visited[] = new boolean[V];
        dist[src] = 0;
        for(int i = 0; i<V; i++)
            if(i!=src)
                dist[i] = Integer.MAX_VALUE;
        pq.offer(new Pair(src, dist[src]));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(!visited[curr.node]){
                visited[curr.node] = true;
                for(int i = 0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    dist[e.dest] = Math.min(dist[e.dest], dist[curr.node]+e.wt);
                    pq.offer(new Pair(e.dest, dist[e.dest]));
                }
            }
        }
        return dist;

    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int dist[] = dijkstra(graph, 0, V);
        for(int i : dist){
            System.out.print(i+" ");
        }
        
    }
}
