public class Queue<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T data) {
        list.add(data);
    }

    public T dequeue() {
        if (list.isEmpty()) return null;
        T first = list.get(0);
        list.remove(first);
        return first;
    }

    public T peek() {
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

