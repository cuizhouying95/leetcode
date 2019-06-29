package leetcode_interviewed_100;
//You are given a target value to search. If found in the array return its index, otherwise return -1.

//You may assume no duplicate exists in the array.

//Your algorithm's runtime complexity must be in the order of O(log n).
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
public class Search_in_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>=nums[low]){//确定断点的位置
                if(target>=nums[low]&&target<nums[mid]){//确定target的范围
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(target>nums[mid]&&target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
