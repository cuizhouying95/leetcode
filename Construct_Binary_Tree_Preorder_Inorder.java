package leetcode_interviewed_100;
import java.util.HashMap;
public class Construct_Binary_Tree_Preorder_Inorder {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null){
            return null;
        }
        //利用哈希表记录位置
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return preIn(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    
    public TreeNode preIn(int[] p,int pi,int pj,int[] n,int ni,int nj,HashMap<Integer,Integer> map){
        if(pi>pj){
            return null;
        }
        TreeNode head=new TreeNode(p[pi]);
        int index=map.get(p[pi]);
        head.left=preIn(p,pi+1,pi+index-ni,n,ni,index-1,map);
        head.right=preIn(p,pi+index-ni+1,pj,n,index+1,nj,map);
        return head;
    }
}
