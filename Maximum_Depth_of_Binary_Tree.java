package leetcode_interviewed_100;
//二叉树的高度
public class Maximum_Depth_of_Binary_Tree {
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	
	public int maxDepth(TreeNode root) {
        return process(root);
    }
    public int process(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftdepth=process(root.left);
        int rightdepth=process(root.right);
        return 1+Math.max(leftdepth,rightdepth);
    }
}
