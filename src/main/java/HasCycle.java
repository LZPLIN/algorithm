import java.util.HashSet;

/**
 * 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class HasCycle {
    public static void main(String[] args) {
        int x=0;
        int b= ++x;
        int c=x++;
        System.out.println(x);
        System.out.println(b);
        System.out.println(c);
    }

    /**
     * 时间复杂度：O(N)，其中 NN 是链表中的节点数。最坏情况下我们需要遍历每个节点一次。
     * 空间复杂度：O(N)，其中 NN 是链表中的节点数。主要为哈希表的开销，最坏情况下我们需要将每个节点插入到哈希表中一次。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){
        HashSet<ListNode> seen = new HashSet<>();

        while (head != null){
            if (!seen.add(head)){
                return true;
            }
            head = head.next;
        }

        return false;
    }

    /**
     * 时间复杂度：O(N)，其中 NN 是链表中的节点数。
     *    当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次。
     *    当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动 NN 轮。
     * 空间复杂度：O(1)。我们只使用了两个指针的额外空间。
     * @param head
     * @return
     */
    public boolean hasCycle_2(ListNode head){
        if (head == null || head.next == null) return false;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast){
            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;

        }

        return true;
    }

}
