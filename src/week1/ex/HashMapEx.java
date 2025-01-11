package week1.ex;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();

        System.out.println("키 : 1-3, 값 : 가-다 추가");
        hashMap.put(1, "가");
        hashMap.put(2, "나");
        hashMap.put(3, "다");
        System.out.println("hashMap = " + hashMap);
        System.out.println();

        System.out.println("해시맵의 키 = 1의 값");
        System.out.println("hashMap.get(1) = " + hashMap.get(1));
        System.out.println();

        System.out.println("해시맵의 키 1, 2, 3 삭제");
        System.out.println("hashMap.remove(1) = " + hashMap.remove(1));
        System.out.println("hashMap.remove(2) = " + hashMap.remove(2));
        System.out.println("hashMap.remove(3) = " + hashMap.remove(3));
        System.out.println("hashMap = " + hashMap);
    }
}
