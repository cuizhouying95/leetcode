package leetcode_interviewed_100;

public class Sort_Colors {
    public void swap(int[] arr,int i,int j) {
    	int temp=arr[i];
    	arr[i]=arr[j];
    	arr[j]=temp;
    }
	//����һ���������飬������ʹ���������벿�����ظ�Ԫ�������򣬶�����֤�Ҳ����Ƿ�����
	public void leftUnique(int[] arr) {
		if(arr==null||arr.length<2) {
			return;
		}
		int u=0;//��ʾ��arr[0..u]�϶������ظ�Ԫ��������ģ��������ΪA
		int i=1;//��ʾ��arr[u+1..i]���ǲ���֤���ظ�Ԫ��������ģ��������ΪB
		while(i!=arr.length) {
			if(arr[i++]!=arr[u]) {
				swap(arr,++u,i-1);
			}
		}
	}
	//�������⣬����һ�����飬����ֻ���ܺ���0,1,2,ʵ������
	public void sort(int[]arr) {
		if(arr==null||arr.length<2) {
			return;
		}
		int left=-1;//��ʾ��arr[0..left](����)�϶���0��left���������ǰ���ҵ�λ�ã���ʼΪ-1
		int index=0;//����������������ұ�������ʾ��arr[left+1..index](����)�϶���1��index���������ǰ���ҵ�λ�ã���ʼΪ0
		int right=arr.length;//��ʾ��arr[right..N-1](����)�϶���0��right���������ǰ�����λ�ã���ʼΪN
		while(index<right) {
			if(arr[index]==0) {
				swap(arr,++left,index++);//�������Ŀ϶���1������index+1
			}else if(arr[index]==2) {
				swap(arr,--right,index);//��������ֵδ֪������index����
			}else {
				index++;
			}
		}
	}
}
