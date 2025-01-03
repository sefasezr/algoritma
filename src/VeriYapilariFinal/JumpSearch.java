package VeriYapilariFinal;

public class JumpSearch {
    public static void main(String[] args) {

    }

    public static int jumpSearch(int[]arr,int target){
        int n = arr.length;
        int step = (int)Math.sqrt(n);

        int prev = 0;
        while (arr[Math.min(step, n)-1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);

            if(prev >= n){
                return -1;
            }
        }

        while (arr[prev] < target) {
            prev++;

            if (prev == Math.min(step, n)) {
                return -1;
            }
        }

        // Hedef bulunduysa indeksini döndür
        if (arr[prev] == target) {
            return prev;
        }

        // Hedef dizide yok
        return -1;
    }
}
