package VeriYapilariFinal;

// Binary Search Tree'nin düğüm yapısı
class Node {
    int value;
    Node left, right;

    // Düğüm oluşturucu
    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

// Binary Search Tree Sınıfı
class BinarySearchTree {
    Node root;

    // Ağaca yeni değer ekleme
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        // Eğer ağaç boşsa yeni düğüm oluştur
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // Değere göre sol ya da sağ alt ağaçta ilerle
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Ağacın içinde belirli bir değeri arama
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        // Eğer ağaç boşsa veya değer bulunursa
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }

        // Değere göre sol ya da sağ alt ağaçta ilerle
        if (value < root.value) {
            return searchRec(root.left, value);
        } else {
            return searchRec(root.right, value);
        }
    }

    // Ağacı sıralı şekilde yazdırma (In-Order Traversal)
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
}

// Ana sınıf
public class BSTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Ağaca değer ekleme
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Sıralı yazdırma
        System.out.print("In-Order Traversal: ");
        bst.inorder();

        // Değer arama
        System.out.println("\nArama: 40 -> " + bst.search(40));
        System.out.println("Arama: 25 -> " + bst.search(25));
    }
}

