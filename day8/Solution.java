import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the sillyGame function below.
     */
    private static int[] a = new int[100001];
    private static int pointer = 2;
    static { a[1] = 0;a[2] = 1;}

    static String sillyGame(int n) {

        if (a[n] > 0) {
            if (a[n] % 2 == 0) return "Bob";
            else return "Alice";
        }

        for (int i = pointer+1; i <= n; i++) {
            boolean x = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    x = false;
                    break;
                }
            }
            if (x) a[i] = a[i-1] + 1;
            else a[i] = a[i-1];
        }

        pointer = n;

        if (a[n] % 2 == 0) return "Bob";
        else return "Alice";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            String result = sillyGame(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
