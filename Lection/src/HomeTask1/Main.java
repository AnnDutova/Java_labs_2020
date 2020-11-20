package HomeTask1;

public class Main {
    public static void main(String[] args) {
        int count = args.length;
        int[] arr = new int[count];
        if (count > 0)
        {
            for (int i=0; i< count; i++)
            {
                arr[i]= Integer.parseInt(args[i]);
            }
        }

        Details task1 = new Details();
        task1.print(arr);

        task1.sort(arr, arr.length);

        System.out.println("");
        task1.print(arr);

    }
}
