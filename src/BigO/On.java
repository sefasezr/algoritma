package BigO;

//elimizdeki veri seti arttıkça algoritmanın calistirilma süresi dogru orantili olarak artis gosterir

public class On { // O(n) --> Linear Complexity eleman sayisi ile dogru orantili olarak süresi artiyorsa

    public static void main(String[] args) {

        // arrayin butun elemanlarini ekrana basalim
        int[] arr = {21,33,2,4,23,11};
        for (int item : arr){
            System.out.print(item + " ,");
        }
    }
}
