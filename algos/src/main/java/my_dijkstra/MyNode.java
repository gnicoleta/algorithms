package my_dijkstra;

import java.util.ArrayList;
import java.util.List;

import util_structures.*;

public class MyNode {
    private String name;
    private int visited = 0;
    private int weight = 100;


    List<Triplet<MyNode, MyNode, Integer>> edges = new ArrayList<Triplet<MyNode, MyNode, Integer>>();

    public void createEdge(MyNode source, MyNode destination, int distance) {
        //util_structures.Triplet t = new util_structures.Triplet(source, destination, distance);
        edges.add(new Triplet(source, destination, distance));
    }

    public List<Triplet<MyNode, MyNode, Integer>> getEdges() {
        return this.edges;
    }

    public MyNode(String name) {
        this.name = name;
    }

    public MyNode() {
    }

    @Override
    public boolean equals(Object otherObject) {
/*
        // a quick test to see if the objects are identical
        if (this == otherObject) return true;
        // must return false if the explicit parameter is null
        if (otherObject == null) return false;
        // if the classes don't match, they can't be equal
        if (getClass() != otherObject.getClass())
            return false;
*/
        // now we know otherObject is a non-null MyNode
        MyNode other = (MyNode) otherObject;
        // test whether the fields have identical values
        return name.equals(other.name);
        //return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
