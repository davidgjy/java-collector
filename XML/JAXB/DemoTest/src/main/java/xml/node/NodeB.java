package xml.node;

import xml.node.enumClazz.NodeType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NodeB extends Node {
    public NodeB(){
        super();
    }
    public NodeB(Long id) {
        super(id);
    }

    private String type = NodeType.ACT.getValue();
    private String exp = "EXPRESSION";

    public String getExp() {
        return exp;
    }

    @XmlAttribute
    public void setExp(String exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "NodeB{" +
                "type='" + type + '\'' +
                ", exp='" + exp + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void doSomething() {
        System.err.println(this.getClass().getName() + "----" + this.toString());
    }

    public static void main(String... args) {
        Node a = new NodeB((long) 456);
        a.doSomething();
    }
}
