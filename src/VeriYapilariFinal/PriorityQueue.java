package VeriYapilariFinal;

import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueue<T> {
    private ArrayList<Node<T>> queue;

    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    // Eleman ekleme (enqueue)
    public void enqueue(T value, int priority) {
        Node<T> newNode = new Node<>(value, priority);
        queue.add(newNode);

        // Kuyruğu önceliğe göre sıralama
        queue.sort(Comparator.comparingInt(Node::getPriority));
    }

    // Eleman çıkarma (dequeue)
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return queue.remove(0).getValue(); // En yüksek öncelikli öğeyi çıkar
    }

    // En yüksek öncelikli öğeyi görüntüleme (peek)
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return queue.get(0).getValue(); // En yüksek öncelikli öğeyi döndür
    }

    // Kuyruğun boş olup olmadığını kontrol etme
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // İç düğüm sınıfı
    private static class Node<T> {
        private T value;
        private int priority;

        public Node(T value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        public T getValue() {
            return value;
        }

        public int getPriority() {
            return priority;
        }
    }

    // Test için ana program
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.enqueue("Task A", 3);
        pq.enqueue("Task B", 1); // En yüksek öncelik
        pq.enqueue("Task C", 2);

        System.out.println("Peek: " + pq.peek()); // Task B
        System.out.println("Dequeue: " + pq.dequeue()); // Task B
        System.out.println("Dequeue: " + pq.dequeue()); // Task C
        System.out.println("Dequeue: " + pq.dequeue()); // Task A
    }
}

