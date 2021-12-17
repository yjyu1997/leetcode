package ms.hard.serialize_and_deserialize_binary_tree;

import com.sun.source.tree.WhileLoopTree;
import ms.medium.binary_tree_zigzag_level_order_traversal.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * DFSCodec
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Dec.16,2021</pre>
 */
public class DFSCodec {

    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<String> list = new LinkedList<>();

        stack.push(root);

        while (stack.size() > 0)  {
            TreeNode pop = stack.pop();

            if(pop != null){
                stack.push(pop.right);
                stack.push(pop.left);
                list.add(String.valueOf(pop.val));
            }else {
                list.add("none");
            }

        }

        return Arrays.toString(list.toArray());
    }



    public List<String> doSerialize(TreeNode root, List<String> list){
        if(root == null){
            list.add("none");
        }
        else {
            list.add(String.valueOf(root.val));
            list = doSerialize(root.left, list);
            list = doSerialize(root.right, list);
        }
        return list;

    }



    /**
     * Decodes your encoded data to tree.
     *
     */
    public TreeNode deserialize(String data) {
        data = data.substring(1,data.length() - 1);
        String[] strs = data.split(", ");

        LinkedList<TreeNode> nodeList = new LinkedList<>();

        for (String s : strs) {
            TreeNode node = "none".equals(s) ? null : new TreeNode(Integer.parseInt(s));
            nodeList.add(node);
        }

        TreeNode root = doDeserialize(nodeList);


        return root;
    }


    public TreeNode doDeserialize(Deque<TreeNode> dataList) {

        //如果为null 为空树
        TreeNode peek = dataList.peek();

        if(peek == null){
            return dataList.pop();
        }

        TreeNode pop = dataList.pop();

        pop.left = doDeserialize(dataList);
        pop.right = doDeserialize(dataList);

        return pop;
    }



    @Test
    public void test(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.left = d;
        c.right = e;

        DFSCodec codec = new DFSCodec();
        String serialize = codec.serialize(a);
        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize(serialize);
    }
}
