package ms.hard.reverse_nodes_k;


import org.junit.Test;

public class Solution1 {

    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }


    @Test
    public void test() {

        ListNode l2 = new ListNode() {{
            val = 1;
            next = new ListNode() {{
                val = 2;
                next = new ListNode() {{
                    val = 3;
                    next = null;
                }};
            }};
        }};

        ListNode listNode = reverseKGroup(l2, 2);
        System.out.println(listNode);
    }
}