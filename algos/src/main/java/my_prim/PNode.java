package my_prim;

import util_structures.Triplet;

import java.util.ArrayList;

public class PNode {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    ArrayList<Triplet<PNode, PNode, Integer>> edges = new ArrayList<Triplet<PNode, PNode, Integer>>();

    public void createEdgeTo(PNode destination, int distance) {
        edges.add(new Triplet(this, destination, distance));
    }

    public ArrayList<Triplet<PNode, PNode, Integer>> getEdges() {
        return this.edges;
    }

    public PNode(String name) {
        this.name = name;
    }

    public PNode() {
    }

}
