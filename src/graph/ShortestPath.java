package graph;

import java.util.*;


/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement def shortestPath(self, fromStationName, toStationName)
 * method to find shortest path between 2 stations
 * 4) If time permits, some possible follow-ups.
 */
/*
 *      Visual representation of the Train map used
 *
 *      King's Cross St Pancras --- Angel ---- Old Street
 *      |                   \                            |
 *      |                    \                            |
 *      |                     \                            |
 *      Russell Square         Farringdon --- Barbican --- Moorgate
 *      |                                                  /
 *      |                                                 /
 *      |                                                /
 *      Holborn --- Chancery Lane --- St Paul's --- Bank
 */

public class ShortestPath {
    public static void main(String[] args) {
        TrainMap map = new TrainMap();
        /*
                       F
                     /   \
              B  -- D      E
             /      |     /
            A  ---  C -- /
         */
        map.addStation("A").addStation("B").addStation("C").addStation("D").addStation("E").addStation("F");
        map.connectStations("A", "B");
        map.connectStations("A", "C");
        map.connectStations("B", "D");
        map.connectStations("C", "E");
        map.connectStations("D", "F");
        map.connectStations("D", "C");
        map.connectStations("F", "E");
        System.out.println(map.checkPath("A", "E")); // true
        System.out.println(map.checkPath("C", "F")); // false
        System.out.println(map.checkPath("D", "E")); // true

        Map<Station, Station> predMap = new HashMap<>();
        Map<Station, Integer> distMap = new HashMap<>();
        System.out.println(map.shortestPath("A", "C", predMap, distMap));
        predMap.clear();
        distMap.clear();
        System.out.println(map.shortestPath("A", "D", predMap, distMap));
        predMap.clear();
        distMap.clear();
        System.out.println(map.shortestPath("A", "E", predMap, distMap));
        predMap.clear();
        distMap.clear();
        System.out.println(map.shortestPath("A", "F", predMap, distMap));
    }


    /**
     * class Station
     * <p>
     * Respresents Station in the rail network. Each station is identified by
     * unique name. Station is connected with other stations - this information
     * is stored in the 'neighbours' field. Two station objects with the same name are
     * equal therefore they are considered to be same station.
     */
    private static class Station {
        private String name;
        private List<Station> neighbours;

        public Station(String name) {
            this.name = name;
            this.neighbours = new ArrayList<>(3);
        }

        String getName() {
            return name;
        }

        void addNeighbour(Station v) {
            this.neighbours.add(v);
        }

        List<Station> getNeighbours() {
            return this.neighbours;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Station && this.name.equals(((Station) obj).getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.name);
        }
    }

    /**
     * class TrainMap
     * <p>
     * Respresents whole rail network - consists of number of the Station objects.
     * Stations in the map are bi-directionally connected. Distance between any 2 stations
     * is of same constant distance unit. This implies that shortest distance between any
     * 2 stations depends only on number of stations in between
     */
    private static class TrainMap {

        private HashMap<String, Station> stations;

        public TrainMap() {
            this.stations = new HashMap<>();
        }

        public TrainMap addStation(String name) {
            Station s = new Station(name);
            this.stations.putIfAbsent(name, s);
            return this;
        }

        public Station getStation(String name) {
            return this.stations.get(name);
        }

        public TrainMap connectStations(String from, String to) {
            Station fromStation = getStation(from);
            Station toStation = getStation(to);
            if (fromStation == null || toStation == null) {
                throw new IllegalArgumentException("error");
            }
            if (!fromStation.getNeighbours().contains(toStation)) {
                fromStation.addNeighbour(toStation);
            }
/*
            if (!toStation.getNeighbours().contains(fromStation)) {
                toStation.addNeighbour(fromStation);
            }
*/
            return this;
        }

        public boolean checkPath(String from, String to) {
            Station fromStation = getStation(from);
            Station toStation = getStation(to);
            Queue<Station> queue = new LinkedList<>();
            Set<Station> visited = new HashSet<>();
            if (fromStation == toStation) {
                return true;
            }
            queue.add(fromStation);
            while (!queue.isEmpty()) {
                Station node = queue.remove();

                visited.add(node);
                if (node == toStation) {
                    return true;
                }
                node.neighbours.stream().filter(n -> !visited.contains(n)).forEach(queue::add);
            }
            return false;
        }

        public Integer shortestPath(String from, String to,
                                    Map<Station, Station> predMap, Map<Station, Integer> distMap) {
            Station fromStation = getStation(from);
            Station toStation = getStation(to);
            Queue<Station> queue = new LinkedList<>();
            Set<Station> visited = new HashSet<>();
            if (fromStation == toStation) {
                return 0;
            }
            queue.add(fromStation);
            distMap.put(fromStation, 0);
            predMap.put(fromStation, null);
            while (!queue.isEmpty()) {
                Station node = queue.remove();

                if (node == toStation) {
                    print(from, to, predMap, distMap);
                    return distMap.get(node);
                }
                node.neighbours.stream().filter(n -> !visited.contains(n)).forEach(n -> {
                    queue.add(n);
                    visited.add(node);
                    distMap.put(n, distMap.getOrDefault(node, 0) + 1);
                    predMap.put(n, node);
                });
            }
            return -1;
        }

        public void print(String from, String to, Map<Station, Station> predMap, Map<Station, Integer> distMap) {
                Station dest = getStation(to);
            System.out.print(dest.name + " ");
            while (predMap.containsKey(dest)) {
                if (predMap.get(dest) != null) {
                    System.out.print(predMap.get(dest).name + " ");
                    dest = predMap.get(dest);
                } else {
                    break;
                }
            }
        }

    }
}