import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Stack<Integer> stack3 = new Stack<Integer>();

        int ha1=0, ha2=0, ha3=0, minStack;

        for(int i=h1.length-1; i>=0; i--){
            stack1.push(h1[i]);
            ha1+=h1[i];
        }

        for(int i=h2.length-1; i>=0; i--){
            stack2.push(h2[i]);
            ha2+=h2[i];
        }

        for(int i=h3.length-1; i>=0; i--){
            stack3.push(h3[i]);
            ha3+=h3[i];
        }

        minStack = Math.min(ha1, Math.min(ha2, ha3));

        while(ha1!=ha2 || ha1!=ha3){

            while(ha1>minStack){
                ha1-=stack1.pop();
            }

            while(ha2>minStack){
                ha2-=stack2.pop();
            }

            while(ha3>minStack){
                ha3-=stack3.pop();
            }

            minStack = Math.min(ha1, Math.min(ha2, ha3));
        }

        return minStack;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
