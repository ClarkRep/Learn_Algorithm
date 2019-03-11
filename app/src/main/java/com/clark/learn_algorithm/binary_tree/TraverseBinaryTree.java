package com.clark.learn_algorithm.binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Clark
 * @description 二叉树进行遍历的四种算法
 * 1、前序遍历 - 递归、循环
 * 2、中序遍历 - 递归、循环
 * 3、后序遍历 - 递归、循环
 * 4、层次遍历
 * @date 2019/3/9
 */
public class TraverseBinaryTree {

    public static void main(String[] args) {

         /*
         这是一个下面数据格式的完全二叉树
                  0
             1         2
          3     4    5   6
         7 8   9
         */

        BinaryNode rootNode = new BinaryNode();
        rootNode.data = 0;

        BinaryNode node1 = new BinaryNode();
        node1.data = 1;

        BinaryNode node2 = new BinaryNode();
        node2.data = 2;

        BinaryNode node3 = new BinaryNode();
        node3.data = 3;

        BinaryNode node4 = new BinaryNode();
        node4.data = 4;

        BinaryNode node5 = new BinaryNode();
        node5.data = 5;

        BinaryNode node6 = new BinaryNode();
        node6.data = 6;

        BinaryNode node7 = new BinaryNode();
        node7.data = 7;

        BinaryNode node8 = new BinaryNode();
        node8.data = 8;

        BinaryNode node9 = new BinaryNode();
        node9.data = 9;

        rootNode.lChild = node1;
        rootNode.rChild = node2;

        node1.lChild = node3;
        node1.rChild = node4;

        node3.lChild = node7;
        node3.rChild = node8;

        node4.lChild = node9;

        node2.lChild = node5;
        node2.rChild = node6;


        //先序遍历
//        preOrder1(rootNode);
//        preOrder2(rootNode);

        //中序遍历
//        inOrder1(rootNode);
//        inOrder2(rootNode);

        //后序遍历
//        postOrder1(rootNode);
//        postOrder2(rootNode);

        //层次遍历
        leverOrder(rootNode);
    }

    /**
     * 1、先序遍历
     * 1.1、递归调用方式
     */
    private static void preOrder1(BinaryNode rootNode) {

        System.out.print(rootNode.data + ",");

        BinaryNode lNode = rootNode.lChild;
        BinaryNode rNode = rootNode.rChild;

        if (lNode != null) {
            preOrder1(lNode);
        }
        if (rNode != null) {
            preOrder1(rNode);
        }
    }

    /**
     * 1、先序遍历
     * 1.2、循环方式
     */
    private static void preOrder2(BinaryNode rootNode) {
        Stack<BinaryNode> stack = new Stack<>();
        while (rootNode != null || !stack.isEmpty()) {
            while (rootNode != null) {
                System.out.print(rootNode.data + ",");
                stack.push(rootNode);
                rootNode = rootNode.lChild;
            }
            if (!stack.isEmpty()) {
                BinaryNode pop = stack.pop();
                rootNode = pop.rChild;
            }
        }
    }

    /**
     * 2、中序遍历
     * 2.1、递归方式
     *
     * @param rootNode
     */
    private static void inOrder1(BinaryNode rootNode) {

        if (rootNode == null) {
            return;
        }

        inOrder1(rootNode.lChild);
        System.out.print(rootNode.data + ",");
        inOrder1(rootNode.rChild);
    }

    /**
     * 2、中序遍历
     * 2.2、循环方式
     *
     * @param rootNode
     */
    private static void inOrder2(BinaryNode rootNode) {

        Stack<BinaryNode> stack = new Stack<>();
        while (rootNode != null || !stack.isEmpty()) {
            while (rootNode != null) {
                stack.push(rootNode);
                rootNode = rootNode.lChild;
            }

            if (!stack.isEmpty()) {
                BinaryNode pop = stack.pop();
                System.out.print(pop.data + ",");
                rootNode = pop.rChild;
            }
        }
    }

    /**
     * 3、后序遍历
     * 3.1、递归方式
     */
    private static void postOrder1(BinaryNode rootNode) {
        if (rootNode == null) {
            return;
        }
        postOrder1(rootNode.lChild);
        postOrder1(rootNode.rChild);
        System.out.print(rootNode.data + ",");
    }


    /**
     * 3、后序遍历
     * 3.2、循环
     */
    private static void postOrder2(BinaryNode rootNode) {

        Stack<BinaryNode> stack = new Stack<>();
        //先把根节点压入栈内
        stack.push(rootNode);

        //记录上一次被取出来的节点
        BinaryNode preNode = null;

        BinaryNode currentTopNode = null;

        while (!stack.isEmpty()) {

            currentTopNode = stack.peek();

            /*判断条件：
             *1、如果该节点没有孩子节点，说明是叶子节点，就可以取出来了;
             *2、如果上一次取出的节点，是不是当前栈顶节点的儿子节点，如果不是，说明需要继续压栈。
             */
            if ((currentTopNode.lChild == null && currentTopNode.rChild == null) ||
                    (preNode != null && (preNode == currentTopNode.lChild || preNode == currentTopNode.rChild))) {
                System.out.print(currentTopNode.data + ",");
                preNode = currentTopNode;
                stack.pop();
            } else {
                if (currentTopNode.rChild != null) {
                    stack.push(currentTopNode.rChild);
                }
                if (currentTopNode.lChild != null) {
                    stack.push(currentTopNode.lChild);
                }
            }
        }
    }

    /**
     * 4、层次遍历
     */
    private static void leverOrder(BinaryNode rootNode) {
        if (rootNode == null) {
            return;
        }
        //用一个顺序队列进行存储，先进先出
        Queue<BinaryNode> queue = new ArrayDeque<>();
        queue.add(rootNode);

        BinaryNode currentTopNode;
        while (!queue.isEmpty()) {
            //取出队列顶部的节点
            currentTopNode = queue.poll();
            //打印顶部节点
            System.out.print(currentTopNode.data + ",");
            //因为是顺序遍历，所以先左后右。
            if (currentTopNode.lChild != null) {
                queue.add(currentTopNode.lChild);
            }
            if (currentTopNode.rChild != null) {
                queue.add(currentTopNode.rChild);
            }
        }
    }
}
