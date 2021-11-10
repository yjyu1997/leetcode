package ms.hard.reverse_nodes_k;


import org.junit.Test;

/**
 * 递归法反转k链表
 */
public class Solution1 {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;

        while (count < k && ptr != null){
            ptr = ptr.next;
            count ++;
        }

        if(count == k){
            //reverse
            ListNode reverseHead = this.reverseLinkedList(head, k);
            head.next = this.reverseKGroup(ptr, k);
            return reverseHead;
        }

        return head;
    }


    public ListNode reverseLinkedList(ListNode head, int k){
        ListNode newHead = null;
        ListNode ptr = head;

        while(k > 0){
            ListNode next = ptr.next;
            ptr.next = newHead;
            newHead = ptr;
            ptr = next;
            k--;
        }

        return newHead;
    }


    @Test
    public void test() {

        ListNode l2 = new ListNode() {{
            val = 1;
            next = new ListNode() {{
                val = 2;
                next = new ListNode() {{
                    val = 3;
                    next = new ListNode() {{
                        val = 4;
                        next = new ListNode() {{
                            val = 5;
                            next = null;
                        }};
                    }};
                }};
            }};
        }};

        ListNode listNode = reverseKGroup(l2,2);
        System.out.println(listNode);
    }
}