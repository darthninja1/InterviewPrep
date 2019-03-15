package graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static graph.GraphNode.checkIfPathExists;
import static graph.GraphNode.createNode;

public class GraphTraversal {
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
        cNode.setAdjacent(Collections.singletonList(createNode("E")));

        GraphNode dNode = createNode("D");
        dNode.setAdjacent(Arrays.asList(createNode("F"), createNode("C")));

        GraphNode fNode = createNode("F");
        fNode.setAdjacent(Collections.singletonList(createNode("E")));

        System.out.println(checkIfPathExists("A", "E", new HashSet<>())); // true
        System.out.println(checkIfPathExists("C", "F", new HashSet<>())); // false
        System.out.println(checkIfPathExists("D", "E", new HashSet<>())); // true
    }

}
