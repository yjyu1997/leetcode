package array.easy.adding_two_number;

/**
 * AddingTwoNumbers2
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 5.0.0
 * @since <pre>Nov.03,2021</pre>
 */
public class AddingTwoNumbers2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(){{
            val = 9;
            next = new ListNode(){{
                val = 9;
                next = new ListNode(){{
                    val = 9;
                    next = new ListNode(){{
                        val = 9;
                        next = new ListNode(){{
                            val = 9;
                            next = null;
                        }};
                    }};
                }};
            }};
        }};

        ListNode l2 = new ListNode(){{
            val = 9;
            next = new ListNode(){{
                val = 9;
                next = new ListNode(){{
                    val = 9;
                    next = null;
                }};
            }};
        }};

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode prev = new ListNode(0);
        ListNode head = prev;
        boolean carry = false;

        while (l1 != null || l2 != null || carry) {
            ListNode cur = new ListNode(0);

            int sum = (l1 == null ? 0 : l1.val)
                    + (l2 == null ? 0 : l2.val)
                    + (carry ? 1 : 0);

            cur.val = sum % 10;
            carry = sum >= 10;

            prev.next = cur;
            prev = cur;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        }
        return head.next;

    }
}
