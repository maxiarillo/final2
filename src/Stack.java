public class Stack<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T data) {
        list.add(data);
    }

    public T pop() {
        if (list.isEmpty()) return null;
        T top = list.get(list.size() - 1);
        list.remove(top);
        return top;
    }

    public T peek() {
        if (list.isEmpty()) return null;
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

