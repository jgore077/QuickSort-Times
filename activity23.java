import java.util.Random;
public class activity23 {

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
    
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);
    
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
    
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
    
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
    
        return i+1;
    }

    public static void main(String[] args){
       Random rand= new Random();
       int[] millionArray = new int[1000000];
       for(int i=0;i<millionArray.length;i++){
        millionArray[i]= rand.nextInt(10000);
       }
        quickSort(millionArray, 0, millionArray.length-1);
    }
    
}
