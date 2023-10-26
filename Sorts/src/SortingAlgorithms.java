
public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] myArray = {2,8,3,5,6,7,1};
        selectionSort(myArray);
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




    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
