package week1.ex;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackEx {

    public static void main(String[] args) {
        Deque<Integer> dequeStack = new ArrayDeque<>();
        System.out.println("스택처럼 앞에서 1, 2, 3 삽입");
        dequeStack.push(1);
        System.out.println("dequeStack.push(1) = " + dequeStack);
        dequeStack.push(2);
        System.out.println("dequeStack.push(2) = " + dequeStack);
        dequeStack.push(3);
        System.out.println("dequeStack.push(3) = " + dequeStack);
        System.out.println();

        System.out.println("스택처럼 다음 꺼낼 데이터 조회");
        System.out.println("dequeStack.peek() = " + dequeStack.peek());
        System.out.println();

        System.out.println("스택처럼 데이터 삭제");
        System.out.println("dequeStack = " + dequeStack);
        dequeStack.poll();
        System.out.println("dequeStack.poll() = " + dequeStack);
        dequeStack.poll();
        System.out.println("dequeStack.poll() = " + dequeStack);
        dequeStack.poll();
        System.out.println("dequeStack.poll() = " + dequeStack);
    }
}
