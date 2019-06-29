package leetcode_interviewed_100;
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Determine if you are able to reach the last index.
public class Jump_Game {
//解法一，递归,Time complexity : O(2^n),Space complexity : O(n) 
	public boolean canJump(int[] nums) {
        return canJumpFromPosition(0,nums);
    }
    
    public boolean canJumpFromPosition(int position,int[] nums){
        if(position==nums.length-1){
            return true;
        }
        
        int furthestJump=Math.min(position+nums[position],nums.length-1);
        for(int nextPosition=position+1;nextPosition<=furthestJump;nextPosition++) {
            if(canJumpFromPosition(nextPosition,nums)){
                return true;
            }
        }   
        return false;
    }
	 
//解法二，动态规划
    public boolean canJump2(int[] nums) {
        //dp[i]表示从i位置能否到达末尾
        boolean[] dp=new boolean[nums.length];
        dp[nums.length-1]=true;
        for (int i = nums.length - 2; i >= 0; i--){
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (dp[j] ==true ) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
    //解法三，贪心
    public boolean canJump3(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
