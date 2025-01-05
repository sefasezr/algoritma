package VeriYapilariFinal.AVLTree;

public class AVLTreeRunner {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        // Değerler ekleme
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        avl.insert(25);

        // Sıralı yazdırma
        System.out.print("In-Order Traversal: ");
        avl.inorder();
    }
}
