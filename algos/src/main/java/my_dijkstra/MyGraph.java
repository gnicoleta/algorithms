package my_dijkstra;

import java.util.ArrayList;

public class MyGraph {

    private ArrayList<MyNode> nodes = new ArrayList<MyNode>();

    public void addNode(MyNode node) {
        this.nodes.add(node);
    }

    public ArrayList<MyNode> getNodes() {
        return this.nodes;
    }

    public MyNode findNode(MyNode node) {
        for (MyNode mm : this.nodes) {
            if (mm.getName().equals(node.getName())) {
                return mm;
            }
        }
        return null;
    }
}
