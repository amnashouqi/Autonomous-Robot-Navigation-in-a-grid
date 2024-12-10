public class RobotState {
    private int x; // Current x-coordinate position of the robot
    private int y; // Current y-coordinate position of the robot
    private Direction orientation; // Orientation of the robot (e.g., North, South, East, West)
    private Node previousNode; // Previous node

    // Constructor
    public RobotState(int x, int y, Direction orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.previousNode = null; // Initialize previousNode to null initially
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    // Method to update the robot's orientation
    public void updateOrientation(Node previousNode, Node currentNode) {
        int deltaX = currentNode.getX() - previousNode.getX();
        int deltaY = currentNode.getY() - previousNode.getY();

        if (deltaX == 0 && deltaY == 0) {
            // No movement, orientation remains unchanged
        } else if (deltaX == 0) {
            // Vertical movement
            orientation = deltaY > 0 ? Direction.north : Direction.south;
        } else if (deltaY == 0) {
            // Horizontal movement
            orientation = deltaX > 0 ? Direction.east : Direction.west;
        } else {
            // Diagonal movement
            orientation = deltaY > 0 ? (deltaX > 0 ? Direction.northeast : Direction.northwest)
                    : (deltaX > 0 ? Direction.southeast : Direction.southwest);
        }

        System.out.println("The robot is facing " + orientation);
    }



    // Direction enum representing possible orientations of the robot
    public enum Direction {
        north, south, east, west, northeast, southeast, northwest, southwest
    }

    // Method to update the previous node when the robot moves
    public void move(Node newNode) {
        // Update previousNode to the current node
        this.previousNode = new Node(x, y);
        // Update current position
        this.x = newNode.getX();
        this.y = newNode.getY();
    }
}
