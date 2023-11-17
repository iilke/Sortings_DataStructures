import java.util.Random;
public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] myArray = {2,8,3,5,6,7,1};
        System.out.println("Beginning array: ");
        printArray(myArray);

        selectionSort(myArray);
        System.out.println("\nSorted:");
        printArray(myArray);

        knuthShuffle(myArray);
        System.out.println("\nShuffled: ");
        printArray(myArray);
    }


    public static void knuthShuffle(int[] arr){
        Random random = new Random();
        int n=arr.length;
        int j;
        for(int i=n-1 ; i>0 ; i--){
            j= random.nextInt(i);
            swap(arr, i,j);
        }
    }


    public static void selectionSort(int[] arr){
        for(int i=0 ; i<arr.length ; i++){
            int min = arr[i];
            int minIndex = i;
            for(int j=i+1; j<arr.length ; j++){
                if(min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    public static void bubbleSort(int[] arr, int n){

        if(n==1){
            return;
        }

        for(int i=0 ; i<n-1 ; i++){
            if(arr[i]>arr[i+1]){
                swap(arr,i,i+1);
            }
        }

        bubbleSort(arr, n-1);
    }

/*----------------------------------------------QUICK SORT--------------------------------------------------------------*/

    public static int partition(int[] arr, int l, int r){
        int p=r;
        int i=l;
        int j=p-1;

        while(j>=i){
            while(i <= j && arr[i] < arr[p]){
                i++;
            }

            while(j >= i && arr[j]>arr[p]){
                j--;
            }

            if(i<=j){
                swap(arr, i, j);
            }
        }
        swap(arr,p,i);
        return i;
    }

    public static void quickSort(int[] A, int l, int r){
        if(l<r){  //to check if we have an array that has at least 2 elements
            int q = partition(A, l, r);
            quickSort(A, l, q-1);
            quickSort(A, q+1, r);
        }
    }

    public static int quickSelect(int[] arr, int k, int l, int r) {

        if (k > 0 && k <= r - l + 1) {
            int partitionIndex = partition(arr, l, r);

            if (partitionIndex - l == k - 1) {
                return arr[partitionIndex];

            } else if (partitionIndex - l > k - 1) {
                return quickSelect(arr, k, l, partitionIndex - 1);

            } else {
                return quickSelect(arr, k - (partitionIndex - l + 1), partitionIndex + 1, r);
            }
        }


        return Integer.MAX_VALUE;
    }

/*----------------------------------------------MERGE SORT--------------------------------------------------------------*/

    public static void mergeSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);

            merge(arr, lo, mid, hi);
        }
    }


    public static void merge(int[] arr, int lo, int mid, int hi){
        int[] aux = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            aux[i] = arr[i];              //creating a copy array
        }

        int i=lo;
        int j=mid+1;
        int k=lo;

        while(i<=mid && j<=hi){
            if(aux[j]<aux[i]){
                arr[k++] = aux[j++];
            }
            else{
                arr[k++] = aux[i++];
            }
        }

        while(i<=mid){
            arr[k++] = aux[i++];
        }

        while(j<=hi){
            arr[k++] = aux[j++];
        }

}


    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
