class CircularQueue {
    int[] queue;
    int front, rear, size, capacity;

    // Constructor
    CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert element
    void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue is Full");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        System.out.println(value + " inserted");
    }

    // Remove element
    void dequeue() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return;
        }

        int value = queue[front];
        front = (front + 1) % capacity;
        size--;

        System.out.println(value + " deleted");
    }

    // Display queue
    void display() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue: ");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        cq.display();

        cq.dequeue();
        cq.dequeue();

        cq.display();

        cq.enqueue(60);
        cq.enqueue(70);

        cq.display();
    }
}