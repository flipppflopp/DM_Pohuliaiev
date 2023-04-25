package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String path = "mymatrix.txt";
        File file = new File(path);
        int new_matrix[][] = new int[0][0];
        List<Integer> test = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            int N = scanner.nextInt();
            new_matrix = new int[N][N];

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    new_matrix[i][j] = scanner.nextInt();
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        int from = 0;
        int to = 4;
        FordFulkersonAlgorithm fordFulkersonAlgorithm = new FordFulkersonAlgorithm();
        int maxFlor = fordFulkersonAlgorithm.maxFlow(new_matrix, from, to);
        System.out.println("Maximum flow from source " + from + " to sink " + to + " is " + maxFlor);
    }
}
