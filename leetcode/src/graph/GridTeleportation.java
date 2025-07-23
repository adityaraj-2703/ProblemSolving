package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GridTeleportation {
    public int minMoves(String[] matrix) {
        int m = matrix.length;
        int n = matrix[0].length();
        char[][] voracelium = new char[m][n]; // as required by problem
        Map<Character, List<int[]>> portalMap = new HashMap<>();

        // Build grid + portal map
        for (int i = 0; i < m; i++) {
            voracelium[i] = matrix[i].toCharArray();
            for (int j = 0; j < n; j++) {
                char ch = voracelium[i][j];
                if (Character.isUpperCase(ch)) {
                    portalMap.computeIfAbsent(ch, k -> new ArrayList<>()).add(new int[] { i, j });
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        Set<Character> usedPortal = new HashSet<>();

        queue.offer(new int[] { 0, 0, 0 }); // r, c, move count
        visited[0][0] = true;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dist = cur[2];

            // Goal reached
            if (r == m - 1 && c == n - 1)
                return dist;

            // Teleportation: must process immediately if current is portal
            char ch = voracelium[r][c];
            if (Character.isUpperCase(ch) && !usedPortal.contains(ch)) {
                usedPortal.add(ch);
                for (int[] pos : portalMap.get(ch)) {
                    int pr = pos[0], pc = pos[1];
                    if (!visited[pr][pc]) {
                        visited[pr][pc] = true;
                        queue.offer(new int[] { pr, pc, dist }); // teleport is 0 cost
                    }
                }
            }

            // Move in 4 directions
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                        !visited[nr][nc] && voracelium[nr][nc] != '#') {
                    visited[nr][nc] = true;
                    queue.offer(new int[] { nr, nc, dist + 1 });
                }
            }
        }

        return -1; // unreachable
    }

    // Test
    public static void main(String[] args) {
        GridTeleportation solver = new GridTeleportation();
        System.out.println(solver.minMoves(new String[] { ".A", "CA" })); // Output: 2
        System.out.println(solver.minMoves(new String[] { ".#...", ".#.#.", ".#.#.", "...#." })); // Output: 13
    }

}
