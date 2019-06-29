package leetcode_interviewed_100;

public class Maximum_Subarray {
	public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int cur=0;
        for(int i=0;i!=nums.length;i++){
            cur+=nums[i];
            max=Math.max(max,cur);
            cur=cur<0?0:cur;
        }
        return max;
    }
}
