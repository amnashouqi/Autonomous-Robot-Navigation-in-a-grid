import java.util.List;

// Grid Representation: Develop a custom class to represent the grid, where each cell can be either empty or occupied by an obstacle.
public class Grid {
    private int width;
    private int height;
    private boolean[][] cells; // 2D array to represent grid cells, true indicates an obstacle

    // Constructor
    public Grid(int width, int height){
        this.width = width;
        this.height = height;
        this.cells = new boolean[width][height]; // Initialize grid cells
    }

    // Method to initialize the grid
    public void initializeGrid() {
        // Set all cells as empty initially
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = false;
            }
        }
    }

    public void setObstacle(int x, int y) {
        if (isValidCell(x, y)) {
            cells[x][y] = true; // Set cell as obstacle
        } else {
            System.out.println("Invalid cell position");
        }
    }

    // Method to set obstacle positions
    public boolean isObstacle(int x, int y) {
        if (isValidCell(x, y)) {
            return cells[x][y];
        } else {
            System.out.println("Invalid cell position");
            return false;
        }
    }

    // Method to check if a cell position is valid within the grid
    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
//
//    // Getters for width and height
//    public int getWidth() {
//        return width;
//    }
//
//    public int getHeight() {
//        return height;
//    }

    public void drawGrid(List<Node> path) {
        for (int y = height - 1; y >= 0; y--) { // Print rows in top-down order
            for (int x = 0; x < width; x++) {
                char symbol;
                if (cells[x][y]) {
                    symbol = '#'; // Obstacle
                } else if (isPathNode(x, y, path)) {
                    symbol = '*'; // Path
                } else {
                    symbol = '.'; // Empty
                }
                System.out.print(symbol + " ");
            }
            System.out.println(); // New line after each row
        }
    }

    private boolean isPathNode(int x, int y, List<Node> path) {
        for (Node node : path) {
            if (node.getX() == x && node.getY() == y) {
                return true;
            }
        }
        return false;
    }

}
