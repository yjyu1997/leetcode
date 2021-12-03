package ms.medium.binary_tree_zigzag_level_order_traversal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution2 <br/>
 *
 * BFS with empty node marking the margin of levels<br/>
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.29,2021</pre>
 */
public class Solution2 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();

        nodeQueue.addLast(root);
        nodeQueue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (nodeQueue.size() > 0) {
            TreeNode curr = nodeQueue.pollFirst();

            if(curr != null){
                    if(is_order_left){
                        level_list.addLast(curr.val);
                    }
                    else {
                        level_list.addFirst(curr.val);
                    }

                if (curr.left != null) {
                    nodeQueue.addLast(curr.left);
                }
                if (curr.right != null) {
                    nodeQueue.addLast(curr.right);
                }

            }else {

                results.add(level_list);
                level_list = new LinkedList<>();

                //prepare the next lvl
                if(nodeQueue.size() > 0){
                    nodeQueue.addLast(null);
                    is_order_left = !is_order_left;
                }
            }
        }

        return results;
    }



    @Test
    public void test1(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.left = d;
        c.right = e;

        List<List<Integer>> lists = zigzagLevelOrder(a);
        System.out.println(lists);

    }
}
