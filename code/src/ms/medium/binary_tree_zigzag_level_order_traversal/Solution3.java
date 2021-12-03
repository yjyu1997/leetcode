package ms.medium.binary_tree_zigzag_level_order_traversal;

import org.junit.Test;

import java.util.*;

/**
 * Solution3 <br/>
 *
 * DFS<br/>
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.29,2021</pre>
 */
public class Solution3 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        Deque<LevelTreeNode> stack = new ArrayDeque<LevelTreeNode>();

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        results.add(level_list);

        // add the root element
        stack.push(new LevelTreeNode(0,root));


        while (!stack.isEmpty()) {
            LevelTreeNode curr = stack.pop();

            if(curr.level >= results.size()){
                level_list = new LinkedList<>();
                results.add(level_list);
            }


            level_list = (LinkedList) results.get(curr.level);

            if(curr.level % 2 == 0){
                level_list.addLast(curr.treeNode.val);
            }
            else {
                level_list.addFirst(curr.treeNode.val);
            }

            if (curr.treeNode.right != null) {
                stack.push(new LevelTreeNode(curr.level + 1, curr.treeNode.right));
            }

            if (curr.treeNode.left != null) {
                stack.push(new LevelTreeNode(curr.level + 1, curr.treeNode.left));
            }

        }
        return results;
    }

    class LevelTreeNode {
        int level;
        TreeNode treeNode;

        public LevelTreeNode() {
        }

        public LevelTreeNode(int level, TreeNode treeNode) {
            this.level = level;
            this.treeNode = treeNode;
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

