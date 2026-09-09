import java.io.*;
import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int[][] result = new int[m][n];

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            // Top row
            for (int j = layer; j < n - layer; j++) {
                elements.add(matrix.get(layer).get(j));
            }

            // Right column
            for (int i = layer + 1; i < m - layer; i++) {
                elements.add(matrix.get(i).get(n - layer - 1));
            }

            // Bottom row
            for (int j = n - layer - 2; j >= layer; j--) {
                elements.add(matrix.get(m - layer - 1).get(j));
            }

            // Left column
            for (int i = m - layer - 2; i > layer; i--) {
                elements.add(matrix.get(i).get(layer));
            }

            int len = elements.size();
            int shift = r % len;

            int index = 0;

            // Top row
            for (int j = layer; j < n - layer; j++) {
                result[layer][j] = elements.get((index + shift) % len);
                index++;
            }

            // Right column
            for (int i = layer + 1; i < m - layer; i++) {
                result[i][n - layer - 1] =
                    elements.get((index + shift) % len);
                index++;
            }

            // Bottom row
            for (int j = n - layer - 2; j >= layer; j--) {
                result[m - layer - 1][j] =
                    elements.get((index + shift) % len);
                index++;
            }

            // Left column
            for (int i = m - layer - 2; i > layer; i--) {
                result[i][layer] =
                    elements.get((index + shift) % len);
                index++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);

                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().trim().split(" ");

        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        int r = Integer.parseInt(firstLine[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] values = br.readLine().trim().split(" ");

            List<Integer> row = new ArrayList<>();

            for (String value : values) {
                row.add(Integer.parseInt(value));
            }

            matrix.add(row);
        }

        matrixRotation(matrix, r);
    }
}

OUTPUT:
Input:
4 4 1
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

Your Output:
2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15

Expected Output:
2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15

Status: Correct 
