package week01.ex;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueEx {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        //Queue<Integer> queue = new LinkedList<>(); 도 사용 가능

        System.out.println("큐에 1, 2, 3 추가");
        queue.add(1);
        System.out.println("queue.add(1) = " + queue);
        queue.add(2);
        System.out.println("queue.add(2) = " + queue);
        queue.add(3);
        System.out.println("queue.add(3) = " + queue);
        System.out.println("queue = " + queue);
        System.out.println();

        System.out.println("다음 꺼낼 데이터 조회 - peek()");
        Integer peek = queue.peek();
        System.out.println("peek = " + peek);
        System.out.println();

        System.out.println("데이터 꺼내기");
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue = " + queue);
    }
}
