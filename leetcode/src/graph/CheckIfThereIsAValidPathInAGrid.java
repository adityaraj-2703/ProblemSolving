package graph;

public class CheckIfThereIsAValidPathInAGrid {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return hasValidPathUtil(grid, visited, m, n, 0, 0, 0);
    }

    public boolean hasValidPathUtil(int[][] grid, boolean[][] visited, int m, int n, int i, int j, int dir) {
        if (i < 0 || i > m || j < 0 || j > n) {
            return false;
        }
        if (i == m && j == n) {
            if (dir == 2 || dir == 4) {
                return true;
            }
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        int path = grid[i][j];
        visited[i][j] = true;
        if (dir == 0) {
            if (path == 1) {
                dir = 2;
                return hasValidPathUtil(grid, visited, m, n, i, j + 1, dir);
            } else if (path == 2) {
                dir = 4;
                return hasValidPathUtil(grid, visited, m, n, i + 1, j, dir);
            } else if (path == 3) {
                dir = 4;
                return hasValidPathUtil(grid, visited, m, n, i + 1, j, dir);
            } else if (path == 4) {
                return false;
            } else if (path == 5) {
                return false;
            } else {
                dir = 2;
                return hasValidPathUtil(grid, visited, m, n, i, j + 1, dir);
            }
        } else if (dir == 1) {
            if (path == 4) {
                dir = 4;
                return hasValidPathUtil(grid, visited, m, n, i + 1, j, dir);
            } else if (path == 6) {
                dir = 3;
                return hasValidPathUtil(grid, visited, m, n, i - 1, j, dir);
            } else if (path == 1) {
                dir = 1;
                return hasValidPathUtil(grid, visited, m, n, i, j - 1, dir);
            } else {
                return false;
            }
        } else if (dir == 2) {
            if (path == 3) {
                dir = 3;
                return hasValidPathUtil(grid, visited, m, n, i + 1, j, dir);
            } else if (path == 5) {
                dir = 3;
                return hasValidPathUtil(grid, visited, m, n, i - 1, j, dir);
            } else if (path == 1) {
                dir = 2;
                return hasValidPathUtil(grid, visited, m, n, i, j + 1, dir);
            } else {
                return false;
            }
        } else if (dir == 3) {
            if (path == 3) {
                dir = 1;
                return hasValidPathUtil(grid, visited, m, n, i, j - 1, dir);
            } else if (path == 4) {
                dir = 2;
                return hasValidPathUtil(grid, visited, m, n, i, j + 1, dir);
            } else if (path == 2) {
                dir = 3;
                return hasValidPathUtil(grid, visited, m, n, i - 1, j, dir);
            } else {
                return false;
            }
        } else {
            if (path == 5) {
                dir = 1;
                return hasValidPathUtil(grid, visited, m, n, i, j - 1, dir);
            } else if (path == 6) {
                dir = 2;
                return hasValidPathUtil(grid, visited, m, n, i, j + 1, dir);
            } else if (path == 2) {
                dir = 4;
                return hasValidPathUtil(grid, visited, m, n, i + 1, j, dir);
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        int[][] arr = { { 2, 4, 3 }, { 6, 5, 2 } };
        CheckIfThereIsAValidPathInAGrid c = new CheckIfThereIsAValidPathInAGrid();
        System.out.println(c.hasValidPath(arr));

    }

}
