package my_prim;

import util_structures.Triplet;

import java.util.ArrayList;

public class My_Prim {

    public static void addEdgesFromVisitedNodes(ArrayList<Triplet<PNode, PNode, Integer>> source, ArrayList<Triplet<PNode, PNode, Integer>> destination) {
        for (Triplet t : source) {
            destination.add(t);
        }
    }

    //public static void mst_prim(PGraph g, PNode source) {
    public static void mst_prim(PGraph g, PNode source, PNode destination) {
        ArrayList<PNode> visited_nodes = new ArrayList<PNode>();

        // this array will contain all the edges of the visited nodes
        // from this array the smallest edge will be chosen (from visited node to unvisited node)
        ArrayList<Triplet<PNode, PNode, Integer>> possible_edges_from_visited_nodes = new ArrayList<Triplet<PNode, PNode, Integer>>();

        //this array will contain the way of the mst
        ArrayList<Triplet<PNode, PNode, Integer>> the_mst_edges = new ArrayList<Triplet<PNode, PNode, Integer>>();

        PNode current_node = g.findNode(source);

        while (current_node != destination) {
            visited_nodes.add(current_node);

            //we add all the edges of the current_nod into the array with all the edges of ALL the visited nodes
            My_Prim.addEdgesFromVisitedNodes(current_node.getEdges(), possible_edges_from_visited_nodes);

            PNode current_node_parent = new PNode();
            int MIN = Integer.MAX_VALUE;    //the minimum value will end up being stored in here
            for (Triplet<PNode, PNode, Integer> ii : possible_edges_from_visited_nodes) {

                //the edge is from a visited node to an unvisited one
                //from the array with all edges of all the visited nodes, the smallest edge will be chosen
                if (visited_nodes.contains(ii.getFirst()) && ii.getThird() < MIN && !visited_nodes.contains(ii.getSecond())) {
                    MIN = ii.getThird();
                    current_node_parent = ii.getFirst();
                    current_node = ii.getSecond();
                }
            }

            //we add the the adges as they are parsed, in order to obtain the mst
            the_mst_edges.add(new Triplet<PNode, PNode, Integer>(current_node_parent, current_node, MIN));

            //to make sure we don't get on the same edge twice, we remove it from the array with all the edges of all visited nodes
            // the way I implemented a edge is ex: A - B, but also B - A (for undirected graphs)
            possible_edges_from_visited_nodes.remove(new Triplet<PNode, PNode, Integer>(current_node_parent, current_node, MIN));
            possible_edges_from_visited_nodes.remove(new Triplet<PNode, PNode, Integer>(current_node, current_node_parent, MIN));
        }

        if (current_node.equals(destination)) {
            visited_nodes.add(current_node);
        }
//
//        for (PNode p : visited_nodes) {
//            System.out.println("Node: " + p.getName());
//        }

        for (Triplet<PNode, PNode, Integer> tt : the_mst_edges) {
            System.out.println(" " + tt.getFirst().getName() + " - " + tt.getSecond().getName() + ": " + tt.getThird());
        }


    }

    public static void main(String args[]) {

        PNode nodeA = new PNode("A");
        PNode nodeB = new PNode("B");
        PNode nodeC = new PNode("C");
        PNode nodeD = new PNode("D");
        PNode nodeE = new PNode("E");
        PNode nodeF = new PNode("F");
        PNode nodeG = new PNode("G");

        nodeA.createEdgeTo(nodeB, 2);
        nodeA.createEdgeTo(nodeC, 3);
        nodeA.createEdgeTo(nodeD, 3);

        nodeB.createEdgeTo(nodeA, 2);
        nodeB.createEdgeTo(nodeC, 4);
        nodeB.createEdgeTo(nodeE, 3);

        nodeC.createEdgeTo(nodeA, 3);
        nodeC.createEdgeTo(nodeB, 4);
        nodeC.createEdgeTo(nodeD, 5);
        nodeC.createEdgeTo(nodeF, 6);
        nodeC.createEdgeTo(nodeE, 1);

        nodeD.createEdgeTo(nodeA, 2);
        nodeD.createEdgeTo(nodeC, 5);
        nodeD.createEdgeTo(nodeF, 7);

        nodeE.createEdgeTo(nodeC, 1);
        nodeE.createEdgeTo(nodeB, 3);
        nodeE.createEdgeTo(nodeF, 8);

        nodeF.createEdgeTo(nodeE, 8);
        nodeF.createEdgeTo(nodeD, 7);
        nodeF.createEdgeTo(nodeC, 6);
        nodeF.createEdgeTo(nodeG, 9);

        nodeG.createEdgeTo(nodeF, 9);

        PGraph graph = new PGraph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);

        My_Prim.mst_prim(graph, nodeA, nodeG);
    }
}
