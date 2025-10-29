package tree;


public class CountNumberOfNodesAverage {
    public int averageOfSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        return treeInfoUtil(root).numberOfNodesAv;
    }
    public TreeInfo treeInfoUtil(TreeNode root){
        if(root==null){
            return new TreeInfo(0,0,0);
        }
        TreeInfo left = treeInfoUtil(root.left);
        TreeInfo right = treeInfoUtil(root.right);
        TreeInfo main = new TreeInfo();
        main.sum = left.sum + right.sum + root.val;
        main.numberOfNodes = left.numberOfNodes+right.numberOfNodes+1;
        int temp = main.sum/main.numberOfNodes;
        if(temp == root.val){
            main.numberOfNodesAv = left.numberOfNodesAv + right.numberOfNodesAv + 1;
        }
        else{
             main.numberOfNodesAv = left.numberOfNodesAv + right.numberOfNodesAv;
        }
        return main;

    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(8);
        t.right = new TreeNode(5);
        t.left.left = new TreeNode(0);
        t.left.right = new TreeNode(1);
        t.right.right = new TreeNode(6);
        System.out.println(new CountNumberOfNodesAverage().averageOfSubtree(t));
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
class TreeInfo{
    int numberOfNodes;
    int sum;
    int numberOfNodesAv;
    TreeInfo(){}
    TreeInfo(int numberOfNodes,int sum,int numberOfNodesAv){
        this.numberOfNodes = numberOfNodes;
        this.sum = sum;
        this.numberOfNodesAv = numberOfNodesAv;
    }
}
