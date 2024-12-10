import java.util.ArrayList;
import java.util.List;
public class Node implements Comparable<Node> {
    private int x;
    private int y;
    private List<Node> neighbors;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node neighbor, boolean isDiagonal) {
        if (isDiagonal) {
            neighbors.add(neighbor);
        } else {
            neighbors.add(neighbor);
        }
    }

    public List<Node> getNeighbors() { return neighbors; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Node other) {
        // Compare nodes based on their coordinates
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}
