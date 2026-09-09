import java.io.*;

public class Solution {

    public static int marsExploration(String s) {
        int count = 0;

        String sos = "SOS";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sos.charAt(i % 3)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(marsExploration(s));
    }
}

OUTPUT:
Accepted
Runtime: 0 ms

Input
SOSSPSSQSSOR

Output
3

Expected Output
3
