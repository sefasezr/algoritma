package VeriYapilariFinal;

public class BinarySearch {

    /*
    Dizinin indis bakimindan ortanca elemani bulunur
    Eger aranan eleman ortanca elemana esitse arama sonlanir
     */

    public static void main(String[] args) {
        int [] arr = {1,4,9,10,22,30,35,43,45};

        System.out.println(binarySearch(arr,32));

    }

    static boolean binarySearch(int [] arr, int key) {

        int kucukIndis = 0;
        int buyukIndis = arr.length-1;

        while (buyukIndis >= kucukIndis) {
            int orta = (buyukIndis+kucukIndis)/2;
            if (arr[orta] == key) {
                return true;
            }
            if (arr[orta] < key) {
                kucukIndis = orta+1;
            }
            if (arr[orta] > key) {
                buyukIndis = orta-1;
            }
        }
        return false;
    }
}
