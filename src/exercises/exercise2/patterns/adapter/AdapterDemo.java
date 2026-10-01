package exercises.exercise2.patterns.adapter;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/** Adapts a legacy XML data source to a JSON data service. */
public final class AdapterDemo {

    private AdapterDemo() {
    }

        public static void run() {
        JsonDataService service = new XmlToJsonAdapter(
                new XmlDataService("<user><name>Ada</name><city>Prague</city><note>first&#10;second&#9;row</note></user>"));
        System.out.println(service.getJsonData());
    }

    private interface JsonDataService {
        String getJsonData();
    }

    private static final class XmlDataService {
        private final String xml;

        private XmlDataService(String xml) {
            this.xml = xml;
        }

        private String getXmlData() {
            return xml;
        }
    }

    private static final class XmlToJsonAdapter implements JsonDataService {
        private final XmlDataService adaptee;

        private XmlToJsonAdapter(XmlDataService adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public String getJsonData() {
            try {
                var factory = DocumentBuilderFactory.newInstance();
                factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
                Element root = factory.newDocumentBuilder()
                        .parse(new InputSource(new StringReader(adaptee.getXmlData())))
                        .getDocumentElement();
                List<String> fields = new ArrayList<>();
                NodeList children = root.getChildNodes();
                for (int i = 0; i < children.getLength(); i++) {
                    Node child = children.item(i);
                    if (child instanceof Element element) {
                        fields.add(quote(element.getTagName()) + ":" + quote(element.getTextContent()));
                    }
                }
                return "{" + String.join(",", fields) + "}";
            } catch (Exception exception) {
                throw new IllegalStateException("Could not adapt XML data", exception);
            }
        }

        private static String quote(String value) {
            StringBuilder json = new StringBuilder("\"");
            for (int i = 0; i < value.length(); i++) {
                char character = value.charAt(i);
                switch (character) {
                    case '"' -> json.append("\\\"");
                    case '\\' -> json.append("\\\\");
                    case '\b' -> json.append("\\b");
                    case '\f' -> json.append("\\f");
                    case '\n' -> json.append("\\n");
                    case '\r' -> json.append("\\r");
                    case '\t' -> json.append("\\t");
                    default -> {
                        if (character < 0x20) {
                            json.append(String.format("\\u%04x", (int) character));
                        } else {
                            json.append(character);
                        }
                    }
                }
            }
            return json.append('"').toString();
        }
    }
}
