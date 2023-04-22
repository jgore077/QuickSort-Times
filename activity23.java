package pNew;
import java.util.Arrays;
import java.util.Random;
//Anusha Ghimire and Jimmy Gore 
public class activity23 {
    // Quicksort algorithm
    public static void quickSort(int arr[], int begin, int end, String pivotPolicy) {
        if (begin<end) {
            // Partition the array and get the partition index
            int partitionIndex = partition(arr, begin, end, pivotPolicy);
    
            // Recursively apply Quicksort to the left and right partitions
            quickSort(arr, begin, partitionIndex-1, pivotPolicy);
            quickSort(arr, partitionIndex+1, end, pivotPolicy);
        }
    }

    public static int partition(int arr[], int begin, int end, String pivotPolicy) {
        int pivot;
        switch (pivotPolicy) {
            case "x[mid]":
                int mid = (begin + end) / 2;
                pivot = arr[mid];
                break;
            case "average of all values":
                int sum = Arrays.stream(arr, begin, end+1).sum();
                pivot = sum / (end - begin + 1);
                break;
            case "median of all values":
                int[] arrCopy = Arrays.copyOfRange(arr, begin, end+1);
                Arrays.sort(arrCopy);
                pivot = arrCopy[(end - begin + 1) / 2];
                break;
            case "median of 10 sampled values":
                int[] sampleArr2 = new int[10];
                Random rand2 = new Random();
                for (int i = 0; i < 10; i++) {
                    int randIndex2 = rand2.nextInt(end - begin + 1) + begin;
                    sampleArr2[i] = arr[randIndex2];
                }
                Arrays.sort(sampleArr2);
                pivot = sampleArr2[5];
                break;
            default:
                throw new IllegalArgumentException("Invalid pivot policy");
        }

        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return i+1;
    }


    public static void main(String[] args) {
        // Generate an integer array of size 1000000 with random numbers
        Random rand = new Random();
        int[] hundredthousandArray = new int[100000];
        for (int i = 0; i < hundredthousandArray.length; i++) {
        	hundredthousandArray[i] = rand.nextInt(10000);
        }

        long startTime, endTime;

        // Measure the time taken to execute Quicksort with x[mid] pivot policy
        int[] array1 = Arrays.copyOf(hundredthousandArray, hundredthousandArray.length);
        startTime = System.nanoTime();
        quickSort(array1, 0, array1.length-1, "x[mid]");
        endTime = System.nanoTime();
        System.out.println("x[mid] pivot policy: " + (endTime-startTime)/1000000.0 + " ms");

        // Measure the time taken to execute Quicksort with median of 10 sampled values pivot policy
        int[] array2 = Arrays.copyOf(hundredthousandArray, hundredthousandArray.length);
        startTime = System.nanoTime();
        quickSort(array2, 0, array2.length-1, "median of 10 sampled values");
        endTime = System.nanoTime();
        System.out.println("median of 10 sampled values pivot policy: " + (endTime-startTime)/1000000.0 + " ms");

        // Measure the time taken to execute Quicksort with average of all values pivot policy
        int[] array3 = Arrays.copyOf(hundredthousandArray, hundredthousandArray.length);
        startTime = System.nanoTime();
        quickSort(array3, 0, array3.length-1, "average of all values");
        endTime = System.nanoTime();
        System.out.println("average of all values pivot policy: " + (endTime-startTime)/1000000.0 + " ms");

        // Measure the time taken to execute Quicksort with median of all values pivot policy
        int[] array4 = Arrays.copyOf(hundredthousandArray, hundredthousandArray.length);
        startTime = System.nanoTime();
        quickSort(array4, 0, array4.length-1, "median of all values");
        endTime = System.nanoTime();
        System.out.println("median of all values pivot policy: " + (endTime-startTime)/1000000.0 + " ms");
    }
}
