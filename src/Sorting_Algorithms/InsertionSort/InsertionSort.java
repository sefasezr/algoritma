package Sorting_Algorithms.InsertionSort;

public class InsertionSort {

    public static void insertionSort(int[] arr){

        //her zaman sol tarafındaki elemana bakilacagi icin
            //i degerini 1 ile baslatiyoruz
        for(int i = 1; i < arr.length; i++){

            int temp = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j] > temp){ //2ye3
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;

        }




    }
}
