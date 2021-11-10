package ms.hard.reverse_nodes_k;

/**
 * Solution2
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.10,2021</pre>
 */
public class Solution2 {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;

        ListNode newHead = null;

        while (ptr != null){
            int count = 0;

            ptr = head;

            while (count < k && ptr != null){
                ptr = ptr.next;
                count ++;
            }

            if(count == k){
                ListNode revHead = this.reverseLinkedList(head, k);

                if(newHead == null){
                    newHead = revHead;
                }

                if(ktail != null){
                    ktail.next = revHead;
                }

                ktail = head;
                head = ptr;
            }
        }

        if(ktail != null){
            ktail.next = head;
        }

        return newHead == null ? head : newHead;
    }

}
