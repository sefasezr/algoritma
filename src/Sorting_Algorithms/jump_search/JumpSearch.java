package Sorting_Algorithms.jump_search;

import java.math.MathContext;

public class JumpSearch {

    public static void jumpSearch(int [] arr, int aranan){

        int atlama = (int) Math.sqrt(arr.length);

        for (int i = 0; ; i+=atlama) {

            if(arr[i] == aranan){
                System.out.println("Bulundu aranan sayi: "+aranan);
                break;
            }else if (aranan < arr[i]){
                //lineer search
            }


        }



    }
}
