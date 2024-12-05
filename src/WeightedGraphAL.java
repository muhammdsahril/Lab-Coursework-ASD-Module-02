import java.util.*;

public class WeightedGraphAL {
    private Map<String, List<Edge>> adjacencyList;

    public WeightedGraphAL() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(String node1, String node2, int weight) {
        adjacencyList.putIfAbsent(node1, new ArrayList<>());
        adjacencyList.putIfAbsent(node2, new ArrayList<>());
        
        adjacencyList.get(node1).add(new Edge(node2, weight));
        adjacencyList.get(node2).add(new Edge(node1, weight));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String node : adjacencyList.keySet()) {
            sb.append(node).append(" --> ");
            List<Edge> edges = adjacencyList.get(node);
            String edgeString = edges.stream()
                .map(edge -> edge.getTargetNode() + "(" + edge.getWeight() + ")")
                .reduce((a, b) -> a + " " + b)
                .orElse("");
            sb.append(edgeString).append("\n");
        }
        return sb.toString();
    }

    public void dijkstra(String start, String end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>();
        
        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (current.getNode().equals(end)) break;
            
            if (current.getDistance() > distances.get(current.getNode())) continue;
            
            for (Edge edge : adjacencyList.get(current.getNode())) {
                int newDistance = current.getDistance() + edge.getWeight();
                
                if (newDistance < distances.get(edge.getTargetNode())) {
                    distances.put(edge.getTargetNode(), newDistance);
                    previousNodes.put(edge.getTargetNode(), current.getNode());
                    pq.offer(new Node(edge.getTargetNode(), newDistance));
                }
            }
        }
        
        List<String> path = new ArrayList<>();
        String current = end;
        while (current != null) {
            path.add(0, current);
            current = previousNodes.get(current);
        }
        
        System.out.print("Path: ");
        System.out.println(String.join(" --> ", path));
        System.out.println("Shortest distance from " + start + " to " + end + " = " + distances.get(end));
    }
}