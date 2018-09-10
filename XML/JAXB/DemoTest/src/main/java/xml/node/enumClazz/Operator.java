package xml.node.enumClazz;

public enum Operator {
    GREATER(">"),
    LESS("<"),
    EQUAL("=");

    private String value;

    public String getValue() {
        return value;
    }

    Operator(String value) {
        this.value = value;
    }

}