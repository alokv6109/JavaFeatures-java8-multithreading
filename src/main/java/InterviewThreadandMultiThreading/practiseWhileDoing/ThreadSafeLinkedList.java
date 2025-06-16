package InterviewThreadandMultiThreading.practiseWhileDoing;

    import java.util.concurrent.locks.ReentrantLock;

    public class ThreadSafeLinkedList<T> {
        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node<T> head;
        private final ReentrantLock lock = new ReentrantLock();

        // Add an element to the end of the list
        public void add(T data) {
            lock.lock();
            try {
                if (head == null) {
                    head = new Node<>(data);
                } else {
                    Node<T> current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = new Node<>(data);
                }
                System.out.println(Thread.currentThread().getName() + " added: " + data);
            } finally {
                lock.unlock();
            }
        }

        // Remove and return the first element from the list
        public T removeFirst() {
            lock.lock();
            try {
                if (head == null) {
                    System.out.println(Thread.currentThread().getName() + " attempted to remove from an empty list.");
                    return null;
                }
                T data = head.data;
                head = head.next;
                System.out.println(Thread.currentThread().getName() + " removed: " + data);
                return data;
            } finally {
                lock.unlock();
            }
        }

        // Print the list elements
        public void printList() {
            lock.lock();
            try {
                Node<T> current = head;
                System.out.print(Thread.currentThread().getName() + " printing list: ");
                while (current != null) {
                    System.out.print(current.data + " ");
                    current = current.next;
                }
                System.out.println();
            } finally {
                lock.unlock();
            }
        }

        public static void main(String[] args) {
            ThreadSafeLinkedList<Integer> list = new ThreadSafeLinkedList<>();

            // Create threads to add elements
            Thread t1 = new Thread(() -> {
                for (int i = 1; i <= 5; i++) {
                    list.add(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            // Create threads to remove elements
            Thread t2 = new Thread(() -> {
                for (int i = 1; i <= 3; i++) {
                    list.removeFirst();
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            // Create a thread to print the list
            Thread t3 = new Thread(() -> {
                for (int i = 1; i <= 5; i++) {
                    list.printList();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            t1.start();
            t2.start();
            t3.start();

            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


