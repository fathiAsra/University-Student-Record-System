import java.util.*;

public class CampusGraph {

    private Map<String, List<String>> graph;

    public CampusGraph() {
        graph = new HashMap<>();
    }

    // Add location
    public boolean addLocation(String location) {

        if (graph.containsKey(location)) {
            return false;
        }

        graph.put(location, new ArrayList<>());

        return true;
    }

    // Remove location
    public boolean removeLocation(String location) {

        if (!graph.containsKey(location)) {
            return false;
        }

        graph.remove(location);

        for (List<String> neighbours : graph.values()) {
            neighbours.remove(location);
        }

        return true;
    }

    // Add connection
    public boolean addConnection(String location1, String location2) {

        if (!graph.containsKey(location1)
                || !graph.containsKey(location2)) {

            return false;
        }

        if (graph.get(location1).contains(location2)) {
            return false;
        }

        graph.get(location1).add(location2);
        graph.get(location2).add(location1);

        return true;
    }

    // Remove connection
    public boolean removeConnection(
            String location1,
            String location2) {

        if (!graph.containsKey(location1)
                || !graph.containsKey(location2)) {

            return false;
        }

        boolean removed = graph.get(location1).remove(location2);

        graph.get(location2).remove(location1);

        return removed;
    }

    // Display graph
    public void displayGraph() {

        if (graph.isEmpty()) {
            System.out.println("No campus locations found.");
            return;
        }

        System.out.println("\n===== CAMPUS NETWORK =====");

        for (String location : graph.keySet()) {

            System.out.println(
                    location + " -> "
                    + graph.get(location));
        }
    }

    // BFS
    public void bfs(String start) {

        if (!graph.containsKey(start)) {

            System.out.println("Location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();

        java.util.Queue<String> queue =
                new LinkedList<>();

        queue.add(start);
        visited.add(start);

        System.out.println("\n===== BFS TRAVERSAL =====");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.println(current);

            for (String neighbour : graph.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }
}