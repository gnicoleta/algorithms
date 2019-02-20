package my_prim;


import java.util.ArrayList;

public class PGraph {
    private ArrayList<PNode> nodes = new ArrayList<PNode>();

    public void addNode(PNode node) {
        this.nodes.add(node);
    }

    public ArrayList<PNode> getNodes() {
        return this.nodes;
    }


    public PNode findNode(PNode node) {
        for (PNode mm : this.nodes) {
            if (mm.getName().equals(node.getName())) {
                return mm;
            }
        }
        return null;
    }
}
