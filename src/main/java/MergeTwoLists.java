import java.util.Stack;

//https://leetcode.cn/problems/merge-two-sorted-lists/
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1  = new ListNode(1);
        ListNode list2 = new ListNode(2);

        ListNode listNode = mergeTwoLists(list1, list2);

        System.out.println(listNode.val);
        System.out.println(listNode.next.next.val);

    }

    //时间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， 因此 while 循环的次数不会超过两个链表的长度之和。所有其他操作的时间复杂度都是常数级别的，因此总的时间复杂度为 O(n+m)O(n+m)。
    //空间复杂度：O(1)O(1)。我们只需要常数的空间存放若干变量。
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        prev.next = list1 == null ? list2 : list1;

        return prehead.next;
    }
}