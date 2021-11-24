package graph;

/**
 * KEdge
 */
class KEdge implements Comparable<KEdge> {
    public int weight;
    public String nodeV;
    public String nodeU;

    public KEdge(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    // System.out.println() 으로 객체 자체 출력시, 다음 메서드를 호출하여, 원하는 attribute등을 출력할 수 있음
    public String toString() {
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
    }

    @Override
    public int compareTo(KEdge edge) {
        return this.weight - edge.weight;
    }
}