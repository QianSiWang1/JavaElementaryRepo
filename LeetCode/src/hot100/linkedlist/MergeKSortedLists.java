package hot100.linkedlist;

import static hot100.linkedlist.MergeTwoSortedLists.mergeTwoLists;

/**
 * num 23 合并k个升序链表
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        LinkedListUtils.printListNode(mergeKLists(new ListNode[]{l1, l2, l3}));
    }

    public static ListNode mergeKLists(ListNode[] listNodes) {
        ListNode ans = null;
        for (int i = 0; i < listNodes.length; ++i) {
            ans = mergeTwoLists(ans, listNodes[i]);
        }
        return ans;
    }
}
