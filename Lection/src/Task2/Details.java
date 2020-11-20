package Task2;

public class Details {
    public void print(int arr[])
    {
        for (int el:arr)
        {
            System.out.print(el + " ");
        }
    }
    public boolean isUsed(int a[][], int index)
    {
        return (a[index][1] == 1);
    }
    public int getRandomIndex(int a[][], int i)
    {
        double temp = Math.random() * a.length;
        int index = (int)temp;
        boolean found = false;
        while ( !found ) {
            if (isUsed(a,index) || index == i) {
            temp = Math.random() * a.length;
            index = (int)temp;
            } else {
                found = true;
            }
        }
        a[index][1] = 1;
        return index;
    }
    public void randomMas(int a[]){
        int[][] arr = new int[a.length][2]; //запишим туда все элементы
                                            // [числа][меняли ли мы этот элемент?]
        for (int i = 0; i < a.length; i++)
        {
            arr[i][0] = a[i];
            arr[i][1] = 0;
        }
        System.out.println();
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + "->");
            int temp = arr[getRandomIndex(arr, i)][0];
            a[i] = temp;
            System.out.println(temp);
        }
    }
}
