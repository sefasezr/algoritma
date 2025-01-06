package VeriYapilariFinal.HashTable;

public class Node {
    Node next;
    int data;

    public Node(){
        next = null;
    }

    public Node(int data) {
        this.data = data;
        next = null;
    }
}
