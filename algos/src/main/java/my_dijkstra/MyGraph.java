package my_dijkstra;

import java.util.ArrayList;

public class MyGraph {

    ArrayList<MyNode> nodes = new ArrayList<MyNode>();

    public void addNode(MyNode node) {
        this.nodes.add(node);
    }

    public ArrayList<MyNode> getNodes() {
        return this.nodes;
    }

    public MyNode findNode(MyNode o) {
        //int oo = this.nodes.indexOf(o);
        //return this.nodes.get(oo);
        for (MyNode mm : this.nodes) {
            if (mm.getName().equals(o.getName())) {
                return mm;
            }
        }
        return null;
    }
}
