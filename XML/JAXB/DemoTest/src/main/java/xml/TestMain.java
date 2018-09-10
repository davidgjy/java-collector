package xml;

import xml.node.Node;
import xml.node.NodeA;
import xml.node.NodeB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TestMain {

    public static void main(String... args) {

        Node n2 = new NodeA((long) 23);
        Node n3 = new NodeB((long) 456);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(NodeA.class, NodeB.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(n2, System.out);
            jaxbMarshaller.marshal(n3, System.out);


        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
