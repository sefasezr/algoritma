package VeriYapilariFinal.HashTable;

public class HashTable {

    Node [] dizi;
    int size;

    public HashTable(int size) {
        this.size = size;
        dizi = new Node[size];

        for (int i = 0; i < size; i++) {
            dizi[i] = new Node();
        }

    }

    int indexOlustur(int data){

        int index = data%size;
        return index;
    }

    void ekle(int data){

        int index = indexOlustur(data);

        Node eleman = new Node(data);

        Node temp = dizi[index];
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = eleman;



    }

    void sil(int data){
        int index = indexOlustur(data);

        Node temp = dizi[index];
        Node temp2 = dizi[index];

        if(temp.next == null){
            System.out.println("Dizi boş");
        }else if (temp.next.next == null && temp.next.data == data){
            temp.next = null;
        }else {
            while(temp.next != null){

                if(temp.data == data){
                    temp2.next = temp.next;
                }

                temp2 = temp;
                temp = temp.next;


            }
        }
    }


}
