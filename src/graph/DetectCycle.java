package graph;

import java.util.*;

public class DetectCycle {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        /*
            3 --- 2
               \  |
                \ |
            0 --- 1
         */
        graph.add(Arrays.asList(0, 1));
        graph.add(Arrays.asList(1, 2));
        graph.add(Arrays.asList(1, 3));
        graph.add(Arrays.asList(2, 3));
        System.out.println(graph);
        System.out.println(removeCycle(graph));
        System.out.println(removeCycleBFS(graph));
        System.out.println();
        graph.clear();

        // No cycle
        /*
            3 --- 2
               \
                \
            0 --- 1
         */
        graph.add(Arrays.asList(0, 1));
        graph.add(Arrays.asList(1, 3));
        graph.add(Arrays.asList(2, 3));
        System.out.println(graph);
        System.out.println(removeCycle(graph));
        System.out.println(removeCycleBFS(graph));
        System.out.println();

        /*
            3 --- 2---4----5
                  |   |
                  |   |
            0 --- 1-- 6 ---7
         */
        graph.clear();
        graph.add(Arrays.asList(0, 1));
        graph.add(Arrays.asList(1, 6));
        graph.add(Arrays.asList(1, 2));
        graph.add(Arrays.asList(2, 3));
        graph.add(Arrays.asList(4, 2));
        graph.add(Arrays.asList(4, 5));
        graph.add(Arrays.asList(6, 7));
        graph.add(Arrays.asList(4, 6));

        System.out.println(graph);
        System.out.println(removeCycle(graph));
        System.out.println(removeCycleBFS(graph));
    }

    private static List<Integer> removeCycle(List<List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int start = graph.get(0).get(0);
        return removeCycleHelper(graph, visited, start, -1);
    }

    private static List<Integer> removeCycleHelper(List<List<Integer>> graph, Set<Integer> visited, int node, int from) {
        visited.add(node);
        for (List<Integer> edge : graph) {
            int n1 = edge.get(0);
            int n2 = edge.get(1);
            if (n1 == from || n2 == from) {
                continue; // this is the parent node
            }
            int next;
            if (n1 == node) {
                next = n2;
            } else if (n2 == node) {
                next = n1;
            } else {
                continue; // not a edge for "node"
            }
            if (visited.contains(next)) {
                return edge;
            }
            visited.add(next);
            List<Integer> match = removeCycleHelper(graph, visited, next, node);
            if (match != null) {
                return match;
            }
        }
        return null;
    }

    private static List<Integer> removeCycleBFS(List<List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int start = graph.get(0).get(0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int from = -1;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            visited.add(node);
            for (List<Integer> edge : graph) {
                int n1 = edge.get(0);
                int n2 = edge.get(1);
                if (n1 == from || n2 == from) {
                    continue; // this is the parent node
                }
                int next;
                if (n1 == node) {
                    next = n2;
                } else if (n2 == node) {
                    next = n1;
                } else {
                    continue; // not a edge for "node"
                }
                if (visited.contains(next)) {
                    return edge;
                }
                queue.add(next);
            }
            from = node;
        }
        return null;
    }
}
