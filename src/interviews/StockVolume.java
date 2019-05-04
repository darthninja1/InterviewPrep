package interviews;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StockVolume {

    private Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        StockVolume sv = new StockVolume();
        sv.addStock("IBM", 100);
        sv.addStock("AAPL", 130);
        sv.addStock("NFLX", 200);
        sv.addStock("IBM", 10);
        sv.addStock("AAPL", 164);
        sv.addStock("NFLX", 40);
        sv.addStock("AAPL", 21);
        sv.addStock("GOOG", 400);
        sv.addStock("IBM", 110);
        System.out.println(sv.getNLargestVolume(1));
        System.out.println(sv.getNLargestVolume(2));
        System.out.println(sv.getNLargestVolume(3));
        System.out.println(sv.getNLargestVolume(4));
    }

    private void addStock(String ticker, int volume) {
        map.put(ticker, map.getOrDefault(ticker, 0) + volume);
    }

    private List<String> getNLargestVolume(int n) {
/*
        LinkedHashMap<String, Integer> sortedMap =
                map.entrySet()
                        .stream()
                        .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap);
*/
        return map.entrySet()
                .stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Entry::getKey)
                .limit(n)
                .collect(Collectors.toList());
    }
}