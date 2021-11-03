package array.easy.adding_two_number;

import java.util.ArrayList;
import java.util.List;

/**
 * AddingTwoNumbers
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.03,2021</pre>
 */
public class AddingTwoNumbers1 {

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
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        List<ListNode> nodeList = new ArrayList<>();


        while(l1 != null || l2 != null) {


            ListNode node = new ListNode();

            int sum = (l1 == null ? 0 : l1.val)
                    + (l2 == null ? 0 : l2.val)
                    + (carry ? 1 : 0);

            carry = false;
            if (sum >= 10) {
                sum = sum % 10;
                carry = true;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            node.val = sum;

            nodeList.add(node);
        }

        if(carry){
            nodeList.add(new ListNode(){{
                val = 1;
                next = null;
            }});
        }

        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).next = nodeList.get(i+1);
        }

        return nodeList.get(0);
    }


}
