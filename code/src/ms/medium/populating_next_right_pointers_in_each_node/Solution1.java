package ms.medium.populating_next_right_pointers_in_each_node;

import ms.medium.binary_tree_zigzag_level_order_traversal.TreeNode;

import java.util.LinkedList;

/**
 * Solution1
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.29,2021</pre>
 */
public class Solution1 {

    public Node connect(Node root) {


        if(root == null){
            return null;
        }

        LinkedList<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.addLast(root);
        nodeQueue.addLast(null);

        Node tmp = null;


        while(nodeQueue.size() > 0){
            Node curr = nodeQueue.pollFirst();

            if(curr != null){

                if(tmp != null){
                    tmp.next = curr;
                }
                tmp = curr;


                if (curr.left != null) {
                    nodeQueue.addLast(curr.left);
                }
                if (curr.right != null) {
                    nodeQueue.addLast(curr.right);
                }
            }

            else {
                if(tmp != null){
                    tmp.next = null;
                }
                tmp = null;

                //prepare the next lvl
                if(nodeQueue.size() > 0){
                    nodeQueue.addLast(null);
                }
            }
        }
        return root;
    }



}
