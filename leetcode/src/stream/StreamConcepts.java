package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamConcepts {
    public static void main(String[] args) {
        List<String> al = Arrays.asList("a", "b", "c", "d", "e");
        // al.stream().forEach(System.out::println);
        al.stream().filter(s -> (int) s.charAt(0) < 99).forEach(System.out::println);
        al.stream().map(s -> "This is " + s).forEach(System.out::println);
        List<Integer> al1 = Arrays.asList(45, 13, 67, 98, 34, 12, 2, 44, 33, 1, 9);
        al1.stream().sorted().forEach(System.out::println);
        System.out.println("-----------------");
        al1.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);

        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 5);
        hm.put(2, 2);
        hm.put(3, 1);
        hm.put(4, 10);

        List<Map.Entry<Integer, Integer>> li = new ArrayList<>(hm.entrySet());
        Collections.sort(li, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
                return m1.getValue() - m2.getValue();
            }
        });
        LinkedHashMap<Integer, Integer> ans = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> m : li) {
            ans.put(m.getKey(), m.getValue());
        }

        for (Map.Entry<Integer, Integer> m : ans.entrySet()) {
            System.out.println(m.getKey() + "," + m.getValue());
        }

        LinkedHashMap<Integer, Integer> ans1 = hm.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));

        for (Map.Entry<Integer, Integer> m : ans1.entrySet()) {
            System.out.println(m.getKey() + "," + m.getValue());
        }
        System.out.println("---------------------------------------------");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().filter(s -> s % 2 == 0).forEach(System.out::println);
        list.stream().map(s -> "this is " + s).forEach(System.out::println);
        list.stream().sorted((a, b) -> a - b).reduce((a, b) -> a - b).ifPresent(System.out::println);

        List<String> capitalize = Arrays.asList("aditya", "raj");
        capitalize.stream().map(s -> s.substring(0, 1).toUpperCase() + s.substring(1, s.length()))
                .forEach(System.out::println);

        List<String> al111 = capitalize.stream().map(s -> s.substring(0, 1).toUpperCase() + s.substring(1, s.length()))
                .collect(Collectors.toList());

        List<Integer> sortingAl = Arrays.asList(21, 3, 5, 6);

        sortingAl.stream().sorted((a, b) -> a - b).forEach(a -> System.out.print(a + ","));
        System.out.println("----------------------------");
        List<Integer> secondLargest = Arrays.asList(21, 3, 5, 6);
        secondLargest.stream().sorted((a, b) -> b - a).filter(a -> a > secondLargest.get(2) && a < secondLargest.get(0))
                .forEach(System.out::println);
    }

}
