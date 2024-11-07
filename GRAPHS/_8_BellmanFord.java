package GRAPHS;

import java.util.ArrayList;

public class _8_BellmanFord {
    // DP - shortest distance from the source to all vertices (weight of edges can be negative as well)
    // BellmanFord does'nt work for negative weight cycles
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
             /*
               (2)        (-1)       
           0 ------> 1 --------> 4 
           |          |          ^          
           | (4)      | (-4)     |(4)       
           |          v          |          
           ---------->2 --------> 3 
                          (2)            
        */
        
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 4, -1));
        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

    }
    // O(V•E)
    public static int[] bellmanFord(ArrayList<Edge> graph[], int src, int V){
        int dist[] = new int[V];
        for(int i = 0; i<V; i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // V-1 iterations
        for(int k = 0; k<V-1; k++){ //O(V)
            // all edges
            for(int i = 0; i<graph.length; i++){ // O(E)
                for(int j = 0; j<graph[i].size(); j++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int dist[] = bellmanFord(graph, 0, V);
        for(int i : dist){
            System.out.print(i+" ");
        }
        
    }
}
