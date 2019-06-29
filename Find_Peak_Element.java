package leetcode_interviewed_100;
//在数组中找到一个局部最大的位置
//Input: nums = [1,2,3,1]
//Output: 2
//Input: nums = [1,2,1,3,5,6,4]
//Output: 1 or 5
public class Find_Peak_Element {

	public int findPeakElement(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        if(nums.length==1||nums[0]>nums[1]){
            return 0;
        }
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        int left=1;
        int right=nums.length-2;
        int mid=0;
        while(left<right){
            mid=(left+right)/2;
            if(nums[mid]<nums[mid-1]){
                right=mid-1;
            }else if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return left;
    }
	
}
