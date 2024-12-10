# Autonomous Robot Pathfinding using A* Algorithm

## Overview
This project involves programming an autonomous robot to navigate a grid-based environment with obstacles using Java. The robot calculates the shortest path from a starting point to a goal while considering various constraints like time and memory. The solution is based on the A* algorithm, utilizing custom data structures to optimize efficiency and performance.

## Key Features:
- **A* Algorithm**: An efficient and optimal pathfinding algorithm that minimizes the search space by using heuristics. The algorithm calculates the shortest path by evaluating both the distance from the current position and the estimated distance to the goal.
- **Custom Data Structures**: Several custom data structures are implemented to support the A* algorithm:
  - **Grid**: Represents the environment with obstacles and available cells.
  - **GridGraph**: Defines the connections (edges) between nodes in the grid.
  - **CustomPriorityQueue**: Manages node prioritization during the search process.
  - **HashMap**: Stores information about nodes, helping prioritize and retrieve data efficiently.
  - **RobotState**: Tracks the robot's position and direction as it navigates the grid.

## Classes:
1. **Main**: The entry point of the program. It handles user input, initializes the grid, and calls the A* algorithm.
2. **Node**: Represents a cell in the grid, storing its position, cost, and heuristic value.
3. **Grid**: Initializes and manages the grid environment with obstacles.
4. **GridGraph**: Provides information on neighboring nodes to facilitate pathfinding.
5. **AStar**: Implements the core pathfinding logic, calculating the optimal path and reconstructing it once the goal is reached.
6. **RobotState**: Keeps track of the robot's current position and orientation.
7. **CustomPriorityQueue**: A customized priority queue used to efficiently manage the nodes during the A* algorithm execution.

## Purpose:
The main objective of this project is to develop an autonomous navigation system capable of finding the shortest path in a grid-based environment, even when faced with obstacles. The robot must decide the most efficient path based on various movement costs and avoid obstacles along the way.

## How it Works:
1. **Grid Setup**: A grid is created where the robot starts at a specified position, with obstacles placed randomly or based on a given pattern.
2. **A* Pathfinding**: The robot uses the A* algorithm to evaluate potential paths from the starting position to the goal. The algorithm dynamically adjusts to obstacles and finds the shortest route.
3. **Movement**: The robot updates its position based on the calculated path, adjusting its orientation at each step.

## Installation:
To run the project:
1. Clone this repository.
2. Compile and run the `Main` class in any Java IDE or terminal.
3. Input the grid configuration, start, and goal positions when prompted.

## Conclusion:
This project demonstrates how to implement an efficient pathfinding solution using the A* algorithm in Java. The use of custom data structures optimizes performance, ensuring that the robot can navigate through complex environments with obstacles while minimizing time and memory usage.
