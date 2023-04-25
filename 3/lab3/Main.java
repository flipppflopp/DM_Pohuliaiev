package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String path = "matrix_3.txt";
        File file = new File(path);
        int new_matrix[][] = new int[0][0];
        int v = 0;
        List<Integer> test = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            int N = scanner.nextInt();
            v = N;
            new_matrix = new int[N][N];
            int matrix[][] = new int[N][N];

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    new_matrix[i][j] = scanner.nextInt();
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        GFG gfg = new GFG(v);
        gfg.TSP(new_matrix);
        System.out.printf("Minimum cost : %d\n", gfg.final_res);
        System.out.printf("Path Taken : ");
        for (int i = 0; i <= v; i++)
        {
            System.out.printf("%d ", gfg.final_path[i]);
        }

    }
}