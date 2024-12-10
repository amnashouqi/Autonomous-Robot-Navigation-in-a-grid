import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        // Get grid dimensions from the user
        System.out.print("Enter grid width: ");
        int width = key.nextInt();
        System.out.print("Enter grid height: ");
        int height = key.nextInt();

        GridGraph graph = new GridGraph(width, height);

        System.out.print("Enter start position (x y): ");
        int startX = key.nextInt();
        int startY = key.nextInt();
        Node start = graph.getNode(startX, startY);

        System.out.print("Enter goal position (x y): ");
        int endX = key.nextInt();
        int endY = key.nextInt();
        Node goal = graph.getNode(endX, endY);

        Grid grid = new Grid(width, height);
        grid.initializeGrid();

        System.out.println("Set obstacles (x y), enter -1 -1 to finish:");
        while (true) {
            int x = key.nextInt();
            int y = key.nextInt();
            if (x == -1 && y == -1) {
                break;
            }
            grid.setObstacle(x, y);

            // Consume the newline character
            key.nextLine();
        }

        RobotState robotState = new RobotState(start.getX(), start.getY(), RobotState.Direction.north);

        AStar aStar = new AStar(graph, grid);
        List<Node> path = aStar.findPath(start, goal);

        if (path != null) {
            System.out.println("Path found:");
            grid.drawGrid(path);

            // Update robot state and orientation for each node in the path
            for (Node node : path) {
                // Move robot to the current node
                robotState.move(node);
                // Update robot orientation based on current and previous nodes
                robotState.updateOrientation(node , goal);
                // Print current node coordinates
                System.out.println("(" + node.getX() + ", " + node.getY() + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
