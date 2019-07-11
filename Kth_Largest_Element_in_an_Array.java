package leetcode_interviewed_100;

public class Kth_Largest_Element_in_an_Array {

	public int findKthLargest(int[] nums, int k) {
        int l=0;
        int r=nums.length-1;
        int index=partition(nums,l,r);
        while(index!=nums.length-k){
            if(index>nums.length-k){
                r=index-1;
                index=partition(nums,l,r);
            }else{
                l=index+1;
                index=partition(nums,l,r);
            }
        }
        return nums[nums.length-k];
    }
    
    public int partition(int[] arr,int l,int r){
        swap(arr,l+(int)(Math.random()*(r-l+1)),r);
        int less=l-1;
        int more=r;
        while(l<more){
            if(arr[l]<arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l]>arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return less+1;
    }
    
    public void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
