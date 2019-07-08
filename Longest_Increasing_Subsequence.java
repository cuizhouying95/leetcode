package leetcode_interviewed_100;
//最长递增子序列
public class Longest_Increasing_Subsequence {
	public int lengthOfLIS1(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        int max=1;
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            max=Math.max(max,dp[i]);
            }
        }
        return max;
    }
	
	public int lengthOfLIS2(int[] nums) {//利用二分法
		int n=nums.length;
		int[] tails=new int[n];//tails[i]表示长度为i+1的最长递增子序列的最后一个元素
		//对于元素x,如果它大于tails数组所有的值，那么把它添加到tails的后面，表示最长递增子序列长度加1；
		//如果tails[i-1]<x<=tails[i],那么更新tails[i]=x
		//tails数组保持有序
		int len=0;
		for(int num:nums) {
			int index=binarySearch(tails,len,num);
			tails[index]=num;
			if(index==len) {
				len++;
			}
		}
		return len;
	}
	
	public int binarySearch(int[] tails,int len,int key) {
		int l=0;
		int h=len;
		while(l<h) {
			int mid=l+(h-l)/2;
			if(tails[mid]==key)	{
				return mid;
			}else if(tails[mid]>key) {
				h=mid;
			}else {
				l=mid+1;
			}
		}
		return l;
	}
}
