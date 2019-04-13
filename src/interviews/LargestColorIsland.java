package interviews;

import com.google.common.collect.Sets;
import javafx.util.Pair;

import java.util.*;

import static interviews.LargestColorIsland.Color.B;
import static interviews.LargestColorIsland.Color.G;
import static interviews.LargestColorIsland.Color.R;

/**
 * Find the largest contiguous matching color island in a 2-d matrix
 */
public class LargestColorIsland {
    public static void main(String[] args) {
        Color[][] matrix = {
                {R, G, B, R},
                {R, R, R, R},
                {B, G, R, R},
                {G, G, G, G}};
        System.out.println(largestIsland(matrix));

        Color[][] matrix2 = {
                {R, G, B, R},
                {R, G, R, R},
                {B, G, R, R},
                {G, G, G, G}};
        System.out.println(largestIsland(matrix2));

        Color[][] matrix3 = {
                {R, G, B, R},
                {R, G, R, R},
                {B, G, R, R},
                {G, G, G, R}};
        System.out.println(largestIsland(matrix3));

        Color[][] matrix4 = {{R, G, B, R}};
        System.out.println(largestIsland(matrix4));

        Color[][] matrix5 = {
                {R, B, B, R},
                {R, B, R, R},
                {G, R, G, B},
                {G, R, G, B}};
        System.out.println(largestIsland(matrix5));
    }

    private static Pair<Integer, Set<Color>> largestIsland(Color[][] matrix) {
        Map<Color, List<Set<Pair<Integer, Integer>>>> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Set<Pair<Integer, Integer>> matchingNeigbhors = matchingNeigbhors(matrix, i, j);
                List<Set<Pair<Integer, Integer>>> islands = map.computeIfAbsent(matrix[i][j], k -> new ArrayList<>());
                if (islands.isEmpty()) {
                    islands.add(matchingNeigbhors);
                } else {
                    boolean matchFound = false;
                    Set<Pair<Integer, Integer>> matchingSet = new HashSet<>();
                    List<Integer> removeIndex = new ArrayList<>();
                    for (int idx = 0; idx < islands.size(); idx++) {
                        Set<Pair<Integer, Integer>> set = islands.get(idx);
                        if (!Sets.intersection(set, matchingNeigbhors).isEmpty()) {
                            if (!matchFound) {
                                set.addAll(matchingNeigbhors);
                                matchFound = true;
                                matchingSet = set;
                            } else {
                                matchingSet.addAll(set);
                                removeIndex.add(idx);
                            }
                        }
                    }
                    if (matchFound) {
                        for (Integer r : removeIndex) {
                            islands.remove(r);
                        }
                    } else {
                        islands.add(matchingNeigbhors);
                    }
                }
            }
        }
        Set<Color> maxColors = new HashSet<>();
        int maxCount = 0;
        for (Map.Entry<Color, List<Set<Pair<Integer, Integer>>>> entry : map.entrySet()) {
            List<Set<Pair<Integer, Integer>>> list = entry.getValue();
            for (Set<Pair<Integer, Integer>> set : list) {
                if (set.size() > maxCount) {
                    maxColors.clear();
                    maxColors.add(entry.getKey());
                    maxCount = set.size();
                } else if (set.size() == maxCount) {
                    maxColors.add(entry.getKey());
                }
            }
        }
        return new Pair<>(maxCount, maxColors);
    }

    private static Set<Pair<Integer, Integer>> matchingNeigbhors(Color[][] matrix, int i, int j) {
        Set<Pair<Integer, Integer>> matchingNeigborsSet = new HashSet<>();
        matchingNeigborsSet.add(new Pair<>(i, j));
        if (i - 1 >= 0 && matrix[i][j] == matrix[i - 1][j]) {
            matchingNeigborsSet.add(new Pair<>(i - 1, j));
        }
        if (j - 1 >= 0 && matrix[i][j] == matrix[i][j - 1]) {
            matchingNeigborsSet.add(new Pair<>(i, j - 1));
        }
        if (i + 1 < matrix.length && matrix[i][j] == matrix[i + 1][j]) {
            matchingNeigborsSet.add(new Pair<>(i + 1, j));
        }
        if (j + 1 < matrix[0].length && matrix[i][j] == matrix[i][j + 1]) {
            matchingNeigborsSet.add(new Pair<>(i, j + 1));
        }
        return matchingNeigborsSet;
    }

    enum Color {
        R, B, G;
    }
}