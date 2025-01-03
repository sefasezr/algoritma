package VeriYapilariFinal;

public class LinearSearch {
    public static void main(String[] args) {
        int [] arr = {4,6,12,8,5,15,25,34};

        System.out.println(linSearch(arr, 19));
    }


    static int linSearch(int [] arr, int n){

        for(int i=0;i<arr.length;i++){
            if(arr[i]==n){
                System.out.println("Aranan eleman dizide mevcut");
                return i;
            }
        }
        System.out.println("Eleman dizide mevcut degil");
        return -1;
    }
}
