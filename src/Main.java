import base.linkedlist.SimpleLinkedList;
import problem_1.TwoValueSumTest;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //problem.1
//        int[] numbers = {2, 7, 11, 15, 8, 5};
//        TwoValueSumTest twoValueSumTest = new TwoValueSumTest();
//        int[] indices = twoValueSumTest.getIndicesOfTwoNumbers(numbers, 13);
//        System.out.print(Arrays.toString(indices));
        SimpleLinkedList list = new SimpleLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4, 8);
        //list.removeNode(4);
        System.out.println(list.toString());
        System.out.println(list.get(4).data);

    }

    void test1(){
        int[] numbers = {2, 7, 11, 15};
        TwoValueSumTest twoValueSumTest = new TwoValueSumTest();
        twoValueSumTest.getIndicesOfTwoNumbers(numbers, 9);
    }
}
