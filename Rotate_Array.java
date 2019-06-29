package leetcode_interviewed_100;

public class Rotate_Array {
	public void rotate(int[] nums, int k) {
        if(nums==null||k<=0||k%nums.length==0){
            return;
        }
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    
    public void reverse(int[] nums,int start,int end){
        
        while(start<end){
            int tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
            start++;
            end--;
        }
    }
}
