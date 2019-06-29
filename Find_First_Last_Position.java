package leetcode_interviewed_100;
//Given an array of integers nums sorted in ascending order, 
//find the starting and ending position of a given target value.
public class Find_First_Last_Position {//Ω£÷∏offer‘≠Ã‚
	public int[] searchRange(int[] nums, int target) {
        int[] targetRange={-1,-1};
        int leftIdx=extremeInsertionIndex(nums,target,true);
        if(leftIdx==nums.length||nums[leftIdx]!=target){
            return targetRange;
        }
        targetRange[0]=leftIdx;
        targetRange[1]=extremeInsertionIndex(nums,target,false)-1;
        return targetRange;
    }
    
    private int extremeInsertionIndex(int[] nums, int target, boolean left){
        int lo=0;
        int hi=nums.length;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>target||(left&&target==nums[mid])){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
}
