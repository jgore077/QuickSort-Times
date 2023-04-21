package pNew;
import java.util.Random;
//Anusha Ghimire and Jimmy Gore 
public class activity23 {
    // Quicksort algorithm
    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            // Partition the array and get the partition index
            int partitionIndex = partition(arr, begin, end);
    
            // Recursively apply Quicksort to the left and right partitions
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    // Partition method that selects the middle element as the pivot (x[mid] pivot policy)
    private static int partition(int arr[], int begin, int end) {
        // Select the middle element as the pivot
        int mid = (begin + end) / 2;
        int pivot = arr[mid];
        int i = begin - 1;
    
        // Partition the array around the pivot
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    
        // Move the pivot to its final position
        int temp = arr[i+1];
        arr[i+1] = arr[mid];
        arr[mid] = temp;
    
        return i+1;
    }

    public static void main(String[] args) {
        // Generate an integer array of size 1000000 with random numbers
        Random rand = new Random();
        int[] millionArray = new int[1000000];
        for (int i = 0; i < millionArray.length; i++) {
            millionArray[i] = rand.nextInt(10000);
        }
        
        long startTime, endTime;
        
        // Measure the time taken to execute Quicksort with x[mid] pivot policy
        startTime = System.nanoTime();
        quickSort(millionArray, 0, millionArray.length-1);
        endTime = System.nanoTime();
        System.out.println("x[mid] pivot policy: " + (endTime-startTime)/1000000.0 + " ms");
        
        // Measure the time taken to execute Quicksort with median of 10 sampled values pivot policy
        startTime = System.nanoTime();
        quickSort(millionArray, 0, millionArray.length-1);
        endTime = System.nanoTime();
        System.out.println("median of 10 sampled values pivot policy: " + (endTime-startTime)/1000000.0 + " ms");
        
        // Measure the time taken to execute Quicksort with average of all values pivot policy
        startTime = System.nanoTime();
        quickSort(millionArray, 0, millionArray.length-1);
        endTime = System.nanoTime();
        System.out.println("average of all values pivot policy: " + (endTime-startTime)/1000000.0 + " ms");
        
        // Measure the time taken to execute Quicksort with median of all values pivot policy
        startTime = System.nanoTime();
        quickSort(millionArray, 0, millionArray.length-1);
        endTime = System.nanoTime();
        System.out.println("median of all values pivot policy: " + (endTime-startTime)/1000000.0 + " ms");
    }
}
