package Task4;

public class Main {
    public static int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static void print(int a[][], int N, int M){
        for (int i = 0; i< N; i++)
        {
            System.out.println();
            for(int j = 0; j< M; j++)
            {
                System.out.print(a[i][j] + " ");
            }
        }
    }
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[][] arr = new int[n][m];
        for (int i = 0; i< n; i++)
        {
            int sum = 0;
            for(int j = 0; j< m-1; j++)
            {
                arr[i][j] = getRandomNumber(-10, 10);
                sum+=arr[i][j];
            }
            arr[i][m-1] = i - sum;
        }
        print(arr, n, m);
    }
}
