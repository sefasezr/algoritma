package BigO;

//Array ne kadar buyuk olursa olsun, algoritmanın çalıştırılma süresi hep sabit kalacaktır

public class O1 { //O(1)  ---> Constant Complexity
    public static void main(String[] args) {

        int[] arr = {10, 2 ,5 ,34 , 56};
        //arrayin son elemanini ekrana yazdiralim
        System.out.println(arr[arr.length-1]);
        //içine kaç tane veri girersek girelim hep sona gittiği için çalışma süresi değişmeyecek
    }
}
