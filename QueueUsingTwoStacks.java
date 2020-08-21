import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList();
        int i, n;
        n = sc.nextInt();
        for(int j=0; j<n; j++){
            i=sc.nextInt();
            switch(i){
                case 1:
                    int ele;
                    ele=sc.nextInt();
                    q.add(ele);
                    break;

                case 2:
                    q.remove();
                    break;

                case 3:
                    int printEle = q.peek();
                    System.out.println(""+printEle);
                    break;
            }
        }
    }
}
