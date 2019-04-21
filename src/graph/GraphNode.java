package graph;

import java.util.*;

class GraphNode {
    static Map<String, GraphNode> mapOfAllNodes = new HashMap<>();
    private String name;
    private List<GraphNode> adjacent = Collections.emptyList();

    private GraphNode(String name) {
        this.name = name;
    }

    static GraphNode createNode(String name) {
        return mapOfAllNodes.computeIfAbsent(name, GraphNode::new);
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

    static boolean checkIfPathExistsBFS(String s, String d) {
        GraphNode src = createNode(s);
        GraphNode dest = createNode(d);
        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();
        if (src == dest) {
            return true;
        }
        queue.add(src);
        while (!queue.isEmpty()) {
            GraphNode node = queue.remove();

            visited.add(node);
            if (node == dest) {
                return true;
            }
            node.getAdjacent().stream().filter(n -> !visited.contains(n)).forEach(queue::add);
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    List<GraphNode> getAdjacent() {
        return adjacent;
    }

    void setAdjacent(List<GraphNode> adjacent) {
        this.adjacent = adjacent;
    }
}
