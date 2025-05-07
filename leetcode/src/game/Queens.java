package game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Queens {
    public static String[][] queensProblemLinkedIn(String[][] board) {
        Map<String, Set<Position>> hm = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Set<Position> hs = hm.getOrDefault(board[i][j], new HashSet<>());
                hs.add(new Position(i, j));
                hm.put(board[i][j], hs);
            }
        }
        Set<String> hs = new HashSet<>();
        boolean t = find(hm, board, "$", 0, hs);
        if (t) {
            return board;
        }
        return new String[0][0];
    }

    static boolean find(Map<String, Set<Position>> hm, String[][] board, String prev, int count, Set<String> hs) {
        if (count == 7) {
            return true;
        }

        for (Map.Entry<String, Set<Position>> m : hm.entrySet()) {
            for (Position p : m.getValue()) {
                String temp = board[p.x][p.y];
                if (!hs.contains(prev) && isSafe(p, board)) {

                    board[p.x][p.y] = "Q";
                    hs.add(m.getKey());
                    if (find(hm, board, m.getKey(), count + 1, hs)) {
                        return true;
                    }
                    hs.remove(m.getKey());

                }
                board[p.x][p.y] = temp;
            }
        }
        return false;

    }

    public static boolean isSafe(Position p, String[][] board) {
        for (int k = 0; k < board.length; k++) {
            if (board[k][p.y].equals("Q") && k != p.x) {
                return false;
            }

        }
        for (int k = 0; k < board[0].length; k++) {
            if (board[p.x][k].equals("Q") && k != p.y) {
                return false;
            }

        }
        int[] dirX = { 0, 0, 1, -1 };
        int[] dirY = { 1, -1, 0, 0 };
        for (int k = 0; k < 4; k++) {
            int newX = dirX[k] + p.x;
            int newY = dirY[k] + p.y;
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length
                    && board[newX][newY].equals("Q")) {
                return false;
            }
        }

        return true;
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        String[][] board = {
                { "Red", "Red", "Red", "Red", "Red", "Red", "Red" },
                { "Red", "Yellow", "Yellow", "Yellow", "Yellow", "Yellow", "Red" },
                { "Red", "Yellow", "Green", "Green", "Green", "Yellow", "Red" },
                { "Grey", "Yellow", "Green", "Blue", "Green", "Yellow", "Red" },
                { "Grey", "Grey", "Green", "Blue", "Green", "Orange", "Orange" },
                { "Grey", "Grey", "Grey", "Grey", "Orange", "Orange", "Orange" },
                { "Grey", "Grey", "Grey", "Purple", "Purple", "Orange", "Orange" }
        };

        String[][] result = queensProblemLinkedIn(board);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                int l = 8 - board[i].length;
                System.out.print(board[i][j]);
                for (int k = 0; k < l; k++) {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
        // Print the result or perform further operations
    }

}
