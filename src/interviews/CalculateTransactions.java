package interviews;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * N friends go on a trip and do a bunch of things together (dining, movies, etc.). Someone pays for each event.
 * You are provided R receipts. Calculate the transactions required so that each person pays his/her fair share
 */
public class CalculateTransactions {

    public static void main(String[] args) {
        List<Pair<Integer, Double>> receipts = new ArrayList<>();
        receipts.add(new Pair<>(1, 10.));
        receipts.add(new Pair<>(2, 10.));
        receipts.add(new Pair<>(3, 10.));
        receipts.add(new Pair<>(4, 10.));
        receipts.add(new Pair<>(5, 10.));
        calculate(receipts);

        System.out.println();
        receipts.clear();

        receipts.add(new Pair<>(1, 10.));
        receipts.add(new Pair<>(2, 4.));
        receipts.add(new Pair<>(3, 6.));
        receipts.add(new Pair<>(4, 14.));
        receipts.add(new Pair<>(5, 16.));
        calculate(receipts);

        System.out.println();
        receipts.clear();

        receipts.add(new Pair<>(1, 9.));
        receipts.add(new Pair<>(2, 4.));
        receipts.add(new Pair<>(3, 15.));
        receipts.add(new Pair<>(4, 15.));
        receipts.add(new Pair<>(5, 7.));
        calculate(receipts);
    }

    private static void calculate(List<Pair<Integer, Double>> receipts) {
        Map<Integer, Double> amountPaidMap = new TreeMap<>();
        // Compute amount paid by each person
        receipts.forEach(r -> amountPaidMap.put(r.getKey(), amountPaidMap.getOrDefault(r.getKey(), 0.) + r.getValue()));

        // Whats the total amount and average per person?
        double totalAmount = receipts.stream().mapToDouble(Pair::getValue).sum();
        double perPersonAmount = totalAmount / amountPaidMap.size();

/*
        // Owed map sorted by amount owed
        LinkedHashMap<Integer, Double> amountOwedMap = amountPaidMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue() - perPersonAmount,
                        (e1, e2) -> e1, LinkedHashMap::new));
        amountOwedMap.entrySet().forEach(System.out::println);
*/
        List<Pair<Integer, Double>> list = amountPaidMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(e -> new Pair<>(e.getKey(), e.getValue() - perPersonAmount))
                .collect(Collectors.toList());
        list.forEach(System.out::println);
        int start = 0;
        int end = list.size() - 1;
        while (start < end && start < list.size() && end >= 0) {
            if (list.get(start).getValue() == 0) {
                start++;
                continue;
            }
            double diff = list.get(end).getValue() - Math.abs(list.get(start).getValue());
            if (diff == 0) {
                System.out.println("Person " + list.get(start).getKey() + " pays $" + Math.abs(list.get(start).getValue()) + " to person " + list.get(end).getKey());
                list.set(end, new Pair<>(list.get(end).getKey(), 0.));
                list.set(start, new Pair<>(list.get(start).getKey(), 0.));
                start++;
                end--;
            } else if (diff > 0) {
                System.out.println("Person " + list.get(start).getKey() + " pays $" + Math.abs(list.get(start).getValue()) + " to person " + list.get(end).getKey());
                list.set(start, new Pair<>(list.get(start).getKey(), 0.));
                list.set(end, new Pair<>(list.get(end).getKey(), diff));
                start++;
            } else {
                System.out.println("Person " + list.get(start).getKey() + " pays $" + Math.abs(list.get(end).getValue()) + " to person " + list.get(end).getKey());
                list.set(start, new Pair<>(list.get(start).getKey(), diff));
                list.set(end, new Pair<>(list.get(end).getKey(), 0.));
                end--;
            }
        }
    }
}
