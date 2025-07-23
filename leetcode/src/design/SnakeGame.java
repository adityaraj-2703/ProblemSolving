package design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SnakeGame {

    int[][] food;
    LinkedList<String> q;
    Set<String> hs;
    int m;
    int n;
    int score;
    int ind;
    Map<String, String> hm;

    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.m = height;
        this.n = width;
        this.q = new LinkedList<>();
        this.hs = new HashSet<>();
        hs.add("0:0");
        q.add("0:0");
        hm = new HashMap<>();
        hm.put("R", "0:1");
        hm.put("L", "0:-1");
        hm.put("U", "-1:0");
        hm.put("D", "1:0");

    }

    public int move(String direction) {
        String[] dir = hm.get(direction).split(":");

        String[] q1 = q.peekLast().split(":");
        int nX = Integer.parseInt(q1[0]) + Integer.parseInt(dir[0]);
        int nY = Integer.parseInt(q1[1]) + Integer.parseInt(dir[1]);
        if (nX < 0 || nX >= m || nY < 0 || nY >= n
                || hs.contains(nX + ":" + nY) && !q.peekFirst().equals(nX + ":" + nY)) {
            return -1;
        }
        if (ind < food.length && food[ind][0] == nX && food[ind][1] == nY) {
            String temp = nX + ":" + nY;
            q.add(temp);
            hs.add(temp);
            this.score++;
            ind++;
        } else {
            String temp = q.removeFirst();
            hs.remove(temp);
            q.add(nX + ":" + nY);
            hs.add(nX + ":" + nY);

        }

        return score;

    }

    public static void main(String[] args) {
        int[][] food = { { 2, 0 }, { 0, 0 }, { 0, 2 }, { 2, 2 } };
        SnakeGame snakeGame = new SnakeGame(3, 3, food);
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("D"));
    }

}
