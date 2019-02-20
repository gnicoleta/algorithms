package my_kruskal;

import util_structures.Triplet;

import java.util.ArrayList;

public class KNode {
    private String name;
    private ArrayList<Triplet<KNode, KNode, Integer>> edges;

    public KNode(String name) {
        this.name = name;
    }

    public KNode() {
    }

    public void createEdgeTo(KNode destination, Integer weight) {
        edges.add(new Triplet(this, destination, weight));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Triplet<KNode, KNode, Integer>> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Triplet<KNode, KNode, Integer>> edges) {
        this.edges = edges;
    }
}
