import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomPriorityQueue<T> {
    private List<AStar.KeyValuePair<T, Double>> elements;

    public CustomPriorityQueue() {
        elements = new ArrayList<>();
    }

    public void add(T item, double priority) {
        elements.add(new AStar.KeyValuePair<>(item, priority));
        elements.sort(Comparator.comparing(AStar.KeyValuePair::getValue)); // Sort based on priority
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        return elements.remove(0).getKey();
    }

    public T peek() {
        return isEmpty() ? null : elements.get(0).getKey();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public boolean contains(T item) {
        return elements.stream().anyMatch(kv -> kv.getKey().equals(item));
    }
}
