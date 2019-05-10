package base.linkedlist;

/**
 * 单链表的结点类
 */
public class Node {
    // 当前节点的下一个结点变量
    public Node next;
    // 存放的数据
    public int data;
    // 构造器
    public Node(int data) {
        this.data = data;
    }
}
