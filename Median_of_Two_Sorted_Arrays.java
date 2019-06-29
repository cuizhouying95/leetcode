package leetcode_interviewed_100;
//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//You may assume nums1 and nums2 cannot be both empty.
public class Median_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] longs=nums1.length>nums2.length?nums1:nums2;
        int[] shorts=nums1.length<=nums2.length?nums1:nums2;
        int l=longs.length;
        int s=shorts.length;
        int iMin=0;
        int iMax=s;
        int halfLen=(l+s+1)/2;
        while(iMin<=iMax){
            int i=(iMin+iMax)/2;
            int j=halfLen-i;
            if(i<iMax&&longs[j-1]>shorts[i]){
                iMin=i+1;
            }else if(i>iMin&&shorts[i-1]>longs[j]){
                iMax=i-1;
            }else{
                int maxLeft=0;
                int minRight=0;
                if(i==0){
                    maxLeft=longs[j-1];
                }else if(j==0){
                    maxLeft=shorts[i-1];
                }else{
                    maxLeft=Math.max(shorts[i-1],longs[j-1]);
                }
                if((l+s)%2==1){
                    return maxLeft;//长度为奇数的话，中间的数放在了左边部分
                }
                if(i==s){
                    minRight=longs[j];
                }else if(j==l){
                    minRight=shorts[i];
                }else{
                    minRight=Math.min(longs[j],shorts[i]);
                }
                return (maxLeft+minRight)/2.0;//长度为偶数
            }
        }
        return 0.0;
    }
}