package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class SilidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Node> max = new PriorityQueue<>(
                new Comparator<Node>() {
                    public int compare(Node m1, Node m2) {
                        return m2.val - m1.val;
                    }
                });
        PriorityQueue<Node> min = new PriorityQueue<>(
                new Comparator<Node>() {
                    public int compare(Node m1, Node m2) {
                        return m1.val - m2.val;
                    }
                });
        // Map<Integer, Node> m = new HashMap<>();
        // for (int i = 0; i < k; i++) {
        // if (max.size() == 0) {
        // max.add();
        // } else if (min.size() == 0) {
        // Map.Entry<Integer, Integer> temp = max.peek();
        // if (temp.getValue() > nums[i]) {
        // max.poll();
        // min.add(temp);
        // max.add(Map.entry(i, nums[i]));
        // } else {
        // min.add(Map.entry(i, nums[i]));
        // }
        // } else if (max.size() == min.size()) {
        // Map.Entry<Integer, Integer> temp = min.peek();
        // if (temp.getValue() > nums[i]) {
        // max.add(Map.entry(i, nums[i]));
        // } else {
        // min.poll();
        // max.add(temp);
        // min.add(Map.entry(i, nums[i]));
        // }
        // }
        // }
        // double[] ans = new double[nums.length - k + 1];
        // if (k % 2 == 0) {
        // ans[0] = ((double) max.peek().getValue() + (double) min.peek().getValue()) /
        // (double) 2;
        // } else {
        // ans[0] = (double) max.peek().getValue();
        // }

        // int ind = 1;
        // int i = 0;
        // Set<Integer> m = new HashSet<>();
        // m.add(0);
        // for (int j = k; j < nums.length; j++) {
        // if (m.contains(max.peek().getKey())) {
        // max.poll();
        // }
        // if (m.contains(min.peek().getKey())) {
        // min.poll();
        // }

        // if (max.size() == 0) {
        // max.add(Map.entry(j, nums[j]));
        // } else if (min.size() == 0) {
        // Map.Entry<Integer, Integer> temp = max.peek();
        // if (temp.getValue() > nums[j]) {
        // max.poll();
        // min.add(temp);
        // max.add(Map.entry(j, nums[j]));
        // } else {
        // min.add(Map.entry(j, nums[j]));
        // }
        // } else if (max.size() == min.size()) {
        // Map.Entry<Integer, Integer> temp = min.peek();
        // if (temp.getValue() > nums[j]) {
        // max.add(Map.entry(j, nums[j]));
        // } else {
        // min.poll();
        // max.add(temp);
        // min.add(Map.entry(j, nums[j]));
        // }
        // }

        // if (k % 2 == 0) {
        // ans[ind] = ((double) max.peek().getValue() + (double) min.peek().getValue())
        // / (double) 2;
        // } else {
        // ans[ind] = (double) max.peek().getValue();
        // }
        // ind++;
        // i++;
        // m.add(i);

        // }

        // return ans;
        return null;

    }

    class Node {
        Node left;
        Node right;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public static void main(String[] args) {
        SilidingWindowMedian s = new SilidingWindowMedian();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        double[] ans = s.medianSlidingWindow(nums, k);
        for (double d : ans) {
            System.out.println(d);
        }
    }
}
