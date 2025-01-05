package VeriYapilariFinal;

import java.util.ArrayList;
import java.util.List;

// B-Tree Düğüm Yapısı
class BTreeNode {
    int[] keys;  // Düğüm içindeki anahtarlar
    int t;       // Minimum derece (minimum anahtar sayısı t-1, maksimum 2t-1)
    BTreeNode[] children; // Çocuk düğümler
    int n;       // Şu anki anahtar sayısı
    boolean isLeaf; // Yaprak düğüm olup olmadığı

    public BTreeNode(int t, boolean isLeaf) {
        this.t = t;
        this.isLeaf = isLeaf;
        this.keys = new int[2 * t - 1]; // Maksimum anahtar sayısı
        this.children = new BTreeNode[2 * t]; // Maksimum çocuk sayısı
        this.n = 0;
    }

    // Düğümdeki anahtarları sıralı şekilde yazdırma
    public void traverse() {
        for (int i = 0; i < n; i++) {
            if (!isLeaf) {
                children[i].traverse();
            }
            System.out.print(keys[i] + " ");
        }
        if (!isLeaf) {
            children[n].traverse();
        }
    }

    // Düğümde bir anahtar arama
    public BTreeNode search(int key) {
        int i = 0;
        while (i < n && key > keys[i]) {
            i++;
        }

        if (i < n && keys[i] == key) {
            return this;
        }

        if (isLeaf) {
            return null;
        }

        return children[i].search(key);
    }

    // Anahtar ekleme
    public void insertNonFull(int key) {
        int i = n - 1;

        if (isLeaf) {
            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = key;
            n++;
        } else {
            while (i >= 0 && keys[i] > key) {
                i--;
            }
            i++;
            if (children[i].n == 2 * t - 1) {
                splitChild(i, children[i]);

                if (keys[i] < key) {
                    i++;
                }
            }
            children[i].insertNonFull(key);
        }
    }

    // Çocuk düğüm ayırma
    public void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.t, y.isLeaf);
        z.n = t - 1;

        for (int j = 0; j < t - 1; j++) {
            z.keys[j] = y.keys[j + t];
        }

        if (!y.isLeaf) {
            for (int j = 0; j < t; j++) {
                z.children[j] = y.children[j + t];
            }
        }

        y.n = t - 1;

        for (int j = n; j >= i + 1; j--) {
            children[j + 1] = children[j];
        }
        children[i + 1] = z;

        for (int j = n - 1; j >= i; j--) {
            keys[j + 1] = keys[j];
        }
        keys[i] = y.keys[t - 1];
        n++;
    }
}

// B-Tree Sınıfı
class BTree {
    private BTreeNode root;
    private int t;

    public BTree(int t) {
        this.t = t;
        this.root = null;
    }

    // Ağacı sıralı yazdırma
    public void traverse() {
        if (root != null) {
            root.traverse();
        }
    }

    // Anahtar arama
    public BTreeNode search(int key) {
        return (root == null) ? null : root.search(key);
    }

    // Anahtar ekleme
    public void insert(int key) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                BTreeNode s = new BTreeNode(t, false);
                s.children[0] = root;
                s.splitChild(0, root);

                int i = 0;
                if (s.keys[0] < key) {
                    i++;
                }
                s.children[i].insertNonFull(key);

                root = s;
            } else {
                root.insertNonFull(key);
            }
        }
    }
}

// Ana sınıf
public class BTreeDemo {
    public static void main(String[] args) {
        BTree tree = new BTree(3); // Minimum derece 3

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);

        System.out.println("B-Tree sıralı yazdırma:");
        tree.traverse();
    }
}

