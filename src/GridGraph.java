public class GridGraph {
    private Node[][] nodes; // 2D array to hold nodes representing the grid

    public GridGraph(int width, int height) {
        nodes = new Node[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                nodes[x][y] = new Node(x, y);
            }
        }
        connectNeighbors(width, height);
    }

    private void connectNeighbors(int width, int height) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Node node = nodes[x][y];
                if (x > 0) {
                    node.addNeighbor(nodes[x - 1][y], false); // Left neighbor
                    if (y > 0) {
                        node.addNeighbor(nodes[x - 1][y - 1], true); // Top-left neighbor
                    }
                    if (y < height - 1) {
                        node.addNeighbor(nodes[x - 1][y + 1], true); // Bottom-left neighbor
                    }
                }
                if (x < width - 1) {
                    node.addNeighbor(nodes[x + 1][y], false); // Right neighbor
                    if (y > 0) {
                        node.addNeighbor(nodes[x + 1][y - 1], true); // Top-right neighbor
                    }
                    if (y < height - 1) {
                        node.addNeighbor(nodes[x + 1][y + 1], true); // Bottom-right neighbor
                    }
                }
                if (y > 0) {
                    node.addNeighbor(nodes[x][y - 1], false); // Top neighbor
                }
                if (y < height - 1) {
                    node.addNeighbor(nodes[x][y + 1], false); // Bottom neighbor
                }
            }
        }
    }


    public Node getNode(int x, int y) {
        if (x >= 0 && x < nodes.length && y >= 0 && y < nodes[0].length) {
            return nodes[x][y]; // Return the node at the specified position
        }
        return null;
    }
}
