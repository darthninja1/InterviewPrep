package array;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/
public class KMostFrequent {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 5, 1, 5, 3, 3, 4, 5, 1, 4};
        System.out.println(mostFrequent(arr, 2));
        System.out.println(mostFrequent(arr, 3));
        System.out.println(mostFrequent(arr, 4));

        System.out.println(mostFrequentTreeMap(arr, 2));
        System.out.println(mostFrequentTreeMap(arr, 3));
        System.out.println(mostFrequentTreeMap(arr, 4));
    }

    private static List<Integer> mostFrequent(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer>[] count = new List[arr.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = count[entry.getValue()];
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(entry.getKey());
            count[entry.getValue()] = list;
        }
        List<Integer> kMostList = new ArrayList<>();
        for (int i = count.length - 1, c = 0; c < k && i >= 0; i--) {
            if (count[i] != null) {
                List<Integer> list = count[i];
                if (list != null) {
                    if (list.size() < k - c) {
                        kMostList.addAll(list);
                        c += list.size();
                    } else {
                       kMostList.addAll(list.subList(0, k - c));
                        c = k;
                        break;
                    }
                }
            }
        }
        return kMostList;
    }

    private static List<Integer> mostFrequentTreeMap(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> numList = treeMap.computeIfAbsent(entry.getValue(), e -> new ArrayList<>());
            numList.add(entry.getKey());
        }
        List<Integer> kMostList = new ArrayList<>();
        int c = 0;
        while (c < k) {
            Map.Entry<Integer, List<Integer>> entry = treeMap.pollLastEntry();
            List<Integer> list = entry.getValue();
            if (list != null) {
                if (list.size() < k - c) {
                    kMostList.addAll(list);
                    c += list.size();
                } else {
                    kMostList.addAll(list.subList(0, k - c));
                    c = k;
                    break;
                }
            }
        }
        return kMostList;
    }
}