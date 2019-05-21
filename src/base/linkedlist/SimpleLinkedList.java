package base.linkedlist;

/**
 * 简单模拟单链表
 * <p>
 *     链表至少包含一个头结点 head，只是充当龙头的作用，并不用来存储数据。
 *     每个结点都存在链接下一个结点的地址-->next引用，指向下一个结点，可以幻想成"贪吃蛇"的模型。
 * </p>
 */
public class SimpleLinkedList {
    public Node head;
    private static final int HEAD_NODE_DATA = -1;

    public SimpleLinkedList() {
        head = new Node(HEAD_NODE_DATA);
    }

    /**
     * 获取当前单链表的长度
     * @return 链表的长度
     */
    public int length() {
        Node temp = head;
        if (temp == null) {
            return 0;
        }
        int size = 1;
        while (temp.next != null) {
            temp = temp.next;
            size = size + 1;
        }
        return size;
    }

    /**
     * 直接在链表内插入一个结点
     * 插入位置：链表最后面
     * @param node 插入的结点
     */
    public void addNode(Node node) {
        Node currentNode = head;
        if (currentNode == null) {
            throw new IllegalArgumentException("the SimpleLinkedList is null, it should have nodes at least one.");
        }
        // 遍历单链表，找到当前链表的最后一个结点
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        // 将目标结点插入到末位结点的后面
        currentNode.next = node;
    }

    /**
     * 通过已知数据在链表内插入一个结点
     * 插入位置：链表最后面
     * @param data 结点中存储的数据
     */
    public void addNode(int data) {
        Node node = new Node(data);
        Node currentNode = head;
        if (currentNode == null) {
            throw new IllegalArgumentException("the SimpleLinkedList is null, it should have nodes at least one.");
        }
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        //System.out.print(node.data);
    }

    /**
     * 在链表的指定位置插入一个结点
     * @param index 插入位置
     * @param data  结点数据
     */
    public void addNode(int index, int data) {
        Node node = new Node(data);
        // 如果链表不为空，至少需要有一个结点
        if (index < 1 || index > length() + 1) {
            throw new IllegalArgumentException("the node position inserted is invalid, please check it up again.");
        }
        // 从第1个位置开始(head位置为0)
        int count = 1;
        Node currentNode = head;
        while (currentNode.next != null) {
            if (index == count++) {
                // 找到插入点
                // 现将当前插入点的node的后续链排到目标node之后
                node.next = currentNode.next;
                // 再将目标node插入到当前node的后面
                currentNode.next = node;
                System.out.print(node.data);
                return;
            }
            currentNode = currentNode.next;
        }
        // 当前插入的位置是链表的末尾
        if (index == length()) {
            addNode(node);
        }
    }

    /**
     * 移除指定位置的结点
     * @param index 位置
     */
    public void removeNode(int index) {
        // 不能少于一个结点，并且不能超过总长度
        if (index < 1 || index > length() -1 ) {
            throw new IllegalArgumentException("the node position removed is invalid, please check it up again.");
        }
        int count = 1;
        Node current = head;
        while (current.next != null) {
            // 找到删除位置
            if (index == count++) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }

    /**
     * 获取某个位置的结点
     * @param location 目标结点的位置
     * @return 目标结点
     */
    public Node get(int location) {
        Node node = null;
        if (location < 1 || location > length() -1 ) {
            throw new IllegalArgumentException("the node position queried is invalid, please check it up again.");
        }
        int count = 1;
        Node current = head;
        while (current.next != null) {
            // 找到目标位置
            if (location == count++) {
                node = current.next;
            }
            current = current.next;
        }
        return node;
    }


    /**
     * 打印链表内所有数据
     * @return 链表数据
     */
    public String toString() {
        Node temp = head.next;
        StringBuilder message = new StringBuilder();
        while (temp != null) {
            message.append(temp.data).append("\t");
            temp = temp.next;
        }
        return message.toString();
    }

}
