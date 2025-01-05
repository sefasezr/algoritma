package VeriYapilariFinal;

import java.util.Arrays;

public class SelectionSort2 {
    public static void main(String[] args) {
        int [] arr = {7,4,5,9,8,2,5};

        int min;
        for (int i = 0; i<arr.length -1; i++){
            min = i;
            for (int j = i+1; j<arr.length; j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

        }

        System.out.println(Arrays.toString(arr));
    }
}
