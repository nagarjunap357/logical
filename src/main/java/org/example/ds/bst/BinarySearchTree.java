package org.example.ds.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    TreeNode root;

    public boolean insert(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
            return true;
        }
        TreeNode temp = root;
        while (true) {
            if (newNode.val == temp.val) return false;

            if (newNode.val < temp.val) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            if (newNode.val > temp.val) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int val) {
        if (root == null) return false;
        TreeNode temp = root;
        while (true) {
            if (temp == null) {
                return false;
            } else if (val == temp.val) {
                return true;
            } else if (val < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
    }

    // Breadth first search method to traverse through the Tree
    public List<Integer> BFS() {
        TreeNode currentNode = root;
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            result.add(currentNode.val);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return result;
    }

    // Depth first search - preOrder method to traverse
    public List<Integer> DFSPreOrder() {
        return preOrderTraverse(root, new ArrayList<Integer>());
    }

    private List<Integer> preOrderTraverse(TreeNode currentNode, List<Integer> results) {
        if (currentNode == null) {
            return results;
        }
        results.add(currentNode.val);
        if (currentNode.left != null) {
            preOrderTraverse(currentNode.left, results);
        }
        if (currentNode.right != null) {
            preOrderTraverse(currentNode.right, results);
        }
        return results;
    }

    // Depth first search - postOrder method to traverse
    public List<Integer> DFSPostOrder() {
        return postOrderTraverse(root, new ArrayList<Integer>());
    }

    private List<Integer> postOrderTraverse(TreeNode currentNode, List<Integer> results) {
        if (currentNode == null) {
            return results;
        }
        if (currentNode.left != null) {
            postOrderTraverse(currentNode.left, results);
        }
        if (currentNode.right != null) {
            postOrderTraverse(currentNode.right, results);
        }
        results.add(currentNode.val);
        return results;
    }

    // Depth first search - InOrder(result will be in natural sorting order) method to traverse
    public List<Integer> DFSInOrder() {
        return InOrderTraverse(root, new ArrayList<Integer>());
    }

    private List<Integer> InOrderTraverse(TreeNode currentNode, List<Integer> results) {
        if (currentNode == null) {
            return results;
        }
        if (currentNode.left != null) {
            InOrderTraverse(currentNode.left, results);
        }
        results.add(currentNode.val);
        if (currentNode.right != null) {
            InOrderTraverse(currentNode.right, results);
        }
        return results;
    }


    int FindHeightOfTree(TreeNode node){
        if(node == null) return -1;
        return Math.max(FindHeightOfTree(node.left), FindHeightOfTree(node.right))+1;
    }

}
