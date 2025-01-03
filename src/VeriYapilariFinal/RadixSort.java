package VeriYapilariFinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

    public static void radixSort(int[] arr) {
        // En büyük sayıyı bul
        int max = getMax(arr);

        // Basamak sayısına göre sırayla işle
        for (int exp = 1; max / exp > 0; exp *= 10) {
            arr = countingSortByDigit(arr, exp);
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static int[] countingSortByDigit(int[] arr, int exp) {
        // Basamaklara göre sıralama yap
        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Her sayıyı ilgili basamağına göre uygun kovaya yerleştir
        for (int num : arr) {
            int digit = (num / exp) % 10;
            buckets[digit].add(num);
        }

        // Kovaları sırayla birleştir
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Orijinal Dizi: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Sıralı Dizi: " + Arrays.toString(arr));
    }
}
