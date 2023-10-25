package hu.saxEG55OI;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxEG55OI {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean insideElement = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    insideElement = true;
                    System.out.print(qName + "{");
                    for (int i = 0; i < attributes.getLength(); i++) {
                        System.out.print(attributes.getQName(i) + ":" + attributes.getValue(i));
                    }
                    System.out.print("}\n");
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("{" + qName + "}\n");
                    insideElement = false;
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (insideElement) {
                        System.out.println(new String(ch, start, length));
                    }
                }
            };

            saxParser.parse("EG55OI_kurzusfelvetel.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
