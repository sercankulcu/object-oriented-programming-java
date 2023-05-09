package TwoDimensional;
import java.util.Random;
import java.util.Stack;

/*
 * Here is a simple Java program that generates a random maze and solves it using the depth-first search algorithm:
 * 
 * This program generates a random maze by filling a two-dimensional array with either walls 
 * ('#') or paths (' ') using a random number generator. It then solves the maze using the 
 * depth-first search algorithm, which involves traversing the maze starting from the top-left
 * corner and exploring as far as possible along each branch before backtracking.
 *  */

public class Maze {
  private static final int WIDTH = 10;
  private static final int HEIGHT = 10;
  private static final char WALL = '#';
  private static final char PATH = ' ';
  
  private static char[][] maze;
  private static boolean[][] visited;
  
  public static void main(String[] args) {
    maze = generateMaze();
    printMaze();
    
    visited = new boolean[HEIGHT][WIDTH];
    dfs(0, 0);
    
    System.out.println();
    printMaze();
  }
  
  private static char[][] generateMaze() {
    Random random = new Random();
    char[][] maze = new char[HEIGHT][WIDTH];
    
    for (int y = 0; y < HEIGHT; y++) {
      for (int x = 0; x < WIDTH; x++) {
        maze[y][x] = random.nextDouble() < 0.3 ? WALL : PATH;
      }
    }
    
    return maze;
  }
  
  private static void printMaze() {
    for (int y = 0; y < HEIGHT; y++) {
      for (int x = 0; x < WIDTH; x++) {
        System.out.print(maze[y][x]);
      }
      System.out.println();
    }
  }
  
  private static void dfs(int x, int y) {
    if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT || visited[y][x] || maze[y][x] == WALL) {
      return;
    }
    
    visited[y][x] = true;
    maze[y][x] = PATH;
    
    dfs(x - 1, y);
    dfs(x + 1, y);
    dfs(x, y - 1);
    dfs(x, y + 1);
  }
}
