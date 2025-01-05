package VeriYapilariFinal.AVLTree;

public class AVLTree {
    private Node root;

    // Ağaca bir değer ekleme
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        // Ağaca yeni düğüm ekleme
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        } else {
            return node; // Aynı değerler ağaca eklenmez.
        }

        // Yüksekliği güncelle
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // Denge faktörünü hesapla
        int balance = getBalance(node);

        // Denge faktörüne göre döndürme işlemleri
        // Sol-Sol Durumu
        if (balance > 1 && value < node.left.value) {
            return rotateRight(node);
        }

        // Sağ-Sağ Durumu
        if (balance < -1 && value > node.right.value) {
            return rotateLeft(node);
        }

        // Sol-Sağ Durumu
        if (balance > 1 && value > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Sağ-Sol Durumu
        if (balance < -1 && value < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node; // Dengeli durum
    }

    // Düğümün yüksekliğini al
    private int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Denge faktörünü hesapla
    private int getBalance(Node node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // Sağ dönüş (Right Rotation)
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Döndürme işlemi
        x.right = y;
        y.left = T2;

        // Yükseklikleri güncelle
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // Sol dönüş (Left Rotation)
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Döndürme işlemi
        y.left = x;
        x.right = T2;

        // Yükseklikleri güncelle
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    // Ağacı sıralı şekilde yazdırma (In-Order Traversal)
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.value + " ");
            inorderRec(node.right);
        }
    }
}
