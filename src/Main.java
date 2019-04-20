import problem_1.TwoValueSumTest;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //problem.1
        int[] numbers = {2, 7, 11, 15, 8, 5};
        TwoValueSumTest twoValueSumTest = new TwoValueSumTest();
        int[] indices = twoValueSumTest.getIndicesOfTwoNumbers(numbers, 13);
        System.out.print(Arrays.toString(indices));

    }

    void test1(){
        int[] numbers = {2, 7, 11, 15};
        TwoValueSumTest twoValueSumTest = new TwoValueSumTest();
        twoValueSumTest.getIndicesOfTwoNumbers(numbers, 9);
    }
}
