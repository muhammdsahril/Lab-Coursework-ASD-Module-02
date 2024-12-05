import java.util.*;

public class Delivery {
    public static int[] dijkstra(int[][] costMatrix, int start) {
        // Section 1: 5 menit
        //simpan node jalan yang sudah dikunjungi
        LinkedList<Integer> visited = new LinkedList<>();
        //pastikan node dengan jarak terpendek diproses lebih dulu
        PriorityQueue<Integer> waiting = new PriorityQueue<>((a, b) -> Integer.compare(costMatrix[start][a], costMatrix[start][b]));
        //simpan jarak minimum dari node awal (start) ke setiap node lain
        int[] distance = new int[costMatrix.length];
        
        // Section 2: 5 menit (maks. 10 menit)
        //inisialisasi jarak, menandai semua node sebagai belum terjangkau (value tak hingga) kecuali node start
        for (int i = 0; i < costMatrix.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0; //jarak ke diri sendiri 
        
        // Section 3: 10 menit (maks. 15 menit)
        //tambah node start ke queue
        waiting.add(start);
        //proses node dalam antrian
        while (!waiting.isEmpty()) {
            int current = waiting.poll();
            if (visited.contains(current)) continue;
            visited.add(current);
            
            for (int neighbor = 0; neighbor < costMatrix.length; neighbor++) {
                if (costMatrix[current][neighbor] > 0 && !visited.contains(neighbor)) {
                    int newDistance = distance[current] + costMatrix[current][neighbor];
                    if (newDistance < distance[neighbor]) {
                        distance[neighbor] = newDistance;
                        waiting.add(neighbor);
                    }
                }
            }
        }

        // return jarak
        return distance;
    }
}