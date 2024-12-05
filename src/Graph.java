public class Graph {
    private int[][] matrix;
    private int size;

    // untuk menginisialisasi graph
    public Graph(int size) {
        this.size = size;
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    // Menambahkan edge/koneksi antara dua vertex
    public void addEdge(int vertex1, int vertex2, int value) {
        matrix[vertex1][vertex2] = value;
        matrix[vertex2][vertex1] = value; // Bidirectional
    }

    // Mendapatkan matriks graph
    public int[][] getGraphMatrix() {
        return matrix;
    }
}