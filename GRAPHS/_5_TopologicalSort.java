package GRAPHS;

import java.util.ArrayList;
import java.util.Stack;

public class _5_TopologicalSort {
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

         // (5)----->(0)<-----(4)
        //  |                 |
        //  |                 |
        //  |                 |
        //  V                 V
        // (2)----->(3)----->(1)
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
    }

    public static void topologicalSort(ArrayList<Edge> graph[], boolean visited[], int curr, Stack<Integer> stack) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topologicalSort(graph, visited, e.dest, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                topologicalSort(graph, visited, i, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
