package org.example.ds.bst;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
//        System.out.println(tree.root);
        tree.insert(47);
        tree.insert(21);
        tree.insert(76);
        tree.insert(18);
        tree.insert(27);
        tree.insert(52);
        tree.insert(82);

//        System.out.println(tree.root.left.right.val);
        System.out.println("BFS: " + tree.BFS());
//        System.out.println("DFSPreOrder: "+tree.DFSPreOrder());
//        System.out.println("DFSPostOrder: "+tree.DFSPostOrder());
//        System.out.println("DFSInOrder: "+tree.DFSInOrder());
//        System.out.println("Height of tree: "+tree.FindHeightOfTree(tree.root));
        int sum = sumOfLeftLeaves(tree.root);
        System.out.println("sum: " + sum);
    }


    //Given the root of a binary tree, return the sum of all left leaves.
    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.remove();

            if (currNode.left != null) {
                queue.add(currNode.left);
                if (currNode.left.left == null && currNode.left.right == null) {
                    sum += currNode.left.val;
                }
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }
        return sum;
    }

    // 2385. Amount of Time for Binary Tree to Be Infected
//    You are given the root of a binary tree with unique values, and an integer start.
//    At minute 0, an infection starts from the node with value start.
//    Each minute, a node becomes infected if:
//    The node is currently uninfected.
//    The node is adjacent to an infected node.
    public static void timeTakenToBurnTree(TreeNode root, int start) {
        Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
        TreeNode targetNode = getTargetNode(root, start, childParentMap);
        int timeTakenToBurnTree = calculateBurnTime(targetNode, childParentMap);
        System.out.println("timeTakenToBurnTree: "+ timeTakenToBurnTree);
    }

    public static TreeNode getTargetNode(TreeNode root, int start, Map<TreeNode, TreeNode> childParentMap) {
        TreeNode targetNode = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.remove();
            if (currNode.val == start) targetNode = currNode;

            if (currNode.left != null) {
                queue.offer(currNode.left);
                childParentMap.put(currNode.left, currNode);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
                childParentMap.put(currNode.right, currNode);
            }
        }
        return targetNode;
    }

    public static int calculateBurnTime(TreeNode targetNode, Map<TreeNode, TreeNode> childParentMap){

        int time = 0;
        Map<TreeNode, Boolean> burntNodeMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(targetNode);
        burntNodeMap.put(targetNode, true);

        while(!queue.isEmpty()){
            int queueSize = queue.size();;
            boolean flg = false;

            for(int i=0;i<queueSize;i++){
                TreeNode currNode = queue.remove();

                if(currNode.left != null && burntNodeMap.get(currNode.left) == null){
                    flg = true;
                    burntNodeMap.put(currNode, true);
                    queue.offer(currNode.left);
                }
                if(currNode.right != null && burntNodeMap.get(currNode.right) == null){
                    flg = true;
                    burntNodeMap.put(currNode.right, true);
                    queue.offer(currNode.right);

                }
                if(childParentMap.get(currNode) != null && burntNodeMap.get(childParentMap.get(currNode)) == null){
                    flg = true;
                    burntNodeMap.put(childParentMap.get(currNode), true);
                    queue.offer(childParentMap.get(currNode));
                }
            }
            if(flg) time++;
        }
        return time;
    }
}
