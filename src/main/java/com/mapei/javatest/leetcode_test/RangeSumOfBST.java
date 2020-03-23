package com.mapei.javatest.leetcode_test;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/27
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class RangeSumOfBST {
    private int count;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null){
            return 0;
        }
        sumValue(root, L, R);
        return count;
    }

    public void sumValue(TreeNode root, int L, int R){
        if (root != null){
            if (L <= root.val && R >= root.val){
                count += root.val;
            }
            if (L < root.val){
                sumValue(root.left, L, R);
            }
            if (R > root.val){
                sumValue(root.right, L, R);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        node1.left = node2;
        TreeNode node3 = new TreeNode(15);
        node1.right = node3;
        TreeNode node4 = new TreeNode(3);
        node2.left = node4;
        TreeNode node5 = new TreeNode(7);
        node2.right = node5;
        TreeNode node6 = new TreeNode(18);
        node3.right = node6;

        RangeSumOfBST test = new RangeSumOfBST();
        System.out.println(test.rangeSumBST(node1, 7, 15));
    }
}
