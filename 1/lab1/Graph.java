package lab1;

import java.util.*;

public class Graph {

    int vertices;
    List<Edge> edges = new ArrayList<>();

    Graph(int vertices) {
        this.vertices = vertices;
    }

    void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge();
        edge.source = source;
        edge.destination = destination;
        edge.weight = weight;
        edges.add(edge);
    }

    int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] += 1;
        }
    }
    void kruskalMST() {
        List<Edge> result = new ArrayList<>();
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        Collections.sort(edges);
        int index = 0;
        while (result.size() < vertices - 1) {
            Edge edge = edges.get(index);
            index++;
            int x = find(parent, edge.source);
            int y = find(parent, edge.destination);
            if (x != y) {
                result.add(edge);
                union(parent, rank, x, y);
            }
        }
        for (Edge edge : result) {
            System.out.println(edge.source + " - " + edge.destination + ": " + edge.weight);
        }
    }
}
