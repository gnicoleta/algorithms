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
        ArrayList<Triplet<PNode, PNode, Integer>> possible_edges_from_visited_nodes = new ArrayList<Triplet<PNode, PNode, Integer>>();
        ArrayList<Triplet<PNode, PNode, Integer>> the_way = new ArrayList<Triplet<PNode, PNode, Integer>>();

        PNode current_node = g.findNode(source);

        while (current_node != destination) {
            visited_nodes.add(current_node);
            My_Prim.addEdgesFromVisitedNodes(current_node.getEdges(), possible_edges_from_visited_nodes);

            PNode intermediary_node = new PNode();
            PNode intermediary_node_parent = new PNode();
            int MIN = Integer.MAX_VALUE;    //the minimum value will end up being stored in here
            for (Triplet<PNode, PNode, Integer> ii : possible_edges_from_visited_nodes) {
                if (visited_nodes.contains(ii.getFirst()) && ii.getThird() < MIN && !visited_nodes.contains(ii.getSecond())) {
                    MIN = ii.getThird();
                    intermediary_node_parent = ii.getFirst();
                    intermediary_node = ii.getSecond();
                }
            }
            the_way.add(new Triplet<PNode, PNode, Integer>(intermediary_node_parent, intermediary_node, MIN));

            possible_edges_from_visited_nodes.remove(new Triplet<PNode, PNode, Integer>(intermediary_node_parent, intermediary_node, MIN));
            possible_edges_from_visited_nodes.remove(new Triplet<PNode, PNode, Integer>(intermediary_node, intermediary_node_parent, MIN));
            current_node = g.findNode(intermediary_node);
        }
//
//        for (PNode p : visited_nodes) {
//            System.out.println("Node: " + p.getName());
//        }

        for (Triplet<PNode, PNode, Integer> tt : the_way) {
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

        nodeA.createEdge(nodeA, nodeB, 2);
        nodeA.createEdge(nodeA, nodeC, 3);
        nodeA.createEdge(nodeA, nodeD, 3);

        nodeB.createEdge(nodeB, nodeA, 2);
        nodeB.createEdge(nodeB, nodeC, 4);
        nodeB.createEdge(nodeB, nodeE, 3);

        nodeC.createEdge(nodeC, nodeA, 3);
        nodeC.createEdge(nodeC, nodeB, 4);
        nodeC.createEdge(nodeC, nodeD, 5);
        nodeC.createEdge(nodeC, nodeF, 6);
        nodeC.createEdge(nodeC, nodeE, 1);

        nodeD.createEdge(nodeD, nodeA, 2);
        nodeD.createEdge(nodeD, nodeC, 5);
        nodeD.createEdge(nodeD, nodeF, 7);

        nodeE.createEdge(nodeE, nodeC, 1);
        nodeE.createEdge(nodeE, nodeB, 3);
        nodeE.createEdge(nodeE, nodeF, 8);

        nodeF.createEdge(nodeF, nodeE, 8);
        nodeF.createEdge(nodeF, nodeD, 7);
        nodeF.createEdge(nodeF, nodeC, 6);
        nodeF.createEdge(nodeF, nodeG, 9);

        nodeG.createEdge(nodeG, nodeF, 9);

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
