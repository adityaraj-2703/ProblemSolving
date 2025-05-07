package graph;

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] visited = new boolean[m][n];
        int[] min = new int[2];
        min[0] = Integer.MIN_VALUE;
        min[1] = Integer.MAX_VALUE;
        dfs(heights, visited, min, 0, 0, heights[0][0]);
        return min[1];
    }

    public void dfs(int[][] heights, boolean[][] visited, int[] min, int i, int j, int last) {

        int m = heights.length;
        int n = heights[0].length;
        if (i == m - 1 && j == n - 1) {
            min[0] = Math.max(min[0], Math.abs(last - heights[m - 1][n - 1]));
            min[1] = Math.min(min[0], min[1]);
            min[0] = Integer.MIN_VALUE;

        }
        int temp = heights[i][j];
        heights[i][j] = 0;
        visited[i][j] = true;
        int[] dirX = { 0, 0, 1, -1 };
        int[] dirY = { 1, -1, 0, 0 };
        for (int k = 0; k < 4; k++) {
            int newX = dirX[k] + i;
            int newY = dirY[k] + j;
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && heights[i][j] != 0) {
                min[0] = Math.max(min[0], Math.abs(last - heights[newX][newY]));
                dfs(heights, visited, min, newX, newY, heights[newX][newY]);
            }
        }
        heights[i][j] = temp;
    }

    public static void main(String[] args) {
        PathWithMinimumEffort p = new PathWithMinimumEffort();
        int[][] heights = {
                { 1, 2, 2 },
                { 3, 8, 2 },
                { 5, 3, 5 }
        };
        System.out.println(p.minimumEffortPath(heights));
    }

}
