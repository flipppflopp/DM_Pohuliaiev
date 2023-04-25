package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args){
        String filepath = "test2.txt";
        File file = new File(filepath);
        int new_matrix[][] = new int[0][0];
        int v = 0;
        List<Integer> test = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            int n = scanner.nextInt();
            v = n;
            new_matrix = new int[n][n];
            int matrix[][] = new int[n][n];

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    new_matrix[i][j] = scanner.nextInt();
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Graph graph = new Graph(5);
        for (int i = 0; i < v; i++){
            for (int j = 0; j < i+1; j++){
                if(new_matrix[i][j] == 0){
                    continue;
                }else{
                    graph.addEdge(j, i, new_matrix[i][j]);
                }
            }
        }

        if(graph.isEulerianGraph(new_matrix)){
            List<Integer> path = graph.findEulerPath();
            int cost = graph.calculateEulerPath(path, graph);
            System.out.println("Euler cycle is " + graph.isEulerianGraph(new_matrix));
            System.out.println("Eulerian Path: " + path);
            System.out.println("Cost Eulerian Path: " + cost);
        }else{
            System.out.println("Euler cycle is " + graph.isEulerianGraph(new_matrix));
            System.out.println("No solution!");
        }
//        System.out.println("Test running...");
//        System.out.println(graph.getWeight(4, 3));
    }


}
