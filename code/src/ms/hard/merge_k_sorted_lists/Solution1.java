package ms.hard.merge_k_sorted_lists;

import ms.hard.reverse_nodes_k.ListNode;

import java.util.PriorityQueue;

/**
 * Solution1
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Dec.15,2021</pre>
 */
public class Solution1 {


    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }



    /**
     * k-指针
     *
     */
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Status> queue = new PriorityQueue<>();

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(!queue.isEmpty()){
            Status f = queue.poll();

            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }

        return head.next;
    }

}
