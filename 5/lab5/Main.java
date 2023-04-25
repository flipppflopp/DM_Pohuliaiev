package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        String path = "I2_2.txt";
        String path1 = "I2_2.txt";
        File file = new File(path);
        File file1 = new File(path1);
        int new_matrix[][] = new int[0][0];
        int new_matrix1[][] = new int[0][0];
        try {
            Scanner scanner = new Scanner(file);
            Scanner scanner1 = new Scanner(file1);
            int N = scanner.nextInt();
            int N1 = scanner1.nextInt();
            new_matrix = new int[N][N];
            new_matrix1 = new int[N1][N1];

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    new_matrix[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < N1; i++){
                for (int j = 0; j < N1; j++){
                    new_matrix1[i][j] = scanner1.nextInt();
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Isomorphism isomorphism = new Isomorphism();
        boolean isTrue = isomorphism.isIsomorphic(new_matrix, new_matrix1);
        if(isTrue){
            System.out.println("These graphs are isomorphic");
        }else{
            System.out.println("These graphs aren't isomorphic");
        }
    }



}
