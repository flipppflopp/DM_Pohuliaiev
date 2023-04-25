package lab1;

import java.util.*;

public class Edge implements Comparable<Edge>{
    int source, destination, weight;

    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
};
