import java.util.ArrayList;
import java.util.List;

public class AStar {
    private GridGraph graph;
    private Grid grid;

    public AStar(GridGraph graph, Grid grid) {
        this.graph = graph;
        this.grid = grid;
    }

    public List<Node> findPath(Node start, Node goal) {
        List<KeyValuePair<Node, Node>> cameFrom = new ArrayList<>();
        CustomPriorityQueue<Node> openSet = new CustomPriorityQueue<>();

        openSet.add(start, 0.0);

        List<KeyValuePair<Node, Double>> gScore = new ArrayList<>();
        List<KeyValuePair<Node, Double>> fScore = new ArrayList<>();

        gScore.add(new KeyValuePair<>(start, 0.0));
        fScore.add(new KeyValuePair<>(start, heuristicCostEstimate(start, goal)));

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.equals(goal)) {
                return reconstructPath(cameFrom, current);
            }

            for (Node neighbor : current.getNeighbors()) {
                if (!grid.isObstacle(neighbor.getX(), neighbor.getY())) {
                    double tentativeGScore = getScore(gScore, current) + calculateCost(current, neighbor);

                    if (tentativeGScore < getScore(gScore, neighbor)) {
                        cameFrom.add(new KeyValuePair<>(neighbor, current));
                        gScore.add(new KeyValuePair<>(neighbor, tentativeGScore));
                        fScore.add(new KeyValuePair<>(neighbor, tentativeGScore + heuristicCostEstimate(neighbor, goal)));
                        if (!openSet.contains(neighbor)) {
                            openSet.add(neighbor, getScore(fScore, neighbor));
                        }
                    }
                }
            }
        }

        return null; // No path found
    }

    private List<Node> reconstructPath(List<KeyValuePair<Node, Node>> cameFrom, final Node start) {
        List<Node> path = new ArrayList<>();
        var ref = new Object() {
            Node current = start;
        };

        while (cameFrom.stream().anyMatch(kv -> kv.getKey().equals(ref.current))) {
            path.add(0, ref.current);
            Node nextCurrent = cameFrom.stream()
                    .filter(kv -> kv.getKey().equals(ref.current))
                    .findFirst()
                    .map(KeyValuePair::getValue)
                    .orElse(null);
            ref.current = nextCurrent;

            if (ref.current == null) {
                break; // Break out of the loop if current is null
            }
        }

        if (ref.current != null) {
            path.add(0, ref.current);
        }

        return path;
    }

    private double heuristicCostEstimate(Node current, Node goal) {
        int dx = Math.abs(current.getX() - goal.getX());
        int dy = Math.abs(current.getY() - goal.getY());
        return Math.sqrt(dx * dx + dy * dy);
    }

    private double getScore(List<KeyValuePair<Node, Double>> scoreList, Node node) {
        return scoreList.stream().filter(kv -> kv.getKey().equals(node)).findFirst().map(KeyValuePair::getValue).orElse(Double.POSITIVE_INFINITY);
    }

    public static class KeyValuePair<K, V> {
        private K key;
        private V value;

        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private double calculateCost(Node current, Node neighbor) {
        int dx = Math.abs(current.getX() - neighbor.getX());
        int dy = Math.abs(current.getY() - neighbor.getY());

        double diagonalCost = Math.sqrt(2);
        double orthogonalCost = 1.0;

        return dx == 0 || dy == 0 ? orthogonalCost : diagonalCost;
    }

}
