package graph;

import java.util.*;

import static graph.GraphTraversal.GraphNode.checkIfPathExists;
import static graph.GraphTraversal.GraphNode.createNode;

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
        cNode.setAdjacent(Arrays.asList(createNode("E")));

        GraphNode dNode = createNode("D");
        dNode.setAdjacent(Arrays.asList(createNode("F"), createNode("C")));

        GraphNode fNode = createNode("F");
        fNode.setAdjacent(Arrays.asList(createNode("E")));

        System.out.println(checkIfPathExists("A", "E", new HashSet<>())); // true
        System.out.println(checkIfPathExists("C", "F", new HashSet<>())); // false
        System.out.println(checkIfPathExists("D", "E", new HashSet<>())); // true
    }

    static class GraphNode {
        static Map<String, GraphNode> mapOfAllNodes = new HashMap<>();
        String name;
        List<GraphNode> adjacent = Collections.emptyList();

        GraphNode(String name) {
            this.name = name;
        }

        public List<GraphNode> getAdjacent() {
            return adjacent;
        }

        static GraphNode createNode(String name) {
            return mapOfAllNodes.computeIfAbsent(name, n -> new GraphNode(n));
        }

        static boolean checkIfPathExists(String s, String d, Set<GraphNode> visited) {
            GraphNode src = createNode(s);
            GraphNode dest = createNode(d);
            if (src == dest) {
                return true;
            }
            if (visited.contains(src)) {
                return false;
            }
            visited.add(src);
            for (GraphNode n : src.getAdjacent()) {
                if (checkIfPathExists(n.name, d, visited)) {
                    return true;
                }
            }
            return false;
        }

        public void setAdjacent(List<GraphNode> adjacent) {
            this.adjacent = adjacent;
        }
    }
}
