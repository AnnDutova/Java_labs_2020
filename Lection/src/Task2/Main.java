package Task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = Arrays.stream(args)
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        Details task2 = new Details();
        task2.print(arr);

        task2.randomMas(arr);

        System.out.println();
        task2.print(arr);
    }
}
