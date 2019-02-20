package my_kruskal;

import util_structures.Triplet;

import java.util.ArrayList;

public class MyKruskal {

    public static void addEdgesFromAllNodes(ArrayList<Triplet<KNode, KNode, Integer>> source, ArrayList<Triplet<KNode, KNode, Integer>> destination) {
        for (Triplet t : source) {
            destination.add(t);
        }
    }

    public static void kruskal_mst(KGraph graph) {
        ArrayList<Triplet<KNode, KNode, Integer>> all_edges = new ArrayList<Triplet<KNode, KNode, Integer>>();
        ArrayList<KNode> visited_nodes = new ArrayList<KNode>();

        for (KNode n : graph.getNodes()) {
            MyKruskal.addEdgesFromAllNodes(n.getEdges(), all_edges);
        }

        KNode current_node_parent = new KNode();
        KNode current_node = new KNode();
        Integer MIN = Integer.MAX_VALUE;
        for (Triplet<KNode, KNode, Integer> t : all_edges) {
            if (t.getThird() < MIN) {
                MIN = t.getThird();
                current_node_parent = t.getFirst();
                current_node = t.getSecond();
            }
        }

    }

    public static void main(String args[]) {

    }
}
