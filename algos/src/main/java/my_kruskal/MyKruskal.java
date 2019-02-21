package my_kruskal;

import javafx.util.Pair;
import util_structures.MyPair;
import util_structures.Triplet;

import java.util.ArrayList;
import java.util.Iterator;

public class MyKruskal {

    public static void addEdgesFromAllNodes(ArrayList<Triplet<KNode, KNode, Integer>> source, ArrayList<Triplet<KNode, KNode, Integer>> destination) {
        for (Triplet t : source) {
            destination.add(t);
        }
    }

    public static void kruskal_mst(KGraph graph) {
        ArrayList<Triplet<KNode, KNode, Integer>> all_edges = new ArrayList<Triplet<KNode, KNode, Integer>>();
        ArrayList<Triplet<KNode, KNode, Integer>> visited_edges = new ArrayList<Triplet<KNode, KNode, Integer>>();
        ArrayList<KNode> visited_nodes = new ArrayList<KNode>();

        for (KNode n : graph.getNodes()) {
            MyKruskal.addEdgesFromAllNodes(n.getEdges(), all_edges);
        }

        ArrayList<MyPair<Triplet<KNode, KNode, Integer>, Integer>> parsed_edges = new ArrayList<MyPair<Triplet<KNode, KNode, Integer>, Integer>>();

        Iterator edge = all_edges.iterator();
        while (edge.hasNext()) {
            parsed_edges.add(new MyPair(edge, 0));
        }

        //while()
        KNode current_node_parent = new KNode();
        KNode current_node = new KNode();
        MyPair<Triplet<KNode, KNode, Integer>, Integer> currrnt = new MyPair<Triplet<KNode, KNode, Integer>, Integer>();
        Integer MIN = Integer.MAX_VALUE;
        for (MyPair<Triplet<KNode, KNode, Integer>, Integer> t : parsed_edges) {
            if (t.getFirst().getThird() < MIN) {
                MIN = t.getFirst().getThird();
                currrnt = t;
                //current_node_parent = t.getFirst();
                //current_node = t.getSecond();
            }
        }
        currrnt.setSecond(1);
        visited_edges.add(currrnt.getFirst());
        if(!visited_nodes.contains(currrnt.getFirst().getFirst()) && !visited_nodes.contains(currrnt.getFirst().getSecond())) {
            visited_nodes.add(currrnt.getFirst().getFirst());
            visited_nodes.add(currrnt.getFirst().getSecond());
        }

    }

    public static void main(String args[]) {

    }
}
