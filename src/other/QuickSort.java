package other;

public class QuickSort {
	static int partition(int[] unsorted, int low, int high)
    {
        int i = low, j = high + 1;
        int v = unsorted[low];
          while(true) {
               while (unsorted[++i] <= v) if (i == high) break;
               while (unsorted[--j] > v) if (j == low) break;
               if (i >= j) break;
               exch(unsorted, i, j);
          }
          exch(unsorted, low, j);
          return j;
    }
	
	public static void exch(int[] unsorted, int low, int high) {
		int temp = unsorted[low];
		unsorted[low] = unsorted[high];
		unsorted[high] = temp;
	}

    static void quick_sort(int[] unsorted, int low, int high)
    {
        int loc = 0;
        if (low < high)
        {
            loc = partition(unsorted, low, high);
            quick_sort(unsorted, low, loc - 1);
            quick_sort(unsorted, loc + 1, high);
        }
    }

    public static void main(String[] args) {
		int[] a = {1,4,2,7,4,9,12,5,1,20,9};
		quick_sort(a, 0, a.length - 1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}

}
