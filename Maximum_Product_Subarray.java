package leetcode_interviewed_100;
//数组中子数组的最大累乘积
public class Maximum_Product_Subarray {
	public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int max=nums[0];
        int min=nums[0];
        int res=nums[0];
        int maxEnd=0;
        int minEnd=0;
       
        for(int i=1;i<nums.length;i++){
            maxEnd=max*nums[i];//max表示以nums[i-1]为结尾的子数组的最大乘积
            minEnd=min*nums[i];//min表示以nums[i-1]为结尾的子数组的最小乘积
            max=Math.max(Math.max(maxEnd,minEnd),nums[i]);
            min=Math.min(Math.min(maxEnd,minEnd),nums[i]);
            res=Math.max(res,max);           
        }
        return res;
    }
}
