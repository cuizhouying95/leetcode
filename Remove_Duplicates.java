package leetcode_interviewed_100;
//Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
public class Remove_Duplicates {
	public int removeDuplicates(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
