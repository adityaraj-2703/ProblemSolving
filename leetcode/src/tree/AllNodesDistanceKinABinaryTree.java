package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AllNodesDistanceKinABinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,List<Integer>> hm = new HashMap<>();
        int[] ind = new int[1];
        distanceKUtil(root,hm,0,ind,target.val);
        return ans;
    }
    public void distanceKUtil(TreeNode root, Map<Integer,List<Integer>> hm,int level,int[] ind,int t){
        if(root==null){
            return;
        }
        List<Integer> li = hm.getOrDefault(level,new ArrayList<>());
        li.add(root.val);
        hm.put(level,li);
        if(root.val==t){
            ind[0] = level;
        }
        distanceKUtil(root.left,hm,level-1,ind,t);
        distanceKUtil(root.right,hm,level+1,ind, t);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode target = root.left;
        List<Integer> li = new AllNodesDistanceKinABinaryTree().distanceK(root, target, 2);
        System.out.println(li);

    }
    public static TreeNode buildTree(Integer[] arr){
        if(arr.length==0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,0));
        for(int i=1;i<arr.length;i++){
            Pair p = st.peek();
            if(p.counter==0){
                if(arr[i]!=null){
                    p.t.left = new TreeNode(arr[i]);
                    st.push(new Pair(p.t.left,0));
                }
                p.counter++;
            }
            else if(p.counter==1){
                 if(arr[i]!=null){
                    p.t.right = new TreeNode(arr[i]);
                    st.push(new Pair(p.t.right,0));
                }
                p.counter++;
            }
            else{
                st.pop();
            }
        }

        return root;
    }
    static class Pair{
        TreeNode t;
        int counter;
        Pair(TreeNode t,int counter){
            this.t = t;
            this.counter = counter;
        }
    }



}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
