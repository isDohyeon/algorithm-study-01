package week01.ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // List<Integer> list = new LinkedList<>();도 사용 가능

        System.out.println("리스트에 1, 2, 3 추가");
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list = " + list);
        System.out.println();

        System.out.println("리스트의 0번째 데이터 검색");
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println();

        System.out.println("리스트의 데이터 삭제");
        System.out.println("list.remove(2) = " + list.remove(2));
        System.out.println("list.remove(1) = " + list.remove(1));
        System.out.println("list.remove(0) = " + list.remove(0));
        System.out.println("list = " + list);
    }
}
