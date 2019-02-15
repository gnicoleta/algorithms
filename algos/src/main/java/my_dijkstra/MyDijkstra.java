package my_dijkstra;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class MyDijkstra {

    public static void calculateShortestPath(MyGraph g, MyNode source, MyNode destination) {

        // this array contains all the visited nodes
        ArrayList<MyNode> visited_nodes = new ArrayList<MyNode>();

        //finds the given in the graph, and since this is the start node, its weight will be 0
        MyNode current_node;
        current_node = g.findNode(source);
        current_node.setWeight(0);

        while (current_node != destination && current_node.getVisited() != 1) {
            current_node.setVisited(1);    //we mark the current_node node as being visited
            visited_nodes.add(current_node);    //we add the current node in the visited_nodes list
            List<Triplet<MyNode, MyNode, Integer>> current_node_edges;
            current_node_edges = current_node.getEdges();

            //here I compute the weight for each node like this:
            //the current_node has a set of edges
            //for each of those edges you need a source (the current_node) and a destination_node (S ----> D)
            // the weight for the destination node
            for (Triplet<MyNode, MyNode, Integer> edge : current_node_edges) {
                int weight = edge.getFirst().getWeight() + edge.getThird();
                if (weight < edge.getSecond().getWeight() && edge.getSecond().getVisited() == 0) {
                    edge.getSecond().setWeight(weight);
                }
            }
            MyNode newNode = new MyNode();
            int aux = 100;
            int cont = 0;
            for (Triplet<MyNode, MyNode, Integer> ii : current_node_edges) {

                if (ii.getSecond().getWeight() < aux && ii.getSecond().getVisited() == 0 && !visited_nodes.contains(ii.getSecond())) {
                    aux = ii.getSecond().getWeight();
                    newNode = ii.getSecond();
                } else if (ii.getSecond().getVisited() == 1 && visited_nodes.contains(ii.getSecond())) {
                    cont++;
                }
            }
            if (cont != current_node_edges.size()) {
                current_node = g.findNode(newNode);
                if (current_node == null) {
                    break;
                }
            } else {
                visited_nodes.remove(visited_nodes.size() - 1);
                current_node = visited_nodes.get(visited_nodes.size() - 1);
                current_node.setVisited(0);
                visited_nodes.remove(visited_nodes.size() - 1);
            }
        }
        visited_nodes.add(destination);

        for (
                MyNode n : visited_nodes) {
            System.out.println(n.getName());
        }

    }

    public static void main(String args[]) {

        MyNode nodeA = new MyNode("A");
        MyNode nodeB = new MyNode("B");
        MyNode nodeC = new MyNode("C");
        MyNode nodeD = new MyNode("D");
        MyNode nodeE = new MyNode("E");
        MyNode nodeF = new MyNode("F");
/*
        nodeA.createEdge(nodeA, nodeB, 10);
        nodeA.createEdge(nodeA, nodeC, 15);

        nodeB.createEdge(nodeB, nodeD, 12);
        nodeB.createEdge(nodeB, nodeF, 15);

        nodeC.createEdge(nodeC, nodeE, 10);

        nodeD.createEdge(nodeD, nodeE, 2);
        nodeD.createEdge(nodeD, nodeF, 1);

        nodeF.createEdge(nodeF, nodeE, 5);
        */


        nodeA.createEdge(nodeA, nodeB, 2);
        nodeA.createEdge(nodeA, nodeC, 4);

        nodeB.createEdge(nodeB, nodeA, 2);
        nodeB.createEdge(nodeB, nodeC, 1);
        nodeB.createEdge(nodeB, nodeE, 2);
        nodeB.createEdge(nodeB, nodeD, 4);

        nodeC.createEdge(nodeC, nodeB, 1);
        nodeC.createEdge(nodeC, nodeA, 4);
        nodeC.createEdge(nodeC, nodeE, 3);

        nodeD.createEdge(nodeD, nodeB, 4);
        nodeD.createEdge(nodeD, nodeF, 2);
        nodeD.createEdge(nodeD, nodeE, 3);

        nodeE.createEdge(nodeE, nodeB, 2);
        nodeE.createEdge(nodeE, nodeC, 3);
        nodeE.createEdge(nodeE, nodeF, 2);
        nodeE.createEdge(nodeE, nodeD, 3);

        nodeF.createEdge(nodeF, nodeD, 2);
        nodeF.createEdge(nodeF, nodeE, 2);


        MyGraph graph = new MyGraph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        MyDijkstra.calculateShortestPath(graph, nodeC, nodeF);
    }
}
