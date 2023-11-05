
public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] myArray = {2,8,3,5,6,7,1};
        mergeSort(myArray, 0, myArray.length-1);
        for(int i=0;i<myArray.length;i++){
            System.out.print(myArray[i] + " ");
        }
    }


    public static void selectionSort(int[] arr){
        for(int i=0 ; i<arr.length - 1 ; i++){
            for(int j=i ; j<arr.length ; j++){
                if(arr[j]<arr[i]){
                    swap(arr,i,j);
                }
            }
        }
    }

    public static void insertionSort(int[] arr){

    }

    public static void bubbleSort(int[] arr){

    }

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
}
