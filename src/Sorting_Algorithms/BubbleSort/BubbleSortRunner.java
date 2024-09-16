package Sorting_Algorithms.BubbleSort;

import java.util.Arrays;

public class BubbleSortRunner {
    public static void main(String[] args) {

        int arr[] = {1,7,5,6,3,8,9,2};
        System.out.println("BubbleSort Oncesi Array : ");
        System.out.println(Arrays.toString(arr));
        System.out.println("BubbleSort Sonrasi Array : ");
        BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
