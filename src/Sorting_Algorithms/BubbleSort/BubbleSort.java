package Sorting_Algorithms.BubbleSort;

public class BubbleSort {

    public static void bubbleSort(int [] arr){  //1, 2, 3, 4

        //swap var mı yok mu? varsa diger iterasyona gececegim
        boolean swapped = false;

        do {
            swapped = false;
            for (int i = 1; i < arr.length - 1; i++) {
                // 2 sayiyi karsilastiriyorum soldaki eleman sagdaki elemandan buyukse swap yap
                if(arr[i-1] >arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    swapped = true;
                }
            }


        }while(swapped);



    }
}
