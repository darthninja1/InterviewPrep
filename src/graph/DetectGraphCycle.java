package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static graph.GraphNode.createNode;

// https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
public class DetectGraphCycle {
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

        System.out.println(checkCycle(aNode, new HashSet<>(), new HashSet<>()));

        // Introduces cycle
        GraphNode eNode = createNode("E");
        eNode.setAdjacent(Arrays.asList(createNode("F")));
        System.out.println(checkCycle(aNode, new HashSet<>(), new HashSet<>()));
    }

    private static boolean checkCycle(GraphNode start, Set<GraphNode> recursionSet, Set<GraphNode> visited) {
        if (recursionSet.contains(start)) {
            return true;
        }

        if (visited.contains(start)) {
            return false;
        }

        visited.add(start);
        recursionSet.add(start);

        for (GraphNode n : start.getAdjacent()) {
            if (checkCycle(n, recursionSet, visited)) {
                return true;
            }
        }
        recursionSet.remove(start);
        return false;
    }

}
