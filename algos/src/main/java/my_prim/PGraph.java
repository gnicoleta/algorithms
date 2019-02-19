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


    public PNode findNode(PNode o) {
        //int oo = this.nodes.indexOf(o);
        //return this.nodes.get(oo);
        for (PNode mm : this.nodes) {
            if (mm.getName().equals(o.getName())) {
                return mm;
            }
        }
        return null;
    }
}
