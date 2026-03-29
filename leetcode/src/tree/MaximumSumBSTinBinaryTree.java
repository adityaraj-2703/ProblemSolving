package tree;

public class MaximumSumBSTinBinaryTree {
    public int maxSumBST(TreeNode root) {
        return dfs(root).sum;
    }
    public TreeInfo dfs(TreeNode root){
        if(root==null){
            return new TreeInfo(true,-100,100000,0);
        }
        if(root.left==null && root.right==null){
            return new TreeInfo(true,root.val,root.val,root.val);
        }
        TreeInfo l = dfs(root.left);
        TreeInfo r = dfs(root.right);
        TreeInfo m = new TreeInfo();

        if(root.val>l.max && root.val<r.min){
            if(l.isBST){
                m.sum += l.sum;
                m.min = root.val+1;
            }
            if(r.isBST){
                m.sum += r.sum;
                m.max = root.val-1;
            }
        }
        if(m.sum>0){
            m.sum += root.val;
        }
        return m;
    }
    class TreeInfo{
        boolean isBST;
        int min;
        int max;
        int sum;
        TreeInfo(){}
        TreeInfo(boolean isBST,int min,int max,int sum){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
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

    public static void main(String[] args) {
        MaximumSumBSTinBinaryTree obj = new MaximumSumBSTinBinaryTree();
        TreeNode t = obj.new TreeNode(1);
        t.left = obj.new TreeNode(4);
        t.right = obj.new TreeNode(3);
        t.left.left = obj.new TreeNode(2);
        t.left.right = obj.new TreeNode(4);
        t.right.left = obj.new TreeNode(2);
        t.right.right = obj.new TreeNode(5);
        t.right.right.left = obj.new TreeNode(4);
        t.right.right.right = obj.new TreeNode(6);
        System.out.println(obj.maxSumBST(t));
    }
}



