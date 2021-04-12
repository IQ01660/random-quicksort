import java.util.Random;

public class ImprovedQuickSort implements QuickSort {
    private int switch_factor = 10;

    private long counter = 0;

    public long getCounter() {
        return counter;
    }
    
    private Random rand = new Random();

    public void sort(int[] A) {
        this.counter = 0;
        this.sort(A, 0, A.length - 1);
    }
     
    private void sort(int[] A, int lo, int hi) {
        if (hi > lo) {
            int r; 
            
            if ((A.length / this.switch_factor) >= (hi - lo + 1))
            {
                r = rand.nextInt(hi + 1 - lo) + lo;
            }
            else {
                r = hi;
            }
            

            int p = partition(A, lo, hi, r);

            this.sort(A, lo, p - 1);

            this.sort(A, p + 1, hi);
        }
    }

    private int partition(int[] A, int lo, int hi, int r) {
        int x = A[r];

        this.swap(A, r, hi);

        int j = hi - 1;
        int i = lo;

        while (i <= j){
            /**
             * INCREMENTING COUNTER RIGHT HERE
             */
            this.counter++;

            if (A[i] <= x) {
                i++;
            }
            else {
                this.swap(A, i, j);
                j--;
            }
        }
        this.swap(A, hi, j + 1);

        return (j + 1);
    }

    private void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
