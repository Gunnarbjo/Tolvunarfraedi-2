import java.util.Random;
import edu.princeton.cs.algs4.*;
import java.util.Collections;

public class Sort{
  private static int[] fylki(){
    int[] million = new int[1000000];

    for(int i = 0; i < million.length;i++){
      million[i] = StdRandom.uniform(-100,100);
    }
    return million;
  }
  private static int quickSort(int[]arr, int low, int high){
    int pivot = arr[high];
    int i = (low-1); // index of smaller element
    for (int j=low; j<high; j++){
    // If current element is smaller than or
    // equal to pivot
      if (arr[j] <= pivot){
        i++;
        // swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

      // swap arr[i+1] and arr[high] (or pivot)
      int temp = arr[i+1];
      arr[i+1] = arr[high];
      arr[high] = temp;

      return i+1;
    }


    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low  --> Starting index,
    high  --> Ending index */
  public void sorting(int arr[], int low, int high){
    if (low < high){
    /* pi is partitioning index, arr[pi] is
      now at right place */
    int pi = quickSort(arr, low, high);

    // Recursively sort elements before
    // partition and after partition
    sorting(arr, low, pi-1);
    sorting(arr, pi+1, high);
    }
  }
  private static void sampleSort(int[] arr, int n){
    


  }
  private void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }





  public static void main(String[] args) {

    Stopwatch klukka = new Stopwatch();
    quickSort(fylki(),0,1000000-1);
    double timi = klukka.elapsedTime();
    StdOut.println("QuickSort: " + timi);

    //StdOut.println(sampleSort(fylki(),5));



  }
}
