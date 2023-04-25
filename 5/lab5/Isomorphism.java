package lab5;

import java.util.Arrays;

public class Isomorphism {

    public boolean isIsomorphic(int[][] graph1, int[][] graph2){
        int n1 = graph1.length;
        int n2 = graph2.length;

        if(n1 != n2 || graph1[0].length != graph2[0].length){
            return false;
        }

        int[] degree1 = new int[n1];
        int[] degree2 = new int[n2];
        for (int i = 0; i < n1; i++){
            for (int j = 0; j < graph1[0].length; j++){
                if(graph1[i][j] > 0){
                    degree1[i]++;
                }

                if(graph2[i][j] > 0){
                    degree2[i]++;
                }
            }
        }

        for (int i = 0; i < n1; i++){
            if(degree1[i] != degree2[i]){
                return false;
            }
        }
        return true;
    }
}
