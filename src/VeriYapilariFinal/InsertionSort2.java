package VeriYapilariFinal;

import java.util.Arrays;

public class InsertionSort2 {
    public static void main(String[] args) {

        int[] arr = {12,9,4,99,120,1,3,10};

        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }

    }
}
