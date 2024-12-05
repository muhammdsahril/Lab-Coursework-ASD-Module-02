import java.util.*;

public class TravelPlan {
    public static void cheapestRoute(int[][] graphMatrix, String[] label, int start) {
        int n = graphMatrix.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        int[] previous = new int[n];

        // Inisialisasi jarak
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        Arrays.fill(previous, -1);

        // Priority queue untuk Dijkstra
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> distances[a] - distances[b]);
        pq.offer(start);

        while (!pq.isEmpty()) {
            int current = pq.poll();
            
            if (visited[current]) continue;
            visited[current] = true;

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graphMatrix[current][neighbor] != Integer.MAX_VALUE) {
                    int newDistance = distances[current] + graphMatrix[current][neighbor];
                    
                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        previous[neighbor] = current;
                        pq.offer(neighbor);
                    }
                }
            }
        }

        // Cetak rute dan biaya
        for (int i = 0; i < n; i++) {
            if (i != start) {
                System.out.print("Path: ");
                printPath(previous, label, start, i);
                System.out.println("Cost: " + (distances[i] == Integer.MAX_VALUE ? "Tidak terjangkau" : distances[i]));
            }
        }
    }

    // Metode bantuan untuk mencetak path
    private static void printPath(int[] previous, String[] label, int start, int end) {
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = previous[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        for (int i = 0; i < path.size(); i++) {
            System.out.print(label[path.get(i)]);
            if (i < path.size() - 1) {
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }
}