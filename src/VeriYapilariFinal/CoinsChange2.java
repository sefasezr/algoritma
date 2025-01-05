package VeriYapilariFinal;

public class CoinsChange2 {

    public static void main(String[] args) {
        int para = 12345;
        int sayac13 =0;
        int sayac7=0;
        int sayac5=0;
        int sayac2 = 0;
        int sayac1 = 0;

        //13 7 5 2 1 lik banknotlara ayırın

        while (para > 0 ) {
            if(para >= 13){
                para = para - 13;
                sayac13++;
            }
            else if(para >= 7){
                para = para - 7;
                sayac7++;

            }else if(para >= 5){
                para = para - 5;
                sayac5++;
            }
            else if(para >= 2){
                para = para - 2;
                sayac2++;
            }
            else if(para >= 1){
                para = para - 1;
                sayac1++;
            }
        }
        System.out.println(sayac13);
        System.out.println(sayac7);
        System.out.println(sayac5);
        System.out.println(sayac2);
        System.out.println(sayac1);
    }
}
