package misc;

import java.util.*;
import java.util.stream.Collectors;

/*
Find the student who has maximum average score.
Input: N * 2 string matrix, where N is the number of records(Student – Marks)
// https://www.glassdoor.com/Interview/Coderpad-given-an-array-scores-jerry-65-bob-91-jerry-23-Eric-83-Find-the-student-with-hi-QTN_2587199.htm
 */
public class StudentWithHighestAverage {
    public static void main(String[] args) {
        String[][] scores = {{"jerry", "65"}, {"bob", "91"}, {"jerry", "23"}, {"Eric", "83"}};
        System.out.println(findStudent(scores));
        String[][] students = {{"jerry", "10"}, {"bob", "20"}, {"jerry", "20"}, {"jerry", "30"}, {"Eric", "13"}};
        System.out.println(findStudent(students));
    }

    private static String findStudent(String[][] scores) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < scores.length; i++) {
            List<Integer> list = map.computeIfAbsent(scores[i][0], k -> new ArrayList<>());
            list.add(Integer.valueOf(scores[i][1]));
        }
        TreeMap<Double, List<String>> averageMap = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
            OptionalDouble avg = e.getValue().stream().mapToInt(i -> i).average();
            List<String> list = averageMap.computeIfAbsent(avg.getAsDouble(), k -> new ArrayList<>());
            list.add(e.getKey());
        }
        return averageMap.firstEntry().getValue().stream().collect(Collectors.joining(", "));
    }
}