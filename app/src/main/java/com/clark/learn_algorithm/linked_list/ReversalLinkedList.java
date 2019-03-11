package com.clark.learn_algorithm.linked_list;

/**
 * @author Clark
 * @description 单链表反转的算法
 * @date 2019/3/9
 */
public class ReversalLinkedList {

    public static void main(String[] args) {

        printLinkedList(revertLinkedList(getStartNode()));

        printLinkedList(reverLinkedList2(getStartNode()));
    }

    private static Node getStartNode() {
        Node startNote = new Node();
        startNote.data = 1;

        Node currentNode = null;

        for (int i = 2; i < 1000; i++) {
            Node node = new Node();
            node.data = i;
            if (currentNode == null) {
                currentNode = node;
                startNote.next = currentNode;
            } else {
                currentNode.next = node;
                currentNode = node;
            }
        }
        printLinkedList(startNote);
        return startNote;
    }

    private static void printLinkedList(Node startNode) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(startNode.data).append(",");
        while (startNode.next != null) {
            stringBuilder.append(startNode.next.data).append(",");
            startNode = startNode.next;
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 方法一：就地反转法
     *
     * @param startNode
     */
    private static Node revertLinkedList(Node startNode) {

        long startTimeMillis = System.currentTimeMillis();

        if (startNode == null || startNode.next == null) {
            return startNode;
        }

        //重新定义一个起始指针，让它指向开始指针。
        Node zeroNode = new Node();
        zeroNode.data = -1;
        zeroNode.next = startNode;

        //将链表的数据一个一个往开始位置提取，提取出来的数据链接到起始指针。

        //记录一个这一次要被提取为开始节点的节点
        Node index;
        //上一次被提取为开始节点的节点
        Node preIndex = startNode;

        while (preIndex.next != null) {
            //当前要被提取为开始节点的节点，是上一次提取为开始节点的下一个节点。
            index = preIndex.next;
            //preIndex的下一个节点指向index的下一个节点
            preIndex.next = index.next;
            //index指向开始节点之前的节点；
            index.next = zeroNode.next;
            //开始节点指向index；
            zeroNode.next = index;
        }
        //计算时间
        System.out.println("revertLinkedList()时间：" + (System.currentTimeMillis() - startTimeMillis));
        return zeroNode.next;
    }

    /**
     * 方法二：新建链表，头节点插入法
     *
     * @param startNode
     * @return
     */
    private static Node reverLinkedList2(Node startNode) {

        long startTimeMillis = System.currentTimeMillis();

        if (startNode == null || startNode.next == null) {
            return startNode;
        }

        Node zeroNode = new Node();

        //即将操作的节点
        Node index = startNode;
        //下一个即将操作的节点
        Node nexIndex;
        while (index != null) {
            nexIndex = index.next;
            index.next = zeroNode.next;
            zeroNode.next = index;
            index = nexIndex;
        }
        //计算时间
        System.out.println("revertLinkedList()时间：" + (System.currentTimeMillis() - startTimeMillis));
        return zeroNode.next;
    }

}
