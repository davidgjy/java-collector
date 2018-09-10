package xml.node;


import xml.node.enumClazz.NodeType;
import xml.node.enumClazz.Operator;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="IF")
public class NodeA extends Node {
    public NodeA(){
        super();
    }
    public NodeA(Long id) {
        super(id);
    }

    private String type = NodeType.IF.getValue();

    private String operator = Operator.GREATER.getValue();

    private String leftField = "LEFT FIELD";

    private String rightField = "RIGHT FIELD";


    public String getOperator() {
        return operator;
    }

    @XmlAttribute
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLeftField() {
        return leftField;
    }

    @XmlAttribute
    public void setLeftField(String leftField) {
        this.leftField = leftField;
    }

    public String getRightField() {
        return rightField;
    }

    @XmlAttribute
    public void setRightField(String rightField) {
        this.rightField = rightField;
    }

    @Override
    public String toString() {
        return "NodeA{" +
                "type='" + type + '\'' +
                ", operator='" + operator + '\'' +
                ", leftField='" + leftField + '\'' +
                ", rightField='" + rightField + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void doSomething() {
        System.err.println(this.getClass().getName() + "////" + this.toString());
    }

    public static void main(String... args) {
        Node a = new NodeA((long) 123);

        a.doSomething();
    }
}
