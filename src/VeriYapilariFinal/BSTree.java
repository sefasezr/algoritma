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

    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            Node minRight = findMinValue(root.right);
            root.value = minRight.value;
            root.right = deleteRec(root.right, minRight.value);
        }

        return root;
    }

    private Node findMaxValue(Node root) {
        Node current = root.left;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return current;
    }

    private Node findMinValue(Node root) {
        Node current = root.right;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    public int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeHeight(root.left),treeHeight(root.right)) + 1;
    }

    private void reverseOrder() {
        reverseOrderRef(root);
    }

    public void printLevel(Node root, int level){
        if (root == null){
            return;
        }
        if (level == 1){
            System.out.println(root.value);
        }else {
            printLevel(root.left, level-1);
            printLevel(root.right, level-1);
        }

    }

    private void reverseOrderRef(Node root) {
        int height = treeHeight(root);
        for (int level = height; level>=1; level++){
            printLevel(root,level);
        }
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

        // Değer silme
        bst.delete(40);
        System.out.println("40 silindikten sonra arama: 40 -> " + bst.search(40));
        System.out.print("In-Order Traversal: ");
        bst.inorder();
    }
}
