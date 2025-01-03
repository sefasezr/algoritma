package VeriYapilariFinal;


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {5,3,8,12,6,1,4,13,10,18,14};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);

     }

     static void bubbleSort(int [] arr){
        boolean swapped = false;

         do {
             swapped = false;
             for (int i = 0; i<arr.length-1; i++){
                 if (arr[i] > arr[i+1]){
                     int temp = arr[i];
                     arr[i] = arr[i+1];
                     arr[i+1] = temp;
                     swapped = true;
                 }
             }
         }while (swapped);

         System.out.println("Siralanmis Array: "+ Arrays.toString(arr));

     }
}
