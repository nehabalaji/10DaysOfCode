import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class KnightlOnChessBoard {
    static int[][] knightlOnAChessboard(int n) {

        int a[][] = new int[n-1][n-1];
        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){
                if(a[i-1][j-1]!=0){
                    a[i-1][j-1] = a[j-1][i-1];
                    continue;
                }

                if(a[i-1][j-1] == 0){
                    a[i-1][j-1] = move(n, i, j);
                }
            }
        }

        return a;

    }

    private static int move(int n, int a, int b){
        int[] rd = new int[] {b, a, b, a, -a, -b, -a, -b};
        int[] cd = new int[] {a, b, -a, -b, b, a, -b, -a};

        int[][] visit = new int[n][n];
        int er = n-1;
        int ec = n-1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,0});
        visit[0][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.remove();

            if(cur[0]==er && cur[1]==ec){
                return cur[2];
            }

            for(int i=0; i<8; i++){
                int nr = rd[i] + cur[0];
                int nc = cd[i] + cur[1];

                if(nr>=0 && nr<n && nc>=0 && nc<n && visit[nr][nc]==0){
                    q.add(new int[] {nr, nc, cur[2] + 1});
                    visit[nr][nc] = 1;
                }
            }
        }

        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] result = knightlOnAChessboard(n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                bufferedWriter.write(String.valueOf(result[i][j]));

                if (j != result[i].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
