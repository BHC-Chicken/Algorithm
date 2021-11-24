package graph;

public class Edge implements Comparable<Edge> {
    public int distance;
    public String vertex;

    public Edge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    public String toString() {
        return "vertax" + this.vertex + "distance" + this.distance;
    }

    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }
}
