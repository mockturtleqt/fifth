package com.epam.fifth.action;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Validation {
    private static Logger logger = Logger.getLogger(Validation.class);

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        boolean isValid;
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            isValid = true;
        } catch (IOException | SAXException e) {
            logger.error(e);
            isValid = false;
        }
        return isValid;
    }
}
