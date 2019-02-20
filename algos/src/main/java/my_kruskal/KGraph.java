package my_kruskal;

import java.util.ArrayList;

public class KGraph {

    private ArrayList<KNode> nodes  = new ArrayList<KNode>();

    public void addNode(KNode node) {
        this.nodes.add(node);
    }

    public ArrayList<KNode> getNodes() {
        return this.nodes;
    }

    public KNode findNode(KNode node) {
        for(KNode n : this.nodes) {
            if(n.equals(node)) {
                return n;
            }
        }
        return null;
    }
}
