package hu.saxEG55OI;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class XsdValidation {

    public static void main(String[] args) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("EG55OI_kurzusfelvetel.xsd"));

            javax.xml.validation.Validator validator = schema.newValidator();
            ErrorHandler errorHandler = new ErrorHandler();

            validator.setErrorHandler(errorHandler);

            validator.validate(new StreamSource(new File("EG55OI_kurzusfelvetel.xml")));

            if (errorHandler.isValid()) {
                System.out.println("XSD Validation successful");
            } else {
                System.out.println("Unsuccessful validation");
            }
        } catch (SAXException | IOException e) {
            System.out.println("Unsuccessful validation");
            e.printStackTrace();
        }
    }

    private static class ErrorHandler extends DefaultHandler {
        private boolean valid = true;

        @Override
        public void error(SAXParseException e) throws SAXException {
            valid = false;
        }

        public boolean isValid() {
            return valid;
        }
    }
}
