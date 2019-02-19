package my_prim;

import my_dijkstra.MyNode;
import util_structures.Triplet;

import java.util.ArrayList;
import java.util.List;

public class PNode {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    ArrayList<Triplet<PNode, PNode, Integer>> edges = new ArrayList<Triplet<PNode, PNode, Integer>>();

    public void createEdge(PNode source, PNode destination, int distance) {
        edges.add(new Triplet(source, destination, distance));
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
