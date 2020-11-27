package Task5;

public class Main {

    public static void print(Integer[][] a, int N, int M)
    {
        for (int i = 0; i< N; i++)
        {
            System.out.println();
            for(int j = 0; j< M; j++)
            {
                System.out.print(a[i][j] + " ");
            }
        }
    }
    public static int getMax(Integer[] a)
    {
        int max = a[0];
        for (int el: a){
            if (el > max)
            {
                max = el;
            }
        }
        return max;
    }

    public static int getRandomNumber(int min, int max)
    {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void createRandomMas(Integer[][] a, int N, int M)
    {
        for (int i = 0; i< N; i++)
        {
            for(int j = 0; j< M; j++)
            {
                a[i][j] = getRandomNumber(-10,10);
            }
        }
    }
    public static void main(String[] args)
    {
        try
        {
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);

            Integer[][] arr = new Integer[n][m];

            createRandomMas(arr, n, m);

            int min = Integer.MAX_VALUE;
            Integer[][] arrMax = new Integer[n][m+1];

            for (int i = 0; i < n; i++)
            {
                int max = getMax(arr[i]);
                if (max < min)
                {
                    min = max;
                }
                arrMax[i][0]=max;
                for (int j = 1; j < m+1; j++)
                {
                    arrMax[i][j] = arr[i][j-1];
                }
            }

            print(arr, n, m);

            System.out.println();

            print(arrMax, n, m+1);

            System.out.println();

            Integer[][] arrAnswer = new Integer[n-1][m];
            boolean found = false;
            int k=-1;
            for (int i=0; i<n; i++)
            {
                if (arrMax[i][0] == min && !found)
                {
                    found = true;
                    i++;
                }
                k++;

                for (int j=0; j<m; j++)
                {
                    arrAnswer[k][j] = arr[i][j];
                }
            }

            print(arrAnswer, n-1, m);

        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
