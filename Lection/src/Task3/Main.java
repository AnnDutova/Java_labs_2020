package Task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void print (int a[])
    {
        for (int el:a)
        {
            System.out.print(el + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = Arrays.stream(args)
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        print(arr);

        HashMap<Integer, Integer> map = new HashMap();
        for (int i =0; i< arr.length; i++)
        {
            if (map.containsKey(arr[i]))
            {
                int count = map.get(arr[i]);
                map.remove(arr[i]);
                map.put(arr[i], count+1);

            }
            else {
            map.put(arr[i], 1);
            }
        }

        System.out.println();

        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue() == 1)
            {
            System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }
    }
}