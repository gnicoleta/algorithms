package my_prim;

import util_structures.Triplet;

import java.util.ArrayList;

public class My_Prim {

    public static void addEdgesFromVisitedNodes(ArrayList<Triplet<PNode, PNode, Integer>> source, ArrayList<Triplet<PNode, PNode, Integer>> destination) {
        for(Triplet t : source) {
            destination.add(t);
        }
    }

    public static void mst_prim(PGraph g, PNode source) {
    //public static void mst_prim(PGraph g, PNode source, PNode destination) {
        ArrayList<PNode> visited_nodes = new ArrayList<PNode>();
        ArrayList<Triplet<PNode, PNode, Integer>> possible_edges_from_visited_nodes = new ArrayList<Triplet<PNode, PNode, Integer>>();

        PNode current_node = g.findNode(source);
        visited_nodes.add(current_node);
        My_Prim.addEdgesFromVisitedNodes(current_node.getEdges(), possible_edges_from_visited_nodes);


    }

    public static void main(String args[]) {
        ArrayList<Integer> lili = new ArrayList<Integer>();
        lili.add(new Integer(5));
        lili.add(new Integer(6));
        lili.add(new Integer(4));

        for(Integer i : lili) {
            System.out.println("Ind: " + i);
        }

        lili.remove(new Integer(5));

        for(Integer i : lili) {
            System.out.println("AAAInd: " + i);
        }
    }
}
