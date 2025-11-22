package hot100.linkedlist;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        l1.next = node1;
        node1.next = node2;
        ListNode l2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        l2.next = node3;
        node3.next = node4;
        LinkedListUtils.printListNode(mergeTwoLists(l1, l2));
    }

    /**
     * 迭代解法
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode vtrHead = new ListNode(-1);
        ListNode pre = vtrHead;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                pre.next = list1;
                list1 = list1.next;
            }else{
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return vtrHead.next;
    }
    // 递归解法
    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }
}
