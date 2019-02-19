package my_dijkstra;
import util_structures.Triplet;

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
            //for each of those edges you need a source (the current_node) and a destination_node (Source_node --edge--(weight)--> Destination_node)
            // the weight for the destination node = the weight of the source + the weight on the edge
            // if this sum si less than the weight of the destination node, then its weight will be overwritten by it
            // otherwise the lesser value will be kept as the weight of the destination_node
            for (Triplet<MyNode, MyNode, Integer> edge : current_node_edges) {
                int weight = edge.getFirst().getWeight() + edge.getThird();
                if (weight < edge.getSecond().getWeight() && edge.getSecond().getVisited() == 0) {
                    edge.getSecond().setWeight(weight);
                }
            }

            //After computing all the weights for the possible destination nodes of the edges of the current_node
            // I want to choose the node with smaller weight
            MyNode intermediary_node = new MyNode();
            int MIN = Integer.MAX_VALUE;    //the minimum value will end up being stored in here
            int contor = 0;    //this contor will be incremented each time a visited node is visited again (in order to avoid cycles in the graph)
            for (Triplet<MyNode, MyNode, Integer> ii : current_node_edges) {

                //I'm looking for the smallest weight and the intermediary_node will be the smallest node that I will choose
                //in order ti obtain the shortest path
                if (ii.getSecond().getWeight() < MIN && ii.getSecond().getVisited() == 0 && !visited_nodes.contains(ii.getSecond())) {
                    MIN = ii.getSecond().getWeight();
                    intermediary_node = ii.getSecond();
                } else if (ii.getSecond().getVisited() == 1 && visited_nodes.contains(ii.getSecond())) {
                    //if the destination (of the edge) was visited and it was also contained in the visited nodes list
                    //the contor will be incremented
                    contor++;
                }
            }

            //if all the possible nodes to visit from the current node were already visited
            // (the contor will be the same size as the edges list of the current_node)
            // if not all the destination_nodes of the current_node edges were visited
            // current_node will become the intermediary_node (the one with the smallest weight)
            // else we will remove the last node from the visited_nodes list (the current node from which we can get a cycle in the path)
            // the current_node will become the anterior one of the current one (the one before the one that makes a cycle in the path)
            // we set it as being unvisited (but it's destination nodes of edges will remain visited, so I can avoid another cycle)
            if (contor != current_node_edges.size()) {
                current_node = g.findNode(intermediary_node);
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

        if (current_node == destination) {
            visited_nodes.add(destination);
        }


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


        /*
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
        */

        //THIS IS FOR AN ORIENTED GRAPH
        nodeA.createEdge(nodeA, nodeB, 2);

        nodeB.createEdge(nodeB, nodeC, 1);
        nodeB.createEdge(nodeB, nodeD, 4);

        nodeC.createEdge(nodeC, nodeA, 3);

        nodeD.createEdge(nodeD, nodeC, 4);
        nodeD.createEdge(nodeD, nodeE, 2);
        nodeD.createEdge(nodeD, nodeF, 5);

        nodeE.createEdge(nodeE, nodeF, 1);



        MyGraph graph = new MyGraph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        MyDijkstra.calculateShortestPath(graph, nodeA, nodeF);
    }
}
