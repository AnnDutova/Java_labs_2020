package Task5;

import java.util.HashMap;
import java.util.Map;

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

            HashMap<Integer, Integer[]> map = new HashMap<>();
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++)
            {
                int max = getMax(arr[i]);
                if (max < min)
                {
                    min = max;
                }
                map.put(max, arr[i]);
            }

            print(arr, n, m);

            System.out.println();

            for (Map.Entry<Integer, Integer[]> pair : map.entrySet())
            {
                System.out.println();
                System.out.println(pair.getKey() + " : ");
                for (Integer el : pair.getValue())
                {
                    System.out.print(el + ", ");
                }
            }

            map.remove(min);
            System.out.println();
            System.out.print("Answer");

            for (Map.Entry<Integer, Integer[]> pair : map.entrySet())
            {
                System.out.println();
                System.out.println(pair.getKey() + " : ");
                for (Integer el : pair.getValue())
                {
                    System.out.print(el + ", ");
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
