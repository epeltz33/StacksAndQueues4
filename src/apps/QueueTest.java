package apps;

import adts.ArrayQueue;
import exceptions.QueueFullException;
import exceptions.QueueEmptyException;

public class QueueTest {
    public static void main(String[] args) {
        System.out.println("Testing ArrayQueue Implementation");
        System.out.println("================================");

        // Test constructor and initial state
        ArrayQueue<String> queue = new ArrayQueue<>(3);
        System.out.println("New queue created");
        System.out.println("Empty? " + queue.isEmpty());
        System.out.println("Full? " + queue.isFull());
        System.out.println(queue);

        try {
            // Test enqueue
            System.out.println("\nTesting enqueue operations:");
            queue.enqueue("A");
            System.out.println("After enqueue A: " + queue);
            queue.enqueue("B");
            System.out.println("After enqueue B: " + queue);
            queue.enqueue("C");
            System.out.println("After enqueue C: " + queue);
            System.out.println("Full? " + queue.isFull());

            // Test QueueFullException
            try {
                queue.enqueue("D");
                System.out.println("Error: Should have thrown QueueFullException");
            } catch (QueueFullException e) {
                System.out.println("Successfully caught QueueFullException: " + e.getMessage());
            }

            // Test dequeue
            System.out.println("\nTesting dequeue operations:");
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("After first dequeue: " + queue);
            queue.enqueue("D");
            System.out.println("After enqueue D: " + queue);

            // Test circular behavior
            System.out.println("\nTesting circular behavior:");
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("After dequeues: " + queue);
            queue.enqueue("E");
            System.out.println("After enqueue E: " + queue);
            queue.enqueue("F");
            System.out.println("After enqueue F: " + queue);

            // Empty the queue
            System.out.println("\nEmptying queue:");
            while (!queue.isEmpty()) {
                System.out.println("Dequeued: " + queue.dequeue());
            }

            // Test QueueEmptyException
            try {
                queue.dequeue();
                System.out.println("Error: Should have thrown QueueEmptyException");
            } catch (QueueEmptyException e) {
                System.out.println("Successfully caught QueueEmptyException: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }
}