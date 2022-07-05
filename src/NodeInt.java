public class NodeInt {
    public int data;
    private NodeInt next;

    public NodeInt(int data) {
        this.data = data;
        this.next = null;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNextNode(NodeInt node) {
        this.next = node;
    }

    public NodeInt getNextNode() {
        return this.next;
    }
}
