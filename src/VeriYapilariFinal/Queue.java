package VeriYapilariFinal;

public class Queue {
    private int front;  // Kuyruğun ön kısmını işaret eder
    private int rear;   // Kuyruğun arka kısmını işaret eder
    private int size;   // Kuyruğun toplam kapasitesi
    private int count;  // Kuyruğun içindeki öğe sayısını takip eder
    private int[] arr;  // Kuyruk için kullanılan dizi

    // Kuyruğu başlatma
    public Queue(int size) {
        this.size = size;
        this.front = 0;
        this.rear = -1; // Rear başlangıçta boş olduğu için -1
        this.count = 0;
        this.arr = new int[size];
    }

    // Eleman ekleme (enqueue)
    public void enqueue(int x) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        // Circular Queue mantığı ile eleman ekleme
        rear = (rear + 1) % size;
        arr[rear] = x;
        count++;
    }

    // Eleman çıkarma (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int item = arr[front];
        front = (front + 1) % size;
        count--;
        return item;
    }

    // Ön sıradaki elemanı görüntüleme (peek)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }

    // Kuyruğun dolu olup olmadığını kontrol etme
    public boolean isFull() {
        return count == size;
    }

    // Kuyruğun boş olup olmadığını kontrol etme
    public boolean isEmpty() {
        return count == 0;
    }

    // Kuyruktaki eleman sayısını döndürme
    public int count() {
        return count;
    }

    // Test için ana program
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(12);
        System.out.println("Front: " + queue.peek()); // 12

        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);
        System.out.println("Count: " + queue.count()); // 4
        queue.enqueue(16);

        System.out.println("Dequeued: " + queue.dequeue()); // 12
        System.out.println("Count: " + queue.count()); // 4
        System.out.println("Dequeued: " + queue.dequeue()); // 13
        System.out.println("Count: " + queue.count()); // 3

        queue.enqueue(17); // Circular mantıkla eklenir
        System.out.println("Front: " + queue.peek()); // 14
    }
}

