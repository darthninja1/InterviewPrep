package graph;

import java.util.*;

import static graph.GraphNode.createNode;

// https://www.geeksforgeeks.org/topological-sorting/
public class TopologicalSort {
    static Random random = new Random();

    public static void main(String[] args) {
         /*
                       F
                     /   \
              B  -- D      E
             /      |     /
            A  ---  C -- /
         */
        GraphNode aNode = createNode("A");
        aNode.setAdjacent(Arrays.asList(createNode("B"), createNode("C")));

        GraphNode bNode = createNode("B");
        bNode.setAdjacent(Arrays.asList(createNode("C"), createNode("D")));

        GraphNode cNode = createNode("C");
        cNode.setAdjacent(Arrays.asList(createNode("E")));

        GraphNode dNode = createNode("D");
        dNode.setAdjacent(Arrays.asList(createNode("F"), createNode("C")));

        GraphNode fNode = createNode("F");
        fNode.setAdjacent(Arrays.asList(createNode("E")));

        sort(new ArrayList<>(GraphNode.mapOfAllNodes.values()), new HashSet<>(), new ArrayDeque<>());
    }

    static void sortHelper(GraphNode selected, Set<GraphNode> visited, Deque<GraphNode> stack) {
        if (visited.contains(selected)) {
            return;
        }
        visited.add(selected);
        for (GraphNode next : selected.getAdjacent()) {
            if (!visited.contains(next)) {
                sortHelper(next, visited, stack);
            }
        }
        stack.push(selected);
    }

    static void sort(List<GraphNode> nodes, Set<GraphNode> visited, Deque<GraphNode> stack) {
        while (visited.size() < nodes.size()) {
            int n = random.nextInt(nodes.size());
            while (visited.contains(nodes.get(n))) {
                n = random.nextInt(nodes.size());
            }
            sortHelper(nodes.get(n), visited, stack);
        }

        System.out.println(stack);

        // Build order
        while (!stack.isEmpty())
            System.out.print(stack.removeLast() + " ");
    }
}
