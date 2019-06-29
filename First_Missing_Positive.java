package leetcode_interviewed_100;
//Given an unsorted integer array, find the smallest missing positive integer.
public class First_Missing_Positive {
	public int firstMissingPositive(int[] nums) {
        int l=0;//表示遍历到目前为止，数组已包含的正数范围是1~l
        //表示遍历到目前为止，在后续出现最优状况的情况下，数组可能包含的正数范围是1~r
        //在未开始遍历前，后续出现最优状况是数组包含1~N所有的正数
        int r=nums.length;
        while(l<r){
            if(nums[l]==l+1){
                l++;
            }else if(nums[l]<=l||nums[l]>r||nums[nums[l]-1]==nums[l]){
                nums[l]=nums[--r];//l+1~r范围上的数少了一个
            }else{
                swap(nums,l,nums[l]-1);//发现l+1~r范围上的数，并且未发现重复
            }
        }
        return l+1;
    }
    public void swap(int[] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;           
    }
}
