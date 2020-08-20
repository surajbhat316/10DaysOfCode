import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;


public class Solution {
    //Referred from youtube video on the same problem...
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        //leant about Stacks in java, various methods isEmpty() and peak() 
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        Stack<Integer> st3 = new Stack<Integer>();

        int height1 = 0, height2 = 0, height3 = 0;

        for (int i = h1.length - 1; i >= 0; i--) {
            height1 += h1[i];
            st1.push(height1);
        }
        for (int i = h2.length - 1; i >= 0; i--) {
            height2 += h2[i];
            st2.push(height2);
        }
        for (int i = h3.length - 1; i >= 0; i--) {
            height3 += h3[i];
            st3.push(height3);
        }

        while (true) {

            
            if (st1.isEmpty() || st2.isEmpty() || st3.isEmpty())
                return 0;

            height1 = st1.peek();
            height2 = st2.peek();
            height3 = st3.peek();

            if (height1 == height2 && height2 == height3)
                return height1;
            if (height1 >= height2 && height1 >= height3)
                st1.pop();
            else if (height2 >= height1 && height2 >= height3)
                st2.pop();
            else if (height3 >= height2 && height3 >= height1)
                st3.pop();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1[h1_i] = in.nextInt();
        }
        int h2[] = new int[n2];
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2[h2_i] = in.nextInt();
        }
        int h3[] = new int[n3];
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3[h3_i] = in.nextInt();
        }
        System.out.println(equalStacks(h1, h2, h3));
        in.close();
    }
}
