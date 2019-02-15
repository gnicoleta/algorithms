package my_dijkstra;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class MyDijkstra {

    public static void calculateShortestPath(MyGraph g, MyNode source, MyNode destination) {


        ArrayList<MyNode> visited = new ArrayList<MyNode>();

        MyNode root = source;
        source = g.findNode(source);
        source.setWeight(0);
//            source.setVisited(1);
        //visited.add(source);

        while (source != destination && source.getVisited() != 1) {

            source.setVisited(1);
            visited.add(source);
            //asici
        /*
        de la sursa iei toate nodurile pe care le poti vizita (get edges?)
        vezi weightul si il recalculezi
         */

            List<Triplet<MyNode, MyNode, Integer>> ed;
            ed = source.getEdges();
            //ArrayList<Pair<String, Integer>> pairs;
            //Triplet<MyNode, MyNode, Integer> trp;
            // trp = ed.

            for (Triplet<MyNode, MyNode, Integer> t : ed) {
                int ww = t.getFirst().getWeight() + t.getThird();
                if (ww < t.getSecond().getWeight() && t.getSecond().visited == 0) {
                    t.getSecond().setWeight(ww);
                }
            }
            MyNode newNode = new MyNode();
            int aux = 100;
            int cont = 0;
            for (Triplet<MyNode, MyNode, Integer> ii : ed) {

                if (ii.getSecond().getWeight() < aux && ii.getSecond().visited == 0 && !visited.contains(ii.getSecond())) {
                    aux = ii.getSecond().getWeight();
                    newNode = ii.getSecond();
                } else if (ii.getSecond().visited == 1 && visited.contains(ii.getSecond())) {
                    cont++;
                }
            }

            if (cont != ed.size()) {
                source = g.findNode(newNode);
                if (source == null) {
                    break;
                }
            } else {
                visited.remove(visited.size() - 1);
                source = visited.get(visited.size() - 1);
                source.setVisited(0);
                visited.remove(visited.size() - 1);
            }
/*
            for (Triplet<MyNode, MyNode, Integer> pp : ed) {
                if(pp.getSecond().getVisited()==1){
                    //visited.remove(pp.getFirst());
                    visited.remove(visited.size()-1);
                    newNode = visited.get(visited.size()-1);
                    //newNode.setVisited(0);
                    System.out.println("AAAA:"+newNode.getName() + "    " + newNode.getVisited());
                    //break;
                } else
                    continue;
            }
            */
//
//            source = g.findNode(newNode);
//            if (source == null) {
//                break;
//            }

        }
        visited.add(destination);

        for (
                MyNode n : visited) {
            System.out.println(n.name);
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
