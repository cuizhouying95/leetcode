package leetcode_interviewed_100;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
public class Longest_Consecutive_Sequence {
//解法一，时间复杂度Time complexity : O(nlgn)，Space complexity : O(1)(or O(n)).
	//先把数组排序
	public int longestConsecutive1(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int longest=1;
        int cur=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                if(nums[i]==nums[i-1]+1){
                  cur+=1;
                }else{
                    longest=Math.max(longest,cur);
                    cur=1;
                }
            }
        }
        return Math.max(longest,cur);
    }
	
	//解法二
	public int longestConsecutive2(int[] nums) {
	     Set<Integer> num_set=new HashSet <Integer>();//不允许有重复元素
	     for(int num:nums){
	         num_set.add(num);
	     }
	        int longest=0;
	        
	    for(int num:num_set){
	        //如果存在(num-1),什么都不做
	        if(!num_set.contains(num-1)){
	            int curNum=num;
	            int curlength=1;
	            while(num_set.contains(curNum+1)){
	                curNum+=1;
	                curlength+=1;
	            }
	            longest=Math.max(longest,curlength);
	        }
	    }
	        return longest;
	    }
}
