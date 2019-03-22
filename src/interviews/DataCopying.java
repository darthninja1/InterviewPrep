package interviews;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;

// https://github.com/rajanmalhotra/Code-Samples/blob/master/twosigma/DataCopier.java
// https://github.com/saillsha/coding-exercises/blob/master/Arrays/TwoSigmaCodeTestCopyFile.java
public class DataCopying {
    public static void main(String[] args) {
        // Using a TreeSet so I can say set.first().
        // Alternatively, you can use a list
        Map<Integer, TreeSet<Integer>> dataSettoDCMap = new HashMap<>();
//        int numberOfDataCenters = getInputFromStdin(dataSettoDCMap);
        int numberOfDataCenters = getInput(dataSettoDCMap);
        printOutput(numberOfDataCenters, dataSettoDCMap);
    }

    private static int getInput(Map<Integer, TreeSet<Integer>> dataSettoDCMap) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        /*
            3
            5 1 3 4 5 7
            2 1 3
            1 2
        */
        map.put(1, Sets.newTreeSet(Lists.newArrayList(1, 3, 4, 5, 7)));
        map.put(2, Sets.newTreeSet(Lists.newArrayList(1, 3)));
        map.put(3, Sets.newTreeSet(Lists.newArrayList(2)));
        for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
            for (Integer dataSet: e.getValue()) {
                TreeSet<Integer> set = dataSettoDCMap.computeIfAbsent(dataSet, k -> new TreeSet<>());
                set.add(e.getKey());
            }
        }
        return 3;
    }

    private static int getInputFromStdin(Map<Integer, TreeSet<Integer>> dataSettoDCMap) {
        Scanner s = new Scanner(System.in);
        int numberOfDataCenters = Integer.parseInt(s.nextLine());
        for (int i = 1; i <= numberOfDataCenters; i++) {
            int count = s.nextInt();
            while (count-- > 0) {
                int d = s.nextInt();
                TreeSet<Integer> dcSet = dataSettoDCMap.computeIfAbsent(d, k -> new TreeSet<>());
                dcSet.add(i);
            }
        }
        return numberOfDataCenters;
    }

    private static void printOutput(int numberofDataCenters, Map<Integer, TreeSet<Integer>> dataSettoDCMap) {
        for (int dataSetIndex : dataSettoDCMap.keySet()) {
            TreeSet<Integer> dataCenterSet = dataSettoDCMap.get(dataSetIndex);

            int count = dataCenterSet.size();
            if (count != numberofDataCenters) {
                for (int i = 1; i <= numberofDataCenters; i++) {
                    if (!dataCenterSet.contains(i)) {
                        System.out.println(dataSetIndex + " " + dataCenterSet.first() + " " + i);
                    }
                }
            }
        }
        System.out.println("done");
    }
}
