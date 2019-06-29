package leetcode_interviewed_100;

public class Sort_Colors {
    public void swap(int[] arr,int i,int j) {
    	int temp=arr[i];
    	arr[i]=arr[j];
    	arr[j]=temp;
    }
	//给定一个有序数组，调整后使得数组的左半部分无重复元素且升序，而不保证右部分是否有序
	public void leftUnique(int[] arr) {
		if(arr==null||arr.length<2) {
			return;
		}
		int u=0;//表示在arr[0..u]上都是无重复元素且升序的，该区域记为A
		int i=1;//表示在arr[u+1..i]上是不保证无重复元素且升序的，该区域记为B
		while(i!=arr.length) {
			if(arr[i++]!=arr[u]) {
				swap(arr,++u,i-1);
			}
		}
	}
	//补充问题，给定一个数组，其中只可能含有0,1,2,实现排序
	public void sort(int[]arr) {
		if(arr==null||arr.length<2) {
			return;
		}
		int left=-1;//表示在arr[0..left](左区)上都是0，left是这个区域当前最右的位置，初始为-1
		int index=0;//利用这个变量从左到右遍历，表示在arr[left+1..index](中区)上都是1，index是这个区域当前最右的位置，初始为0
		int right=arr.length;//表示在arr[right..N-1](左区)上都是0，right是这个区域当前最左的位置，初始为N
		while(index<right) {
			if(arr[index]==0) {
				swap(arr,++left,index++);//换过来的肯定是1，所以index+1
			}else if(arr[index]==2) {
				swap(arr,--right,index);//换过来的值未知，所以index不变
			}else {
				index++;
			}
		}
	}
}
