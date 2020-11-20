package HomeTask1;

public class Details {
    public void sort (int a[], int n) {
        for (int step = n / 2; step > 0; step /= 2) {
            for (int i = step; i < n; i++) {
                for (int j = i - step; j >= 0 && a[j] > a[j + step]; j -= step) {
                    int x = a[j];
                    a[j] = a[j + step];
                    a[j + step] = x;
                }
            }
        }
    }
    public void print(int a[]){
        for (int el:a)
        {
            System.out.print(el + " ");
        }
    }
}
