package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filepath = "I1_3.txt";
        int vertices = 0;
        int new_matrix[][] = new int[0][0];
        File file = new File(filepath);
        try {
            Scanner scanner = new Scanner(file);
            int n = scanner.nextInt();
            int matrix[][] = new int[n][n];

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    matrix[i][j] = scanner.nextInt();
                }
            }
            vertices = n;
            new_matrix = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    new_matrix[i][j] = matrix[i][j];
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Graph graph = new Graph(vertices);
        for (int i = 0; i < vertices; i++){
            for (int j = 0; j < vertices; j++){
                if(new_matrix[i][j] == 0){
                    continue;
                }
                else{
                    graph.addEdge(i, j, new_matrix[i][j]);
                }
            }
        }
        graph.kruskalMST();
    }
}