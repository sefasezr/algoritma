package VeriYapilariFinal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class CoinsChange {

    public static void main(String[] args) {

        int para = 12345;
        int adet = para / 13;

        boolean bulundu = false;

        for (int i = adet; i >=0 ; i--) {

            int kalan = para - (i * 13);
            for(int z = kalan/7 ; z >=0 ; z-- ){
                int kalan2 = kalan - z*7;
                if (kalan2 % 2 == 0){
                    int x = kalan2 / 2;

                    System.out.println("13 sayisi :" + i);
                    System.out.println("7 sayisi :" + z);
                    System.out.println("2 sayisi :" + x);

                    bulundu = true;
                }
            }
            if (bulundu){
                break;
            }
        }


    }




}

