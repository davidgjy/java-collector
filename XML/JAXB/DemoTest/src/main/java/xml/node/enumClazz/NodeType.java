package xml.node.enumClazz;

public enum NodeType {
    ACT("act"),
    ELSE("else"),
    IF("if");

    private String value;
    public String getValue() {
        return value;
    }
    NodeType(String value) {
        this.value = value;
    }
}