package VeriYapilariFinal.AVLTree;

public class Node {
    int value;
    int height;
    Node left, right;

    public Node(int value) {
        this.value = value;
        this.height = 1; // Yeni düğümün yüksekliği başlangıçta 1'dir.
    }

}
