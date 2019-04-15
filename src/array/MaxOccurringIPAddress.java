package array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given list of IP addresses, find out max occured IP. I.e given ["255.255.11.135", "255.255.111.35", "255.255.110.135",
"255.255.11.135", "255.255.98.135"], maximum occured IP address is "255.255.110.135" with 2 occurances where as rest
of them have only one
 */
public class MaxOccurringIPAddress {
    public static void main(String[] args) {
        String[] ips = new String[]{"1.1.1.1", "255.255.11.135", "255.255.111.35", "255.255.110.135",
                "255.255.11.135", "255.255.98.135"};
        System.out.println(maxOccurringIP(ips));
        System.out.println(boringImplmaxOccurringIP(ips));

        ips = new String[]{"1.1.1.1", "2.2.2.2", "1.1.100.1", "1.255.255.255"};
        System.out.println(maxOccurringIP(ips));
        System.out.println(boringImplmaxOccurringIP(ips));
    }

    private static String boringImplmaxOccurringIP(String[] ips) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < ips.length; i++) {
            map.put(ips[i], map.getOrDefault(ips[i], 0) + 1);
        }
        TreeMap<Integer, List<String>> reverseMap = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            List<String> list = reverseMap.computeIfAbsent(e.getValue(), k -> new ArrayList<>());
            list.add(e.getKey());
        }
        return reverseMap.firstEntry().getValue().stream().collect(Collectors.joining(", "));
    }

    private static String maxOccurringIP(String[] ips) {
        // IP -> count
        Map<String, Long> countMap = Arrays.stream(ips)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // count -> IPs
        Map<Long, List<String>> mapByCount = countMap.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
/*
        LinkedHashMap<Long, List<String>> sortedMap = mapByCount.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(mapByCount);
*/

        List<Map.Entry<Long, List<String>>> list = mapByCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        return list.get(0).getValue().stream().collect(Collectors.joining(", "));
    }
}
