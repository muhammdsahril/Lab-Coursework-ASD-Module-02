public class Node implements Comparable<Node> {
    private String node;
    private int distance;

    public Node(String node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public String getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}