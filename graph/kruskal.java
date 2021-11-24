package graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class kruskal {

    HashMap<String, String> parent = new HashMap<String, String>();
    HashMap<String, Integer> rank = new HashMap<String, Integer>();

    public String find(String node) {
        // path compression 기법
        if (this.parent.get(node) != node) {
            this.parent.put(node, find(this.parent.get(node)));
        }
        return this.parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank 기법
        if (this.rank.get(root1) > this.rank.get(root2)) {
            this.parent.put(root2, root1);
        } else {
            this.parent.put(root1, root2);
            if (this.rank.get(root1) == this.rank.get(root2)) {
                this.rank.put(root2, this.rank.get(root2) + 1);
            }
        }
    }

    public void makeSet(String node) {
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }

    public ArrayList<KEdge> kruskalFunc(ArrayList<String> vertices, ArrayList<KEdge> kEdges) {
        ArrayList<KEdge> mst = new ArrayList<KEdge>();
        KEdge currentNode;

        // 1. 초기화
        for (int index = 0; index < vertices.size(); index++) {
            makeSet(vertices.get(index));
        }

        // 2. 간선 weight 기반 sorting
        // Collections.sort() : ArrayList 정렬 기능
        Collections.sort(kEdges);

        for (int index = 0; index < kEdges.size(); index++) {
            currentNode = kEdges.get(index);
            if (find(currentNode.nodeV) != find(currentNode.nodeU)) {
                union(currentNode.nodeV, currentNode.nodeU);
                mst.add(currentNode);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<KEdge> edges = new ArrayList<KEdge>();
        edges.add(new KEdge(7, "A", "B"));
        edges.add(new KEdge(5, "A", "D"));
        edges.add(new KEdge(7, "B", "A"));
        edges.add(new KEdge(8, "B", "C"));
        edges.add(new KEdge(9, "B", "D"));
        edges.add(new KEdge(7, "B", "E"));
        edges.add(new KEdge(8, "C", "B"));
        edges.add(new KEdge(5, "C", "E"));
        edges.add(new KEdge(5, "D", "A"));
        edges.add(new KEdge(9, "D", "B"));
        edges.add(new KEdge(7, "D", "E"));
        edges.add(new KEdge(6, "D", "F"));
        edges.add(new KEdge(7, "E", "B"));
        edges.add(new KEdge(5, "E", "C"));
        edges.add(new KEdge(7, "E", "D"));
        edges.add(new KEdge(8, "E", "F"));
        edges.add(new KEdge(9, "E", "G"));
        edges.add(new KEdge(6, "F", "D"));
        edges.add(new KEdge(8, "F", "E"));
        edges.add(new KEdge(11, "F", "G"));
        edges.add(new KEdge(9, "G", "E"));
        edges.add(new KEdge(11, "G", "F"));

        kruskal kObject = new kruskal();
        System.out.println(kObject.kruskalFunc(vertices, edges));
    }
}