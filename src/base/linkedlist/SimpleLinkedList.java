package base.linkedlist;

/**
 * 简单模拟单链表
 */
public class SimpleLinkedList {
    public Node head;

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
    }

    /**
     * 在链表的指定位置插入一个结点
     * @param index 插入位置
     * @param data  结点数据
     */
    public void addNode(int index, int data) {
        Node node = new Node(data);
        // 如果链表不为空，至少需要有一个结点
        if (index < 0 || index > length()) {
            throw new IllegalArgumentException("the node position inserted is invalid, please check it up again.");
        }
        // 从第0个位置开始(head位置为0)
        int count = 0;
        Node currentNode = head;
        while (currentNode.next != null) {
            if (index == count++) {
                // 找到插入点
                // 现将当前插入点的node的后续链排到目标node之后
                node.next = currentNode.next;
                // 再将目标node插入到当前node的后面
                currentNode.next = node;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    /**
     * 移除指定位置的结点
     * @param index 位置
     */
    public void removeNode(int index) {
        // 不能少于一个结点，并且不能超过总长度
        if (index < 0 || index > length() -1 ) {
            throw new IllegalArgumentException("the node position removed is invalid, please check it up again.");
        }
        int count = 0;
        Node current = head;
        Node preNode = head;
        while (current.next != null) {
            // 找到删除位置
            if (index == count++) {
                preNode.next = current.next;
                return;
            }
            preNode = current;
            current = current.next;
        }

    }

    /**
     * 打印链表内所有数据
     * @return 链表数据
     */
    public String toString() {
        Node temp = head;
        String message = null;
        while (temp.next != null) {
            message = temp.data + "\t";
            temp = temp.next;
        }
        return message;
    }

}
