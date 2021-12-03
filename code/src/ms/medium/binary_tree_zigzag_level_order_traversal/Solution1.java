package ms.medium.binary_tree_zigzag_level_order_traversal;

import org.junit.Test;

import java.util.*;

/**
 * Solution1
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.25,2021</pre>
 */
public class Solution1 {

    int level = 1;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {



        List<List<Integer>> ret = new LinkedList<>();

        if(root == null){
            return ret;
        }

        LinkedList<Integer> tmp = new LinkedList<>();
        LinkedList<Map<TreeNode, Integer>> toBeVisited = new LinkedList<>();

        toBeVisited.add(Map.of(root, 1));


        while (!toBeVisited.isEmpty()) {
            Map<TreeNode, Integer> map = toBeVisited.poll();
            TreeNode node = map.keySet().iterator().next();
            int level = map.get(node);

            if(level != this.level){
                ret.add(tmp);
                tmp = new LinkedList<>();
                this.level = level;
            }

            if(level % 2 == 1){
                tmp.add(node.val);
            }
            else {
                tmp.addFirst(node.val);
            }


            pushLeft(toBeVisited, node, level);
            pushRight(toBeVisited, node, level);
        }

        ret.add(tmp);
        return ret;
    }

    private void pushRight(LinkedList<Map<TreeNode, Integer>> toBeVisited, TreeNode node, int level) {
        TreeNode right = node.right;
        if (right != null) {
            toBeVisited.add(Map.of(right, level + 1));
        }
    }

    private void pushLeft(LinkedList<Map<TreeNode, Integer>> toBeVisited, TreeNode node, int level) {
        TreeNode left = node.left;
        if (left != null) {
            toBeVisited.add(Map.of(left, level + 1));
        }
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
