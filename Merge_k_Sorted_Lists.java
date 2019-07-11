package leetcode_interviewed_100;

public class Merge_k_Sorted_Lists {
	public class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
		 }
	
	public ListNode mergeKLists(ListNode[] lists) {
        int len=lists.length;
        if(lists==null||len==0){
            return null;
        }
        if(len==1){
            return lists[0];
        }
        while(len>1){
            int mid=(len+1)/2;
            for(int i=0;i<len/2;i++){
            	lists[i]=mergeTwoLists(lists[i],lists[i+mid]);
            }
            len=mid;
        }
        return lists[0];
    }
    
    public ListNode mergeTwoLists(ListNode head1,ListNode head2){
        if(head1==null||head2==null) {
			return head1!=null?head1:head2;
		}
		ListNode head=head1.val<head2.val?head1:head2;
		ListNode cur1=head==head1?head1:head2;//head 所在的链表
		ListNode cur2=head==head1?head2:head1;
		ListNode pre=null;
		ListNode next=null;
		while(cur1!=null&&cur2!=null) {
			if(cur1.val<=cur2.val) {
				pre=cur1;
				cur1=cur1.next;
			}else {
				next=cur2.next;
				pre.next=cur2;
				cur2.next=cur1;
				pre=cur2;
				cur2=next;
			}
		}
		pre.next=cur1==null?cur2:cur1;
		return head;
    }
    
    public ListNode mergeTwoLists2(ListNode L1,ListNode L2){
        if(L1==null) return L2;
        if(L2==null) return L1;
        
        ListNode head=new ListNode(0);
        ListNode phead=head;
        while(L1!=null&&L2!=null){
            if(L1.val <=L2.val){
                phead.next=L1;//接入结果链表
				phead=phead.next;//移动指针
				L1=L1.next;
            }else{
                phead.next=L2;
				phead=phead.next;
				L2=L2.next;
            }
        }
        
        if(L1!=null)
			phead.next=L1;
		else
			phead.next=L2;
        
        return head.next;
    }
}
