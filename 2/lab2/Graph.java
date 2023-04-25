package lab2;

import java.util.*;

public class Graph {

    private List<Edge> edges;
    private int vertexCount;

    public Graph(int vertexCount) {
        this.edges = new ArrayList<>();
        this.vertexCount = vertexCount;
    }

    public void addEdge(int from, int to, int weight) {
        edges.add(new Edge(from, to, weight));
    }

    public List<Integer> findEulerPath() {
        List<Boolean> visited = new ArrayList<>(edges.size());
        for (int i = 0; i < edges.size(); i++) {
            visited.add(false);
        }

        Stack<Edge> stack = new Stack<>();
        List<Integer> path = new ArrayList<>();

        stack.push(edges.get(0));

        while (!stack.isEmpty()) {
            Edge cur = stack.pop();

            if (visited.get(edges.indexOf(cur))) {
                continue;
            }

            visited.set(edges.indexOf(cur), true);

            if (path.isEmpty()) {
                path.add(cur.from);
                path.add(cur.to);
            } else if (path.get(path.size() - 2) == cur.from) {
                Collections.swap(path, path.size() - 1, path.size() - 2);
                path.add(cur.to);
            } else if (path.get(path.size() - 1) == cur.from) {
                path.add(cur.to);
            } else {
                path.add(cur.from);
            }

            for (Edge edge : edges) {
                if (visited.get(edges.indexOf(edge))) {
                    continue;
                } else if (edge.from == cur.from || edge.to == cur.to || edge.to == cur.from || edge.from == cur.to) {
                    stack.push(edge);
                }
            }
        }

        return path;
    }

    public int calculateEulerPath(List<Integer> path, Graph graph){
        int cost = 0;

        for (int i = 0; i < path.size() - 1; i++){
            int from = path.get(i);
            int to = path.get(i+1);
            for (Edge edge : graph.edges){
                if(edge.from == from && edge.to == to || edge.from == to && edge.to == from){
                    cost += edge.weight;
                    break;
                }
            }
        }
        return cost;
    }

    private static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public static boolean isEulerianGraph(int[][] graph) {
        int begin = 0;
        int end = graph.length;
        for (int i = 0; i < graph.length; ++i) {
            int counter = 0;
            for (int j = begin; j < end; ++j) {
                if (graph[i][j - begin] != 0) {
                    ++counter;
                }
            }
            begin = end;
            end += graph.length;
            if (counter % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}