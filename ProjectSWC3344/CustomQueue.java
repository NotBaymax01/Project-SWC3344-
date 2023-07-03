import java.util.*;

public class CustomQueue {
    private LinkedList<Object> list; // declare object of the queue

    // constructor without parameter
    public CustomQueue() {
        list = new LinkedList<>();
    }// end of constructor

    // method to insert an object to a queue
    public void enqueue(Object item) {
        list.addLast(item);
    }// end of enqueue

    // method to remove an object from a queue
    public Object dequeue() {
        if (!empty()) {
            return list.removeFirst(); // remove first element
        } else {
            System.out.println("Queue is empty!");
            return null;
        }
    }// end of dequeue

    // method to test whether the queue is empty or not
    public boolean empty() {
        return list.isEmpty();
    }

    // return the element at the front without removing it
    public Object front() {
        if (!empty()) {
            return list.getFirst();
        } else {
            System.out.println("Queue is empty!");
            return null;
        }
    }
}