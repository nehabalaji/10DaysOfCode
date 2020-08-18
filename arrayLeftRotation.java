import java.util.Scanner;

public class arrayLeftRotation {

    public static void main(String[] args) {
        int n, d;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        d = sc.nextInt();
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0; i<d; i++){
            int first, j;
            first=arr[0];
            for(j=0; j<n-1; j++){
                arr[j]=arr[j+1];
            }
            arr[n-1]=first;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
